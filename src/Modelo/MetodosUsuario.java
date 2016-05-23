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
import javax.swing.JOptionPane;

/**
 *
 * @author chelvivil
 */
public class MetodosUsuario {
String arregloInformacionConsultada[]=new String[3];
    
    Connection con = null;
    public MetodosUsuario() {
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
     public boolean registrarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuario(cedula,nombre,usuario,contraseña) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                JOptionPane.showMessageDialog(null,"Se registró correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean modificar(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE usuario SET cedula='"+informacion[0]+"'"+",nombre='"+ informacion[1]+"'"+",usuario='"+informacion[2]+"'"+",contraseña='"+informacion[3]+"'"+"WHERE cedula='"+ informacion[0]+"'");
                JOptionPane.showMessageDialog(null,"Se modificó correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean eliminar(String informacion[]){
       ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuario WHERE cedula='"+informacion[0]+"'");
                JOptionPane.showMessageDialog(null,"Se eliminó correctamente");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    
    public boolean consultarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuario WHERE siglaCurso ='"+informacion[0]+"'");
                
                while (rs.next()) 
                {
                   this.arregloInformacionConsultada[0] = rs.getString("nombre");
                   this.arregloInformacionConsultada[2]=rs.getString("usuario");
                   this.arregloInformacionConsultada[1]=""+ rs.getInt("contraseña");
                   
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
     public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }   
}
