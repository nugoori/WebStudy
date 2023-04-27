package com.example.test.board.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="BoardHasProduct")
@Table(name="BoardHasProduct")
@IdClass(BoardHasProductEntity.class)
public class BoardHasProductEntity implements Serializable {
    
    @Id
    private int boardNumber;
    @Id
    private int productNumber;
}
