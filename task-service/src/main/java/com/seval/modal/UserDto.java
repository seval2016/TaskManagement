package com.seval.modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String password;
    private String email;
    private String role;
    private String fullName;
}
