package com.messagingapp.messageapp2;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public MessageDTO getMessage(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);

        return new MessageDTO(
                message.getSender(),
                message.getContent(),
                message.getDateStamp(),
                message.getTimeStamp()
        );
    }

    @GetMapping
    public List<MessageDTO> getRecentMessages() {
        return messageService.getRecentMessages()
                .stream()
                .map(m -> new MessageDTO(
                        m.getSender(),
                        m.getContent(),
                        m.getDateStamp(),
                        m.getTimeStamp()
                ))
                .toList();
    }
}
