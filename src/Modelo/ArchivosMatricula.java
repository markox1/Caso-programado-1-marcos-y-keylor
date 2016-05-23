package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ArchivosMatricula {
    ObjectOutputStream archivoMatriculaSalida;
    ObjectInputStream archivoMatriculaEntrada;
    
    public ArchivosMatricula(){
        try{
            archivoMatriculaEntrada=new ObjectInputStream(new FileInputStream("archivoMatricula.dat"));
        }
        catch(Exception e){
            System.out.println(""+e);
        }
    }
    
    public boolean verificarExistenciaDeArchivoDeMatricula(){
        boolean existe=true;
        try{
            archivoMatriculaEntrada=new ObjectInputStream(new FileInputStream("archivoMatricula.dat"));
        }
        catch(Exception e)
        {
            existe=false;
            System.out.println("Error al cargar el archivo de matricula:"+e);
        }
            
        return existe;
    }
    
    public void crearArchivo(){
        try{
            archivoMatriculaSalida=new ObjectOutputStream(new FileOutputStream("archivoMatricula.dat"));
            System.out.println("Se creo el archivo matricula");
        }
        catch(Exception e){
            System.out.println("Error al crear el matricula usuario"+e);
        } 
    }
    
    public void ingresarInformacionAlArchivoMatricula(MatriculaArchivo matricula){
        try{
            archivoMatriculaSalida.writeObject(matricula);
            System.out.println("Se escribio la informacion en el archivo matricula");
    }
        catch (Exception e){
            System.out.println("Error al ingresar informacion de la matricula usuario al archivo");
        }
    }
    
    public MatriculaArchivo[] devolverInformacionDelArchivoComoArreglo(){
        
        int tamano=devolverTamanoDelArchivo();
        
        MatriculaArchivo arregloMatricula[]=new MatriculaArchivo[tamano];
        
        try{
            archivoMatriculaEntrada=new ObjectInputStream(new FileInputStream("archivoMatricula.dat"));
            for(int i=0; i<tamano; i++){
                arregloMatricula[i]=(MatriculaArchivo)archivoMatriculaEntrada.readObject();
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver informacion del archivo matricula como arreglo."+e);
        }  
        return arregloMatricula;
    }
    
    public int devolverTamanoDelArchivo(){
        int contador=0;
        MatriculaArchivo temporal;
        try{
            while(true){
                temporal=(MatriculaArchivo)archivoMatriculaEntrada.readObject();
                contador++;
                System.out.println("Entro a devolverTamanoDelArchivo");
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver tamaño del archivo matricula."+e);
        }
        return contador;
    }
    
}