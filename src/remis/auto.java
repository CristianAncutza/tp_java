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
class Auto {
    private int idAuto;
    int año;
    private String marca;
    private String modelo;
    private String patente;
    
    
    public Auto(int año, String marca, String patente, String modelo){
       
        this.año= año;
        this.marca = marca;
        this.patente = patente;
        this.modelo = modelo;
    }

    
    
    
}
