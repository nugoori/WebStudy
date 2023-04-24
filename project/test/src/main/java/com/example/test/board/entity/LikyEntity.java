package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.entity.primaryKey.LikyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Liky")
@Table(name="Liky")
public class LikyEntity {
    @Id
    private LikyPk likyPK;
    private String userNickname;
    private String userProfileImageUrl;
    
}
