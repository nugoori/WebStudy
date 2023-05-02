package com.example.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.board.common.ApiPattern;
import com.example.test.board.dto.request.product.PatchProductDto;
import com.example.test.board.dto.response.ResponseDto;
import com.example.test.board.dto.response.product.DeleteProductResponseDto;
import com.example.test.board.dto.response.product.PatchProductResponseDto;
import com.example.test.board.service.ProductService;

@RestController
@RequestMapping(ApiPattern.PRODUCT)

public class ProductController {

    @Autowired ProductService productService;

    private final String DELETE_PRODUCT = "/{boardNumber}/{productNumber}";
    private final String PATCH_PRODUCT = "/patch-product";

    @PatchMapping(PATCH_PRODUCT)
    private ResponseDto<PatchProductResponseDto> patchProduct(
        @AuthenticationPrincipal String email,
        // @PathVariable("boardNumber") int boardNumber,
        // @PathVariable("productNumber") int productNumber,
        @PathVariable PatchProductDto dto
    ) {
        ResponseDto<PatchProductResponseDto> response = productService.patchProduct(email, dto);
        return response;
    }
    
    @DeleteMapping(DELETE_PRODUCT)
    private ResponseDto<DeleteProductResponseDto> deleteProduct(
        @AuthenticationPrincipal String email,
        @PathVariable("boardNumber") int boardNumber,
        @PathVariable("productNumber") int productNumber
    ) { 
        ResponseDto<DeleteProductResponseDto> response = productService.deleteProduct(email, boardNumber, productNumber);
        return response;
    }
}
