package com.messagingapp.messageapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message save(Message message) {
        if (message.getDateStamp() == null) {
            message.setDateStamp(LocalDate.now());
            message.setTimeStamp(LocalTime.now());
        }
        return messageRepository.save(message);
    }

    public List<Message> getRecentMessages() {
        return messageRepository.findTop50ByOrderByTimeStampDesc();
    }

    public Message getMessageById(long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
    }
}
