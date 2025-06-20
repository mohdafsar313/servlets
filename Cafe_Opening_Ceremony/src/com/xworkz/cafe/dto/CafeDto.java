package com.xworkz.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CafeDto {

    private String cafeName;

    private String ownerName;

    private LocalDate establishedDate;

    private String cuisineType;

    private String hasWiFi;

    public CafeDto() {

    }
}

