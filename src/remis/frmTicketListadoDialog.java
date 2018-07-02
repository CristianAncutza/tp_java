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
                 cboClientes.setModel(new DefaultComboBoxModel(cliList.toArray()));
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
        jLabel6 = new javax.swing.JLabel();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        txtFechaLlegada = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        cboChofer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTickets = new javax.swing.JTable();
        cboClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnAplicar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel5.setText("Chofer :");

        jLabel6.setText("Cliente :");

        txtFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        txtFechaLlegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

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

        cboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jLabel1)))
                        .addGap(119, 119, 119)
                        .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblMensaje)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(cboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAplicar)))
                    .addComponent(txtFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addContainerGap(55, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        
        llenarListaTickets();
    }//GEN-LAST:event_btnAplicarMousePressed
    
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
           
           statement.setString(1, null);
           statement.setString(2, null);
           chofer c = new chofer();
           c = (chofer)cboChofer.getSelectedItem();
           cliente cl = new cliente();
           cl = (cliente)cboClientes.getSelectedItem();
           statement.setInt(3, c.getIdPersona());
           statement.setInt(4, cl.getcodCliente());

            
           @SuppressWarnings("LocalVariableHidesMemberVariable")
                    
           boolean hadResults = statement.execute();
          while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                  tbTickets.setModel(DbUtils.resultSetToTableModel(resultSet));   
                  
                }
               
                hadResults = statement.getMoreResults();
               
                
            }
           // process result set
           
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
    private javax.swing.JComboBox<String> cboClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tbTickets;
    private javax.swing.JFormattedTextField txtFechaLlegada;
    private javax.swing.JFormattedTextField txtFechaSalida;
    // End of variables declaration//GEN-END:variables
}
