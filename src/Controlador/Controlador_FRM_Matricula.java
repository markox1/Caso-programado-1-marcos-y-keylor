/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionEstudiante;
import Modelo.ConexionCurso;

import Modelo.MetodosCursosArchivos;
import Modelo.MetodosEstudianteArchivos;

import Modelo.MetodosMatricula;
import Modelo.MetodosMatriculaArchivos;

import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    FRM_MenuPrincipal valor;
    MetodosMatricula metodosMatricula;
    MetodosCursosArchivos metodosCursosArchivos;
    MetodosEstudianteArchivos metodosEstudianteArchivos;
    MetodosMatriculaArchivos metodosMatriculaArchivos;
    FRM_Matricula frm_Matricula;
    ConexionEstudiante conexionE;
    ConexionCurso conexionC;
    boolean encontroEstudiante=false; 
    boolean encontroCurso=false;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula,FRM_MenuPrincipal valor)
    {
        this.conexionC=mantenimientoCursos.controlador.conexion;
        this.conexionE=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.conexion;
        this.frm_Matricula=frm_Matricula;
        this.valor=valor;
        
        switch(valor.seleccionar()){
            case 1:
                metodosMatriculaArchivos=new MetodosMatriculaArchivos();
                this.metodosCursosArchivos=mantenimientoCursos.controlador.metodosCursosArchivos;
                this.metodosEstudianteArchivos=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudianteArchivos;
                break;
                
            case 2:
                
                break;
                
            case 3:
                 metodosMatricula=new MetodosMatricula();
                break;
        }
       
      
    }
  
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
        {
              switch(valor.seleccionar()){
                  
            case 1:
             if(metodosEstudianteArchivos.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=metodosEstudianteArchivos.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true; 
                frm_Matricula.mostrarMensaje("Se encontro el estudiante");
            }
            else
            {
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
            }
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
              if(conexionE.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=conexionE.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;  
                
            }
            else
            {
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
            }
                break;   
        }
            
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
        {
            switch(valor.seleccionar()){
            case 1:
              if(metodosCursosArchivos.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=metodosCursosArchivos.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
                frm_Matricula.mostrarMensaje("Se encontro el curso");
            }
            else
            {
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
            } 
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
                if(conexionC.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=conexionC.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
            } 
                break;
      }
            
        }
        if(e.getActionCommand().equals("Consultar"))
        {
             switch(valor.seleccionar()){
            case 1:
              if(metodosMatriculaArchivos.consultarMatricula(frm_Matricula.obtenerCodigo())){
                String arreglo[]=new String[2];
                arreglo=metodosMatriculaArchivos.getArregloInformacion();
                
                System.out.print(""+arreglo[0]+arreglo[1]);
                
                metodosEstudianteArchivos.consultarEstudiante(arreglo[0]);
                String arregloEstudiante[]=metodosEstudianteArchivos.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arregloEstudiante[0]);
                frm_Matricula.mostrarCedula(arreglo[0]);
                    
                metodosCursosArchivos.consultarCurso(arreglo[1]);
                String arregloCurso[]=metodosCursosArchivos.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arregloCurso[0]);
                frm_Matricula.mostrarSigla(arreglo[1]);
                frm_Matricula.habilitarEliminar();
                
                frm_Matricula.cargarTabla();
                
                frm_Matricula.mostrarMensaje("Se encontro la matricula");
                
            }
            
            else{
                frm_Matricula.mostrarMensaje("No se encontro la matricula");
            }
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
                metodosMatricula.consultarMatricula(frm_Matricula.obtenerCodigo());
        metodosMatricula.mostrarInformacion();
        frm_Matricula.mostrarCedulaSigla(metodosMatricula.getArregloInformacion());
        if(conexionE.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=conexionE.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;        
            }
        if(conexionC.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=conexionC.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }
        frm_Matricula.habilitarEliminar();
        
        frm_Matricula.cargarTabla();
        
                break;
      }
            
             
        }
         if(e.getActionCommand().equals("Eliminar"))
        { 
             switch(valor.seleccionar()){
            case 1:
              for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++){
                metodosMatriculaArchivos.eliminarMatricula(frm_Matricula.getInformacionTabla(contador));
                frm_Matricula.mostrarMensaje("Se elimino la matricula");
            }
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
                metodosMatricula.eliminar(frm_Matricula.obtenerCodigo());
                break;
      }
            }
        if(e.getActionCommand().equals("Agregar"))
        {  
             switch(valor.seleccionar()){
            case 1:
              frm_Matricula.cargarTabla();
            encontroCurso=false;
            frm_Matricula.mostrarMensaje("Matricula lista para agregar. Es necesario finalizarla.");
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
                frm_Matricula.cargarTabla();
            encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso(); 
                break;
      }
            
        }
        if(e.getActionCommand().equals("Finalizar"))
        {  
            switch(valor.seleccionar()){
            case 1:
              for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
               metodosMatriculaArchivos.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
               frm_Matricula.mostrarMensaje("Se finalizo con exito");
            }
            
            metodosMatriculaArchivos.mostrarInformacion();
                break;  
            case 2:
              System.out.println("X");
                break;   
            case 3:
                for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
               metodosMatricula.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            frm_Matricula.resetearInterfaz();
            
            metodosMatricula.mostrarInformacion();
                break;
      }
            
        }
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
    }
   
    public String colocarCodigo()
    {
        return metodosMatricula.devolverCodigo();
    }
}
