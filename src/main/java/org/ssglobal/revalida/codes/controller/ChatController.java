package org.ssglobal.revalida.codes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.ssglobal.revalida.codes.dto.MessageDTO;
import org.ssglobal.revalida.codes.service.MessageService;
import org.springframework.messaging.handler.annotation.SendTo;
@Controller
@CrossOrigin(origins = "${social-media-app.origin}", allowCredentials = "true")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public MessageDTO receiveMessage(@Payload MessageDTO message){
        return message;
    }
    
    @MessageMapping("/private-message")
    public MessageDTO recMessage(@Payload MessageDTO message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        System.out.println(message.toString());
        messageService.saveMessage(message);
        return message;
    }
}
