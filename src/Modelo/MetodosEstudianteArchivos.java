package Modelo;

import java.util.ArrayList;


public class MetodosEstudianteArchivos {
    
    private ArrayList <EstudianteArchivo> arrayEstudiante;
    String arregloInformacionConsultada[] = new String[2];
    
    ArchivosEstudiante archivosEstudiante;
    
    public MetodosEstudianteArchivos() {
        arrayEstudiante = new ArrayList <EstudianteArchivo>();
        archivosEstudiante = new ArchivosEstudiante();
        cargarArchivoAlArray();
    }
    
    public void escribirInformacionArchivo(){
        archivosEstudiante.crearArchivo();
        for(int i=0; i<arrayEstudiante.size(); i++){
            archivosEstudiante.ingresarInformacionAlArchivoEstudiante(arrayEstudiante.get(i));
        }
        System.out.println("Se envió a escribir la informacion al archivo estudiante.");
    }
    
    public void cargarArchivoAlArray(){
        EstudianteArchivo arregloTemporalEstudiante[]=archivosEstudiante.devolverInformacionDelArchivoComoArreglo();
        
        for(int i=0; i<arregloTemporalEstudiante.length; i++){
            arrayEstudiante.add((EstudianteArchivo)arregloTemporalEstudiante[i]);
            System.out.println("Se cargo un estudiante del archivo al arrayEstudiante.");
        }
    }
    
    public void agregarEstudiante(String informacion[]){
        EstudianteArchivo temporal = new EstudianteArchivo(informacion[0], informacion[1], informacion[2]);
        arrayEstudiante.add(temporal);
        escribirInformacionArchivo();
    }
    
    public void mostrarInformacion(){
        for(int i=0; i<arrayEstudiante.size(); i++){
            System.out.println(arrayEstudiante.get(i).getInformacion());
        }
    }
    
    public boolean consultarEstudiante(String cedula){
        boolean existe = false;
        for(int i=0; i<arrayEstudiante.size(); i++){
            if(arrayEstudiante.get(i).getCedula().equals(cedula)){
                arregloInformacionConsultada[0]=arrayEstudiante.get(i).getNombreCompleto();
                arregloInformacionConsultada[1]=arrayEstudiante.get(i).getDireccion();
                existe=true;
            }
        }
        return existe;
    }
    
    public void modificarEstudiante(String arreglo[]){
        for(int i=0; i<arrayEstudiante.size(); i++){
            if(arrayEstudiante.get(i).getCedula().equals(arreglo[0])){
                arrayEstudiante.get(i).setNombreCompleto(arreglo[1]);
                arrayEstudiante.get(i).setDireccion(arreglo[2]);
                escribirInformacionArchivo();
            }
        }
    }
    
    public void eliminarEstudiante(String arreglo[]){
        for(int i=0; i<arrayEstudiante.size(); i++){
            if(arrayEstudiante.get(i).getCedula().equals(arreglo[0])){
                arrayEstudiante.remove(i);
                escribirInformacionArchivo();
            }
            
        }
    }
    
    public String[] getArregloInformacion(){
        return this.arregloInformacionConsultada;
    }
    
}
