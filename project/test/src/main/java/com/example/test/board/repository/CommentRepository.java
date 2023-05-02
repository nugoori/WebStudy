package com.example.test.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
    public List<CommentEntity> findByBoardNumberOrderByCommentWriteDateDesc(int boardNumber);

    public List<CommentEntity> findByBoardNumber(int boardNumber);

    @Transactional
    public void deleteByBoardNumber(int boardNumber);
}
