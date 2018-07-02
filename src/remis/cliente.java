/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author u583313
 */
public class cliente extends persona{
    
    private int codCliente;
    private Date fechaAlta;
    
    public int getcodCliente( ){
    return this.codCliente;
  }
 
    public void setCodCli(int codCliente){
    this.codCliente = codCliente;
  }
        
    public Date getfechaAlta( ){
    return this.fechaAlta;
  }
 
    public void setfechaAlta(Date fechaAlta){
    this.fechaAlta = fechaAlta;
  }   
    
   /**
     *Este metodo se usa para dar de alta un auto.
     */
    public int altaCliente()  {
    
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {             
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());

            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_CLIENTE_ALTA] ?, ?");
            statement.setString(1,this.nombre);
            statement.setString(2, this.apellido);
            
   
            if (conn != null) {
                System.out.println("La conexión fue realizada correctamente");
             }
            
             //verifico que no exista el auto
            String query = "SELECT * FROM CLIENTE WHERE NOMBRE ='" + this.nombre + "'"+"AND APELLIDO ="+"'"+ this.apellido+ "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);                            
           
            if(!rs.next()){
                boolean hadResults = statement.execute();
                return 0;
            }
            if (conn != null) {
                System.out.println("La operacion fue realizada correctamente");
             }
            
            
            statement.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
        }
       return 1;
    }

    /**
     * Metodo para actualizar datos del auto.
     * @param id_auto
     */
    /*public int modifAuto(int id_auto){
         Connection conn = null;
         Conectar cn = new Conectar();
        
        try {             
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
                     
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_AUTO_MODIFICACION] ?, ?, ?, ?, ?");                                   
            statement.setInt(1, id_auto);
            statement.setInt(2, this.año);
            statement.setString(3, this.color);
            statement.setString(4, this.marca);
            statement.setString(5, this.modelo);
                                     
            boolean hadResults = statement.execute();
           
            if(hadResults){
                return 0;
            }
           
            if (conn != null) {                    
                    System.out.println("La conexión fue realizada correctamente");                    
             }
            statement.close();
            conn.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
        }  
        return 1;
    }*/
    
    /**
     * Este metodo se utiliza para borrar un auto.
     * retorna 0 si el auto se elimino correctamente o 1 si hubo un error.
     * 
     * @param id_auto
     * @return 
     */
    public int bajaCliente(int id_cliente){
         Connection conn = null;
         Conectar cn = new Conectar();
        
        try {             
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());

            //borro el cliente
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_CLIENTE_DELETE] ?");
            statement.setInt(1, id_cliente);            
            boolean hadResults = statement.execute();             
            
            //verifico que se haya borrado correctamente el cliente
            CallableStatement statement_test = conn.prepareCall("SELECT * FROM AUTO WHERE ID_CLIENTE = "+ id_cliente);
            boolean hadResults_test = statement_test.execute();                                  
            
            if(hadResults_test == false){
                return 1;
            }
            
            if (conn != null) {                    
                    System.out.println("La conexión fue realizada correctamente");                    
             }
            
            statement.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
        }
        return 0;
    }

    public cliente () 
    {}
    public cliente(int codCliente,Date fechaAlta, String nombre, String apellido){
      
        this.codCliente = codCliente;
        this.fechaAlta = fechaAlta;
        this.setNombre(nombre);
        this.setApellido(apellido);
        
     }
     public cliente getCliente ( int id)
    { 
        cliente cli = new cliente();
               
        cli.getcodCliente();
        cli.getfechaAlta();
        String nombre = cli.getNombre();
        cli.getApellido();
                
        return cli;
    }

}
