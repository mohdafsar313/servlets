package com.xworkz.watches.service;

import com.xworkz.watches.dto.WatchDto;
import com.xworkz.watches.repository.WatchRepo;
import com.xworkz.watches.repository.WatchRepoImpl;

public class WatchServiceImpl implements WatchService {

    public WatchServiceImpl() {
        System.out.println("Running in the WatchServiceImpl constructor");
    }

    @Override
    public boolean save(WatchDto dto) {
        System.out.println("save method in WatchServiceImpl class");

        WatchRepo watchRepo = new WatchRepoImpl();
        return watchRepo.persist(dto);
    }
}

