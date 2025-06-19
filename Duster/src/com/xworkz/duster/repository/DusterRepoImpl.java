package com.xworkz.duster.repository;

import com.xworkz.duster.constant.DBProperties;
import com.xworkz.duster.dto.DusterDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class DusterRepoImpl implements DusterRepo{
    @Override
    public boolean persist(DusterDTO dusterDTO) {
        System.out.println("running persist in DusterRepoImpl");
        if (dusterDTO != null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager
                        .getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());

                String sql = "insert into duster_details values (0,'"+ dusterDTO.getMaterial()+"','"+ dusterDTO.getColor()+"',"+ dusterDTO.getCost()+",'"+ dusterDTO.getDateOfManufac()+"',"+ dusterDTO.getQuantity()+",'"+ dusterDTO.getIsUseful()+"');";
                Statement statement = connection.createStatement();

                statement.executeUpdate(sql);
            }
            catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        return false;
    }

   @Override
    public DusterDTO[] findAll() {
        int index=0;
        int arraySize=1;
        DusterDTO[] dusterDtos=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            Connection connection = DriverManager.getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());
            String fetchAll ="select * from duster_details";
            PreparedStatement statement = connection.prepareStatement(fetchAll);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                dusterDtos=new DusterDTO[arraySize];
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getDate(4));
                System.out.println(resultSet.getInt(5));
                System.out.println(resultSet.getString(6));
                System.out.println("==========================================");
                DusterDTO dusterDTO=new DusterDTO();
                dusterDTO.setMaterial(resultSet.getString(1));
                dusterDTO.setColor(resultSet.getString(2));
                dusterDTO.setCost(resultSet.getInt(3));
                dusterDTO.setDateOfManufac(resultSet.getDate(4).toLocalDate());
                dusterDTO.setQuantity(resultSet.getInt(5));
                dusterDTO.setIsUseful(resultSet.getString(6));
                dusterDtos[index]=dusterDTO;
                arraySize++;
                index++;


            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dusterDtos;
    }

    @Override
    public Optional<DusterDTO> findById(int id) {
        System.out.println("running findById in dusterRepositoryImpl...");
        //JDBC
        // Load & register , Create the Connection , Preppare the Statemtne , Execute the statement
        //URL,UN,PWD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DBProperties.URL.getProp(), DBProperties.USER_NAME.getProp(), DBProperties.SECRET.getProp());
            String findByIdSQL="select * from duster_details dust where id="+id+"";
            System.out.println("findById :"+findByIdSQL);
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(findByIdSQL);
            System.out.println("resultSet :"+resultSet);
            while(resultSet.next())
            {
                int pk= resultSet.getInt("id");
                String material=resultSet.getString("material");
                String color=resultSet.getString("color");
                int cost=resultSet.getInt("cost");
                LocalDate manfdate=resultSet.getDate("dateOfManufac").toLocalDate();
                int quantity=resultSet.getInt("quantity");
                String useFul=resultSet.getString("isUseful");

                DusterDTO  dusterDTO=new DusterDTO(material,color,cost,manfdate,quantity,useFul);
                return  Optional.of(dusterDTO);
            }

        }
        catch (SQLException | ClassNotFoundException exception)
        {
            System.err.println("SQLException in findById "+exception.getMessage());
        }
        return Optional.empty();
    }
}
