package com.learning.restwebservices.restfulwebservices;

import org.springframework.web.bind.annotation.*;

@RestController
public class sayHelloWorld {



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
}
