/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;
import Clases.recepcionista;
import ConexionDB.Conectar;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JFrame;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;


/**
 *
 * @author Jonathan
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        
        
        initComponents();
        rdbChofer.setVisible(false);
        rdbRecepcionista.setVisible(false);
        Centrado();
        
        try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");             

        }catch(Exception ex){
        }
    }
    
    /**
     * Funcion para centrar form
     */
    private void Centrado()
    {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLog = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rdbRecepcionista = new javax.swing.JRadioButton();
        rdbChofer = new javax.swing.JRadioButton();
        lblMensaje = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
        });

        jLabel3.setText("LOGIN");

        buttonGroupLog.add(rdbRecepcionista);
        rdbRecepcionista.setSelected(true);
        rdbRecepcionista.setText("Recepcionista");
        rdbRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbRecepcionistaMousePressed(evt);
            }
        });

        buttonGroupLog.add(rdbChofer);
        rdbChofer.setText("Chofer");
        rdbChofer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbChoferMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbRecepcionista)
                        .addGap(18, 18, 18)
                        .addComponent(rdbChofer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(txtUsuario)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbRecepcionista)
                    .addComponent(rdbChofer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int id_chofer;
    private int id_recepcionista;
    
    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        
        frmMenu menu;
        if (LoginRecepcionista())
            {
                recepcionista rep = new recepcionista(id_recepcionista);
                menu = new frmMenu(rep);
                menu.setVisible(true);
                menu.setLocationRelativeTo(this);
                this.dispose();
            }
       
        
      
    }//GEN-LAST:event_btnAceptarMousePressed

    private void rdbRecepcionistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbRecepcionistaMousePressed
        
        jLabel2.setVisible(true);
        txtContraseña.setVisible(true);
    }//GEN-LAST:event_rdbRecepcionistaMousePressed

    private void rdbChoferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbChoferMousePressed

        jLabel2.setVisible(false);
        txtContraseña.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_rdbChoferMousePressed
   
    /**
     * validacion de login de la recpcionista
     * @return 
     */
    private boolean LoginRecepcionista()
    {
        int minLength = 2;
        int maxLength = 20;
        int validacion = 0;
        
        Border highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
        Border noBorder = BorderFactory.createLineBorder(java.awt.Color.gray);
        
        
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_RECEPCIONISTA_LOGIN] ?,?");
            statement.setString(1, txtUsuario.getText());
            statement.setString(2, txtContraseña.getText());
            boolean hadResults = statement.execute();
        
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                
              
                // process result set
                while (resultSet.next()) {
                    rowCount++;
                     id_recepcionista = Integer.parseInt(resultSet.getString("LEGAJO"));
                    String title = resultSet.getString("NOMBRE");
                    String description = resultSet.getString("APELLIDO");
                  
                    lblMensaje.setText("| " + title + " | " + description + " | ");
                }
 
                hadResults = statement.getMoreResults();
                
            }
 
            statement.close();
            conn.close();
            
            //Validacion de usuario
            if(!lengthCheck(txtUsuario.getText(),minLength, maxLength) || txtUsuario.getText().equals("") ){                        
                txtUsuario.setBorder(highlightBorder);                   
            } else {    txtUsuario.setBorder(noBorder);   }                                      


            //Validacion de contraseña
            if(!lengthCheck(txtContraseña.getText(),minLength, maxLength)){             
                txtContraseña.setBorder(highlightBorder);                   
            }else{    txtContraseña.setBorder(noBorder);   }

            if(rowCount < 1)
            {
                 JOptionPane.showMessageDialog(this, "Error! Usuario y contraseña incorrecta.\n","",JOptionPane.ERROR_MESSAGE); 
                 return false;
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Error! Usuario o contraseña incorrecta.\n","",JOptionPane.ERROR_MESSAGE); 
            e.getMessage();
               return false;
        }
        return true;
    }
    
    private boolean lengthCheck(String text, int minLength, int maxLength) {
        return maxLength > text.length() && text.length() > minLength;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
                try{
            UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");             

        }catch(Exception ex){
        }
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroupLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JRadioButton rdbChofer;
    private javax.swing.JRadioButton rdbRecepcionista;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
