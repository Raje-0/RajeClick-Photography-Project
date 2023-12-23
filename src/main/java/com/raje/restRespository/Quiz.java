package com.raje.restRespository;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.raje.restEntity.Question;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

}
