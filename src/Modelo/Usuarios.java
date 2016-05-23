/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author chelvivil
 */
public class Usuarios {
    private String cedula;
    private String nombre;
    private String usuario;
    private String Contraseña;

    public Usuarios() {
    }

    public Usuarios(String cedula, String nombre, String usuario, String Contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.Contraseña = Contraseña;
    }
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
}
