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
public class cliente {
    
    private int codCliente;
    private Date fechaAlta;
    
    public String getcodCliente( ){
    return this.codCliente;
  }
 
    public void setCodCli(String codCliente){
    this.codCliente = codCliente;
  }
        
    public String getfechaAlta( ){
    return this.fechaAlta;
  }
 
    public void setfechaAlta(String fechaAlta){
    this.fechaAlta = fechaAlta;
  }    
    public void altaCli(){
    
    }
    public void bajaCli(){
    
    }
    public void modifCli(){
    
        
    }
}
