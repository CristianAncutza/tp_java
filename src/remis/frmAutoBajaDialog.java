/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Cristian Ancutza
 */
public class frmAutoBajaDialog extends java.awt.Dialog {

    /**
     * Creates new form frmAutoBajaDialog
     */
    public frmAutoBajaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        lista_autos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBaja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel2.setText("ID Auto :");

        lblMensaje.setText(" ");

        jLabel1.setText("Baja de Auto");

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        tblAuto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAuto);

        jLabel3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(88, 88, 88)
                                .addComponent(btnBaja)))))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnBaja)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Metodo para refrescar el listado de autos.
     */
    public void refresh_tabla(){
    
        String sql = null;        
        Connection conn = null;
        Conectar cn = new Conectar();
        try{
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());   
            String query = "SELECT * FROM auto";
            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet rs = st.executeQuery(query);            
            tblAuto.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    /**
    *Meotodo para listar los autos.
    */
    public void lista_autos(){ 
            
         Connection conn = null;
         Conectar cn = new Conectar();
            
        try{
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
            auto autos;
            String query = "SELECT * FROM auto";

            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet rs = st.executeQuery(query);
            
            tblAuto.setModel(DbUtils.resultSetToTableModel(rs));
            
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

    private void tblAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoMouseClicked
        //completo los campos del formulario en base a la seleccion de row en la lista.
        DefaultTableModel model =(DefaultTableModel)tblAuto.getModel();
        int selectedRowIndex = tblAuto.getSelectedRow();
        jLabel3.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_tblAutoMouseClicked

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
         //obtengo el id de la row seleccionada.
        int selectedRowIndex = tblAuto.getSelectedRow();                       
        int id_auto = (int) tblAuto.getModel().getValueAt(selectedRowIndex, 0);
        
        auto a = new auto();                
        if(a.bajaAuto(id_auto) == 0){
                lblMensaje.setText("Se eliminó correctamente el auto");
                refresh_tabla();
        }
        else{
            lblMensaje.setText("Error: no se pudo eliminar el auto");
        }              
    }//GEN-LAST:event_btnBajaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAutoBajaDialog dialog = new frmAutoBajaDialog(new java.awt.Frame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblAuto;
    // End of variables declaration//GEN-END:variables
}
