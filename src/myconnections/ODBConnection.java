/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconnections;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;*/
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jules
 */
public class ODBConnection {
    protected String dbName;
    protected String username;
    protected String password;
    
    public ODBConnection() {
     PropertyResourceBundle properties = (PropertyResourceBundle)
     PropertyResourceBundle.getBundle("resources.application");//ressources.application ?
     dbName =properties.getString("cours.DB.database");
     username=properties.getString("cours.DB.login");
     password=properties.getString("cours.DB.password");
   
    }

  public ODBConnection(String username,String password){
     this();
     this.username=username;
     this.password=password;
  }  
 

 public Connection getConnection() {
     try{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  //chargement du driver JDBC-ODBC
      
     dbName="ProjetOracle";
     String url = "jdbc:odbc:"+dbName;
     return DriverManager.getConnection(url,username,password);
    }
    catch(Exception e) {
     System.out.println("erreur de connexion "+e);
     e.printStackTrace();
     return null ;
    }    
  }     
}
