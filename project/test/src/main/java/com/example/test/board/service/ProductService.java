package com.example.test.board.service;

import com.example.test.board.dto.request.product.PatchProductDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.product.DeleteProductResponseDto;
import com.example.test.board.dto.response.product.PatchProductResponseDto;

public interface ProductService {
    
    public ResponseDto<PatchProductResponseDto> patchProduct(String email, PatchProductDto dto);
    public ResponseDto<DeleteProductResponseDto> deleteProduct(String email, int boardNumber, int productNumber);
}
