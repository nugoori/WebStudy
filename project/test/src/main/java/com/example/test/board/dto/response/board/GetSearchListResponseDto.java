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
public class GetSearchListResponseDto {
    
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

    public GetSearchListResponseDto(BoardEntity boardEntity) {
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

    public GetSearchListResponseDto(ProductEntity productEntity) {
        this.productNumber = productEntity.getProductNumber();
        this.productName = productEntity.getProductName();
        this.productPrice = productEntity.getProductPrice();
        this.productPurchaseUrl = productEntity.getProductPurchaseUrl();
        this.productImgUrl = productEntity.getProductImageUrl();
    }

    public static List<GetSearchListResponseDto> copyList(List<BoardEntity> boardEntityList) {
        List<GetSearchListResponseDto> list = new ArrayList<>();
        
        for (BoardEntity boardEntity: boardEntityList) {
            GetSearchListResponseDto dto = new GetSearchListResponseDto(boardEntity);
            list.add(dto);
        }
        return list;
    }

    public static List<GetSearchListResponseDto> copy(List<ProductEntity> productEntityList) {
        List<GetSearchListResponseDto> list = new ArrayList<>();

        for (ProductEntity productEntity: productEntityList) {
            GetSearchListResponseDto dto = new GetSearchListResponseDto(productEntity);
            list.add(dto);
        }
        return list;
    }
}
