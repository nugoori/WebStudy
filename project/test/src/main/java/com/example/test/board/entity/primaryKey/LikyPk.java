package com.example.test.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import com.example.test.board.entity.BoardEntity;
import com.example.test.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikyPk implements Serializable {
    @Column(name="board_number")
    private int boardNumber;
    @Column(name="user_email")
    private String email;

    public LikyPk(BoardEntity boardEntity, UserEntity userEntity) {

        this.boardNumber = boardEntity.getBoardNumber();
        this.email = userEntity.getEmail();
    }
}
