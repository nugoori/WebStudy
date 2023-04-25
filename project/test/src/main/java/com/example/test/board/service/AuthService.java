package com.example.test.board.service;

import com.example.test.board.dto.request.auth.SignInDto;
import com.example.test.board.dto.request.auth.SignUpDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.auth.SignInResponseDto;
import com.example.test.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    public ResponseDto<SignInResponseDto> signIn(SignInDto signInDto);
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto signUpDto);
    
}
