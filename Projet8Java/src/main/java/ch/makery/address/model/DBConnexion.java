package ch.makery.address.model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class DBConnexion {
    public static Connection getConnection(){
        Connection con = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/ProjetENI";
            String username = "postgres";
            String password = "123456789";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
