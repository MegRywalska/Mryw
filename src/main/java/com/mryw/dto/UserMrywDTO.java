package com.mryw.dto;

import com.mryw.model.StatusAccount;
import com.mryw.model.UserMryw;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMrywDTO {

    private Long id;
    private String email;
    private String accountName;
    private String password;
    private String accountURL;
    private LocalDate creationDate;
    private StatusAccount statusAccount;
    private Blob avatar;

    public static UserMrywDTO fromUserMryw(UserMryw userMryw){
        return UserMrywDTO.builder()
                .id(userMryw.getId())
                .email(userMryw.getEmail())
                .accountName(userMryw.getAccountName())
                .password(userMryw.getPassword())
                .accountURL(userMryw.getAccountURL())
                .creationDate(userMryw.getCreationDate())
                .avatar(userMryw.getAvatar())
                .build();
    }
}
