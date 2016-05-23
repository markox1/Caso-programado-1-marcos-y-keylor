/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chelvivil
 */
public class MetodosLogin {
    Connection con = null;

    public MetodosLogin() {
        realizarConexion();
    }
     
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3307/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    public boolean verificarAdmin(){
     ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuario");
                
                while (rs.next()) 
                {
                  existe=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            existe=false;
        }
        return existe;
    }
    
    
    public boolean consultarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuario WHERE usuario ='"+informacion[0]+"' AND contraseña='"+informacion[1]+"'");
                
                while (rs.next()) 
                {
                   System.out.println("login exitoso");
                   
                     existe=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            existe=false;
        }
        return existe;
    }
}
