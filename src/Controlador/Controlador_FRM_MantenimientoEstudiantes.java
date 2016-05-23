/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ConexionEstudiante;
import Modelo.MetodosEstudianteArchivos;
import Modelo.MetodosEstudianteXML;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    
   
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MenuPrincipal control;
    ConexionEstudiante conexion;
    MetodosEstudianteXML metodosEstudianteXML;
    MetodosEstudianteArchivos metodosEstudianteArchivos;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MenuPrincipal control)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        this.control=control;
       
       
              metodosEstudianteXML= new MetodosEstudianteXML(mantenimientoEstudiantes);
              
              metodosEstudianteArchivos = new MetodosEstudianteArchivos();
              
                conexion=new ConexionEstudiante();
         
        
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        {
            switch(control.seleccionar()){
                case 1:
                    if(metodosEstudianteArchivos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula())){
                mantenimientoEstudiantes.mostrarInformacion(metodosEstudianteArchivos.getArregloInformacion());
                mantenimientoEstudiantes.mostrarMensaje("Se encontraron coincidencias.");
            mantenimientoEstudiantes.habilitarOpciones();
                    }
            else{
                mantenimientoEstudiantes.mostrarMensaje("No se encontraron coincidencias.");
                mantenimientoEstudiantes.mostrarMensaje("Proceda a agregar el estudiante.");
           mantenimientoEstudiantes.habilitarAgregar();
                    }
                    mantenimientoEstudiantes.desahabilitarCedula();
                    break;
                
                case 2:      
                    if(metodosEstudianteXML.consultarInformacionDelXml(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacionXML(metodosEstudianteXML.getArregloInformacion());
                                            mantenimientoEstudiantes.mostrarMensaje("Información encontrada con la cédula : "+mantenimientoEstudiantes.devolverCedula());

                                   mantenimientoEstudiantes.habilitarOpciones();
                     
            } else
            {
               JOptionPane.showMessageDialog(null,"No se encontró el Estudiante");
                     mantenimientoEstudiantes.habilitarAgregar();

            }
                                     mantenimientoEstudiantes.desahabilitarCedula();
   
                    break;
                
                case 3:
                    
                    if(conexion.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(conexion.getArregloInformacion());
                            mantenimientoEstudiantes.mostrarMensaje("Información encontrada con la cédula : "+mantenimientoEstudiantes.devolverCedula());
                                   mantenimientoEstudiantes.habilitarOpciones();


            }
            else
            {
               JOptionPane.showMessageDialog(null,"No se encontró el Estudiante");
                                mantenimientoEstudiantes.habilitarAgregar();

            }                                     mantenimientoEstudiantes.desahabilitarCedula();

                    break;
                
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            switch(control.seleccionar()){
                case 1:
                    metodosEstudianteArchivos.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            metodosEstudianteArchivos.mostrarInformacion();
            mantenimientoEstudiantes.mostrarMensaje("Se agrego el estudiante con éxito.");
                    mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
            break;
                
                case 2:
                                metodosEstudianteXML.guardarEnXML(mantenimientoEstudiantes.devolverInformacion());
            mantenimientoEstudiantes.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
                
                case 3:
                    conexion.registrarEstudiante(mantenimientoEstudiantes.devolverInformacion());
                       mantenimientoEstudiantes.mostrarMensaje("Información agregada a ala base de datos de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
        }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
          switch(control.seleccionar()){
                case 1:
                    metodosEstudianteArchivos.modificarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            mantenimientoEstudiantes.mostrarMensaje("Se modifico el estudiante con éxito.");
             mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();    
            break;
                
                case 2:
            metodosEstudianteXML.modificarInformacionDelXml(mantenimientoEstudiantes.devolverInformacion());
                    mantenimientoEstudiantes.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
                
                case 3:
                    conexion.modificar(mantenimientoEstudiantes.devolverInformacion());
                    mantenimientoEstudiantes.mostrarMensaje("Información modificada en la base de dato de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
          }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
           switch(control.seleccionar()){
                case 1:
                    metodosEstudianteArchivos.eliminarEstudiante(mantenimientoEstudiantes.devolverInformacion());
                    mantenimientoEstudiantes.mostrarMensaje("Se elimino el estudiante con éxito.");
                    mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
                
                case 2:
            metodosEstudianteXML.eliminarInformacionDelXml(mantenimientoEstudiantes.devolverCedula());
            mantenimientoEstudiantes.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
                
                case 3:
                     conexion.eliminar(mantenimientoEstudiantes.devolverInformacion());
                        mantenimientoEstudiantes.mostrarMensaje("Información eliminada en la base de datos de forma correcta.");
 mantenimientoEstudiantes.limpiarInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    break;
           }
        }
    
    }
    
}
