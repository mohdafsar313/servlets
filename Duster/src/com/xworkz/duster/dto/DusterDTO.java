package com.xworkz.duster.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DusterDTO {
    String material;

    String color;

    int cost;

    LocalDate dateOfManufac;

    int quantity;

    String isUseful;

}

