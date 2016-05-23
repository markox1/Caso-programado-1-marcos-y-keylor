package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivosCurso {
    ObjectOutputStream archivoCursosSalida;
    ObjectInputStream archivoCursosEntrada;
    
    
     public ArchivosCurso(){
        try{
        archivoCursosEntrada=new ObjectInputStream(new FileInputStream("archivoCursos.dat"));
        }
        catch(Exception e){
            System.out.println(""+e);
        }
    }
     
     public void crearArchivo(){
         try{
             archivoCursosSalida=new ObjectOutputStream(new FileOutputStream("archivoCursos.dat"));
             System.out.println("Se creo el archivo curso");
         }
         catch(Exception e){
             System.out.println("Error al crear el archivo curso"+e);   
         }
     }
     
 public void ingresarInformacionAlArchivoCursos(CursosArchivo cursos){
     try{
         archivoCursosSalida.writeObject(cursos);
         System.out.println("Se escribio la informacion del curso");
         
     }catch(Exception e)
     {
      System.out.println("Error al ingresar informacion curso al archivo");
     }
 }
 
/*public ArrayList<Usuario> devolverInformacionDelArchivoCursos(){
    ArrayList<Usuario>array= new ArrayList<Usuario>();
    try{
        while(true){
            array.add((Usuario)archivoCursosEntrada.readObject());
        }
    }
    catch(Exception e){
        System.out.println("Se llego al final del archivo curso");
    }
    return array;
}*/
    public CursosArchivo[] devolverInformacionDelArchivoComoArreglo(){
        int tamano=devolverTamanoDelArchivo();
        CursosArchivo arregloCurso[]= new CursosArchivo[tamano];
        try{
            archivoCursosEntrada=new ObjectInputStream(new FileInputStream("archivoCursos.dat"));
            for(int contador=0;contador<tamano;contador++){
                arregloCurso[contador]=(CursosArchivo)archivoCursosEntrada.readObject();
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver informacion del archivo curso como arreglo.");
        }  
        return arregloCurso;
    }

public int devolverTamanoDelArchivo(){
        int contador=0;
        CursosArchivo temporal;
        try{
            
            while(true){
              temporal=(CursosArchivo)archivoCursosEntrada.readObject();
              contador++;
              System.out.println("Entro a devolverTamanoDelArchivo");
            }
        }
        
        catch(Exception e){
            System.out.println("Error al devolver tamaño del archivo curso."+e);
        }
        return contador;
    }
    
}
