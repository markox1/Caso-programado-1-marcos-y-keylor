package Modelo;

import java.util.ArrayList;


public class MetodosCursosArchivos {
    
    private ArrayList <CursosArchivo> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    
    ArchivosCurso archivoCursos;

    public MetodosCursosArchivos() {
        arrayCursos = new ArrayList<CursosArchivo>();
        archivoCursos = new ArchivosCurso();
        cargarArchivoAlArray();
    }
    
    public void escribirInformacionArchivo(){
        archivoCursos.crearArchivo();
        for(int i=0; i<arrayCursos.size(); i++){
            archivoCursos.ingresarInformacionAlArchivoCursos(arrayCursos.get(i));
        }
        System.out.println("Se envió a escribir la informacion al archivo curso.");
    }
    
    public void cargarArchivoAlArray(){
        CursosArchivo arregloTemporalCursos[]=archivoCursos.devolverInformacionDelArchivoComoArreglo();
        
        for(int i=0; i<arregloTemporalCursos.length; i++){
            arrayCursos.add((CursosArchivo)arregloTemporalCursos[i]);
            System.out.println("Se cargo un curso del archivo al arrayCursos.");
        }
    }
    
    public void agregarCurso(String informacion[]){
        CursosArchivo temporal = new CursosArchivo(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        escribirInformacionArchivo();
    }
    
    public void mostrarInformacion(){
        for(int i=0; i<arrayCursos.size(); i++){
            //System.out.println(arrayCursos.get(contador).getInformacion());
        }
    }
    public boolean consultarCurso(String sigla){
        boolean existente=false;
        for(int i=0; i<arrayCursos.size(); i++){
            if(arrayCursos.get(i).getSigla().equals(sigla)){
                arregloInformacionConsultada[0]=arrayCursos.get(i).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(i).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(i).getHorario();
                existente =true;
            }
        }
        return existente;
    }
    
    public void modificarCurso(String arreglo[]){
        for(int i=0; i<arrayCursos.size(); i++){
            if(arrayCursos.get(i).getSigla().equals(arreglo[0])){
                arrayCursos.get(i).setNombre(arreglo[1]);
                arrayCursos.get(i).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(i).setHorario(arreglo[3]);
                escribirInformacionArchivo();
            }
        }
    }
    
    public void eliminarCurso(String arreglo[]){
        for(int i=0; i<arrayCursos.size(); i++){
            if(arrayCursos.get(i).getSigla().equals(arreglo[0])){
                arrayCursos.remove(i);
                escribirInformacionArchivo();
            }
        }
    }
    public String[] getArregloInformacion(){
        return this.arregloInformacionConsultada;
    }
    
}
