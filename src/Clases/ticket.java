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
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author u583313
 */
public class ticket {
    
    private int idTicket;
    private Date fecha;
    private float importe;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
    private int idViaje;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idTicket;
        hash = 41 * hash + Objects.hashCode(this.fecha);
        hash = 41 * hash + Float.floatToIntBits(this.importe);
        hash = 41 * hash + this.idViaje;
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
        final ticket other = (ticket) obj;
        if (this.idTicket != other.idTicket) {
            return false;
        }
        if (Float.floatToIntBits(this.importe) != Float.floatToIntBits(other.importe)) {
            return false;
        }
        if (this.idViaje != other.idViaje) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    public void listarTicket(){
    
        
    }
    
    public void listarTicket (int num){
              
    }
    
    public void generarTicket(){
     Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_TICKET_ALTA] ?");
            
            statement.setInt(1, this.idViaje);
            statement.execute();
        
            statement.close();
            conn.close();
            
           
            
        } catch (Exception e) {
             
            e.getMessage();
              
        }

    }
}
