package com.example.test.board.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Liky")
@Table(name="Liky")
@IdClass(LikyEntity.class)
public class LikyEntity implements Serializable{
    @Id
    private int boardNumber;
    @Id
    private String email;
    private String userNickname;
    private String userProfileImageUrl;
    

    public LikyEntity(UserEntity userEntity, int boardNumber) {
        this.email = userEntity.getEmail();
        this.boardNumber = boardNumber;
        this.userNickname = userEntity.getNickname();
        
    }
}
