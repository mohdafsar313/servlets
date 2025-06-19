package com.xworkz.duster.service;

import com.xworkz.duster.dto.DusterDTO;

import java.util.Optional;

public interface DusterService {
    boolean save(DusterDTO dusterDTO);

    default Optional<DusterDTO> findById(int id)
    {
        return  Optional.empty();
    }

}

