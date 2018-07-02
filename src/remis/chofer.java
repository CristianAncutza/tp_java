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
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author 272623
 */
public class chofer extends persona{
 
    private int legajo;
    private String licencia;
    private auto suAuto;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.legajo;
        hash = 47 * hash + Objects.hashCode(this.licencia);
        hash = 47 * hash + Objects.hashCode(this.suAuto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final chofer other = (chofer) obj;
        if (this.legajo != other.legajo) {
            return false;
        }
        if (this.licencia != other.licencia) {
            return false;
        }
        if (!Objects.equals(this.suAuto, other.suAuto)) {
            return false;
        }
        return true;
    }

    public auto getSuAuto() {
        return suAuto;
    }

    public void setSuAuto(auto suAuto) {
        this.suAuto = suAuto;
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
     * @return the licencia
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * @param licencia the licencia to set
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
       
    public void altaChofer(){
    
    }
    
    public void modifCchofer(){
    
    }
    
    public void bajaChofer(){
    
    }
    
    public chofer(){};
            
    public chofer(int legajo, String licencia, String nombre, String apellido){
        
        this.legajo = legajo;
        this.licencia = licencia;
        this.setNombre(nombre);
        this.setApellido(apellido);  
        
    }
    
    public chofer(int id){
        
        Connection conn = null;
        Conectar cn = new Conectar();
        
         try {             
         
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
              CallableStatement statement = conn.prepareCall("SELECT * FROM CHOFER WHERE LEGAJO = "+ id);
              
          
             boolean hadResults = statement.execute();
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                
                    rowCount++;
                   this.legajo = (Integer.parseInt(resultSet.getString("LEGAJO")));
                   this.setNombre(resultSet.getString("NOMBRE"));
                   this.setApellido(resultSet.getString("APELLIDO"));
                   this.licencia = (resultSet.getString("LICENCIA"));
                    
                
                   
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
    };
    
    public chofer getChofer ( int id)
    { 
       chofer ch = new chofer();
        
        Connection conn = null;
        Conectar cn = new Conectar();
        
         try {             
         
            conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
              CallableStatement statement = conn.prepareCall("SELECT * FROM CHOFER WHERE LEGAJO = "+ id);
              
          
             boolean hadResults = statement.execute();
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                
                    rowCount++;
                    ch.setLegajo(Integer.parseInt(resultSet.getString("LEGAJO")));
                    ch.setNombre(resultSet.getString("NOMBRE"));
                        ch.setApellido(resultSet.getString("APELLIDO"));
                        ch.setLicencia(resultSet.getString("LICENCIA"));
                    
                
                   
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
        
                
        return ch;
                
   
    }
}
