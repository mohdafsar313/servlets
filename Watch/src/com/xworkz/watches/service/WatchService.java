package com.xworkz.watches.service;

import com.xworkz.watches.dto.WatchDto;

import java.util.Optional;

public interface WatchService {
    boolean save(WatchDto dto);

    default Optional<WatchDto> findById(int id)
    {
        return  Optional.empty();
    }
}
