package com.bridgelabz.greetingcontroller.service;

import com.bridgelabz.greetingcontroller.dto.GreetingDTO;
import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;

import java.util.List;

public interface IGreetingService {
    public GreetingMessage createMessage(UserDTO userDTO);
    public GreetingMessage findMessageById(Long id);
    public List<GreetingMessage> findAllMessage();
    public GreetingMessage updateMessage(GreetingDTO greetingDTO);
    public String deleteMessage(Long id);
}
