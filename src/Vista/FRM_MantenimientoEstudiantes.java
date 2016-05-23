/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_MantenimientoEstudiantes;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnologiamultimedia
 */
public class FRM_MantenimientoEstudiantes extends javax.swing.JFrame {

    public Controlador_FRM_MantenimientoEstudiantes controlador_FRM_MantenimientoEstudiantes;
  
    public FRM_MantenimientoEstudiantes(FRM_MenuPrincipal control) {
        initComponents();
               setSize(400,300);
        controlador_FRM_MantenimientoEstudiantes=new Controlador_FRM_MantenimientoEstudiantes(this,control);
        gUI_Botones1.agregarEventos(controlador_FRM_MantenimientoEstudiantes);
        
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public String[] devolverInformacion()
    {
        return this.gUI_InformacionEstudiantes1.devolverInformacion();
    }
    public String devolverCedula()
    {
        return this.gUI_InformacionEstudiantes1.devolverCedula();
    
    }
    public void mostrarInformacionXML(String arreglo[]){
    
            this.gUI_InformacionEstudiantes1.mostrarInformacionXML(arreglo);

    }
      public void mostrarInformacion(String arreglo[]){
    
            this.gUI_InformacionEstudiantes1.mostrarInformacion(arreglo);

    }
    
    public void habilitarAgregar(){
    this.gUI_Botones1.habilitarAgregar();
    this.gUI_InformacionEstudiantes1.habilitarOpciones();
    
    }
    public void habilitarOpciones(){
    this.gUI_Botones1.habilitarOpciones();
    this.gUI_InformacionEstudiantes1.habilitarOpciones();
    
    }
    
    public void desahabilitarCedula(){
    this.gUI_InformacionEstudiantes1.desahabilitarCedula();
    }
    public void limpiarInterfaz(){
    
    this.gUI_InformacionEstudiantes1.limpiarInterfaz();
    }
     
      public void estadoInicial(){
    this.gUI_InformacionEstudiantes1.estadoInicial();
    this.gUI_Botones1.estadoInicial();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_Botones1 = new Vista.GUI_Botones();
        gUI_InformacionEstudiantes1 = new Vista.GUI_InformacionEstudiantes();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(430, 290));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gUI_Botones1.setOpaque(false);
        getContentPane().add(gUI_Botones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        gUI_InformacionEstudiantes1.setForeground(new java.awt.Color(54, 54, 54));
        gUI_InformacionEstudiantes1.setOpaque(false);
        getContentPane().add(gUI_InformacionEstudiantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pag.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 710, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionEstudiantes gUI_InformacionEstudiantes1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
