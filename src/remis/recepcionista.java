/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

/**
 *
 * @author u583313
 */
public class recepcionista extends persona{

    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

 
    private int usuario;
    private int legajo;
    private int password;
    
    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
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
