package com.bridgelabz.greetingcontroller;

import com.bridgelabz.greetingcontroller.dto.UserDTO;
import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import com.bridgelabz.greetingcontroller.repository.IGreetingRepository;
import com.bridgelabz.greetingcontroller.service.GreetingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class GreetingControllerApplicationTests {

    @Mock
    IGreetingRepository greetingRepository;

    UserDTO userDTO;

    GreetingMessage greetingMessage;

    @InjectMocks
    GreetingService service;

    @Test
    void contextLoads() {
        userDTO = new UserDTO();
        greetingMessage = new GreetingMessage();
        when(greetingRepository.save(greetingMessage)).thenReturn(greetingMessage);
        String message = service.createMessage(userDTO).getGreetingMessage();
        Assert.assertTrue((message).equals("Hello World"));
    }
}
