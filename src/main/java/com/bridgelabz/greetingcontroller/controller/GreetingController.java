package com.bridgelabz.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.dto.UserDTO;
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
    public ResponseEntity getMessage(@RequestBody UserDTO userDTO) {
        String message = greetingService.getMessage(userDTO);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
