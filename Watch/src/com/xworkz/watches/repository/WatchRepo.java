package com.xworkz.watches.repository;

import com.xworkz.watches.dto.WatchDto;

public interface WatchRepo {
    boolean persist(WatchDto dto);
}
