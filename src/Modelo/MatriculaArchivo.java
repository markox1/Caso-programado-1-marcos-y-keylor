package Modelo;

import java.io.Serializable;


public class MatriculaArchivo implements Serializable{
    private String codigo;
    private String cedula;
    private String sigla;

    public MatriculaArchivo(String codigo, String cedula, String sigla) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.sigla = sigla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public String getInformacion()
    {
        return getCodigo()+" "+getCedula()+" "+getSigla();
    }
        
}
