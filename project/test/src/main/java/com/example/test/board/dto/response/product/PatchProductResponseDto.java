package com.example.test.board.dto.response.product;

import com.example.test.board.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProductResponseDto {
    
    private ProductEntity product;
}
