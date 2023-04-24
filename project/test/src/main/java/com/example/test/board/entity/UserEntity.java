package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    //? 이름 맞추기?
    private String profileImageUrl;
    private int height;
    private int weight;
    private String gender;
}
