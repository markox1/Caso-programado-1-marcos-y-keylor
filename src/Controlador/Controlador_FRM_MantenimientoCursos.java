/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ConexionCurso;
import Modelo.MetodosCursosArchivos;
import Modelo.MetodosCursosXML;
import Modelo.MetodosEstudianteXML;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    
   
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_MenuPrincipal control;
    ConexionCurso conexion;
        MetodosCursosXML metodosCursosXML;
        MetodosCursosArchivos metodosCursosArchivos;

    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos mantenimientoCursos,FRM_MenuPrincipal control)
    {
          this.mantenimientoCursos=mantenimientoCursos;
        this.control=control;
                
        metodosCursosXML= new MetodosCursosXML(mantenimientoCursos);
        metodosCursosArchivos = new MetodosCursosArchivos();
              conexion=new ConexionCurso();
                 }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        {
            switch(control.seleccionar()){
                case 1:
                    if(metodosCursosArchivos.consultarCurso(mantenimientoCursos.devolverSigla())){
                mantenimientoCursos.mostrarInformacion(metodosCursosArchivos.getArregloInformacion());
                mantenimientoCursos.mostrarMensaje("Se encontraron coincidencias.");
               mantenimientoCursos.habilitarOpciones();
                    }
                    else{
                mantenimientoCursos.mostrarMensaje("No se encontraron coincidencias.");
                mantenimientoCursos.mostrarMensaje("Proceda a agregar el curso.");
            mantenimientoCursos.habilitarAgregar();
                    
                    }
                                        mantenimientoCursos.desahabilitarSigla();

                    break;
                
                case 2:
                          if(metodosCursosXML.consultarInformacionDelXml(mantenimientoCursos.devolverSigla()))
            {
                mantenimientoCursos.mostrarInformacionXML(metodosCursosXML.getArregloInformacion());
                                            mantenimientoCursos.mostrarMensaje("Información encontrada con la cédula : "+mantenimientoCursos.devolverSigla());
               mantenimientoCursos.habilitarOpciones();

            } else
            {
               JOptionPane.showMessageDialog(null,"No se encontró el Curso");
                       mantenimientoCursos.habilitarAgregar();

            }                    mantenimientoCursos.desahabilitarSigla();

                    
                    break;
                
                case 3:
                    
                    if(conexion.consultarCurso(mantenimientoCursos.devolverSigla()))
            {
                mantenimientoCursos.mostrarInformacion(conexion.getArregloInformacion());
                           mantenimientoCursos.habilitarOpciones();

            }
            else
            {
               JOptionPane.showMessageDialog(null,"No se encontró el Curso");
                                   mantenimientoCursos.habilitarAgregar();

            }
                    mantenimientoCursos.desahabilitarSigla();
                    break;
                
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            switch(control.seleccionar()){
                case 1:
                    metodosCursosArchivos.agregarCurso(mantenimientoCursos.devolverInformacion());
            mantenimientoCursos.mostrarMensaje("Se agrego el curso con éxito.");
                             mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
            break;
                
                case 2:
                                       metodosCursosXML.guardarEnXML(mantenimientoCursos.devolverInformacion());
            mantenimientoCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
             mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
                
                case 3:
                    conexion.registrarCurso(mantenimientoCursos.devolverInformacion());
                       mantenimientoCursos.mostrarMensaje("Información agregada a la base de datos de forma correcta.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
        }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
          switch(control.seleccionar()){
                case 1:
                    metodosCursosArchivos.modificarCurso(mantenimientoCursos.devolverInformacion());
            mantenimientoCursos.mostrarMensaje("Se modifico el curso con éxito.");
                      mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();       
            break;
                
                case 2:
                     metodosCursosXML.modificarInformacionDelXml(mantenimientoCursos.devolverInformacion());
                    mantenimientoCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
                
                case 3:
                    conexion.modificar(mantenimientoCursos.devolverInformacion());
                            mantenimientoCursos.mostrarMensaje("Información modificada en la base de datos de forma correcta.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
          }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
           switch(control.seleccionar()){
                case 1:
                    metodosCursosArchivos.eliminarCurso(mantenimientoCursos.devolverInformacion());
                mantenimientoCursos.mostrarMensaje("Se elimino el curso con éxito.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                break;
                
                case 2:
                     metodosCursosXML.eliminarInformacionDelXml(mantenimientoCursos.devolverSigla());
            mantenimientoCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
                
                case 3:
                     conexion.eliminar(mantenimientoCursos.devolverInformacion());
                        mantenimientoCursos.mostrarMensaje("Información eliminada de la base de datos de forma correcta.");
          mantenimientoCursos.limpiarInterfaz(); 
            mantenimientoCursos.estadoInicial();
                    break;
           }
        }
    
    }
    
}
