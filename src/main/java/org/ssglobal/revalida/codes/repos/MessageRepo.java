package org.ssglobal.revalida.codes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssglobal.revalida.codes.model.Message;

public interface MessageRepo extends JpaRepository<Message, String> {
    List<Message> findBySenderNameAndReceiverName(String senderName, String receiverName);
    List<Message> findByReceiverNameAndSenderName(String receiverName, String senderName);
}
