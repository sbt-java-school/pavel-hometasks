package com.norg.home06;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norg on 24.08.2016.
 */
public class ClassUtils {
    public static String getMethodArgs(Method method) {
        StringBuilder arguments = new StringBuilder();
        Type[] argTypes = method.getGenericParameterTypes();
        arguments.append("(");
        boolean needComma = false;
        for (Type type : argTypes) {
            if(needComma) {
                arguments.append(", ");
            }
            arguments.append(type.getTypeName());
            needComma = true;
        }
        arguments.append(")");
        return arguments.toString();
    }

    public static List<Method> getGetters(String className) throws ClassNotFoundException {
        return parseMetods(Class.forName(className), true);
    }

    public static List<Method> getSetters(String className) throws ClassNotFoundException {
        return parseMetods(Class.forName(className), false);
    }

    private static List<Method> parseMetods(Class clazz, boolean getters) {
        Method[] allMethods = clazz.getMethods();
        List<Method> methods = new ArrayList<>();
        for (Method method : allMethods) {
            if (
                    (getters && (
                            method.getName().startsWith("get") || method.getName().startsWith("is")
                    )) ||
                            (!getters && method.getName().startsWith("set"))
                    ) {
                methods.add(method);
            }
        }
        return methods;
    }

    public static List<Method> getGetters(Class clazz) {
        return parseMetods(clazz, true);
    }

    public static List<Method> getSetters(Class clazz) {
        return parseMetods(clazz, false);
    }

    public static boolean isSuper(Class clazz, Class superClass) {
        while(clazz != null) {
            if(clazz == superClass) {
                return true;
            }
            clazz = clazz.getSuperclass();
        }
        return false;
    }
}
