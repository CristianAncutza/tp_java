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
class auto {

    private int idAuto;
    private int año;
    private String marca;
    private String modelo;
    private String patente;
    private String color;
    
      /**
     * @return the idAuto
     */
    public int getIdAuto() {
        return idAuto;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @param patente the patente to set
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
     public void altaAuto(){
    
    }
    public void bajaAuto(){
    
    }
    public void modifAuto(){
    
    }
    
    public auto(int año, String marca, String patente, String modelo, String color){
       
        this.año= año;
        this.marca = marca;
        this.patente = patente;
        this.modelo = modelo;
        this.color = color;
        
    }

    
    
    
}
