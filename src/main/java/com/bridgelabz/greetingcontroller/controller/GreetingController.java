package com.bridgelabz.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.dto.GreetingDTO;
import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import com.bridgelabz.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/hello")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody UserDTO userDTO) {
        System.out.println("request body"+ userDTO);
        GreetingMessage message = greetingService.createMessage(userDTO);
        return new ResponseEntity(message.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity getMessageById(@RequestParam Long id) {
        GreetingMessage greetingMessage = greetingService.findMessageById(id);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllMessage() {
        System.out.println("Hello");
        List<GreetingMessage> greetingMessages = greetingService.findAllMessage();
        return new ResponseEntity<>(greetingMessages, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updateMessageById(@RequestBody GreetingDTO greetingDTO) {
        GreetingMessage greetingMessage = greetingService.updateMessage(greetingDTO);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteMessageById(@RequestParam Long id) {
        String message = greetingService.deleteMessage(id);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
