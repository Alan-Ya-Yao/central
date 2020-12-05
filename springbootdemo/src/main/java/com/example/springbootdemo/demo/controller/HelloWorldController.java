package com.example.springbootdemo.demo.controller;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/22/20
 * @since 1.0.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Alibaba Cloud Toolkit: Hello,World.";
    }
}