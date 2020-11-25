/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jhonathan
 */
public class Conexion {


        public static final String USERNAME = "root";
        public static final String PASSWORD = "";
        public static final String HOST = "localhost";
        public static final String PORT = "3306";
        public static final String DATABASE = "epe3";
        public static final String CLASSNAME = "com.mysql.jdbc.Driver";
        public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

        public java.sql.Connection con;

        //constructor sin parametros
        public Conexion() {
            try {
                Class.forName(CLASSNAME);
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println("error Driver no encontrado");
            } catch (SQLException e) {
                System.out.println("Error en sql");
            }
        }// cierre constructor
      
    }


