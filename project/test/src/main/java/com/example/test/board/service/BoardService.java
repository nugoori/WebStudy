package com.example.test.board.service;

import com.example.test.board.dto.request.board.LikeDto;
import com.example.test.board.dto.request.board.PostCommentDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.board.DeleteBoardResponseDto;
import com.example.test.board.dto.response.board.LikeResponseDto;
import com.example.test.board.dto.response.board.PostCommentResponseDto;


public interface BoardService {
    
    public ResponseDto<PostCommentResponseDto> postComment(String email, PostCommentDto dto);
    public ResponseDto<LikeResponseDto> like(String email, LikeDto dto);

    public ResponseDto<DeleteBoardResponseDto> deleteBoard(String email, int boardNumber);
}
