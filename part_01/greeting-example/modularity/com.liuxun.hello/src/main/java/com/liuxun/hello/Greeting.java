package com.liuxun.hello;

public class Greeting {
    final String m_name;

    public Greeting(String m_name) {
        this.m_name = m_name;
    }

    public void sayHello() {
        System.out.println("Hello, " + m_name + "! +++++++++");
    }
}
