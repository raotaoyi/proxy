package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHander implements InvocationHandler {

    private Object target;


    public TimeHander(Object target) {
        this.target = target;
    }

    /*
     * 被代理的对象
     * 被代理对象的方法
     * 方法的参数
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        method.invoke(target);
        System.out.println("end");
        return null;
    }
}
