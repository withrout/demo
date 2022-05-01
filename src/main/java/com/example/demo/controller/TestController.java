package com.example.demo.controller;

import com.example.demo.entity.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping
    public Test testPost(@RequestBody Test test) {
        return test;
    }

    @PostMapping("/test2")
    public Test testPost2(@RequestBody Test test) {
        return test;
    }
}
