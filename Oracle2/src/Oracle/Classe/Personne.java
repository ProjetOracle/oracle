/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author WorkStation
 */
public class Personne {
    
    Connecteur connecteur= new Connecteur();
    
    int id_personne;
    String login;
    
   private static  ArrayList<Quizz> listeOfQuizz;

    public Personne() {
        this.listeOfQuizz = new ArrayList<Quizz>();
    }
    
   public Personne(int id_personne, String login)
   {
       this.listeOfQuizz = new ArrayList<Quizz>();
       this.id_personne = id_personne;
       this.login = login;
       
   }
   
   public Personne(int id_personne, String login, ArrayList listeOfQuizz)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
   }
   
   public Personne(Personne p)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
   }
   
   public void setConnecteur(Connecteur connecteur)
   {
       this.connecteur = connecteur;
   }
   public Connecteur getConnecteur()
   {
       return connecteur;
   }
   
   public boolean  seConnecter(String login, String pwd)
   {
       
       ResultSet r;
       r = connecteur.requete("SELECT COUNT(*) FROM personne where login LIKE '"+login+"' and pwd LIKE '"+pwd+"'");
       if(Integer.parseInt(r.toString())==1)
       {
           r = connecteur.requete("SELECT * FROM personne where login LIKE '"+login+"'");
           return true;
       }
       else
       {
           return false;
       }
   }
   
   
   
   public void seDeconnecter()
   {
       
        this.id_personne = -1;
        this.login = "";
   }
    
    
}
