//this class handles GET requests from for /greeting route by  returning a new instance of the Greeting class 
package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class GreetingController {
            
              private static final String template = "Hello, %s!";
              private final AtomicLong counter = new AtomicLong();

            //ensures http requests to /greeting are mapped to greeting() method 
            @GetMapping("/greeting");
            //@RequestParam binds value of the query string param name of the greeting() method incase absent, uses the defaultValue 
            public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
                  return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
