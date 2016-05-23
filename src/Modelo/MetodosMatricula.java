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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosMatricula {
    
    private ArrayList <Matricula> arrayMatricula;
    String arregloInformacionConsultada[]=new String[2];
     Connection con = null;
    public MetodosMatricula()
    {
        arrayMatricula=new ArrayList <Matricula>();
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
    public boolean registrarMatricula(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula(codigo,cedula,sigla) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
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
    /*public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);    
    }*/
    public void mostrarInformacion()
    {
        String codigo=arregloInformacionConsultada[0];
        String cedula=arregloInformacionConsultada[1];
        
        System.out.println(codigo +" " +cedula);
    }
    public boolean consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula WHERE codigo ='"+codigo+"'");
                
                while (rs.next()) 
                {
                   this.arregloInformacionConsultada[0] = rs.getString("cedula");
                   this.arregloInformacionConsultada[1]=rs.getString("sigla");
                   
                   
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
    
    /*public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                arregloInformacionConsultada[0]=arrayMatricula.get(contador).getCedula();
                arregloInformacionConsultada[1]=arrayMatricula.get(contador).getSigla();
                existe=true;
            }
        }
        return existe;
    }*/
    
    public boolean eliminar(String codigo){
       ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM matricula WHERE codigo='"+codigo+"'");
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
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
    public String devolverCodigo()
    {
        int codigo=1;
        String codigo1="";
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula ");
                
          while(rs.next()){
          codigo = codigo+1;
          codigo1=""+codigo;
          }
        }catch(Exception e){
        
        }
        
        
//        String codigo= "";
//        
//        if(arrayMatricula.size()==0)
//        {
//            codigo="1";
//        }
//        else
//        {
//            for(int contador=0;contador<arrayMatricula.size();contador++)
//            {
//                if(arrayMatricula.get(contador)!=null)
//                {
//                    codigo=arrayMatricula.get(contador).getCodigo();
//                }
//            }
//            int numero=Integer.parseInt(codigo);
//            numero++;
//            codigo=""+numero;
//        }
        
        return codigo1; 
    }
    
    
    
    
    
    
    
    
}
