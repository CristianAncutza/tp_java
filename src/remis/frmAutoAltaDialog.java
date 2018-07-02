/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
/**
 *
 * @author Cristian Ancutza
 */
public class frmAutoAltaDialog extends java.awt.Dialog {

    /**
     * Creates new form frmAutoAltaDial
     */
    public frmAutoAltaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        //lleno el combobox de año
        for(int año = 1980; año<=Calendar.getInstance().get(Calendar.YEAR); año++) {
            cboAño.addItem(año);            
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboAño = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Alta de Auto");

        cboAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAñoActionPerformed(evt);
            }
        });

        jLabel2.setText("Año :");

        jLabel3.setText("Color :");

        jLabel4.setText("Marca :");

        jLabel5.setText("Modelo :");

        jLabel6.setText("Patente :");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblMensaje.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboAño, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtColor)
                                    .addComponent(txtMarca)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnAceptar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(lblMensaje)))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(28, 28, 28)
                .addComponent(lblMensaje)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void cboAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAñoActionPerformed

    }//GEN-LAST:event_cboAñoActionPerformed

    private boolean Validar(){
        return true;
    }
    
    /**
    *   valido y luego guardo el alta de auto.
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int minLength = 2;
        int maxLength = 20;
        Border highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
        Border noBorder = BorderFactory.createLineBorder(java.awt.Color.gray);
        
        //verifico que los campos no esten vacios
        if(!lengthCheck(txtColor.getText(),minLength, maxLength) ){
            lblMensaje.setText("por favor complete todos los campos");
            txtColor.setBorder(highlightBorder);   
        }else if( !txtColor.getText().matches("^[a-zA-Z]+$")){
            lblMensaje.setText("Ingrese solo letras para el campo color.");
            txtColor.setBorder(highlightBorder);
        }          
        else {    txtColor.setBorder(noBorder);   }                                      
             
        
        if(!lengthCheck(txtMarca.getText(),minLength, maxLength)){
            lblMensaje.setText("por favor complete todos los campos");
            txtMarca.setBorder(highlightBorder);   
        }else{    txtMarca.setBorder(noBorder);   }
        
        if(!lengthCheck(txtModelo.getText(),minLength, maxLength)){
            lblMensaje.setText("por favor complete todos los campos");
            txtModelo.setBorder(highlightBorder);   
        }else{    txtModelo.setBorder(noBorder);   }
        
        if(!lengthCheck(txtPatente.getText(),minLength, maxLength)){
            lblMensaje.setText("por favor complete todos los campos");
            txtPatente.setBorder(highlightBorder);   
        
        }else{    txtPatente.setBorder(noBorder);   }
        
        if(lengthCheck(txtColor.getText(),minLength, maxLength) && txtColor.getText().matches("^[a-zA-Z]+$") && lengthCheck(txtMarca.getText(),minLength, maxLength) && lengthCheck(txtModelo.getText(),minLength, maxLength) && lengthCheck(txtPatente.getText(),minLength, maxLength))
        {
            auto a = new auto();
            a.setaño((int)cboAño.getSelectedItem());
            a.setcolor(txtColor.getText());
            a.setmarca(txtMarca.getText());
            a.setmodelo(txtModelo.getText());
            a.setpatente(txtPatente.getText());
            
            if( a.altaAuto() == 0){
                lblMensaje.setText("Se creó correctamente el auto.");            
            }
            else{
                lblMensaje.setText("Error! Ya existe otro auto con esa patente.");
            }  
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private boolean lengthCheck(String text, int minLength, int maxLength) {
        return maxLength > text.length() && text.length() > minLength;
    }
    
     //*************VALIDACIONES****************************        
    
    //  VALIDA QUE LO QUE SE INGRESE SEA SOLO TEXTO
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
          char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume();                         
          } 
    }//GEN-LAST:event_txtColorKeyTyped

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
          char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume();                         
          } 
    }//GEN-LAST:event_txtMarcaKeyTyped
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAutoAltaDialog dialog = new frmAutoAltaDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<Integer> cboAño;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPatente;
    // End of variables declaration//GEN-END:variables
}
