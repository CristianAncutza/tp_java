/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ex1fernajo
 */
public class frmViajeModificaciónDialog extends java.awt.Dialog {

    /**
     * Creates new form frmViajeModificaciónDialog
     */
    public frmViajeModificaciónDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        CargarChoferes();
        CargarEstados();
        lista_viajes();
    }

    /**
     *Metodo para cargar el listado de viajes.
     */
    public void lista_viajes(){ 
            
         Connection conn = null;
         Conectar cn = new Conectar();
            
        try{
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
            
            String query = "EXEC [dbo].[SP_VIAJES_LISTADO]";

            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet rs = st.executeQuery(query);
            
            tbViajes.setModel(DbUtils.resultSetToTableModel(rs));               
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }            
    }
    /**
     * cargos los enums de estados en el combo
     */
    public void CargarEstados()
    {
          cboEstado.setModel(new DefaultComboBoxModel(EnumEstados.values()));
    }
    
    /**
     * cargo los choferes en el combo box
     */
    public void CargarChoferes()
    {
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT [ID_CHOFER]\n" +
                                                            "      ,[NOMBRE]\n" +
                                                            "      ,[APELLIDO]\n" +
                                                            "      ,[LEGAJO]\n" +
                                                            "      ,[LICENCIA]\n" +
                                                            "      ,[ID_AUTO]\n" +
                                                            "  FROM [RemisJava].[dbo].[CHOFER] ");
            //statement.setString(1, txtUsuario.getText());
            
            boolean hadResults = statement.execute();
        
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                
                //List<String> ls = new ArrayList<String>(); 
                List<chofer> cliList = new ArrayList<chofer>();
                chofer ch;
                // process result set
                while (resultSet.next()) {
                    rowCount++;
                    
                    ch = new chofer();
                    ch.setApellido(resultSet.getString("APELLIDO"));
                    ch.setIdPersona(Integer.parseInt(resultSet.getString("ID_CHOFER")));
                    ch.setLegajo(Integer.parseInt(resultSet.getString("LEGAJO")));
                    ch.setLicencia(resultSet.getString("LICENCIA"));
                    ch.setNombre(resultSet.getString("NOMBRE"));
                   
                    
//                    String id = resultSet.getString("ID_CLIENTE");
//                    String nombre = resultSet.getString("NOMBRE");
//                    String apellido = resultSet.getString("APELLIDO");
                  
                    //lblMensaje.setText("| " + nombre + " | " + apellido + " | ");
                    cliList.add(ch);
                    //ls.add(id + " " + nombre + " " + apellido);
                   
                }
                //cboClientes.setModel(new DefaultComboBoxModel(ls.toArray()));
                 cboChofer.setModel(new DefaultComboBoxModel(cliList.toArray()));
                hadResults = statement.getMoreResults();
                
            }
 
            statement.close();
            conn.close();
            
          
            
        } catch (Exception e) {
             lblMensaje.setText( e.getMessage());
            
          
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbViajes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboChofer = new javax.swing.JComboBox<>();
        txtKMS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Edición de Viajes");

        tbViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbViajesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbViajes);

        jLabel6.setText("Valor :");

        jLabel2.setText("ID Viaje: ");
        jLabel2.setToolTipText("");

        lblId.setText("----");

        jLabel7.setText("Chofer :");

        jLabel3.setText("KMS :");

        cboChofer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtKMS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKMSKeyTyped(evt);
            }
        });

        jLabel8.setText("Estado :");

        jLabel4.setText("Fecha Salida :");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Fecha Llegada :");

        jToggleButton1.setText("Guardar");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtKMS, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblId)))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboChofer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblId)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMensaje)
                            .addComponent(jToggleButton1)))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tbViajesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViajesMousePressed
        // TODO add your handling code here:
            DefaultTableModel model =(DefaultTableModel)tbViajes.getModel();
           int selectedRowIndex = tbViajes.getSelectedRow();
           lblId.setText(model.getValueAt(selectedRowIndex, 0).toString());
           txtKMS.setText(model.getValueAt(selectedRowIndex, 3).toString());
            txtValor.setText(model.getValueAt(selectedRowIndex, 6).toString());
            //cboChofer.setSelectedItem((chofer)model.getValueAt(selectedRowIndex, 9 ));
            
//           cboAño.setSelectedItem(model.getValueAt(selectedRowIndex, 1));
//           txtColor.setText(model.getValueAt(selectedRowIndex, 2).toString());
//           txtMarca.setText(model.getValueAt(selectedRowIndex, 3).toString());
//           txtModelo.setText(model.getValueAt(selectedRowIndex, 4).toString());
//           txtPatente.setText(model.getValueAt(selectedRowIndex, 5).toString());
           
    }//GEN-LAST:event_tbViajesMousePressed

    /**
     * Modifico el viaje
     * @param evt 
     */
    private void jToggleButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MousePressed
        // TODO add your handling code here:
        
        if(lblId.getText()== "----")
        {
            lblMensaje.setText("Elija un registro");
        }
        else
        {
            try
            {
           viaje v = new viaje();
           v.setIdViaje(Integer.parseInt(lblId.getText()));
           v.setKms(Integer.parseInt(txtKMS.getText()));
           v.setValor(Float.parseFloat(txtValor.getText()));
           v.setChofer((chofer)cboChofer.getSelectedItem());
           v.setEstado((EnumEstados)cboEstado.getSelectedItem());
           v.actualizarEstadoViaje();
            
           lista_viajes();
            lblMensaje.setText("se actualizo el viaje");
            
            
            }
            catch(Exception e)
            {
                lista_viajes();
                lblMensaje.setText("Ocurrio un ERROR , intente nuevamente");
            }
        }
    }//GEN-LAST:event_jToggleButton1MousePressed

    private void txtKMSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMSKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar(); 
            if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              
             evt.consume(); 
              
               
          } 
    }//GEN-LAST:event_txtKMSKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmViajeModificaciónDialog dialog = new frmViajeModificaciónDialog(new java.awt.Frame(), true);
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
    private javax.swing.JComboBox<String> cboChofer;
    private javax.swing.JComboBox<String> cboEstado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tbViajes;
    private javax.swing.JTextField txtKMS;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
