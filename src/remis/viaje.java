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

    /**
     * @return the Chofer
     */
    public chofer getChofer() {
        return Chofer;
    }

    /**
     * @param Chofer the Chofer to set
     */
    public void setChofer(chofer Chofer) {
        this.Chofer = Chofer;
    }

    /**
     * @return the Cliente
     */
    public cliente getCliente() {
        return Cliente;
    }

    /**
     * @param Cliente the Cliente to set
     */
    public void setCliente(cliente Cliente) {
        this.Cliente = Cliente;
    }

    /**
     * @return the Recepcionista
     */
    public recepcionista getRecepcionista() {
        return Recepcionista;
    }

    /**
     * @param Recepcionista the Recepcionista to set
     */
    public void setRecepcionista(recepcionista Recepcionista) {
        this.Recepcionista = Recepcionista;
    }

    /**
     * @return the estado
     */
    public EnumEstados getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EnumEstados estado) {
        this.estado = estado;
    }

    private int idViaje;
    private char origen;
    private char destino;
    private int kms;
    private Date fechaSalida;
    private Date fechaLlegada;
    private float valor;
    private chofer Chofer;
    private cliente Cliente;
    private recepcionista Recepcionista;
    private EnumEstados estado;
    
    
      /**
     * @return the idViaje
     */
    
    public viaje(){};
     
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
