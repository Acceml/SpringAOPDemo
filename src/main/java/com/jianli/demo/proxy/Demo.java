package com.jianli.demo.proxy;

public class Demo {
  public static void main(String args[]){
    //JDK Proxy
    JDKProxyMessageSender a=new JDKProxyMessageSender();
    JDKProxy jdkProxy=new JDKProxy(a);
    ExInterface proxy=jdkProxy.createProxy();
    proxy.execute();
    System.out.println("\n");

    //CGLib Proxy
    CGLibInstance cgLibInstance=new CGLibInstance();
    CGLibMessageSender cgLibProxy=new CGLibMessageSender(cgLibInstance);
    cgLibInstance= cgLibProxy.createProxy();
    cgLibInstance.execute();
  }


}
