package com.example.resorts.db;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ResortControl {
    final static String complete = "operate with resort is successful";
    final static String fail = "Ooops, it's fail!";
    // 1. получить все курорты
    public static String[] getAllResorts() {

        // открываем соединение
        try (Connection conn = DBConnection.openDBConnection()) {

            assert conn != null;
            // 1. создать выражения
            Statement statement = conn.createStatement();
            // 2. выполнить запрос
            ResultSet queryResult = statement.executeQuery("SELECT * FROM res_table");
            // 3. выполнить перебор результатов
            LinkedList<String> resList = new LinkedList<>();
            while (queryResult.next()) {
                String name = queryResult.getString(2);
                String country = queryResult.getString(3);
                String season = queryResult.getString(4);
                String price = queryResult.getString(5);
                resList.add(name + " " + country + " " + season + " " + price);
            }
            // 4. вернуть результат
            return resList.toArray(new String[0]);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String[] getResByParam(String param, String value) {
        // открываем соединение
        try (Connection conn = DBConnection.openDBConnection()) {

            assert conn != null;
            // 1. создать выражения
//            Statement statement = conn.createStatement();
            // 2. выполнить запрос
            String requestSQL = "SELECT * FROM db_resorts.res_table WHERE " + param +  " = " + "'" + value + "'";
            PreparedStatement ps = conn.prepareStatement(requestSQL);

//            ResultSet queryResult = statement.executeQuery("SELECT * FROM res_table WHERE ? = ?");
//            ps.setString(2, param);
//            ps.setString(1, param);
//            ps.setString(2, value);

            ResultSet queryResult = ps.executeQuery();
            // 3. выполнить перебор результатов
            LinkedList<String> resList1 = new LinkedList<>();
            while (queryResult.next()) {
                String name = queryResult.getString(2);
                String country = queryResult.getString(3);
                String season = queryResult.getString(4);
                String price = queryResult.getString(5);
                resList1.add(name + " " + country + " " + season + " " + price);
            }
            // 4. вернуть результат
            return resList1.toArray(new String[0]);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String createRes(String name, String country, String season, String price) {

        // открываем соединение
        try (Connection conn = DBConnection.openDBConnection()) {

            assert conn != null;
            // 1. создать выражения
            PreparedStatement ps = conn.prepareStatement("INSERT INTO db_resorts.res_table (name, country, season, price) VALUES (?,?,?,?)");
            // 2. выполнить запрос
            ps.setString(1, name);
            ps.setString(2, country);
            ps.setString(3, season);
            ps.setInt(4, Integer.parseInt(price));

            int rs = ps.executeUpdate();

            if (rs == 1) {
                return complete;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fail;
    }
    public static String updateRes(String param, String value, String newParams) {
//
//        String complete = "create resort is successful";
//        String fail = "Ooops, it's fail!";
        // открываем соединение
        try (Connection conn = DBConnection.openDBConnection()) {

            assert conn != null;
            // 1. создать выражения
            PreparedStatement ps = conn.prepareStatement("UPDATE db_resorts.res_table SET " + newParams +
                    " WHERE " + param +  " = " + "'" + value + "'");
            // 2. выполнить запрос
//            ps.setString(1, name);
//            ps.setString(2, country);
//            ps.setString(3, season);
//            ps.setInt(4, Integer.parseInt(price));


            int rs = ps.executeUpdate();
//            ResultSet queryResult = ps.executeQuery();

            if (rs > 0) {
                    return complete;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fail;
    }

    public static String deleteRes(String param, String value) {
//
//        String complete = "create resort is successful";
//        String fail = "Ooops, it's fail!";
        // открываем соединение
        try (Connection conn = DBConnection.openDBConnection()) {

            assert conn != null;
            // 1. создать выражения
            PreparedStatement ps = conn.prepareStatement("DELETE FROM db_resorts.res_table " +
                    " WHERE " + param +  " = " + "'" + value + "'");
            int rs = ps.executeUpdate();
//            ResultSet queryResult = ps.executeQuery();

            if (rs > 0) {
                return complete;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fail;
    }
}