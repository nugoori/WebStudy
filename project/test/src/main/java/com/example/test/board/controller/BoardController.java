package com.example.test.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.board.common.ApiPattern;
import com.example.test.board.dto.request.board.LikeDto;
import com.example.test.board.dto.request.board.PostCommentDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.board.DeleteBoardResponseDto;
import com.example.test.board.dto.response.board.LikeResponseDto;
import com.example.test.board.dto.response.board.PostCommentResponseDto;
import com.example.test.board.service.BoardService;

@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {

    @Autowired private BoardService boardService;

    private final String POST_COMMENT = "/comment";
    private final String LIKE = "/like";
    private final String DELETE_BOARD = "/{boardNumber}";
    
    @PostMapping(POST_COMMENT)
    public ResponseDto<PostCommentResponseDto> postComment(  
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostCommentDto requestBody
    ) {
        ResponseDto<PostCommentResponseDto> response = boardService.postComment(email, requestBody);
        return response;
    }

    @PostMapping(LIKE)
    public ResponseDto<LikeResponseDto> like(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody LikeDto requestBody
    ) {
        ResponseDto<LikeResponseDto> response = boardService.like(email, requestBody);
        return response;
    }

    @DeleteMapping(DELETE_BOARD)
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(
        @AuthenticationPrincipal String email,
        @PathVariable("boardNumber") int boardNumber
    ) {
        ResponseDto<DeleteBoardResponseDto> response = boardService.deleteBoard(email, boardNumber);
        return response;
    }
}
