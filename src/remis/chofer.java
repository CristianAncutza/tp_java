/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

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
        setNombre(nombre);
        setApellido(apellido);    
        
    }
    
    public chofer getChofer ( int id)
    { 
        chofer ch = new chofer();
               
        ch.getLegajo();
        ch.getLicencia();
        ch.getNombre();
        ch.getApellido();
                
        return ch;
    }
}
