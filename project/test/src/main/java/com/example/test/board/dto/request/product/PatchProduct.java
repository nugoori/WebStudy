package com.example.test.board.dto.request.product;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProduct {
    
    @NotBlank
    @Min(1)
    private int boardNumber;

    @Max(6)
    private int productNumber;
    private String productName;
    private String productPrice;
    private String productPerchaseUrl;
    private String productImgUrl;
}
