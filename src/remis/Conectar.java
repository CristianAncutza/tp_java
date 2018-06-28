/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remis;

/**
 *
 * @author ex1fernajo
 */
public class Conectar {
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setDatabaseUserName(String databaseUserName) {
        this.databaseUserName = databaseUserName;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getDatabaseUserName() {
        return databaseUserName;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }
    
   
    public Conectar() {
    
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.databaseUserName = "sa";
        this.databasePassword = "Sqlserver";
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=RemisJava";
    }
    private String url;
    private String driver;
    private String databaseUserName;
    private String databasePassword;

}
