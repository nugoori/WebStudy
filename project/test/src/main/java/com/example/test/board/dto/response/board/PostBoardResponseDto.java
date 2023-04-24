package com.example.test.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.example.test.board.entity.BoardEntity;
import com.example.test.board.entity.CommentEntity;
import com.example.test.board.entity.LikyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBoardResponseDto {
    
    private BoardEntity board;

    private List<LikyEntity> likeList;

    private List<CommentEntity> commentList;

    public PostBoardResponseDto(BoardEntity board) {
        this.board = board;
        this.likeList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }
}
