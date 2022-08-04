package com.learning.restwebservices.restfulwebservices.SayHelloWorldPrograms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class sayHelloWorld {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/sayhello")
    //  @RequestMapping(method = RequestMethod.GET, path = "/sayhello") -- use this also.
    public String sayHello(){
        return "Welcome to Jurassic Park!!";
    }

    @GetMapping("/sayhello/usingbeans")
    public SayHello sayHelloUsingBeans(){
        return new SayHello("Welcome to Jurassic World!! xD");
    }

    @GetMapping("/sayhello/{name}")
    public String sayHelloUsingParamateres( @PathVariable String name){
        return ("Hello : "+name);
    }

    @GetMapping("/sayhello/intn")
    public String sayHelloInternationalized(){

        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
