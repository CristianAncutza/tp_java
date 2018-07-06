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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ex1fernajo
 */
public class frmChoferModificacionDialog extends java.awt.Dialog {

    /**
     * Creates new form frmChoferModificacionDialog
     */
    public frmChoferModificacionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        CargarAUTOS();
        listaChoferes();
    }
    
    public void resetForm(){    
        txtNombre.setText("");
        txtApellido.setText("");
        lblLegajo.setText("");
        txtLicencia.setText("");
        lblID.setText("");
        lblMensaje.setText("");
    }
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
            String query = "SELECT C.ID_CHOFER, C.NOMBRE, C.APELLIDO, C.LEGAJO, C.LICENCIA, a.ID_AUTO, (a.marca +', '+ a.modelo) as AUTO  FROM CHOFER C "
                    + "INNER JOIN AUTO A ON C.ID_AUTO = A.ID_AUTO WHERE C.BAJA = 1";

            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet rs = st.executeQuery(query);
            
            tblChofer.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            System.out.println(e);
        }            
    }
/**
     * Cargo las autos para el combo
     */
    public void CargarAUTOS()
    {
        Connection conn = null;
        Conectar cn = new Conectar();
        
         /*CARGADO CON QUERY*/
        /*try {
             
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT ID_AUTO, MARCA, MODELO FROM AUTO WHERE BAJA = 1");
            
            boolean hadResults = statement.execute();
                    
            while (hadResults) 
            {
           
                ResultSet rs = statement.getResultSet();

                while (rs.next()) {                   
                    
                    cboAuto.addItem(rs.getString("MARCA")+", "+rs.getString("MODELO"));
                }
                hadResults = statement.getMoreResults(); 
            }
            statement.close();
            conn.close();
        
            
        } catch (Exception e) {
            System.out.println(e);
        }*/
        /*CARGADO CON OBJETO*/
        
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
                
                List<auto> autoList = new ArrayList<auto>();
                 
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
            
          
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChofer = new javax.swing.JTable();
        txtLicencia = new javax.swing.JTextField();
        cboAuto = new javax.swing.JComboBox<>();
        lblApellido4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLegajo = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel2.setText("ID de Chofer:");

        lblApellido2.setText("Legajo :");

        lblID.setText("---");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblApellido3.setText("Licencia :");

        jLabel1.setText("Modificación de Chofer");

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
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

        txtLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenciaKeyTyped(evt);
            }
        });

        lblApellido4.setText("Auto :");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        lblNombre.setText("Nombre :");

        lblApellido.setText("Apellido :");

        lblLegajo.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblApellido4)
                            .addGap(18, 18, 18)
                            .addComponent(cboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblApellido2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLegajo)
                                .addGap(116, 116, 116))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblID)))))
                .addGap(240, 240, 240))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(btnAceptar)))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblApellido3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblApellido)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(460, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(210, 210, 210)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(155, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 218, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido2)
                    .addComponent(lblLegajo))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblApellido4)
                    .addComponent(cboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnAceptar)
                .addGap(31, 31, 31)
                .addComponent(lblMensaje)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellido)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellido3)
                        .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(90, Short.MAX_VALUE)))
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

    private void tblChoferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoferMousePressed
        
        auto auto = null;
        
        DefaultTableModel model =(DefaultTableModel)tblChofer.getModel();
        int selectedRowIndex = tblChofer.getSelectedRow();
        lblID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        txtNombre.setText(model.getValueAt(selectedRowIndex, 1).toString());
        txtApellido.setText(model.getValueAt(selectedRowIndex, 2).toString());
        lblLegajo.setText(model.getValueAt(selectedRowIndex, 3).toString());
        txtLicencia.setText(model.getValueAt(selectedRowIndex, 4).toString());
        //cboAuto.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
        //LOGICA PARA LA SELECCION DE AUTO
                 
       /* Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            String query = "SELECT id_auto, marca, modelo FROM auto WHERE id_auto =" + model.getValueAt(selectedRowIndex,5) +"";
            
            Statement st = conn.createStatement();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            ResultSet resultado = st.executeQuery(query);
                                                
                    
           while(resultado.next()){
             auto = new auto(resultado.getString(2), resultado.getString(3));
            }
        
 
            this.cboAuto.setSelectedItem(auto);            
            
            st.close();
            conn.close();
            
        
        }catch(Exception e){} 
        */
        
    }//GEN-LAST:event_tblChoferMousePressed

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
               
        if(validacion == 0)        
        {            
            chofer ch = new chofer();
            ch.setIdPersona(Integer.parseInt(lblID.getText()));
            ch.setApellido(txtApellido.getText());
            ch.setNombre(txtNombre.getText());
            ch.setLicencia(txtLicencia.getText());
            ch.setLegajo(Integer.parseInt(lblLegajo.getText()));
            ch.setSuAuto((auto)cboAuto.getSelectedItem());
            
            ch.modifChofer();
        
        listaChoferes();
        lblMensaje.setText("Se inserto correctamente el chofer");
        
        }
    }//GEN-LAST:event_btnAceptarMousePressed

    private boolean lengthCheck(String text, int minLength, int maxLength) {
        return maxLength > text.length() && text.length() > minLength;
    }
    
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

    private void txtLicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLicenciaKeyTyped
        
          char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
                        
          } 
    }//GEN-LAST:event_txtLicenciaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmChoferModificacionDialog dialog = new frmChoferModificacionDialog(new java.awt.Frame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblApellido3;
    private javax.swing.JLabel lblApellido4;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLegajo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblChofer;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
