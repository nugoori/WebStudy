package com.example.test.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.board.common.ApiPattern;
import com.example.test.board.dto.request.auth.SignInDto;
import com.example.test.board.dto.request.auth.SignUpDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.auth.SignInResponseDto;
import com.example.test.board.dto.response.auth.SignUpResponseDto;
import com.example.test.board.service.AuthService;

@RestController
@RequestMapping(ApiPattern.AUTH)
public class AuthController {
    
    private final String SIGN_IN = "/sign-in";
    private final String SIGN_UP = "/sign-up";

    @Autowired AuthService authService;

    @PostMapping(SIGN_IN)
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

    @PostMapping(SIGN_UP)
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto requestBody) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

}
