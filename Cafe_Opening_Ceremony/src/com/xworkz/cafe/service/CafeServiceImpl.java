package com.xworkz.cafe.service;

import com.xworkz.cafe.service.CafeService;
import com.xworkz.cafe.dto.CafeDto;
import com.xworkz.cafe.repository.CafeRepo;
import com.xworkz.cafe.repository.CafeRepoImpl;

import java.util.Optional;

public class CafeServiceImpl implements CafeService {
    @Override
    public boolean save(CafeDto cafeDto) {
        boolean valid = true;
        if(cafeDto==null){
            System.out.println("DTO returning null");
            valid = false;
        }

        if (cafeDto.getCafeName() == null ) {
            System.out.println("Invalid cafe name");
            valid = false;
        }


        if (cafeDto.getOwnerName() == null ) {
            System.out.println("Invalid owner name");
            valid = false;
        }


        if (cafeDto.getEstablishedDate() ==null) {
            System.out.println("invalid establishment date");
            valid = false;
        }

        if (cafeDto.getCuisineType()==null) {
            System.out.println("Invalid cuisine type");
            valid = false;
        }


        if (cafeDto.getHasWiFi()==null ) {
            System.out.println("wifi problem");
            valid = false;
        }



        System.out.println("data is valid, will save into DB using repo...");

        CafeRepo cafeRepo= new CafeRepoImpl();
        boolean repo = cafeRepo.persist(cafeDto);

        return valid;
    }

    @Override
    public Optional<CafeDto> findById(int id) {//>0
        System.out.println("running findById in CafeServiceImpl...");
        if(id>0)
        {
            System.out.println("id is valid :"+id);// call the repo
            CafeRepo cafeRepo=new CafeRepoImpl();
            return cafeRepo.findById(id);
        }
        return CafeService.super.findById(id);
    }
}
