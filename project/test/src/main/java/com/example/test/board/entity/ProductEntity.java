package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    //? 이름 맞추기?
    private String productImageUrl;
    private String productPurchaseUrl;
}
