/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author chelvivil
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener {
  FRM_MantenimientoEstudiantes registroEstudiante; 
  FRM_MantenimientoCursos registroCurso;
  FRM_Matricula matricula;
  FRM_MenuPrincipal control;
      FRM_RegistroUsuario usuario;

    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal control) {
        
        registroEstudiante = new FRM_MantenimientoEstudiantes(control);
        registroCurso = new FRM_MantenimientoCursos(control);
        this.control=control;
       
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiante"))
        {
            
            this.registroEstudiante.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
         this.registroCurso.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
          matricula = new FRM_Matricula(registroEstudiante, registroCurso,control);
            this.matricula.setVisible(true);
        }
         if(e.getActionCommand().equals("Registrar Usuario"))
        {
            usuario= new FRM_RegistroUsuario(control);
            this.usuario.setVisible(true);
            System.out.println("apreto");
            }
  
}
}
