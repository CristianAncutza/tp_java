/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author u583313
 */
public class persona {

    private int idPersona;
    String nombre;
    String apellido;
    
     /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    @Override
    public String toString() {
        return  getNombre() + ", " + getApellido() ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.getIdPersona();
        hash = 71 * hash + Objects.hashCode(this.getNombre());
        hash = 71 * hash + Objects.hashCode(this.getApellido());
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
        final persona other = (persona) obj;
        if (this.getIdPersona() != other.getIdPersona()) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
}
