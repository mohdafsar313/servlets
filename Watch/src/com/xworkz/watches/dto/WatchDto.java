package com.xworkz.watches.dto;

public class WatchDto {

        private String brand;
        private String model;
        private double price;
        private String manufactureDate;
        private String isSmart;
        private int warrantyYears;


        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setManufactureDate(String manufactureDate) {
            this.manufactureDate = manufactureDate;
        }

        public void setIsSmart(String isSmart) {
            this.isSmart = isSmart;
        }

        public void setWarrantyYears(int warrantyYears) {
            this.warrantyYears = warrantyYears;
        }


        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        public String getManufactureDate() {
            return manufactureDate;
        }

        public String getIsSmart() {
            return isSmart;
        }

        public int getWarrantyYears() {
            return warrantyYears;
        }
    }

