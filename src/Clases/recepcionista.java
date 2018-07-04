/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.persona;
import ConexionDB.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author u583313
 */
public class recepcionista extends persona{

    

    private String usuario;
    private int legajo;
    private int password;
    
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the legajo
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    /**
     * @return the password
     */
    public int getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(int password) {
        this.password = password;
    }
    
    
    public void validarUsuario(int leg){
    
        
    }
    public recepcionista(){}
    
    public recepcionista(int id)
    {
     recepcionista rep = new recepcionista();
        
         
        Connection conn = null;
        Conectar cn = new Conectar();
        
         try {             
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
         
            CallableStatement statement = conn.prepareCall("SELECT * FROM RECEPCIONISTA WHERE LEGAJO = "+ id);
           
            boolean hadResults = statement.execute();
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                
                    rowCount++;
                    
                   this.setIdPersona(Integer.parseInt(resultSet.getString("ID_RECEPCIONISTA")));
                   this.legajo = (Integer.parseInt(resultSet.getString("LEGAJO")));
                   this.setNombre(resultSet.getString("NOMBRE"));
                   this.setApellido(resultSet.getString("APELLIDO"));
                   this.usuario = (resultSet.getString("USUARIO"));
                    
                
                   
                }
               
                hadResults = statement.getMoreResults();
                
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
        
  
    }
    public recepcionista getRecepcionista ( int id)
    { 
        recepcionista rep = new recepcionista();
        
        rep.getRecepcionista(id);
        rep.getNombre();
        rep.getApellido();
        rep.getLegajo();
        rep.getUsuario();
        rep.getPassword();
        
        return rep;
    }
}
