package com.messagingapp.messageapp2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
public class Message {
    private String content;

    private String sender;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dateStamp = LocalDate.now();
    private LocalTime timeStamp = LocalTime.now();

    public Message(String content){
        this.content = content;
    }

    public Message() {

    }
}
