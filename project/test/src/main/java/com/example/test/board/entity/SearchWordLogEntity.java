package com.example.test.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="SearchWordLog")
@Table(name="SearchWordLog")
public class SearchWordLogEntity {
    @Id
    private int sequence;
    private String searchWord;
}
