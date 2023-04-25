package com.example.test.board.dto.response.user;

import com.example.test.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    
    private String email;
    private String nickname;
    //? 이름 맞추기?
    private String profileImageUrl;
    private int height;
    private int weight;
    private String gender;

    public GetUserResponseDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImageUrl = userEntity.getProfileImageUrl();
        this.height = userEntity.getHeight();
        this.weight = userEntity.getWeight();
        this.gender = userEntity.getGender();
    }
}
