package com.greenfox.controller;

import com.greenfox.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloRESTController {
  AtomicLong id = new AtomicLong();
  @RequestMapping (value = "/greeting")
  public Greeting greeting(@RequestParam String name) {
    return new Greeting(id.getAndIncrement(), String.format("Hello, %s", name));
  }
}
