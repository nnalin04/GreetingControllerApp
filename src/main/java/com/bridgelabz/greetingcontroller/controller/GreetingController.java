package com.bridgelabz.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import com.bridgelabz.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hello")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody UserDTO userDTO) {
        GreetingMessage message = greetingService.createMessage(userDTO);
        return new ResponseEntity(message.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getMessageById(@RequestParam Long id) {
        GreetingMessage greetingMessage = greetingService.findById(id);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List> getAllMessage() {
        List<GreetingMessage> greetingMessages = greetingService.findAllMessage();
        return new ResponseEntity<>(greetingMessages, HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity updateMessageById(@RequestParam Long id, @RequestBody UserDTO userDTO) {
        GreetingMessage greetingMessage = greetingService.updateMessage(id, userDTO);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }
}
