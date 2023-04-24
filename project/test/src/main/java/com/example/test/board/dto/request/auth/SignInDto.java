package com.example.test.board.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInDto {
    
    @Email
    @NotBlank
    @Length(max=45)
    private String email;

    @NotBlank
    @Length(min=10, max=20)
    private String password;
}
