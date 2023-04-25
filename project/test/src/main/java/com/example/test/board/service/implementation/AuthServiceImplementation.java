package com.example.test.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.test.board.common.ResponseMessage;
import com.example.test.board.dto.request.auth.SignInDto;
import com.example.test.board.dto.request.auth.SignUpDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.auth.SignInResponseDto;
import com.example.test.board.dto.response.auth.SignUpResponseDto;
import com.example.test.board.entity.UserEntity;
import com.example.test.board.provider.TokenProvider;
import com.example.test.board.repository.UserRepository;
import com.example.test.board.service.AuthService;

@Service
public class AuthServiceImplementation implements AuthService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto signUpDto) {
        
        SignUpResponseDto data = null;

        String email = signUpDto.getEmail();
        String password = signUpDto.getPassword();
        String nickname = signUpDto.getNickname();

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            if (hasEmail) return ResponseDto.setFail(ResponseMessage.EXIST_EMAIL);
            
            boolean hasNickname = userRepository.existsByNickname(nickname);
            if (hasNickname) return ResponseDto.setFail(ResponseMessage.EXIST_NICKNAME);

            String encodedPassword = passwordEncoder.encode(password);
            signUpDto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(signUpDto);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto signInDto) {

        SignInResponseDto data = null;

        String email = signInDto.getEmail();
        String password = signInDto.getPassword();

        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFail(ResponseMessage.FAIL_SIGN_IN);

            boolean isMatch = passwordEncoder.matches(password, userEntity.getPassword());
            if (!isMatch) return ResponseDto.setFail(ResponseMessage.FAIL_SIGN_IN);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(email);
            data = new SignInResponseDto(userEntity, token);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    

    }
}
