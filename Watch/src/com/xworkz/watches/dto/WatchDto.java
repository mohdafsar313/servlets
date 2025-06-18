package com.xworkz.watches.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor

public class WatchDto {

        private String brand;
        private String model;
        private double price;
        private LocalDate mfgDate;
        private String smart;
        private int warranty;


    /*public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setMfgDate(String mfgDate) {
            this.mfgDate = mfgDate;
        }

        public void setSmart(String smart) {
            this.smart = smart;
        }

        public void setWarranty(int warranty) {
            this.warranty = warranty;
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

        public String getMfgDate() {
            return mfgDate;
        }

        public String getSmart() {
            return smart;
        }

        public int getWarranty() {
            return warranty;*/
        /*}*/
    }

