package com.rest.webservices01.restfullwebservices.controllers;

import org.springframework.web.bind.annotation.*;

//REST API
@RestController
public class HelloWord {

    @GetMapping("/hello-world")
    public String helloWorld(){
        System.out.println("holas");
        return "hello world";
    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(
                String.format("Hello world, %s", name)
                );
    }
}
