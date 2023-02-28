package org.ssglobal.revalida.codes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import org.ssglobal.revalida.codes.enums.Status;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class Message {

    @Id
    @Column(nullable = false, updatable = false)
    private String date;

    private String senderName;
    private String receiverName;
    private String message;
    private Status status;
}
