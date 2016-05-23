package Controlador;

import Modelo.MetodosUsuarioArchivos;
import Modelo.Usuarios;
import Vista.FRM_LoginArchivos;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_RegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controlador_FRM_LoginArchivos implements ActionListener{

    FRM_LoginArchivos login;
    MetodosUsuarioArchivos metodoUsuarios;
    FRM_RegistroUsuario usuarios;
    FRM_MenuPrincipal principal;
    
    public Controlador_FRM_LoginArchivos(FRM_LoginArchivos login,FRM_MenuPrincipal principal) throws Exception
    {
        this.login=login;
       usuarios=new FRM_RegistroUsuario(principal);
        metodoUsuarios=new MetodosUsuarioArchivos();
        this.principal=principal;
//        principal=new FRM_MenuPrincipal();
        
        if(metodoUsuarios.verificarExistenciaDeArchivoDeUsuarios())
        {
            login.hacerLogin();
        }
        else
        {
            login.noHacerLogin();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Entrar"))
        {
            buscar();
//            principal.setVisible(true);
            System.out.println("sirve");
           
        }
    }
    
    public void buscar()
    {
//       if(!login.devolverNombreUsuario().equals("")&&!usuarios.devolverContraseña().equals(""))
//            {   
            
        if(metodoUsuarios.consultarUsuarioLogin(login.devolverNombreUsuario(),login.devolverContraseña()))
        {
            JOptionPane.showMessageDialog(null,"el usuario es valido ");
            principal.setVisible(true);
            login.setVisible(false);
          
            
        }else{
            JOptionPane.showMessageDialog(null,"el usuario o la contraseña no son correctos");
            
        }
//    }
//       else
//         {
//            JOptionPane.showMessageDialog(null, "Por favor digite una cédula antes de buscar.");
//      }
}
    
    
}
//}
