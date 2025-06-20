package com.xworkz.cafe.repository;

import com.xworkz.cafe.constant.DBProperties;
import com.xworkz.cafe.dto.CafeDto;

import java.sql.*;


public class CafeRepoImpl implements CafeRepo{
    @Override
    public boolean persist(CafeDto cafeDto) {
        System.out.println("running persist in DusterRepoImpl");
        if (cafeDto!=null){

            try(Connection connection = DriverManager
                    .getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String query = "insert into cafe_details(cafe_name,owner_name,established_date,cuisine_type,has_wifi) values(?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,cafeDto.getCafeName());
                statement.setString(2, cafeDto.getOwnerName());
                statement.setDate(3, Date.valueOf(cafeDto.getEstablishedDate()));
                statement.setString(4,cafeDto.getCuisineType());
                statement.setString(5,cafeDto.getHasWiFi());
                int result =  statement.executeUpdate();
                if(result>0){
                    return true;
                }

            }catch (ClassNotFoundException | SQLException e){

            }

        }
        return false;
    }

    @Override
    public CafeDto[] findAll() {
        return new CafeDto[0];
    }
}
