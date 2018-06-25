/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.util.Date;

/**
 *
 * @author 272623
 */
class viaje {

    private int idViaje;
    private char origen;
    private char destino;
    private int kms;
    private Date fechaSalida;
    private Date fechaLlegada;
    private float valor;
    
      /**
     * @return the idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }

    /**
     * @return the origen
     */
    public char getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(char origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public char getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(char destino) {
        this.destino = destino;
    }

    /**
     * @return the kms
     */
    public int getKms() {
        return kms;
    }

    /**
     * @param kms the kms to set
     */
    public void setKms(int kms) {
        this.kms = kms;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public void consultarInformes(){
    
    }
    
    public void altaViaje(){
    
    }
    
    public void actualizarEstadoViaje(){
    
    }
    
    public viaje(char origen,char destino,int kms,Date fechaSalida,Date fechaLlegada,int valor){
       
        this.origen = origen;
        this.destino = destino;
        this.kms = kms;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.valor = valor;
        
    }
            
}
