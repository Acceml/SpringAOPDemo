package com.jianli.demo.proxy;

import com.jianli.demo.util.MessageUtil;

public class JDKProxyMessageSender implements ExInterface {
  public void execute(){
    MessageUtil.sendMessage("JDK Proxy");
  }
}
