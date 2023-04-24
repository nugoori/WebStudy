package com.example.test.board.dto.response.auth;

import com.example.test.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    
    private String email;
    private String nickname;
    private String profileImgUrl;
    private int height;
    private int weight;
    private String gender;

    public SignInResponseDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImgUrl = userEntity.getProfileImageUrl();
        this.height = userEntity.getHeight();
        this.weight = userEntity.getWeight();
        this.gender = userEntity.getGender();
    }
}
