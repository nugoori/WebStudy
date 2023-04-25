package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.dto.request.auth.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="User")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String height;
    private String weight;
    private String gender;

    public UserEntity(SignUpDto signUpDto) {
        this.email = signUpDto.getEmail();
        this.password = signUpDto.getPassword();
        this.nickname = signUpDto.getNickname();
        this.height = signUpDto.getHeight();
        this.weight = signUpDto.getWeight();
        this.gender = signUpDto.getGender();
    }
}
