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
@Entity(name="Comment")
@Table(name="Comment")
public class CommentEntity {
    @Id
    private int commentNumber;
    private int boardNumber;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileUrl;
    //? 이름 맞추기?
    private String commentWriteDate;
    private String commentContent;
}
