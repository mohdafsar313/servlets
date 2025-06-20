package com.xworkz.cafe.repository;

import com.xworkz.cafe.dto.CafeDto;
import com.xworkz.cafe.service.CafeService;

import java.util.Optional;

public interface CafeRepo {
    boolean persist(CafeDto cafeDto);
    CafeDto[] findAll();

    default Optional<CafeDto> findById(int id)
    {
        return  Optional.empty();
    }
}
