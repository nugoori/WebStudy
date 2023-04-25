package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.test.board.entity.primaryKey.BoardHasProductPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="BoardHasProduct")
@Table(name="BoardHasProduct")
public class BoardHasProductEntity {
    
    @Id
    private BoardHasProductPk boardHasProductPk;

}
