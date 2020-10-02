package com.bridgelabz.greetingcontroller.service;

import com.bridgelabz.greetingcontroller.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getMessage(UserDTO userDTO) {
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null)
           return "Hello "+ userDTO.getFirstName() + " "+ userDTO.getLastName();
        if (userDTO.getFirstName() != null && userDTO.getLastName() == null)
            return "Hello "+ userDTO.getFirstName() ;
        if (userDTO.getFirstName() == null && userDTO.getLastName() != null)
            return "Hello "+ userDTO.getLastName();
        return "Hello World";
    }
}
