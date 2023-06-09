package com.example.test.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.board.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    
    public ProductEntity findByProductNumber(int productNumber);

    @Transactional
    public void deleteByProductNumber(int productNubmer);
}
