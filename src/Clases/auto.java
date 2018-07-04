/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ConexionDB.Conectar;
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
 * @author Cristian Ancutza
 */
public class auto {
    private int id_auto;
    private int año;
    private String color;
    private String marca;
    private String patente;
    private String modelo;
    
    
    public int getid_auto(){
    return id_auto;
    }
        
    public void setid_auto(int id_auto){
    this.id_auto = id_auto;
    }
    
    public int getaño( ){
    return año;
  }
 
    public void setaño(int año){
    this.año = año;
  }
   
    public String getcolor( ){
    return color;
  }
 
    public void setcolor(String color){
    this.color = color;
  }
        
    public String marca( ){
    return marca;
  }
 
    public void setmarca(String marca){
    this.marca = marca;
  }    
    
    public String patente( ){
    return patente;
  }
 
    public void setpatente(String patente){
    this.patente = patente;
  }  
    
    public String modelo( ){
    return modelo;
  }
 
    public void setmodelo(String modelo){
    this.modelo = modelo;
  }  
    
    /**
     *Este metodo se usa para dar de alta un auto.
     */
    public int altaAuto(){
    
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {             
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());

            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_AUTO_ALTA] ?, ?, ?, ?, ?");
            statement.setInt(1, this.año);
            statement.setString(2, this.color);
            statement.setString(3, this.marca);
            statement.setString(4, this.modelo);
            statement.setString(5, this.patente);
   
            if (conn != null) {
                System.out.println("La conexión fue realizada correctamente");
             }
            
             //verifico que no exista el auto
            String query = "SELECT * FROM AUTO WHERE PATENTE ='" + this.patente + "'";
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
    public int modifAuto(int id_auto){
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
    }
    
    /**
     * Este metodo se utiliza para borrar un auto.
     * retorna 0 si el auto se elimino correctamente o 1 si hubo un error.
     * 
     * @param id_auto
     * @return 
     */
    public int bajaAuto(int id_auto){
         Connection conn = null;
         Conectar cn = new Conectar();
        
        try {             
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());

            //borro el auto
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_AUTO_DELETE] ?");
            statement.setInt(1, id_auto);            
            boolean hadResults = statement.execute();             
            
            //verifico que se haya borrado correctamente el auto
            CallableStatement statement_test = conn.prepareCall("SELECT * FROM AUTO WHERE ID_AUTO = "+ id_auto);
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

    @Override
    public String toString() {
        return   marca + ", " + modelo ;
    }
    
}

    
    
    

