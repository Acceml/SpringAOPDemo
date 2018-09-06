package com.jianli.demo.proxy;

import com.jianli.demo.util.AuthUtil;
import com.jianli.demo.util.MessageUtil;

public class MessageSender {
  public MessageSender() {
  }

  public static void sendMessage() {
    AuthUtil.auth();
    MessageUtil.sendMessage("No proxy");
  }
}
