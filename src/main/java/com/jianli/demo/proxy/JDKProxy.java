package com.jianli.demo.proxy;

import com.jianli.demo.util.AuthUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
  private JDKProxyMessageSender target;

  public JDKProxy(JDKProxyMessageSender target) {
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
      AuthUtil.auth();
      Object result = method.invoke(target, args);
      return result;
    }
    return method.invoke(target, args);
  }
}
