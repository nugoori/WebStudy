package com.example.test.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.dto.request.board.PostBoardDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    @Id
    private int boardNumber;
    private String boardContent;
    private String boardImgUrl1;
    private String boardImgUrl2;
    private String boardImgUrl3;
    private String boardDateTime;
    private String tag;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileUrl;    
    private int likeCount;
    private int commentCount;
    private int viewCount;

    public BoardEntity(UserEntity userEntity, PostBoardDto postBoardDto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.boardContent = postBoardDto.getBoardContent();
        this.boardImgUrl1 = postBoardDto.getBoardImgUrl1();
        this.boardImgUrl2 = postBoardDto.getBoardImgUrl2();
        this.boardImgUrl3 = postBoardDto.getBoardImgUrl3();
        this.boardDateTime = simpleDateFormat.format(now);       
        this.writerEmail = userEntity.getEmail();
        this.writerNickname = userEntity.getNickname();
        this.commentCount = 0;
        this.likeCount = 0;
        this.viewCount = 0;
    }


    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        this.likeCount--;
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }
}
