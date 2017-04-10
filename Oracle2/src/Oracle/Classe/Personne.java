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
public class Personne {
    
    Connecteur connecteur= new Connecteur();
    
    int id_personne;
    String login;
    Fonction fonction;
    
    
   private static  ArrayList<Quizz> listeOfQuizz;

    public Personne() {
        this.listeOfQuizz = new ArrayList<Quizz>();
        fonction = new Fonction(connecteur);
    }
    
   public Personne(int id_personne, String login)
   {
       this.listeOfQuizz = new ArrayList<Quizz>();
       this.id_personne = id_personne;
       this.login = login;
       fonction = new Fonction(connecteur);
       
   }
   
   public Personne(int id_personne, String login, ArrayList listeOfQuizz)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
        fonction = new Fonction(connecteur);
   }
   
   public Personne(Personne p)
   {
        this.connecteur = p.connecteur;
        this.fonction = p.fonction;
        this.id_personne = p.id_personne;
        this.login = p.login;
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
           this.login = r.getString("PSEUDO");
           this.id_personne = r.getInt("ID_PERSONNE");
           System.out.println(id_personne);
           //fonction.initialize(r.getInt("ID_FONCTION"));
           return true;
       }
       
       /*
       //System.out.println(r.toString());
       if(Integer.parseInt(r.toString())==1)
       {
           r = connecteur.requete("SELECT * FROM personne WHERE LIKE '"+login+"' LIMIT 1");
           r.first();
           this.login = r.getString("PSEUDO");
           
           this.id_personne = r.getInt("ID_PERSONNE");
           
           
           return true;
       }
       else
       {
           return false;
       }*/
       }
       catch(NumberFormatException e)
       {
           System.out.println("erreur : "+e);
       }

       return false;
   }
   
   
   
   public void seDeconnecter()
   {
       
        this.id_personne = -1;
        this.login = "";
   }
    
    
}
