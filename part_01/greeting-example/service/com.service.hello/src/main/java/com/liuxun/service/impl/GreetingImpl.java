package com.liuxun.service.impl;

import com.service.api.Greeting;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, "+name+" !!!!  12345678910");
    }
}
