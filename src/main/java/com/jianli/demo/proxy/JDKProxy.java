package com.jianli.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
  private JDKProxyInstance target;

  public JDKProxy(JDKProxyInstance target) {
    this.target = target;
  }


  public ExInterface createProxy() {
    return (ExInterface) Proxy
        .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
  }


  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if ("execute".equals(method.getName())) {
      System.out.println("Authentification processing");
      Object result = method.invoke(target, args);
      System.out.println("Log processing");
      return result;
    } else if ("delete".equals(method.getName())) {
      //.....
    }
    return method.invoke(target, args);
  }
}
