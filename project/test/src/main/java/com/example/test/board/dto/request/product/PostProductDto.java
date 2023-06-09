package com.example.test.board.dto.request.product;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProductDto {
    
    @Max(6)
    private int productNumber;
    private String productName;
    private String productPrice;
    private String productUrl;
    private String productImgUrl;
}
