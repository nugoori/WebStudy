package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.dto.request.product.PatchProductDto;
import com.example.test.board.dto.request.product.PostProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Product")
@Table(name="Product")
public class ProductEntity {
    @Id
    private int productNumber;
    private String productName;
    private String productPrice;
    private String productImgUrl;
    private String productUrl;

    public ProductEntity(UserEntity userEntity, PostProductDto dto) {
        this.productName = dto.getProductName();
        this.productImgUrl = dto.getProductImgUrl();
        this.productPrice = dto.getProductPrice();
        this.productUrl = dto.getProductUrl();
    }

    public void patch(PatchProductDto dto) {
        this.productName = dto.getProductName();
        this.productImgUrl = dto.getProductImgUrl();
        this.productPrice = dto.getProductPrice();
        this.productUrl = dto.getProductUrl();
    }
}
