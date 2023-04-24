package com.example.test.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.board.entity.BoardHasProductEntity;
import com.example.test.board.entity.primaryKey.BoardHasProductPk;

@Repository
public interface BoardHasProductRepository extends JpaRepository<BoardHasProductEntity, BoardHasProductPk> {
    
}
