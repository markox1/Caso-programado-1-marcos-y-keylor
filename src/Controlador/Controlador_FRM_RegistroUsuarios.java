
package Controlador;

import Modelo.ArchivosUsuario;
import Modelo.MetodosUsuario;
import Modelo.MetodosUsuarioArchivos;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author chelvivil
 */
public class Controlador_FRM_RegistroUsuarios implements ActionListener {
    FRM_MenuPrincipal control;
FRM_RegistroUsuario mantenimientoRegistroUsuarios;
    MetodosUsuarioArchivos metodosUsuarioArchivos;
    ArchivosUsuario archivoUsuario;
MetodosUsuario metodos;

    public Controlador_FRM_RegistroUsuarios(FRM_RegistroUsuario mantenimientoRegistroUsuarios,    FRM_MenuPrincipal control) {
      this.mantenimientoRegistroUsuarios=mantenimientoRegistroUsuarios;
        this.control=control;
        switch(control.seleccionar()){
            case 1:
                metodosUsuarioArchivos = new MetodosUsuarioArchivos();
                archivoUsuario = new ArchivosUsuario();
                break;
                
            case 2:
                
                break;
                
            case 3:
                metodos=new MetodosUsuario();
                break;
        }

    }
     public void actionPerformed(ActionEvent e)
    {
            if(e.getActionCommand().equals("Consultar"))
        {
            switch(control.seleccionar()){
                case 1:
                    if(metodosUsuarioArchivos.consultarUsuario(mantenimientoRegistroUsuarios.devolverUsuario())){
                mantenimientoRegistroUsuarios.mostrarInformacion2(metodosUsuarioArchivos.getArregloInformacion());
                mantenimientoRegistroUsuarios.mostrarMensaje("Se encontraron coincidencias.");
            }
            else{
                mantenimientoRegistroUsuarios.mostrarMensaje("No se encontraron coincidencias.");
                mantenimientoRegistroUsuarios.mostrarMensaje("Proceda a agregar el usuario.");
            }
                    break;
                
                case 2:
//                          if(metodosCursosXML.consultarInformacionDelXml(mantenimientoCursos.devolverSigla()))
//            {
//                mantenimientoCursos.mostrarInformacion(metodosCursosXML.getArregloInformacion());
//                                            mantenimientoCursos.mostrarMensaje("Información encontrada con la cédula : "+mantenimientoCursos.devolverSigla());
//
//            } else
//            {
//               JOptionPane.showMessageDialog(null,"No se encontró el Curso");
//            }
                    
                    break;
                
                case 3:
                    
                    if(metodos.consultarUsuario(mantenimientoRegistroUsuarios.devolverInformacion()))
            {
                mantenimientoRegistroUsuarios.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
               JOptionPane.showMessageDialog(null,"No se encontró el Curso");
            }
                    break;
                
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            switch(control.seleccionar()){
                case 1:
                    metodosUsuarioArchivos.agregarUsuario(mantenimientoRegistroUsuarios.devolverInformacion2());
            mantenimientoRegistroUsuarios.mostrarMensaje("Se agrego el usuario con éxito.");
                    break;
                
                case 2:
//                                       metodosCursosXML.guardarEnXML(mantenimientoCursos.devolverInformacion());
//            mantenimientoCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
//
                  break;
                
                case 3:
                    metodos.registrarUsuario(mantenimientoRegistroUsuarios.devolverInformacion());
                       mantenimientoRegistroUsuarios.mostrarMensaje("Información agregada a la base de datos de forma correcta.");

                    break;
        }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
          switch(control.seleccionar()){
                case 1:
                    metodosUsuarioArchivos.modificarUsuario(mantenimientoRegistroUsuarios.devolverInformacion2());
           
            mantenimientoRegistroUsuarios.mostrarMensaje("Se modifico el usuario con éxito.");
                    break;
                
                case 2:
//                     metodosCursosXML.modificarInformacionDelXml(mantenimientoCursos.devolverInformacion());
//                    mantenimientoCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");

                    break;
                
                case 3:
                    metodos.modificar(mantenimientoRegistroUsuarios.devolverInformacion());
                            mantenimientoRegistroUsuarios.mostrarMensaje("Información modificada en la base de datos de forma correcta.");

                    break;
          }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
           switch(control.seleccionar()){
                case 1:
                    metodosUsuarioArchivos.eliminarUsuario(mantenimientoRegistroUsuarios.devolverInformacion2());
            mantenimientoRegistroUsuarios.mostrarMensaje("Se elimino el usuario con éxito.");
                    break;
                
                case 2:
//                     metodosCursosXML.eliminarInformacionDelXml(mantenimientoCursos.devolverSigla());
//            mantenimientoCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");

                    break;
                
                case 3:
                     metodos.eliminar(mantenimientoRegistroUsuarios.devolverInformacion());
                        mantenimientoRegistroUsuarios.mostrarMensaje("Información eliminada de la base de datos de forma correcta.");

                    break;
           }
        }
}
}