package com.vdvc.reactivedemo.Users;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final String template = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    public User user(@RequestParam(value="name", defaultValue="unknown user") String name) {
        Thread currThread = Thread.currentThread();
        System.out.println("current thread = " + currThread.getId());
      
        return new User(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
