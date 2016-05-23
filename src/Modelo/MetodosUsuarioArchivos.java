package Modelo;

import java.util.ArrayList;


public class MetodosUsuarioArchivos {
    
    private ArrayList <UsuarioArchivo> arrayUsuario;
    String arregloInformacionConsultada[]=new String[3];
    
    ArchivosUsuario archivoUsuario;

    public MetodosUsuarioArchivos() {
        arrayUsuario = new ArrayList<UsuarioArchivo>();
        archivoUsuario = new ArchivosUsuario();
        cargarArchivoAlArray();
    }
    
    public void cargarArchivoAlArray(){
        UsuarioArchivo arregloTemporalUsuario[]=archivoUsuario.devolverInformacionDelArchivoComoArreglo();
        
        for(int i=0; i<arregloTemporalUsuario.length; i++){
            arrayUsuario.add((UsuarioArchivo)arregloTemporalUsuario[i]);
            System.out.println("Se cargo un usuario del archivo al arrayUsuario.");
        }
    }
    
    public void escribirInformacionArchivo(){
        archivoUsuario.crearArchivo();
        for(int i=0; i<arrayUsuario.size(); i++){
            archivoUsuario.ingresarInformacionAlArchivoUsuario(arrayUsuario.get(i));
        }
        System.out.println("Se envió a escribir la informacion al archivo usuario.");
    }
    
    public void agregarUsuario(String informacion[]){
        UsuarioArchivo temporal = new UsuarioArchivo(informacion[0], informacion[1], informacion[2], informacion[3]);
        arrayUsuario.add(temporal);
        escribirInformacionArchivo();
    }
    
    public boolean consultarUsuario(String nombreUsuario){
        boolean existente=false;
        for(int i=0; i<arrayUsuario.size(); i++){
            if(arrayUsuario.get(i).getNombreUsuario().equals(nombreUsuario)){
                arregloInformacionConsultada[0]=arrayUsuario.get(i).getNombreCompletoUsuario();
                arregloInformacionConsultada[1]=arrayUsuario.get(i).getContraseña();
                arregloInformacionConsultada[2]=arrayUsuario.get(i).getCedula();
                existente =true;
            }
        }
        return existente;
    }
    
    public boolean consultarUsuarioLogin(String nombreUsuario, String contrasena){
        boolean existente=false;
        for(int i=0; i<arrayUsuario.size(); i++){
            if(arrayUsuario.get(i).getNombreUsuario().equals(nombreUsuario)&&arrayUsuario.get(i).getContraseña().equals(contrasena)){
                arregloInformacionConsultada[0]=arrayUsuario.get(i).getNombreCompletoUsuario();
                arregloInformacionConsultada[1]=arrayUsuario.get(i).getContraseña();
                arregloInformacionConsultada[2]=arrayUsuario.get(i).getCedula();
                existente =true;
            }
        }
        return existente;
    }
    
    public void modificarUsuario(String arreglo[]){
        for(int i=0; i<arrayUsuario.size(); i++){
            if(arrayUsuario.get(i).getNombreUsuario().equals(arreglo[0])){
                arrayUsuario.get(i).setNombreCompletoUsuario(arreglo[1]);
                arrayUsuario.get(i).setContraseña(arreglo[2]);
                arrayUsuario.get(i).setCedula(arreglo[3]);
                escribirInformacionArchivo();
            }
        }
    }
    
    public void eliminarUsuario(String arreglo[]){
        for(int i=0; i<arrayUsuario.size(); i++){
            if(arrayUsuario.get(i).getNombreUsuario().equals(arreglo[0])){
                arrayUsuario.remove(i);
                escribirInformacionArchivo();
            }
        }
    }
    public String[] getArregloInformacion(){
        return this.arregloInformacionConsultada;
    }
    
    public boolean verificarExistenciaDeArchivoDeUsuarios(){
       return archivoUsuario.verificarExistenciaDeArchivoDeUsuarios();
    }
}
