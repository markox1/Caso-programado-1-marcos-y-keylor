package Modelo;

import java.util.ArrayList;


public class MetodosMatriculaArchivos {
    
    private ArrayList <MatriculaArchivo> arrayMatricula;
    String arregloInformacionConsultada[] = new String[2];
    
    ArchivosMatricula archivosMatricula;

    public MetodosMatriculaArchivos() {
        arrayMatricula = new ArrayList <MatriculaArchivo>();
        archivosMatricula = new ArchivosMatricula();
        cargarArchivoAlArray();
    }
    
    public void cargarArchivoAlArray(){
        MatriculaArchivo arregloTemporalMatricula[]=archivosMatricula.devolverInformacionDelArchivoComoArreglo();
        for(int i=0; i<arregloTemporalMatricula.length; i++){
            arrayMatricula.add((MatriculaArchivo)arregloTemporalMatricula[i]);
            System.out.println("Se cargo una matricula del archivo al arrayMatricula.");
        }
    }
    
    public void escribirInformacionArchivo(){
        archivosMatricula.crearArchivo();
        for(int i=0; i<arrayMatricula.size(); i++){
            archivosMatricula.ingresarInformacionAlArchivoMatricula(arrayMatricula.get(i));
        }
        System.out.println("Se envió a escribir la informacion al archivo matricula.");
    }
    
    public void agregarMatricula(String informacion[]){
        MatriculaArchivo temporal=new MatriculaArchivo(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);
        escribirInformacionArchivo();
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            //System.out.println(arrayMatricula.get(contador).getInformacion());
        }
    }
    
    public boolean consultarMatricula(String codigo){
        boolean existe = false;
        
        for(int i=0; i<arrayMatricula.size(); i++){
            if(arrayMatricula.get(i).getCodigo().equals(codigo)){
                arregloInformacionConsultada[0]=arrayMatricula.get(i).getCedula();
                arregloInformacionConsultada[1]=arrayMatricula.get(i).getSigla();
                existe=true;
            }
        }
        return existe;
    }
    
    public void modificarMatricula(String arreglo[]){
        for(int i=0; i<arrayMatricula.size(); i++){
            if(arrayMatricula.get(i).getCodigo().equals(arreglo[0])){
                arrayMatricula.get(i).setCedula(arreglo[1]);
                arrayMatricula.get(i).setSigla(arreglo[2]);
                escribirInformacionArchivo();
            }
        }
    }
        
    public void eliminarMatricula(String arreglo[]){
        for(int i=0; i<arrayMatricula.size(); i++){
            if(arrayMatricula.get(i).getCodigo().equals(arreglo[0])){
                arrayMatricula.remove(i);
                escribirInformacionArchivo();
            }
        }
    }
    
    public String[] getArregloInformacion(){
        return this.arregloInformacionConsultada;
    }
    
    public String devolverCodigo()
    {
        String codigo= "";
        
        if(arrayMatricula.size()==0)
        {
            codigo="1";
        }
        else
        {
            for(int contador=0;contador<arrayMatricula.size();contador++)
            {
                if(arrayMatricula.get(contador)!=null)
                {
                    codigo=arrayMatricula.get(contador).getCodigo();
                }
            }
            int numero=Integer.parseInt(codigo);
            numero++;
            codigo=""+numero;
        }
        
        return codigo; 
    }
}
