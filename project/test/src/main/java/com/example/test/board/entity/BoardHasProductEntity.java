package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
import com.example.test.board.entity.primaryKey.BoardHasProductPk;

=======
>>>>>>> 4493bae9acf3ce90f0edcbf14831983e747431f6
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="BoardHasProduct")
@Table(name="BoardHasProduct")
public class BoardHasProductEntity {
<<<<<<< HEAD
    
    @Id
    private BoardHasProductPk boardHasProductPk;
=======
    @Id
    private int boardNumber;
    @Id
    private int productNumber;
>>>>>>> 4493bae9acf3ce90f0edcbf14831983e747431f6
}
