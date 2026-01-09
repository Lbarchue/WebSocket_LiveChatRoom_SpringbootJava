package com.messagingapp.messageapp2;

import java.time.LocalDate;
import java.time.LocalTime;

public record MessageDTO(
        String sender,
        String content,
        LocalDate dateStamp,
        LocalTime timeStamp
) {}
