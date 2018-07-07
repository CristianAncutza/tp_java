/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import ConexionDB.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;

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
       
      public int altaChofer(){
     Connection conn = null;
        Conectar cn = new Conectar();
        
        try {      
               Class.forName(cn.getDriver()).newInstance();
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
             

            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_CHOFER_ALTA] ?, ?, ?, ?, ?");
            statement.setString(1, this.getNombre());
            statement.setString(2, this.getApellido());
            statement.setInt(3, this.legajo);
            statement.setString(4, this.licencia);
            statement.setInt(5, this.suAuto.getid_auto());
   
           //verifico que no exista el chofer
            String query = "SELECT * FROM CHOFER WHERE LEGAJO ='" + this.legajo + "' AND BAJA = 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);                            
           
            if(!rs.next()){
                statement.execute();
                return 0;
           }
            if (conn != null) {
                System.out.println("La operación fue realizada correctamente");
             }
        
            statement.close();
            conn.close();         
            
        } catch (Exception e) {
             
            e.getMessage();              
        }
        return 1;
    
    }
    public void modifChofer(){
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {      
             Class.forName(cn.getDriver()).newInstance();
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());
             

            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_CHOFER_MODIFICACION] ?, ?, ?, ?, ?, ?");
            statement.setInt(1, this.getIdPersona());
            statement.setString(2, this.getNombre());
            statement.setString(3, this.getApellido());
            statement.setInt(4, this.legajo);
            statement.setString(5, this.licencia);
            statement.setInt(6, this.suAuto.getid_auto());
            statement.execute();       
            
            statement.close();
            conn.close();
            
           
            
        } catch (Exception e) {
             
            e.getMessage();
              
        }
    }
    
   /**
     * Este metodo se utiliza para borrar un chofer.
     * retorna 0 si el auto se elimino correctamente o 1 si hubo un error.
     * 
     * @param id_chofer
     * @return 
     */
    public int bajaChofer(int id_chofer){
         Connection conn = null;
         Conectar cn = new Conectar();
        
        try {    
           
             conn = DriverManager.getConnection(cn.getUrl(),cn.getDatabaseUserName(),cn.getDatabasePassword());

            //borro el auto
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_CHOFER_BAJA] ?");
            statement.setInt(1, id_chofer);            
            boolean hadResults = statement.execute();             
            
            //verifico que se haya borrado correctamente el auto
            CallableStatement statement_test = conn.prepareCall("SELECT * FROM CHOFER WHERE baja = 1 and ID_CHOFER = "+ id_chofer);
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
    
    public chofer(){
        
    };    
    
    
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
