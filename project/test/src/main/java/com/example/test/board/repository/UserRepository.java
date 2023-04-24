package com.example.test.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
}
