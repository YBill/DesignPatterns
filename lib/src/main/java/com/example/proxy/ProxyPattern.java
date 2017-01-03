package com.example.proxy;

/**
 * Created by Bill on 2016/12/30.
 *
 * 静态代理
 */

public class ProxyPattern {

    public static void main(String[] arg0){
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.request();
    }

    public interface Subject {
        void request();
    }

    static class RealSubject implements Subject {

        @Override
        public void request() {
            System.out.println("real subject");
        }
    }

    static class Proxy implements Subject {

        Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("PreProcess");
            subject.request();
            System.out.println("PostProcess");
        }
    }

}
