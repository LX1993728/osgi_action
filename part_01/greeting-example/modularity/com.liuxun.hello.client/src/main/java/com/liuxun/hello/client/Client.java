package com.liuxun.hello.client;

import com.liuxun.hello.Greeting;

public class Client {
    static {
        new Greeting("liuxun first osgi test!!!").sayHello();
    }
}
