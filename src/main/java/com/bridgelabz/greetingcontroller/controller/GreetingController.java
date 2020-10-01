package com.bridgelabz.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping(path = "/hello")
    public ResponseEntity getMessage() {
        String message = greetingService.getMessage();
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
