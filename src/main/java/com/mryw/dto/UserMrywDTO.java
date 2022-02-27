package com.mryw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMrywDTO {
    private String email;
    private String password;
    private String accountName;
    private String accountURL;
}
