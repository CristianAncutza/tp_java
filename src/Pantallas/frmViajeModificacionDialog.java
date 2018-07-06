/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.viaje;
import Clases.chofer;
import ConexionDB.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ex1fernajo
 */
public class frmViajeModificacionDialog extends java.awt.Dialog {

    /**
     * Creates new form frmViajeModificaciónDialog
     */
    public frmViajeModificacionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        CargarChoferes();
        CargarEstados();
        listaViajes();
    }
    
        public void resetForm(){    
        lblId.setText("");
        txtKMS.setText("");
        txtValor.setText("");        
        lblMensaje.setText("");
      
    }
    

    /**
     *Metodo para cargar el listado de viajes.
     */
    public void listaViajes(){ 
            
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
     * Cargo los choferes en el combo box
     */
    public void CargarChoferes()
    {
        Connection conn = null;
        Conectar cn = new Conectar();                
        
        
        /*cargado con query*/
        /*try {
             
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT [ID_CHOFER]\n" +
                                                            "      ,[NOMBRE]\n" +
                                                            "      ,[APELLIDO]\n" +
                                                            "      ,[LEGAJO]\n" +
                                                            "      ,[LICENCIA]\n" +
                                                            "      ,[ID_AUTO]\n" +
                                                            "  FROM [RemisJava].[dbo].[CHOFER] \n " +
                                                            "WHERE BAJA = 1 ");         
            boolean hadResults = statement.execute();
                    
            while (hadResults) 
            {
           
                ResultSet rs = statement.getResultSet();

                while (rs.next()) {                   
                    cboChofer.addItem(rs.getString("NOMBRE") + "," + rs.getString("APELLIDO"));
                }
                hadResults = statement.getMoreResults(); 
            }
            statement.close();
            conn.close();
        
            
        } catch (Exception e) {
            System.out.println(e);
        }
        */
            
        
        /*COMBO CARGADO CON ARRAYLIST*/
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT [ID_CHOFER]\n" +
                                                            "      ,[NOMBRE]\n" +
                                                            "      ,[APELLIDO]\n" +
                                                            "      ,[LEGAJO]\n" +
                                                            "      ,[LICENCIA]\n" +
                                                            "      ,[ID_AUTO]\n" +
                                                            "  FROM [RemisJava].[dbo].[CHOFER] \n " +
                                                            "WHERE BAJA = 1 ");         
            
            boolean hadResults = statement.execute();
                    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                                
                List<chofer> cliList = new ArrayList<>();
                chofer ch;
                
                while (resultSet.next()) {
                                        
                    ch = new chofer();
                    ch.setApellido(resultSet.getString("APELLIDO"));
                    ch.setIdPersona(Integer.parseInt(resultSet.getString("ID_CHOFER")));
                    ch.setLegajo(Integer.parseInt(resultSet.getString("LEGAJO")));
                    ch.setLicencia(resultSet.getString("LICENCIA"));
                    ch.setNombre(resultSet.getString("NOMBRE"));
                   
                    cliList.add(ch);       
                   
                }       
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
        txtKMS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        cboChofer = new javax.swing.JComboBox<>();

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

        txtKMS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKMSKeyTyped(evt);
            }
        });

        jLabel8.setText("Estado :");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jToggleButton1.setText("Guardar");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton1MousePressed(evt);
            }
        });

        cboChofer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboEstado, 0, 194, Short.MAX_VALUE)
                                            .addComponent(cboChofer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(242, 242, 242))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblId))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtKMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(lblMensaje))
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
            
           DefaultTableModel model =(DefaultTableModel)tbViajes.getModel();
           int selectedRowIndex = tbViajes.getSelectedRow();
   
           lblId.setText(model.getValueAt(selectedRowIndex, 0).toString());
           txtKMS.setText(model.getValueAt(selectedRowIndex, 3).toString());
           txtValor.setText(model.getValueAt(selectedRowIndex, 6).toString());           
           //cboChofer.setSelectedItem(model.getValueAt(selectedRowIndex, 8));
           //cboEstado.setSelectedItem(model.getValueAt(selectedRowIndex, 10));
           //cboChofer.addItem(model.getValueAt(selectedRowIndex, 8).toString());
            //cboEstado.addItem(model.getValueAt(selectedRowIndex, 10).toString());       
    }//GEN-LAST:event_tbViajesMousePressed

    /**
     * Modifico el viaje
     * @param evt 
     */
    private void jToggleButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MousePressed
        
        int minLength = 0;
        int maxLength = 20;
        int validacion = 0;
        Border highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
        Border noBorder = BorderFactory.createLineBorder(java.awt.Color.gray);               
        
        /**********************VALIDACIONES****************************/        
        
        //Validacion de KMS
        if(!lengthCheck(txtKMS.getText(),minLength, maxLength) || txtKMS.getText().equals("") ){                        
            txtKMS.setBorder(highlightBorder);   
            validacion = 1;
        } else {    txtKMS.setBorder(noBorder);   }    
        
        //Validacion de Valor
        if(!lengthCheck(txtValor.getText(),minLength, maxLength) || txtValor.getText().equals("") ){                        
            txtValor.setBorder(highlightBorder);   
            validacion = 1;
        } else {    txtValor.setBorder(noBorder);   }    
        
        
        if(lblId.getText().equals( "----"))
        {
            JOptionPane.showMessageDialog(this, "Por favor, elija un registro de la tabla.\n","",JOptionPane.ERROR_MESSAGE); 
        }
        else
        {
            try
            {
                if(validacion == 0)        
                {  
                    viaje v = new viaje();
                    v.setIdViaje(Integer.parseInt(lblId.getText()));
                    v.setKms(Integer.parseInt(txtKMS.getText()));
                    v.setValor(Float.parseFloat(txtValor.getText()));
                    v.setChofer((chofer)cboChofer.getSelectedItem());
                    v.setEstado((EnumEstados)cboEstado.getSelectedItem());
                    v.actualizarEstadoViaje();

                    listaViajes();
                    JOptionPane.showMessageDialog(this, "Se actualizó correctamente el viaje.\n","",JOptionPane.INFORMATION_MESSAGE); 
 
                }
                else{
                    JOptionPane.showMessageDialog(this, "Complete todos los campos, con longitud minima de 1 y maxima de 20 caracteres.\n","",JOptionPane.ERROR_MESSAGE); 
                }
            }
            catch(Exception e)
            {
                listaViajes();
                JOptionPane.showMessageDialog(this, "Error! no se pudó actualizar el viaje.\n","",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }//GEN-LAST:event_jToggleButton1MousePressed

    private boolean lengthCheck(String text, int minLength, int maxLength) {
        return maxLength > text.length() && text.length() > minLength;
    }
    
    private void txtKMSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMSKeyTyped
        
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
                frmViajeModificacionDialog dialog = new frmViajeModificacionDialog(new java.awt.Frame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
