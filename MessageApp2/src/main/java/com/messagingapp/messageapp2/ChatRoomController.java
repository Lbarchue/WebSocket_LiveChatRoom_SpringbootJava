package com.messagingapp.messageapp2;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatRoomController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;
    private final MessageService messageService;

    public ChatRoomController(SimpMessagingTemplate messagingTemplate,  MessageRepository messageRepository, MessageService messageService) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/chat.send")
    public void sendMessage(Message message){
        messageService.save(message);               // persistence
        messagingTemplate.convertAndSend("/topic/general", message);
    }
}
