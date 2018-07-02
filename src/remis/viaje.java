/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 272623
 */
public class viaje {

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
    private String calleOrigen;
    private String numerOrigen;
    private localidad localidadOrigen;
    
      private String calleDestino;
    private String numeroDestino;
    private localidad localidadDestino;
            
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
    
   /**
     * Inserto viaje
     * @return 
     */
    public void altaViaje()
    {
        Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_VIAJE_ALTA] ?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            
            statement.setString(1, this.calleOrigen);//@CALLE_ORIGEN nvarchar(50),
            statement.setString(2, this.numerOrigen);//@NUMERO_ORIGEN nvarchar(50),
            statement.setInt(3, this.localidadOrigen.getId_localidad());//@ID_LOCALIDAD_ORIGEN int,
            statement.setString(4, this.calleDestino);//@CALLE_DESTINO nvarchar(50),
            statement.setString(5, this.numeroDestino);//@NUMERO_DESTINO nvarchar(50),
            statement.setInt(6, this.localidadDestino.getId_localidad());//@ID_LOCALIDAD_DESTINO int,
            statement.setDouble(7, 0);//@KMS float,
            statement.setDate(8, (java.sql.Date) this.fechaSalida);//@FECHA_SALIDA datetime,
            statement.setDate(9, (java.sql.Date) this.fechaLlegada);//@FECHA_LLEGADA datetime,
            statement.setString(10, null);//@VALOR float,
            statement.setString(11, null);//@ID_CHOFER int,
            statement.setInt(12, this.Cliente.getcodCliente());//@ID_CLIENTE int,
            statement.setInt(13, 1);//@ID_ESTADO int,
            statement.setInt(14, this.Recepcionista.getIdPersona());//@ID_RECEPCIONISTA_CREADO int
           
            boolean hadResults = statement.execute();
        
            statement.close();
            conn.close();
            
           
            
        } catch (Exception e) {
             
            e.getMessage();
              
        }
      
    }
    public viaje getUltimoViaje()
    {
        viaje v = new viaje();
         Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
            CallableStatement statement = conn.prepareCall("SELECT TOP 1 [ID_VIAJE]\n" +
                                                            "      ,[ID_DIRECCION_ORIGEN]\n" +
                                                            "      ,[ID_DIRECCION_DESTINO]\n" +
                                                            "      ,[KMS]\n" +
                                                            "      ,[FECHA_SALIDA]\n" +
                                                            "      ,[FECHA_LLEGADA]\n" +
                                                            "      ,[VALOR]\n" +
                                                            "      ,[ID_CHOFER]\n" +
                                                            "      ,[ID_CLIENTE]\n" +
                                                            "      ,[ID_ESTADO]\n" +
                                                            "      ,[ID_RECEPCIONISTA_CREADO]\n" +
                                                            "  FROM [REMISJAVA].[DBO].[VIAJE]\n" +
                                                            "  ORDER BY ID_VIAJE DESC");
            //statement.setString(1, txtUsuario.getText());
            
            boolean hadResults = statement.execute();
        
            int rowCount = 0;    
            while (hadResults) 
            {
                ResultSet resultSet = statement.getResultSet();
                // process result set
                while (resultSet.next()) {
                
                    rowCount++;
                    
                    v.setIdViaje(Integer.parseInt(resultSet.getString("ID_VIAJE")));
                
                   
                }
               
                hadResults = statement.getMoreResults();
                
            }
 
            statement.close();
            conn.close();
            
          
            
        } catch (Exception e) {
            
            
          
        }
        
        return v;
    }
    
    public void actualizarEstadoViaje(){
         Connection conn = null;
        Conectar cn = new Conectar();
        
        try {
            Class.forName(cn.getDriver()).newInstance();
            conn = DriverManager.getConnection(cn.getUrl(), cn.getDatabaseUserName(), cn.getDatabasePassword());
             CallableStatement statement = conn.prepareCall("EXEC [dbo].[SP_VIAJE_MODIFICACION] ?,?,?,?,?,?,?");
             statement.setInt(1, idViaje);    //@ID_VIAJE INT,
             statement.setInt(2,kms);  //@KMS int,
             statement.setString(3, null); //@FECHA_SALIDA datetime,
             statement.setString(4, null);  //@FECHA_LLEGADA datetime,
             statement.setFloat(5, valor);  //@VALOR float,
             statement.setInt(6, Chofer.getIdPersona()); //@ID_CHOFER int,
             
           
             Date date = new Date();
        
               switch(estado)
               {
                   case CANCELADO:
//                       statement.setDate(3, (java.sql.Date)date); //@FECHA_SALIDA datetime,
//                       statement.setDate(4, (java.sql.Date)date);  //@FECHA_LLEGADA datetime,
                       statement.setInt(7,3);//@ID_ESTADO int
                       break;
                   case FINALIZADO:
//                       statement.setDate(3, (java.sql.Date)this.fechaSalida);
//                       statement.setInt(7,4);//@ID_ESTADO int
                       break;
                   case PENDIENTE:
//                       statement.setString(3, null); //@FECHA_SALIDA datetime,
//                       statement.setString(4, null);  //@FECHA_LLEGADA datetime,
                       statement.setInt(7,1);//@ID_ESTADO int
                      break;
                   case TOMADO:
//                       statement.setDate(3, (java.sql.Date)date); //@FECHA_SALIDA datetime,
//                       statement.setString(4, null);  //@FECHA_LLEGADA datetime,
                       statement.setInt(7,2);//@ID_ESTADO int
                       break;
                       
                     
               }
              boolean hadResults = statement.execute();
        
            statement.close();
            conn.close();
            
           
            
        } catch (Exception e) {
             
            e.getMessage();
              
        }
    }

    public String getCalleOrigen() {
        return calleOrigen;
    }

    public String getNumerOrigen() {
        return numerOrigen;
    }

    public localidad getLocalidadOrigen() {
        return localidadOrigen;
    }

    public String getCalleOrigenDestino() {
        return calleDestino;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public localidad getLocalidadOrigenDestino() {
        return localidadDestino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public float getValor() {
        return valor;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setCalleOrigen(String calleOrigen) {
        this.calleOrigen = calleOrigen;
    }

    public void setNumerOrigen(String numerOrigen) {
        this.numerOrigen = numerOrigen;
    }

    public void setLocalidadOrigen(localidad localidadOrigen) {
        this.localidadOrigen = localidadOrigen;
    }

    public void setCalleDestino(String calleDestino) {
        this.calleDestino = calleDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public void setLocalidadDestino(localidad localidadDestino) {
        this.localidadDestino = localidadDestino;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idViaje;
        hash = 71 * hash + Objects.hashCode(this.calleOrigen);
        hash = 71 * hash + Objects.hashCode(this.numerOrigen);
        hash = 71 * hash + Objects.hashCode(this.localidadOrigen);
        hash = 71 * hash + Objects.hashCode(this.calleDestino);
        hash = 71 * hash + Objects.hashCode(this.numeroDestino);
        hash = 71 * hash + Objects.hashCode(this.localidadDestino);
        hash = 71 * hash + this.kms;
        hash = 71 * hash + Objects.hashCode(this.fechaSalida);
        hash = 71 * hash + Objects.hashCode(this.fechaLlegada);
        hash = 71 * hash + Float.floatToIntBits(this.valor);
        hash = 71 * hash + Objects.hashCode(this.Chofer);
        hash = 71 * hash + Objects.hashCode(this.Cliente);
        hash = 71 * hash + Objects.hashCode(this.Recepcionista);
        hash = 71 * hash + Objects.hashCode(this.estado);
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
        final viaje other = (viaje) obj;
        if (this.idViaje != other.idViaje) {
            return false;
        }
        if (this.kms != other.kms) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.calleOrigen, other.calleOrigen)) {
            return false;
        }
        if (!Objects.equals(this.numerOrigen, other.numerOrigen)) {
            return false;
        }
        if (!Objects.equals(this.calleDestino, other.calleDestino)) {
            return false;
        }
        if (!Objects.equals(this.numeroDestino, other.numeroDestino)) {
            return false;
        }
        if (!Objects.equals(this.localidadOrigen, other.localidadOrigen)) {
            return false;
        }
        if (!Objects.equals(this.localidadDestino, other.localidadDestino)) {
            return false;
        }
        if (!Objects.equals(this.fechaSalida, other.fechaSalida)) {
            return false;
        }
        if (!Objects.equals(this.fechaLlegada, other.fechaLlegada)) {
            return false;
        }
        if (!Objects.equals(this.Chofer, other.Chofer)) {
            return false;
        }
        if (!Objects.equals(this.Cliente, other.Cliente)) {
            return false;
        }
        if (!Objects.equals(this.Recepcionista, other.Recepcionista)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }
   
            
}
