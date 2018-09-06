package com.jianli.demo.proxy;

import com.jianli.demo.util.AuthUtil;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibMessageSender implements MethodInterceptor {


  private CGLibInstance target;

  public CGLibMessageSender(CGLibInstance target) {
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
      AuthUtil.auth();
      Object result = methodProxy.invokeSuper(proxy, args);
      return result;
    }
    return methodProxy.invokeSuper(proxy, args);
  }
}
