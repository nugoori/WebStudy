package com.example.test.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.board.entity.LikyEntity;
import com.example.test.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPk>{

    public List<LikyEntity> findByBoardNumber(int boardNumber);

    public LikyEntity findByEmailAndBoardNumber(String email, int boardNumber);

    @Transactional
    public void deleteByBoardNumber(int boardNumber);
}
