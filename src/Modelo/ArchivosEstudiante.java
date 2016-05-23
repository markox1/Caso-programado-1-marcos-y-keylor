package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivosEstudiante {
    ObjectOutputStream archivoEstudianteSalida;
    ObjectInputStream archivoEstudianteEntrada;    

    
    public ArchivosEstudiante(){
        try{
            archivoEstudianteEntrada=new ObjectInputStream(new FileInputStream("archivoEstudiante.dat"));
        }
        catch(Exception e){
            System.out.println(""+e);
        }
    }
    public void crearArchivo(){
        try{
            archivoEstudianteSalida=new ObjectOutputStream(new FileOutputStream("archivoEstudiante.dat"));
            System.out.println("Se creo el archivo estudiante");
        }
        catch (Exception e){
        System.out.println("Error al crear el archivo estudiante"+e);
        }
    }
    public void ingresarInformacionAlArchivoEstudiante(EstudianteArchivo estudiante){
        try{
            archivoEstudianteSalida.writeObject(estudiante);
            System.out.println("Se escribio la informacion del estudiante en el archivo");
        }
        catch (Exception e){
            System.out.println("Error al ingresar informacion del estudiante al archivo"+e);
        }
    }
    public EstudianteArchivo[] devolverInformacionDelArchivoComoArreglo(){
        int tamano=devolverTamanoDelArchivo();
        EstudianteArchivo arregloEstudiantes[]=new EstudianteArchivo[tamano];
        try{
            archivoEstudianteEntrada=new ObjectInputStream(new FileInputStream("archivoEstudiante.dat"));
            for(int i=0; i<tamano; i++){
                arregloEstudiantes[i]=(EstudianteArchivo)archivoEstudianteEntrada.readObject();
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver informacion del archivo estudiante como arreglo."+e);
        }
        return arregloEstudiantes;
    }
    public int devolverTamanoDelArchivo(){
        int contador=0;
        EstudianteArchivo temporal;
        try{
            while(true){
                temporal=(EstudianteArchivo)archivoEstudianteEntrada.readObject();
                contador++;
                System.out.println("Entro a devolverTamanoDelArchivo");
            }
        }
        catch(Exception e){
            System.out.println("error al devolver tamaño del archivo estudiante."+e);
        }
        return contador;
    }
}
