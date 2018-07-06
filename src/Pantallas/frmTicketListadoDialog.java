/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;
import Clases.cliente;
import Clases.chofer;
import ConexionDB.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ex1fernajo
 */
public class frmTicketListadoDialog extends java.awt.Dialog {

    /**
     * Creates new form frmTicketListadoDialog
     */
    public frmTicketListadoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        CargarChoferes();
        CargarClientes();
    }
    public void CargarClientes()
    {
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT [ID_CLIENTE]\n" +
                                                            "      ,[NOMBRE]\n" +
                                                            "      ,[APELLIDO]\n" +
                                                            "      ,[FECHA_ALTA]\n" +
                                                            "  FROM [RemisJava].[dbo].[CLIENTE] ");
            //statement.setString(1, txtUsuario.getText());
            
            boolean hadResults = statement.execute();
        
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                
                //List<String> ls = new ArrayList<String>(); 
                List<cliente> cliList = new ArrayList<cliente>();
                cliente cli;
                // process result set
                while (resultSet.next()) {
                    rowCount++;
                    
                    cli = new cliente();
                    cli.setApellido(resultSet.getString("APELLIDO"));
                    cli.setNombre(resultSet.getString("NOMBRE"));
                    cli.setCodCli(Integer.parseInt(resultSet.getString("ID_CLIENTE")));
                    
                    
//                    String id = resultSet.getString("ID_CLIENTE");
//                    String nombre = resultSet.getString("NOMBRE");
//                    String apellido = resultSet.getString("APELLIDO");
                  
                    //lblMensaje.setText("| " + nombre + " | " + apellido + " | ");
                    cliList.add(cli);
                    //ls.add(id + " " + nombre + " " + apellido);
                   
                }
                //cboClientes.setModel(new DefaultComboBoxModel(ls.toArray()));
                // cboClientes.setModel(new DefaultComboBoxModel(cliList.toArray()));
                hadResults = statement.getMoreResults();
                
            }
 
            statement.close();
            conn.close();
            
          
            
        } catch (Exception e) {
             lblMensaje.setText( e.getMessage());
            
          
        }
        
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

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboChofer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTickets = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAplicar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jDesde = new com.toedter.calendar.JDateChooser();
        jHasta = new com.toedter.calendar.JDateChooser();
        lblValor = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel5.setText("Chofer :");

        jLabel1.setText("Listado de Tickets");

        cboChofer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbTickets.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbTickets);

        jLabel2.setText("Filtros");

        btnAplicar.setText("Aplicar");
        btnAplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAplicarMousePressed(evt);
            }
        });

        jLabel3.setText("Desde :");

        jLabel4.setText("Hasta :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jLabel1)))
                        .addGap(119, 119, 119)
                        .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValor)
                            .addComponent(lblMensaje))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(btnAplicar)))
                    .addComponent(jHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValor)
                .addContainerGap(49, Short.MAX_VALUE))
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

    private void btnAplicarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAplicarMousePressed
        
        if(Validar())
        {
            llenarListaTickets();
        }
    }//GEN-LAST:event_btnAplicarMousePressed
    
    private boolean Validar()
    {
        if(jDesde.getDate() == null)
        {
            lblMensaje.setText("Campo desde es obligatorio!!");
            return false;
        }
        if(jHasta.getDate() == null)
        {
            lblMensaje.setText("Campo hasta es obligatorio!!");
            return false;
        }
        int result = jHasta.getDate().compareTo(jDesde.getDate());
        if(result < 0)
        {
             lblMensaje.setText("Campo hasta debe ser mayor al desde!!");
            return false;
        }
        return true;
        
    }
    /**
     * llena la table con el query del listado 
     */
    private void llenarListaTickets ()
    {
         Connection conn = null;
         Conectar cn = new Conectar();
            
        try{
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
            
           CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_TICKETS_LISTADO] ?,?,?,?");
          Date desde = new Date();
           
//           Date desde  = new Date();
           desde = jDesde.getDate();
//           
           Date hasta  = new Date();
           
           hasta = jHasta.getDate();
           chofer c = new chofer();
           c = (chofer)cboChofer.getSelectedItem();
//           cliente cl = new cliente();
//           cl = (cliente)cboClientes.getSelectedItem(); 
           
           //statement.setDate(1, (java.sql.Date) desde);
           statement.setDate(1, new java.sql.Date(desde.getTime()));
           
           statement.setDate(2, new java.sql.Date(desde.getTime()));
      
           statement.setInt(3, c.getIdPersona());
           statement.setString(4, null);
          
            
           @SuppressWarnings("LocalVariableHidesMemberVariable")
                    
           boolean hadResults = statement.execute();
            
           float valor = 0;  
        
          while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                   valor = valor +   (Float.parseFloat(resultSet.getString("VALOR")));
                  tbTickets.setModel(DbUtils.resultSetToTableModel(resultSet));   
                  
                }
               
                hadResults = statement.getMoreResults();
               
                
            }
          
           
            statement.close();
            conn.close();
            
            
            
                       
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }            
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmTicketListadoDialog dialog = new frmTicketListadoDialog(new java.awt.Frame(), true);
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
    private javax.swing.JToggleButton btnAplicar;
    private javax.swing.JComboBox<String> cboChofer;
    private com.toedter.calendar.JDateChooser jDesde;
    private com.toedter.calendar.JDateChooser jHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tbTickets;
    // End of variables declaration//GEN-END:variables
}
