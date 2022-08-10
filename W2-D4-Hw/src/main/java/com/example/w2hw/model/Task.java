package com.example.w2hw.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {

    private Integer id;
    private String title;
    private String description;
    private String status;

}
