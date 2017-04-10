/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author WorkStation
 */
public class Quizz {
    
    Connecteur connecteur; 
    Personne personne; 
    
    private String nom;
    private int duree;
    private int niveau;
    private int votre_score;
    private int meilleur_score;
    private int classement;
    private int fini;       
            
    
    private ArrayList quizzList;
    
    public Quizz(Connecteur connecteur, Personne personne)
    {
        this.connecteur = connecteur;
        this.personne = personne;
        quizzList = new ArrayList<Quizz>();
    }
    public Quizz(Connecteur connecteur, Quizz q, Personne personne)
    {
        this.connecteur = connecteur;
        this.quizzList = q.quizzList;
        this.classement = q.classement;
        this.duree = q.duree;
        this.fini = q.fini;
        this.meilleur_score = q.meilleur_score;
        this.niveau =q.niveau;
        this.nom = q.nom;
        this.votre_score = q.votre_score;
        
        this.personne = personne;
    }
    
    
    public Quizz(String nom, int duree, int niveau, int votre_score, int meilleur_score, int classement, int fini)
    {
        this.nom = nom;
        this.duree = duree;
        this.niveau = niveau;
        this.votre_score = votre_score;
        this.meilleur_score = meilleur_score;
        this.classement = classement;
        this.fini = fini;
    }
   
    
    private void initialize() throws SQLException
    {
        ResultSet r = connecteur.requete("SELECT * FROM QUIZZ");
        
        while(r.next())
        {
        
        }
        
        
            /*
        
        quizzList.add(new Quizz(r.getString()));
        
                r.getString("NOM")
                r.getInt("DUREE_QUIZZ")
                r.getInt("NIVEAU")
        
        ResultSet r_score = connecteur.requete("SELECT score FROM participe WHERE id_personne = "+personne.id_personne);
        r_score.next();
        ResultSet r_maxScore = connecteur.requete("SELECT MAX(score) FROM participe WHERE id_quizz = "+r.getInt("ID_QUIZZ"));
        r_maxScore.next();
        
                        
            */    
                
                
    }
}
