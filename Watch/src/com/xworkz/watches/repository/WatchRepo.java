package com.xworkz.watches.repository;

import com.xworkz.watches.dto.WatchDto;

import java.util.Optional;

public interface WatchRepo {
    boolean persist(WatchDto dto);

    default Optional<WatchDto> findById(int id)
    {
        return  Optional.empty();
    }

}
