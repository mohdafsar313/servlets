package com.xworkz.duster.repository;

import com.xworkz.duster.dto.DusterDTO;

import java.util.Optional;

public interface DusterRepo {
    boolean persist(DusterDTO dusterDTO);
    /*DusterDTO[] findAll();*/

    default Optional<DusterDTO> findById(int id)
    {
        return  Optional.empty();
    }

}
