/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.auto;
import Clases.chofer;
import ConexionDB.Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ex1fernajo
 */
public class frmChoferBajaDialog extends java.awt.Dialog {
    
   
    /**
     * Creates new form frmChoferBajaDialog
     * @param parent
     * @param modal
     */
    public frmChoferBajaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        listaChoferes();        
    }
    
    public void resetForm(){    
        lblID.setText("");
        lblMensaje.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBaja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChofer = new javax.swing.JTable();
        lblMensaje = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();

        setName(""); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("ID Chofer:");

        jLabel2.setText("Baja de Chofer");

        btnBaja.setText("Baja");
        btnBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBajaMousePressed(evt);
            }
        });

        tblChofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChofer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChoferMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChofer);

        lblID.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(157, 157, 157)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblID)
                            .addGap(87, 87, 87)
                            .addComponent(btnBaja))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel2)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBaja)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * llena la grilla con todos los choferes
     */
    public void listaChoferes()
    {
        Connection conn = null;
         Conectar cn = new Conectar();
            
        try{
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
            auto autos;
            String query = "SELECT * FROM CHOFER WHERE BAJA = 1";

            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet rs = st.executeQuery(query);
            
            tblChofer.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }            
    }
    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tblChoferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoferMousePressed
       
        DefaultTableModel model =(DefaultTableModel)tblChofer.getModel();
        int selectedRowIndex = tblChofer.getSelectedRow();
        lblID.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_tblChoferMousePressed

    private void btnBajaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaMousePressed
        
          //obtengo el id de la row seleccionada.
        int selectedRowIndex = tblChofer.getSelectedRow();                       
        int id_chofer = (int) tblChofer.getModel().getValueAt(selectedRowIndex, 0);
        
        chofer ch = new chofer();                
        if(ch.bajaChofer(id_chofer) == 0){
                lblMensaje.setText("Se eliminó correctamente el chofer.");
                listaChoferes();
        }
        else{
            lblMensaje.setText("Error: no se pudo eliminar el chofer.");
        }    
    }//GEN-LAST:event_btnBajaMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                frmChoferBajaDialog dialog = new frmChoferBajaDialog(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblChofer;
    // End of variables declaration//GEN-END:variables
}
