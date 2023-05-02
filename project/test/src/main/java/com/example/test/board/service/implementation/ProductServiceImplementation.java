package com.example.test.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.board.common.ResponseMessage;
import com.example.test.board.dto.request.product.PatchProductDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.product.DeleteProductResponseDto;
import com.example.test.board.dto.response.product.PatchProductResponseDto;
import com.example.test.board.entity.BoardEntity;
import com.example.test.board.entity.ProductEntity;
import com.example.test.board.entity.UserEntity;
import com.example.test.board.repository.BoardRepository;
import com.example.test.board.repository.ProductRepository;
import com.example.test.board.repository.UserRepository;
import com.example.test.board.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
    
    @Autowired private UserRepository userRepository;
    @Autowired private BoardRepository boardRepository;
    @Autowired private ProductRepository productRepository;

    public ResponseDto<PatchProductResponseDto> patchProduct(String email, PatchProductDto dto) {
        
        PatchProductResponseDto data = null;

        int boardNumber = dto.getBoardNumber();
        int productNumber = dto.getProductNumber();

        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_BOARD);

            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
            if (productEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_PRODUCT);

            productEntity.patch(dto);
            productRepository.save(productEntity);

            data = new PatchProductResponseDto(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

public ResponseDto<DeleteProductResponseDto> deleteProduct(String email, int boardNumber, int productNumber) {

    DeleteProductResponseDto data = null;

    try {
        BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
        if (boardEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_BOARD);

        ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
        if (productEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_PRODUCT);

        boolean isEqualWriter = email.equals(boardEntity.getWriterEmail());
        if (!isEqualWriter) return ResponseDto.setFail(ResponseMessage.NOT_PERMISSION);

        productRepository.delete(productEntity);

        data = new DeleteProductResponseDto(true);

    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
    }
    return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
}





}
