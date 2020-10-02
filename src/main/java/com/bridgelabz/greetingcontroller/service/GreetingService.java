package com.bridgelabz.greetingcontroller.service;

import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import com.bridgelabz.greetingcontroller.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService implements IGreetingService{

    @Autowired
    IGreetingRepository greetingRepository;

    public GreetingMessage createMessage(UserDTO userDTO) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage(getMessage(userDTO));
        GreetingMessage message = greetingRepository.save(greetingMessage);
        return message;
    }

    public String getMessage(UserDTO userDTO) {
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null)
           return "Hello "+ userDTO.getFirstName() + " "+ userDTO.getLastName();
        if (userDTO.getFirstName() != null && userDTO.getLastName() == null)
            return "Hello "+ userDTO.getFirstName() ;
        if (userDTO.getFirstName() == null && userDTO.getLastName() != null)
            return "Hello "+ userDTO.getLastName();
        return "Hello World";
    }

    public GreetingMessage findById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<GreetingMessage> findAllMessage() {
        return greetingRepository.findAll();
    }
}
