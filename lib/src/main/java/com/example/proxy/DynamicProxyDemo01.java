package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Bill on 2017/1/3.
 *
 * 动态代理
 */

public class DynamicProxyDemo01 {

    public static void main(String[] args){
        Subject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        proxySubject.request();
    }

    /**
     * 接口
     */
    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {

        @Override
        public void request() {
            System.out.println("=====  RealSubject Request  =====");
        }
    }

    static class ProxyHandler implements InvocationHandler{

        private Subject subject;

        public ProxyHandler(Subject subject){
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("=====before=====");
            Object object = method.invoke(subject, args);
            System.out.println("=====after=====");
            return object;
        }
    }

}
