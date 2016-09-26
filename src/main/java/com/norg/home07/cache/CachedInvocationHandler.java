package com.norg.home07.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * InvocationHandler, which caches method invocation results
 */

public class CachedInvocationHandler implements InvocationHandler {
    private final Object delegate;
    private Map<InvokeContext, Object> cache = new ConcurrentHashMap<>();

    public CachedInvocationHandler(Object delegate) throws IllegalAccessException, InstantiationException {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if(!method.isAnnotationPresent(Cache.class)) {
            result = method.invoke(delegate, args);
        }else {
            InvokeContext invokeContext = new InvokeContext(method.getName(), args);
            if(cache.containsKey(invokeContext)) {
                result = cache.get(invokeContext);
            }else {
                result = method.invoke(delegate, args);
                cache.put(invokeContext, result);
            }
        }
        return result;
    }

    class InvokeContext {
        //не Method, потому что никакой необходимости нет: методов с одинаковым именем и набором параметров быть не может
        private final String methodName;
        private final Object[] args;

        InvokeContext(String methodName, Object[] args) {
            this.methodName = methodName;
            this.args = args;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            InvokeContext that = (InvokeContext) o;

            if (!methodName.equals(that.methodName)) return false;
            // будет работать правильно, только если для объектов массива правильно реализованы hashCode() и equals()
            return Arrays.equals(args, that.args);

        }

        @Override
        public int hashCode() {
            int result = methodName.hashCode();
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }
}
