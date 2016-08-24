package com.norg.home06;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

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
}
