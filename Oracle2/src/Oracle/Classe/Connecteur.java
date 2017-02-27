/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;
import java.util.*;
import java.sql.*;

/**
 *
 * @author WorkStation
 */
public class Connecteur {
    
    private Connection con;
    private Statement stmt;
 
    /**
     * create a new instance of connecteur
     */
    public Connecteur() {
        String username = "root";
        String password = null;
        String bdd = "compagnieaerienne";
        String port = "3306";
 
        String url = "jdbc:oracle:thin:@localhost:1521:cei";
 
        try{
            Class.forName("oracle.jdbc.OracleDriver");//ici, ça ne marche plus et lève une exception aparement avec CLASSPATH
        }catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try{
            con =  DriverManager.getConnection(url, username, password);
            System.out.println("OK connexion réussie...");
            stmt = con.createStatement();
 
        }
 
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
 
    /**
     * return db statement
     * @return 
     */
    private Statement getStmt() {
        return stmt;
    }
 
    /**
     * return the connection
     * @return 
     */
    public Connection getCon() {
        return con;
    }
    /*
     public ResultSet exec(String sql) {
        try {
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */
      
    
    /**
     * use only with SELECT or for data return
     * @param sql
     * @return 
     */
    public ResultSet requete(String sql)
    {
       try
       {
           ResultSet rs = this.getStmt().executeQuery(sql);
           return rs;
       }
       catch(SQLException ex)
       {
           System.out.println("sql error on SELECT : "+ex);
       }
       return null;
     
     }
     /**
      * use with UPDATE, INSERT, DELETE
      * @param sql 
      * @param i random number not used
      */
     public void requete (String sql, int i)
     {
        try
        {
            this.getStmt().execute(sql);
            
        }
        catch(SQLException ex)
        {
            System.out.println("sql error on UPDATE, DELETE or INSERT : "+ex);
        }
     }
     
    public int count(String table)
    {
    int i = 0 ;
    
    return i;
    }
    
    public int count (String table, String condition)
    {
    int i = 0;
    
    return i;
    }
     
    public void close()
    {
        try
        {
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("sql error on close: "+ex);
        }
    }
     
    
    
    /*
    public ArrayList<T> returnArray(String sql)
    {
        retourne un arraylist de T elements 
        creation d'une requete select auto basé sur le nom des colones
    }
    
    /*
    public void connexion() {
        try{
            Connexion connect = new Connexion();
            stmt = connect.getStmt();
            con = connect.getCon();
            rqt = new Requete(con, stmt);
            //mise_a_jour();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    */
}