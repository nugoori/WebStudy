package com.example.test.board.dto.response.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateNicknameResponseDto {
    
    @NotBlank
    @Length(max=45)
    private String nickname;
}
