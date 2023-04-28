package com.example.test.board.service;

import com.example.test.board.dto.request.board.PatchBoardDto;
import com.example.test.board.dto.request.product.PatchProductDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.product.DeleteProductResponseDto;
import com.example.test.board.dto.response.product.PatchProductResponseDto;

public interface ProductService {
    
    public ResponseDto<PatchProductResponseDto> patchProductResponseDto(String email, int boardNumber, int productNumber,PatchProductDto dto);
    public ResponseDto<DeleteProductResponseDto> deleteProductResponseDto(String email, int boardNumber, int productNumber);
}
