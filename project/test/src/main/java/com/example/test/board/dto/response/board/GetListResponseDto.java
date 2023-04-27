package com.example.test.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.example.test.board.entity.BoardEntity;
import com.example.test.board.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListResponseDto {
    
    private int boardNumber;
    private String boardContent;
    private String boardImgUrl1;
    private String boardImgUrl2;
    private String boardImgUrl3;
    private String boardDateTime;
    private String tag;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileUrl;    
    private int likeCount;
    private int commentCount;
    private int viewCount;

    private int productNumber;
    private String productName;
    private String productPrice;
    private String productImgUrl;
    private String productPurchaseUrl;

    public GetListResponseDto(BoardEntity boardEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardContent = boardEntity.getBoardContent();
        this.boardImgUrl1 = boardEntity.getBoardImgUrl1();
        this.boardImgUrl2 = boardEntity.getBoardImgUrl2();
        this.boardImgUrl3 = boardEntity.getBoardImgUrl3();
        this.tag = boardEntity.getTag();
        this.writerEmail = boardEntity.getWriterEmail();
        this.writerNickname = boardEntity.getWriterNickname();
        this.writerProfileUrl = boardEntity.getWriterProfileUrl();
        this.likeCount = boardEntity.getLikeCount();
        this.commentCount = boardEntity.getCommentCount();
        this.viewCount = boardEntity.getViewCount();
    }

    public GetListResponseDto(ProductEntity productEntity) {
        this.productNumber = productEntity.getProductNumber();
        this.productName = productEntity.getProductName();
        this.productPrice = productEntity.getProductPrice();
        this.productPurchaseUrl = productEntity.getProductPurchaseUrl();
        this.productImgUrl = productEntity.getProductImageUrl();
    }

    public static List<GetListResponseDto> copyList(List<BoardEntity> boardEntityList) {
        List<GetListResponseDto> list = new ArrayList<>();
        
        for (BoardEntity boardEntity: boardEntityList) {
            GetListResponseDto dto = new GetListResponseDto(boardEntity);
            list.add(dto);
        }
        return list;
    }

    public static List<GetListResponseDto> copy(List<ProductEntity> productEntityList) {
        List<GetListResponseDto> list = new ArrayList<>();

        for (ProductEntity productEntity: productEntityList) {
            GetListResponseDto dto = new GetListResponseDto(productEntity);
            list.add(dto);
        }
        return list;
    }
}
