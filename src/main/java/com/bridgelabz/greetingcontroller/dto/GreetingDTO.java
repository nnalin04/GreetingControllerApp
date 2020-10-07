package com.bridgelabz.greetingcontroller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingDTO {
    private Long greetingId;
    private String firstName;
    private String lastName;
    private String message;
}
