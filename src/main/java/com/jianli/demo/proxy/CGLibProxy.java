package com.jianli.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {


  private CGLibInstance target;

  public CGLibProxy(CGLibInstance target) {
    super();
    this.target = target;
  }


  public CGLibInstance createProxy() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(target.getClass());
    enhancer.setCallback(this);
    return (CGLibInstance) enhancer.create();
  }

  @Override
  public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    if ("execute".equals(method.getName())) {
      System.out.println("Authentication processing");
      Object result = methodProxy.invokeSuper(proxy, args);
      System.out.println("Log processing");
      return result;
    } else if ("delete".equals(method.getName())) {
      //.....
      return methodProxy.invokeSuper(proxy, args);
    }
    return methodProxy.invokeSuper(proxy, args);

  }
}
