/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.util.Date;

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
    
    public void altaCli(){
    
    }
    public void bajaCli(){
    
    }
    public void modifCli(){
    
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
