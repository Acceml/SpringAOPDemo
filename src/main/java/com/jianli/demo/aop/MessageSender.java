package com.jianli.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class MessageSender {

  @Authentication
  public void sendMessage() throws InterruptedException {
    Thread.sleep(2000);
  }
}