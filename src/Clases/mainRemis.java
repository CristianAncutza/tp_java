package Clases;

import ConexionDB.Conectar;

import Pantallas.frmLogin;

import Pantallas.frmAutoAltaDialog;
import Pantallas.frmAutoModificacionDialog;
import Pantallas.frmAutoBajaDialog;

import Pantallas.frmChoferAltaDialog;
import Pantallas.frmChoferModificacionDialog;
import Pantallas.frmChoferBajaDialog;

import Pantallas.frmClienteAltaDialog;
import Pantallas.frmClienteModificacionDialog;
import Pantallas.frmClienteBajaDialog;

import Pantallas.frmViajeAltaDialog;
import Pantallas.frmViajeModificacionDialog;

import Pantallas.frmTicketListadoDialog;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementacion de singleton para crear las pantallas.
 * 
 * @author Cristian Ancutza
 */
public class mainRemis {
    private static Conectar                        conectar;
    
    private static frmLogin                        frmLogin;
    
    private static frmClienteAltaDialog            frmClienteAltaDialog;
    private static frmClienteModificacionDialog    frmClienteModificacionDialog;
    private static frmClienteBajaDialog            frmClienteBajaDialog;
    
    private static frmChoferAltaDialog             frmChoferAltaDialog;
    private static frmChoferModificacionDialog     frmChoferModificacionDialog;
    private static frmChoferBajaDialog             frmChoferBajaDialog;
        
    private static frmAutoAltaDialog               frmAutoAltaDialog;
    private static frmAutoModificacionDialog       frmAutoModificacionDialog;
    private static frmAutoBajaDialog               frmAutoBajaDialog;      
    
    private static frmViajeAltaDialog              frmViajeAltaDialog;
    private static frmViajeModificacionDialog      frmViajeModificacionDialog;

    private static frmTicketListadoDialog          frmTicketListadoDialog;

    /**
     * mainRemis: Crea una nueva instancia de la pantalla Login.
     * 
     * @param args
     * 
     * @author Cristian Ancutza
     */
    public static void mainRemis(String[] args) {
        new frmLogin().setVisible(true);
    }
    
    /**
     * Crea una nueva instancia de la pantalla alta cliente.
     * 
     * @param parent
     * @param modal
     * @return frmClienteAltaDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmClienteAltaDialog getfrmClienteAltaDialog(java.awt.Frame parent, boolean modal){
        if(frmClienteAltaDialog == null)
            frmClienteAltaDialog = new frmClienteAltaDialog(parent, modal);
        frmClienteAltaDialog.resetForm();                       
        
        return frmClienteAltaDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla modificacion cliente.
     * 
     * @param parent
     * @param modal
     * @return frmClienteModificacionDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmClienteModificacionDialog getfrmClienteModificacionDialog(java.awt.Frame parent, boolean modal){
        if(frmClienteModificacionDialog == null)
            frmClienteModificacionDialog = new frmClienteModificacionDialog(parent, modal);
        
        frmClienteModificacionDialog.listaClientes();
        frmClienteModificacionDialog.resetForm();
        return frmClienteModificacionDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla baja cliente.
     * 
     * @param parent
     * @param modal
     * @return frmClienteBajaDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmClienteBajaDialog getfrmClienteBajaDialog(java.awt.Frame parent, boolean modal){
        if(frmClienteBajaDialog == null)
            frmClienteBajaDialog = new frmClienteBajaDialog(parent, modal);
        
        frmClienteBajaDialog.listaClientes();
        frmClienteBajaDialog.resetForm();
        return frmClienteBajaDialog;
    }
    
     /**
     * Crea una nueva instancia de la pantalla alta chofer.
     * 
     * @param parent
     * @param modal
     * @return frmChoferAltaDialog
     * 
     * @author Cristian Ancutza
     */  
        public static synchronized frmChoferAltaDialog getfrmChoferAltaDialog(java.awt.Frame parent, boolean modal){
        if(frmChoferAltaDialog == null)
            frmChoferAltaDialog = new frmChoferAltaDialog(parent, modal);
        
        frmChoferAltaDialog.resetForm();
        return frmChoferAltaDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla modificacion chofer.
     * 
     * @param parent
     * @param modal
     * @return frmChoferModificacionDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmChoferModificacionDialog getfrmChoferModificacionDialog(java.awt.Frame parent, boolean modal){
        if(frmChoferModificacionDialog == null)
            frmChoferModificacionDialog = new frmChoferModificacionDialog(parent, modal);
        
        frmChoferModificacionDialog.listaChoferes();
        frmChoferModificacionDialog.resetForm();
        return frmChoferModificacionDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla baja chofer.
     * 
     * @param parent
     * @param modal
     * @return frmChoferBajaDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmChoferBajaDialog getfrmChoferBajaDialog(java.awt.Frame parent, boolean modal){
        if(frmChoferBajaDialog == null)
            frmChoferBajaDialog = new frmChoferBajaDialog(parent, modal);
        
            frmChoferBajaDialog.listaChoferes();
            frmChoferBajaDialog.resetForm();
        return frmChoferBajaDialog;
    }
    
     /**
     * Crea una nueva instancia de la pantalla alta auto.
     * 
     * @param parent
     * @param modal
     * @return frmAutoAltaDialog
     * 
     * @author Cristian Ancutza
     */
          public static synchronized frmAutoAltaDialog getfrmAutoAltaDialog(java.awt.Frame parent, boolean modal){
        if(frmAutoAltaDialog == null)
            frmAutoAltaDialog = new frmAutoAltaDialog(parent, modal);
        
        frmAutoAltaDialog.resetForm();
        return frmAutoAltaDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla modificacion auto.
     * 
     * @param parent
     * @param modal
     * @return frmAutoModificacionDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmAutoModificacionDialog getfrmAutoModificacionDialog(java.awt.Frame parent, boolean modal){
        if(frmAutoModificacionDialog == null)
            frmAutoModificacionDialog = new frmAutoModificacionDialog(parent, modal);
        
            frmAutoModificacionDialog.listaAutos();        
            frmAutoModificacionDialog.resetForm();
        return frmAutoModificacionDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla baja auto.
     * 
     * @param parent
     * @param modal
     * @return frmAutoBajaDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmAutoBajaDialog getfrmAutoBajaDialog(java.awt.Frame parent, boolean modal){
        if(frmAutoBajaDialog == null)
            frmAutoBajaDialog = new frmAutoBajaDialog(parent, modal);
        
        frmAutoBajaDialog.listaAutos();
        frmAutoBajaDialog.resetLabels();
        return frmAutoBajaDialog;
    }
    
         /**
     * Crea una nueva instancia de la pantalla alta viaje.
     * 
     * @param parent
     * @param modal
     * @return frmViajeAltaDialog
     * 
     * @author Cristian Ancutza
     */
          public static synchronized frmViajeAltaDialog getfrmViajeAltaDialog(java.awt.Frame parent, boolean modal, persona per){
        if(frmViajeAltaDialog == null)
            frmViajeAltaDialog = new frmViajeAltaDialog(parent, modal, per);
        
        frmViajeAltaDialog.resetForm();
        return frmViajeAltaDialog;
    }
    
        /**
     * Crea una nueva instancia de la pantalla modificacion viaje.
     * 
     * @param parent
     * @param modal
     * @return frmViajeModificacionDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmViajeModificacionDialog getfrmViajeModificacionDialog(java.awt.Frame parent, boolean modal){
        if(frmViajeModificacionDialog == null)
            frmViajeModificacionDialog = new frmViajeModificacionDialog(parent, modal);
        
        frmViajeModificacionDialog.listaViajes();
        frmViajeModificacionDialog.resetForm();
        return frmViajeModificacionDialog;
    }
    
     /**
     * Crea una nueva instancia de la pantalla listado de tickets.
     * 
     * @param parent
     * @param modal
     * @return frmTicketListadoDialog
     * 
     * @author Cristian Ancutza
     */
    public static synchronized frmTicketListadoDialog getfrmTicketListadoDialog(java.awt.Frame parent, boolean modal){
        if(frmTicketListadoDialog == null)
            frmTicketListadoDialog = new frmTicketListadoDialog(parent, modal);
        
        return frmTicketListadoDialog;
    }
    
    
    /**
     * Crea una nueva instancia de la conexión a la Base de Datos
     * @return conexion
     *     
     */
    public static synchronized Conectar getConectar(){
        if(conectar == null){
            conectar = new Conectar();
        }
        return conectar;
    }
    
   
}
