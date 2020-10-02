package com.bridgelabz.greetingcontroller.repository;

import com.bridgelabz.greetingcontroller.modle.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<GreetingMessage, Long> {
}
