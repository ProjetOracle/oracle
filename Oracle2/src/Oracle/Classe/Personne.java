/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.util.*;

/**
 *
 * @author WorkStation
 */
public class Personne {
    int id_personne;
    String login;
   private static  ArrayList<Quizz> listeOfQuizz;

    public Personne() {
        this.listeOfQuizz = new ArrayList<Quizz>();
    }
    
   public Personne(int id_personne, String login)
   {
       this.listeOfQuizz = new ArrayList<Quizz>();
       
   }
   
   public Personne(int id_personne, String login, ArrayList listeOfQuizz)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
   }
   
   public Personne(Personne p)
   {
        this.listeOfQuizz = new ArrayList<Quizz>();
   }
   
   public void seConnecter(String login, String pwd)
   {
   
   }
   
   public void seDeconnecter()
   {
   
   }
    
    
}
