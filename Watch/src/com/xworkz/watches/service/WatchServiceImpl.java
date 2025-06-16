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
        if (dto != null) {
            String brand = dto.getBrand();
            if (brand.length() >= 3 && brand.length() < 25) {
                System.out.println("Brand name is valid.");
            } else {
                System.out.println("Brand should be between 3 and 25 characters.");
            }

            String model = dto.getModel();
            if (model.length() >= 2 && model.length() < 20) {
                System.out.println("Model is valid.");
            } else {
                System.out.println("Model should be between 2 and 20 characters.");
            }

            double price = dto.getPrice();
            if (price >= 500 && price <= 50000) {
                System.out.println("Price is valid.");
            } else {
                System.out.println("Price should be in range 500 to 50000.");
            }

            String manufactureDate = dto.getManufactureDate();
            if (manufactureDate != null && !manufactureDate.isEmpty()) {
                System.out.println("Manufacture date is valid.");
            } else {
                System.out.println("Manufacture date should not be null or empty.");
            }

            String isSmart = dto.getIsSmart();
            if (isSmart != null && (isSmart.equalsIgnoreCase("yes") ||
                    isSmart.equalsIgnoreCase("no"))) {
                System.out.println("isSmart is valid.");
            } else {
                System.out.println("isSmart should be 'yes' or 'no'.");
            }

            int warrantyYears = dto.getWarrantyYears();
            if (warrantyYears >= 0 && warrantyYears <= 10) {
                System.out.println("Warranty years is valid.");
            } else {
                System.out.println("Warranty should be 0 to 10 years.");
            }
        } else {
            System.out.println("WatchDTO is null.");
        }
        return true;
    }
}



