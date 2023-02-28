package org.ssglobal.revalida.codes.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.ssglobal.revalida.codes.dto.MessageDTO;
import org.ssglobal.revalida.codes.model.Message;
import org.ssglobal.revalida.codes.repos.MessageRepo;

@Service
public class MessageService {

    private final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public MessageDTO saveMessage(MessageDTO message) {
        Message msg = new Message();
        mapToEntity(message, msg);
        System.out.println(msg.toString());
        boolean isSaved = messageRepo.save(msg) != null;
        if (isSaved) {
            return message;
        }
        return null;
    }

    public List<MessageDTO> getMessages(String senderName, String receiverName) {
        List<Message> sender = messageRepo.findBySenderNameAndReceiverName(senderName, receiverName);
        List<Message> receiver = messageRepo.findByReceiverNameAndSenderName(senderName, receiverName);
        List<Message> messages = new ArrayList<>();
        messages.addAll(sender);
        messages.addAll(receiver);
        messages.sort((m1, m2) -> m1.getDate().compareTo(m2.getDate()));
        return messages.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private MessageDTO mapToDTO(Message msg) {
        MessageDTO message = new MessageDTO();
        message.setDate(msg.getDate());
        message.setSenderName(msg.getSenderName());
        message.setReceiverName(msg.getReceiverName());
        message.setMessage(msg.getMessage());
        message.setStatus(msg.getStatus());
        return message;
    }

    private Message mapToEntity(MessageDTO message, Message msg) {
        msg.setDate(new Timestamp(System.currentTimeMillis()).toString());
        msg.setSenderName(message.getSenderName());
        msg.setReceiverName(message.getReceiverName());
        msg.setMessage(message.getMessage());
        msg.setStatus(message.getStatus());
        return msg;
    }

}
