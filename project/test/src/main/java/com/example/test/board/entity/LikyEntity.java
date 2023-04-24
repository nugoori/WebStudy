package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
import com.example.test.board.entity.primaryKey.LikyPk;

=======
>>>>>>> 4493bae9acf3ce90f0edcbf14831983e747431f6
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
<<<<<<< HEAD
    private LikyPk likyPK;
=======
    private int boardNubmer;
    @Id
    private String userEmail;
>>>>>>> 4493bae9acf3ce90f0edcbf14831983e747431f6
    private String userNickname;
    private String userProfileImageUrl;
    
}
