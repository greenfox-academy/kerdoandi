package com.greenfox.messageservice.Service;

public class EmailService implements MessageService {
  @Override
  public void sendMessage(String message, String address) {
    System.out.println("Email Sent to " + address + " with Message=" + message);
  }
}
