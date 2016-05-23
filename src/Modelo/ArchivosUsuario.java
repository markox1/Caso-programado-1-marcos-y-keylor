package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivosUsuario {
    
    ObjectOutputStream archivoUsuarioSalida;
    ObjectInputStream archivoUsuarioEntrada;
    
    public ArchivosUsuario(){
        try{
            archivoUsuarioEntrada=new ObjectInputStream(new FileInputStream("archivoUsuarios.dat"));
        }
        catch(Exception e){
            System.out.println(""+e);
        }
    }
    
    public boolean verificarExistenciaDeArchivoDeUsuarios(){
        boolean existe=true;
        try{
            archivoUsuarioEntrada=new ObjectInputStream(new FileInputStream("archivoUsuarios.dat"));
        }
        catch(Exception e){
            existe=false;
            System.out.println("Error al cargar el archivo de usuarios:"+e);
        }
            
        return existe;
    }
    
    public void crearArchivo(){
        try{
            archivoUsuarioSalida=new ObjectOutputStream(new FileOutputStream("archivoUsuarios.dat"));
            System.out.println("Se creo el archivo usuario");
        }
        catch(Exception e){
            System.out.println("Error al crear el archivo usuario"+e);
        }
    }
    
    public void ingresarInformacionAlArchivoUsuario(UsuarioArchivo usuario){
        try{
            archivoUsuarioSalida.writeObject(usuario);
            System.out.println("Se escribio la informacion del usuario en el archivo");
        }
        catch (Exception e){
            System.out.println("Error al ingresar informacion del usuario al archivo"+e);
        }
    }
    
    public UsuarioArchivo[] devolverInformacionDelArchivoComoArreglo(){
        int tamano=devolverTamanoDelArchivo();
        UsuarioArchivo arregloUsuario[]=new UsuarioArchivo[tamano];
        try{
            archivoUsuarioEntrada=new ObjectInputStream(new FileInputStream("archivoUsuarios.dat"));
            for(int i=0; i<tamano; i++){
                arregloUsuario[i]=(UsuarioArchivo)archivoUsuarioEntrada.readObject();
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver informacion del archivo como arreglo."+e);
        }  
        return arregloUsuario;
    }
    
    public int devolverTamanoDelArchivo(){
        int contador=0;
        UsuarioArchivo temporal;
        try{
            while(true){
                temporal=(UsuarioArchivo)archivoUsuarioEntrada.readObject();
                contador++;
                System.out.println("paso x aqui");
            }
        }
        catch(Exception e){
            System.out.println("Error al devolver tamaño del archivo."+e);
        }
        return contador;
    }
}
