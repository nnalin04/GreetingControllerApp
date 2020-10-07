package com.bridgelabz.greetingcontroller.service;

import com.bridgelabz.greetingcontroller.dto.GreetingDTO;
import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.exception.GreetingMessageException;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import com.bridgelabz.greetingcontroller.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GreetingService implements IGreetingService{

    @Autowired
    IGreetingRepository greetingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GreetingMessage createMessage(UserDTO userDTO) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage(getMessage(userDTO.getMessage(),
                userDTO.getFirstName(), userDTO.getLastName()));
        return greetingRepository.save(greetingMessage);
    }

    public String getMessage(String message, String firstName, String lastName) {
        if (message != null)
            return message;
        if (firstName != null && lastName != null)
           return "Hello "+ firstName + " "+ lastName;
        if (firstName != null)
            return "Hello "+ firstName ;
        if (lastName != null)
            return "Hello "+ lastName;
        return "Hello World";
    }

    @Override
    public GreetingMessage findMessageById(Long id) {
        return greetingRepository.findById(id).orElseThrow(
                () -> new GreetingMessageException("Record not found"));
    }

    @Override
    public List<GreetingMessage> findAllMessage() {
        return greetingRepository.findAll();
    }

    @Override
    public GreetingMessage updateMessage(GreetingDTO greetingDTO) {
        findMessageById(greetingDTO.getGreetingId());
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingId(greetingDTO.getGreetingId());
        greetingMessage.setGreetingMessage( getMessage( greetingDTO.getMessage(),
                greetingDTO.getFirstName(), greetingDTO.getLastName()));
        return greetingRepository.save(greetingMessage);
    }

    @Override
    public String deleteMessage(Long id) {
        greetingRepository.delete(findMessageById(id));
        return "Successfully deleted";
    }
}
