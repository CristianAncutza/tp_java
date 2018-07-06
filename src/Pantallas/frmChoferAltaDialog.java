/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.auto;
import Clases.chofer;
import ConexionDB.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author ex1fernajo
 */
public class frmChoferAltaDialog extends java.awt.Dialog {

    /**
     * Creates new form frmChoferAltaDialog
     */
    public frmChoferAltaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        CargarAUTOS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        txtLegajo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblApellido3 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        txtLicencia = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        lblApellido4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        cboAuto = new javax.swing.JComboBox<>();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Alta de Chofer");

        lblApellido2.setText("Legajo :");

        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblApellido3.setText("Licencia :");

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblApellido4.setText("Auto :");

        lblNombre.setText("Nombre :");

        cboAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblApellido.setText("Apellido :");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(lblApellido4)
                                .addGap(18, 18, 18)
                                .addComponent(cboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblApellido3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(lblApellido2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(163, 163, 163)
                                        .addComponent(btnAceptar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido3)
                    .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido2)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido4)
                    .addComponent(cboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void resetForm(){    
        txtNombre.setText("");
        txtApellido.setText("");
        txtLegajo.setText("");
        txtLicencia.setText("");
        lblMensaje.setText("");
    }
    
    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        
          char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
                        
          } 
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped

          char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
                        
          } 
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped
        char c=evt.getKeyChar(); 
            if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              
             evt.consume(); 
              
               
          } 
    }//GEN-LAST:event_txtLegajoKeyTyped

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        int minLength = 2;
        int maxLength = 20;
        int validacion = 0;
        Border highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
        Border noBorder = BorderFactory.createLineBorder(java.awt.Color.gray);
        
        /**********************VALIDACIONES****************************/        
        
        //Validacion de nombre
        if(!lengthCheck(txtNombre.getText(),minLength, maxLength) || txtNombre.getText().equals("") ){                        
            txtNombre.setBorder(highlightBorder);   
            validacion = 1;
        } else {    txtNombre.setBorder(noBorder);   }                                      
        
        if( !txtNombre.getText().matches("^[a-zA-Z]+$")){            
            lblMensaje.setText("Aviso! debe ingresar unicamente letras en el campo nombre.");
            txtNombre.setBorder(highlightBorder);
            validacion = 2;
        }          
        else {    txtNombre.setBorder(noBorder);   }                                      
             
        //Validacion de apellido
        if(!lengthCheck(txtApellido.getText(),minLength, maxLength)){             
            txtApellido.setBorder(highlightBorder);   
            validacion = 1;
        }else{    txtApellido.setBorder(noBorder);   }
        
        if( !txtApellido.getText().matches("^[a-zA-Z]+$")){            
            lblMensaje.setText("Aviso! debe ingresar unicamente letras en el campo apellido.");
            txtApellido.setBorder(highlightBorder);
            validacion = 2;
        }          
        else {    txtApellido.setBorder(noBorder);   }  
           
        //Validacion de licencia
        if(!lengthCheck(txtLicencia.getText(),minLength, maxLength)){            
            txtLicencia.setBorder(highlightBorder);   
            validacion = 1;
        }else{    txtLicencia.setBorder(noBorder);   }
        
        //Validacion de legajo
        if(!lengthCheck(txtLegajo.getText(),minLength, maxLength)){            
            txtLegajo.setBorder(highlightBorder);   
            validacion = 1;
        
        }else{    txtLegajo.setBorder(noBorder);   }
        
        if(validacion == 0)        
        {        
            chofer ch = new chofer();
            ch.setApellido(txtApellido.getText());
            ch.setNombre(txtNombre.getText());
            ch.setLicencia(txtLicencia.getText());
            ch.setLegajo(Integer.parseInt(txtLegajo.getText()));
            ch.setSuAuto((auto)cboAuto.getSelectedItem());
            
         if( ch.altaChofer() == 0){
                JOptionPane.showMessageDialog(this, "Se creó correctamente el chofer.\n","",JOptionPane.INFORMATION_MESSAGE); 
            }
            else{
                JOptionPane.showMessageDialog(this, "Error! ya existe otro chofer con ese legajo.\n","",JOptionPane.ERROR_MESSAGE); 
            }  
        } else if(validacion == 1){
                JOptionPane.showMessageDialog(this, "Complete todos los campos, con longitud minima de 3 y maxima de 20 caracteres.\n","",JOptionPane.ERROR_MESSAGE); 
            }  
    }//GEN-LAST:event_btnAceptarMousePressed
 /**
     * Cargo las autos para el combo
     */
    public void CargarAUTOS()
    {
         Connection conn = null;
        Conectar cn = new Conectar();
        
         /*cargado con query*/
        try {
             
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT [ID_AUTO]\n" +
                                                            "      ,[MARCA]\n" +
                                                            "      ,[MODELO]\n" +
                                                            
                                                            "  FROM [RemisJava].[dbo].[AUTO] \n " +
                                                            "WHERE BAJA = 1 ");         
            boolean hadResults = statement.execute();
                    
            while (hadResults) 
            {
           
                ResultSet rs = statement.getResultSet();

                while (rs.next()) {                   
                    cboAuto.addItem(rs.getString("MARCA") + "," + rs.getString("MODELO"));
                }
                hadResults = statement.getMoreResults(); 
            }
            statement.close();
            conn.close();
        
            
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT  [ID_AUTO]\n" +
                                                            "      ,[AÑO]\n" +
                                                            "      ,[COLOR]\n" +
                                                            "      ,[MARCA]\n" +
                                                            "      ,[MODELO]\n" +
                                                            "      ,[PATENTE]\n" +
                                                            "  FROM [RemisJava].[dbo].[AUTO]");
            //statement.setString(1, txtUsuario.getText());
            
            boolean hadResults = statement.execute();
        
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                
               /* List<auto> autoList = new ArrayList<auto>();
                 
                 auto au;
                // process result set
                while (resultSet.next()) {
                    
                    au = new auto();
                    
                    rowCount++;
                    au.setid_auto(Integer.parseInt(resultSet.getString("ID_AUTO")));
                    au.setaño(Integer.parseInt(resultSet.getString("AÑO")));
                    au.setcolor(resultSet.getString("COLOR"));
                    au.setmarca(resultSet.getString("MARCA"));
                    au.setmodelo(resultSet.getString("MODELO"));
                    au.setpatente(resultSet.getString("PATENTE"));
                                       
                    autoList.add(au);
                   
                }
                cboAuto.setModel(new DefaultComboBoxModel(autoList.toArray()));
                hadResults = statement.getMoreResults();
                
            }
 
            statement.close();
            conn.close();
            
          
            
        } catch (Exception e) {
             lblMensaje.setText( e.getMessage());
            
          
        }*/
    }
    
    private boolean lengthCheck(String text, int minLength, int maxLength) {
        return maxLength > text.length() && text.length() > minLength;
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmChoferAltaDialog dialog = new frmChoferAltaDialog(new java.awt.Frame(), true);
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
    private javax.swing.JComboBox<String> cboAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblApellido3;
    private javax.swing.JLabel lblApellido4;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtLegajo;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
