package springdm.provider.test.serviceImpl;

import org.springframework.stereotype.Service;
import springdm.provider.test.HelloService;


public class HelloServiceImpl implements HelloService {

    public void sayHello(String name) {
        System.out.println("Hello "+name+" !!!!!");
    }
}
