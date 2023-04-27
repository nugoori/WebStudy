package com.example.test.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.dto.request.board.PostCommentDto;

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
    private String commentWriteDate;
    private String commentContent;

    public CommentEntity(UserEntity userEntity, PostCommentDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.writerEmail = userEntity.getEmail();
        this.writerNickname = userEntity.getNickname();
        this.boardNumber = dto.getBoardNumber();
        this.commentWriteDate = simpleDateFormat.format(now);
        this.commentContent = dto.getCommentContent();
        
    }
}
