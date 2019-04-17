package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args){
        /*
        *jdk动态代理：只能代理实现了接口的类，没有实现接口的类不能实现jdk的动态代理
        * 1,创建一个实现接口InvocationHandler的类，它必须实现invoke方法
        * 2，创建被代理的类以及接口
        * 3，调用Proxy的静态方法Proxy.newProxyInstance，创建一个代理类
        * 4，通过代理调用方法
        * */
        Car car = new Car();
        InvocationHandler h = new TimeHander(car);
        Class<?> cls = car.getClass();
        /*
         * loader 类加载器
         * intefaces 实现的接口
         * h InvocationHandler
         * */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        m.move();
    }
}
