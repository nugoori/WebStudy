package com.example.test.board.dto.request.board;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBoardDto {

    @NotBlank
    private String boardContent;

    private String boardImgUrl1;
    private String boardImgUrl2;
    private String boardImgUrl3;

    @Max(6)
    private int productNumber;
    private String productName;
    private String productPrice;
    private String productImgUrl;
    private String productPurchaseUrl;
    
}
