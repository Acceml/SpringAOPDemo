package com.jianli.demo.proxy;

public class Demo {
  public static void main(String args[]){
    JDKProxyInstance a=new JDKProxyInstance();
    JDKProxy jdkProxy=new JDKProxy(a);
    ExInterface proxy=jdkProxy.createProxy();
    proxy.execute();

    CGLibInstance cgLibInstance=new CGLibInstance();
    CGLibProxy cgLibProxy=new CGLibProxy(cgLibInstance);
    cgLibInstance= cgLibProxy.createProxy();
    cgLibInstance.execute2();
  }


}
