/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;




import Vista.FRM_MenuPrincipal;
import Vista.FRM_SeleccionarTipo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chelvivil
 */
public class Controlador_FRM_SeleccionarTipo implements ActionListener{
FRM_SeleccionarTipo control;
FRM_MenuPrincipal menuPrincipal;



    public Controlador_FRM_SeleccionarTipo(FRM_SeleccionarTipo control) {
        this.control=control;
         
       
    }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ENTRAR")){
            
            try {
                menuPrincipal= new FRM_MenuPrincipal(control);
            } catch (Exception ex) {
                Logger.getLogger(Controlador_FRM_SeleccionarTipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            }
            
          
        }
    }

