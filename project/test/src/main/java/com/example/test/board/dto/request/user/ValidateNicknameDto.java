package com.example.test.board.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateNicknameDto {
    
    @NotBlank
    @Length(max=45)
    private String nickname;
}
