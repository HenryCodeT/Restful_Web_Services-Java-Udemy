package com.rest.webservices01.restfullwebservices.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//REST API
@RestController
public class HelloWord {

    private MessageSource messageSource;

    public HelloWord(MessageSource messageSource){
        this.messageSource = messageSource;
    }

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

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(
                            "good.morning.message",
                            null,
                            "Default Message",
                            locale);
        //

    }
}
