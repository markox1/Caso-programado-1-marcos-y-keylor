/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosLogin;
import Vista.FRM_LoginUsuario;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author chelvivil
 */
public class Controlador_FRM_LoginUsuario implements ActionListener {
FRM_LoginUsuario control;
    MetodosLogin metodos;
    FRM_MenuPrincipal mp;
    public Controlador_FRM_LoginUsuario(FRM_LoginUsuario control,FRM_MenuPrincipal mp) {
        this.mp=mp;
    this.control=control;
    metodos= new MetodosLogin();
    
    
    
    }
    
    public boolean visible(){
    return metodos.verificarAdmin();
    }
    
    
    
     public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Login")){
           if(metodos.consultarUsuario(control.devolverinformacion())){
            control.setVisible(false);
            mp.setVisible(true);
        }
           else{
               JOptionPane.showMessageDialog(null,"El usuario o la contraseña son incorretos");
           }
            
        }
            }
    
}
