package org.ssglobal.revalida.codes.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDTO {
    private Integer userId;

    private String username;

    private String email;

    private String password;

    private Boolean isValidated;

    private Boolean isActive;

    private Integer profile;

    private String firstname;

    private String middlename;

    private String lastname;

    private String name;

    private String phone;

    private LocalDate birthdate;

    private String bio;

    private String gender;

    private String profilePic;

    private Integer followers;

    private Integer following;

    private String dateJoined;
}
