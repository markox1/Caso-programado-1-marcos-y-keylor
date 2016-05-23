package Modelo;

import java.io.Serializable;


public class UsuarioArchivo implements Serializable{
    
    
    private String nombreUsuario;
    private String nombreCompletoUsuario;
    private String contraseña;
    private String cedula;

    public UsuarioArchivo(String nombreUsuario, String nombreCompletoUsuario, String contraseña, String cedula) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompletoUsuario = nombreCompletoUsuario;
        this.contraseña = contraseña;
        this.cedula = cedula;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompletoUsuario() {
        return nombreCompletoUsuario;
    }

    public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
        this.nombreCompletoUsuario = nombreCompletoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getInformacion()
    {
        return "Nombre Usuario"+ nombreUsuario +"Nombre Completo"+nombreCompletoUsuario+"Contraseña"+contraseña+"tipo";
    }
}
