/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

/**
 *
 * @author 272623
 */
class Chofer extends persona{
 
    private int legajo;
    private int licencia;
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
    public int getLicencia() {
        return licencia;
    }

    /**
     * @param licencia the licencia to set
     */
    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }
   
    
    public Chofer(int legajo, int licencia, String nombre, String apellido){
        
        this.legajo = legajo;
        this.licencia = licencia;
        this.nombre = nombre;
        this.apellido = apellido;
              
        
        
        
    }
    
}
