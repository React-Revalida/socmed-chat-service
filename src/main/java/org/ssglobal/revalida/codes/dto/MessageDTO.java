package org.ssglobal.revalida.codes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.ssglobal.revalida.codes.enums.Status;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageDTO {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
