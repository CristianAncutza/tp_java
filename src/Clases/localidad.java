/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author ex1fernajo
 */
public class localidad {
    
    private int id_localidad;

    public int getId_localidad() {
        return id_localidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
    private String descripcion;

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id_localidad;
        hash = 47 * hash + Objects.hashCode(this.descripcion);
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
        final localidad other = (localidad) obj;
        if (this.id_localidad != other.id_localidad) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    
}
