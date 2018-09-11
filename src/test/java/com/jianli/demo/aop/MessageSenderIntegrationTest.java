package com.jianli.demo.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class MessageSenderIntegrationTest {

  @Autowired
  private MessageSender messageSender;

  @Test
  public void shouldApplyCustomAnnotation() throws InterruptedException {
    messageSender.sendMessage();
  }

}