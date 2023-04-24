package com.example.test.board.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    @Length(max=45)
    private String password;
    
    @NotBlank
    @Length(max=45)
    private String nickname;
    
    private String profileImgUrl;
    
    private int height;
    
    private int weight;
    
    private String gender;

}
