package org.ssglobal.revalida.codes.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.revalida.codes.dto.MessageDTO;
import org.ssglobal.revalida.codes.service.MessageService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessagesController {

    private final MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public List<MessageDTO> getMessages(@RequestBody MessageDTO message) {
        return messageService.getMessages(message.getSenderName(), message.getReceiverName());
    }

}
