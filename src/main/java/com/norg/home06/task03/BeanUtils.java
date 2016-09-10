package com.norg.home06.task03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.norg.home06.ClassUtils.getGetters;
import static com.norg.home06.ClassUtils.getSetters;
import static com.norg.home06.ClassUtils.isSuper;

public class BeanUtils {
    /**
     * Scans	object	"from"	for	all	getters.	If	object	"to"
     * contains	correspondent	setter,	it	will	invoke	it
     * to	set	property	value	for	"to"	which	equals	to	the	property
     * of	"from".
     * <p/>
     * The	type	in	setter	should	be	compatible	to	the	value	returned
     * by	getter	(if	not,	no	invocation	performed).
     * Compatible	means	that	parameter	type	in	setter	should
     * be	the	same	or	be	superclass	of	the	return	type	of	the	getter.
     * <p/>
     * The	method	takes	care	only	about	public	methods.
     *
     * @param to   Object	which	properties	will	be	set.
     * @param from Object	which	properties	will	be	used	to	get	values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Class fromClass = from.getClass();
        Class toClass = to.getClass();

        List<Method> fromGetters = getGetters(fromClass);
        for (Method getter : fromGetters) {
            Method setter = setter(getter, toClass);
            if(setter != null) {
                setter.invoke(to, getter.invoke(from));
            }
        }
    }

    private static Method setter(Method getter, Class clazz) {
        List<Method> toSetters = getSetters(clazz);
        String setterName = getter.getName().replaceFirst("^get", "set");
        for(Method setter : toSetters) {
            if(setter.getName().equals(setterName)) {
                if(setter.getParameterCount() == 1 && isSuper(getter.getReturnType(), setter.getParameterTypes()[0])) {
                    return setter;
                }
            }
        }
        return null;
    }
}
