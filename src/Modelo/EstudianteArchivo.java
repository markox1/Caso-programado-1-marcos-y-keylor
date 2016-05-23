package Modelo;

import java.io.Serializable;


public class EstudianteArchivo implements Serializable {
    
    private String cedula;
    private String nombreCompleto;
    private String direccion;

    public EstudianteArchivo(String cedula, String nombreCompleto, String direccion) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getInformacion()
    {
        return "Cédula: "+cedula+" Nombre completo: "+nombreCompleto+" Dirección: "+direccion;
    } 
}
