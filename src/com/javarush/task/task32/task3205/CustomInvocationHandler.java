package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods someInterfaceWithMethods;
    Method method;
    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods){
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.method = method;
        System.out.println(method.getName() + " in");
        getMethod().invoke(someInterfaceWithMethods, args);
        System.out.println(method.getName() + " out");
        return "";
    }

    public Method getMethod() {
        return method;
    }
}
