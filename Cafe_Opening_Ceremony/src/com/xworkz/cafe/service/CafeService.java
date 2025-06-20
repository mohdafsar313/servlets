package com.xworkz.cafe.service;

import com.xworkz.cafe.dto.CafeDto;

import java.util.Optional;

public interface CafeService {
    boolean save(CafeDto cafeDto);

    default Optional<CafeDto> findById(int id)
    {
        return  Optional.empty();
    }
}
