package com.example.resorts.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/db_resorts"; // адрес БД
    private static String dbUser = "root";
    private static String dbPassword = "UJtgyu55b603nyZ";

    public static Connection openDBConnection(){
        // 1. зарегистрировать драйвер
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
                    .getDeclaredConstructor()
                    .newInstance();
            // 2. открываем соединение
            return DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
