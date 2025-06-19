package com.xworkz.duster.service;

import com.xworkz.duster.dto.DusterDTO;
import com.xworkz.duster.repository.DusterRepo;
import com.xworkz.duster.repository.DusterRepoImpl;

import java.util.Optional;

public class DusterServiceImpl implements DusterService{
    @Override
    public boolean save(DusterDTO dusterDTO) {
        boolean valid = true;
        if(dusterDTO==null){
            System.out.println("DTO returning null");
            valid = false;
        }

        if (dusterDTO.getMaterial() == null ) {
            System.out.println("Invalid material name");
            valid = false;
        }


        if (dusterDTO.getColor() == null ) {
            System.out.println("Invalid color");
            valid = false;
        }


        if (dusterDTO.getCost() > 150||dusterDTO.getCost()==0) {
            System.out.println("Cost is too high or zero");
            valid = false;
        }

        if (dusterDTO.getDateOfManufac()==null) {
            System.out.println("Invalid date of manufacture");
            valid = false;
        }


        if (dusterDTO.getQuantity()==0 ) {
            System.out.println("Minimum one quantity");
            valid = false;
        }


        if (dusterDTO.getIsUseful() == null ) {
            System.out.println("Invalid check ");
            valid = false;
        }


        System.out.println("data is valid, will save into DB using repo...");

        DusterRepo dusterRepo= new DusterRepoImpl();
        boolean repo = dusterRepo.persist(dusterDTO);

        return valid;
    }

    @Override
    public Optional<DusterDTO> findById(int id) {//>0
        System.out.println("running findById in dusterServiceImpl...");
        if(id>0)
        {
            System.out.println("id is valid :"+id);// call the repo
            DusterRepo dusterRepo=new DusterRepoImpl();
            return dusterRepo.findById(id);
        }

        return DusterService.super.findById(id);
    }
}
