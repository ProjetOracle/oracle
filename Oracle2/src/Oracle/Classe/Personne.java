/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author WorkStation
 */
public class Personne implements SQL_Interface{
    
    Connecteur       connecteur= new Connecteur();
    private int      id_personne;
    private String   login;
    private Fonction fonction;
    private static   ArrayList<Quizz> listeOfQuizz;

   
   
    /**
     * 
     */
    public Personne() {
        this.listeOfQuizz = new ArrayList<Quizz>();
        fonction          = new Fonction(connecteur);
    }
    
    /**
     * 
     * @param id_personne
     * @param login 
     */
   public Personne(int id_personne, String login)
   {
       this.listeOfQuizz = new ArrayList<Quizz>();
       this.id_personne  = id_personne;
       this.login        = login;
       fonction          = new Fonction(connecteur);
       
   }
   
   /**
    * 
    * @param id_personne
    * @param login
    * @param listeOfQuizz 
    */
   public Personne(int id_personne, String login, ArrayList listeOfQuizz)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
        fonction          = new Fonction(connecteur);
   }
   
   /**
    * 
    * @param p 
    */
   public Personne(Personne p)
   {
        this.connecteur  = p.connecteur;
        this.fonction    = p.fonction;
        this.id_personne = p.id_personne;
        this.login       = p.login;
   }
   
   public void setConnecteur(Connecteur connecteur)
   {
       this.connecteur = connecteur;
   }
   public Connecteur getConnecteur()
   {
       return connecteur;
   }
   
   public Fonction getFonction()
   {
       return fonction;
   }
   public int getId()
   {
       return getId_personne();
   }
   
   public boolean  seConnecter(String login, String pwd) throws SQLException
   {
       try{
            ResultSet r = connecteur.requete("SELECT * FROM personne where PSEUDO LIKE '"+login+"' AND MDP LIKE '"+pwd+"'");
            if(!r.next())
            {
                return false;
            }
            else
            {
                System.out.println("Recuperation des informations");
                this.setLogin(r.getString("PSEUDO"));
                this.setId_personne(r.getInt("ID_PERSONNE"));
                //fonction.initialize(r.getInt("ID_FONCTION"));
                return true;
            }
       
      
       }
       catch(NumberFormatException e)
       {
           System.out.println("erreur : "+e);
       }

       return false;
   }
   
   
   
   public void seDeconnecter()
   {
       
       this.setId_personne(-1);
       this.setLogin("");
   }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the id_personne
     */
    public int getId_personne() {
        return id_personne;
    }

    /**
     * @param id_personne the id_personne to set
     */
    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
