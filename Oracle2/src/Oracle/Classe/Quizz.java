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
    private String classement;
    private int fini;       
            
    
    private ArrayList quizzList;
    /**
     * 
     * @param connecteur
     * @param personne 
     */
    public Quizz(Connecteur connecteur, Personne personne)
    {
        this.connecteur = connecteur;
        this.personne = personne;
        quizzList = new ArrayList<Quizz>();
    }
    /**
     * 
     * @param connecteur
     * @param q
     * @param personne 
     */
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
    
     public Quizz(String nom, int duree, int niveau, int votre_score, int meilleur_score, String classement, int fini)
    {
        this.nom = nom;
        this.duree = duree;
        this.niveau = niveau;
        this.votre_score = votre_score;
        this.meilleur_score = meilleur_score;
        this.classement = classement;
        this.fini = fini;
    }
    
    public Quizz(Quizz q)
    {
        this.classement =q.classement;
        this.connecteur =q.connecteur;
        this.duree = q.duree;
        this.fini = q.fini;
        this.meilleur_score = q.meilleur_score;
        this.niveau = q.niveau;
        this.nom = q.nom;
        this.personne = q.personne;
        this.quizzList = q.quizzList;
        this.votre_score =q.votre_score;
    }
    
    public String getNom()
    {
        if(nom!=null)
        {
            return nom;
        }
        else
        {
            return null;
        }
        
        
    }
    public int getDuree()
    {
       return duree;
    }
    public int getNiveau()
    {
        return niveau;
    }
    public int getVotreScore()
    {
        return votre_score;
    }
    public int getMeilleurScore()
    {
        return meilleur_score;
    }
    public String getClassement()
    {
        return classement;
    }
    public int fini()
    {
        return fini;
    }
    
    public void setNom(String nom)
    {
       this.nom = nom;
    }
    public void setDuree(int duree)
    {
        this.duree = duree;
    }
    public void setNiveau(int niveau)
    {
        this.niveau = niveau;
    }
    
    
    
    
    private void initialize() throws SQLException
    {
        ResultSet r = connecteur.requete("SELECT * FROM QUIZZ");
        
        while(r.next())
        {
            ResultSet r_score = connecteur.requete("SELECT score FROM participe WHERE id_personne = "+personne.getId_personne());
            r_score.next();
            ResultSet r_maxScore = connecteur.requete("SELECT MAX(score) FROM participe WHERE id_quizz = "+r.getInt("ID_QUIZZ"));
            r_maxScore.next();
            ResultSet r_classement = connecteur.requete("SELECT * FROM participe WHERE id_quizz = "+r.getInt("ID_QUIZZ"));
            String classement = "";
            int classement_total = 0;
            int classement_personne=0 ;
       
            while(r_classement.next())
            {
                classement_total++;
            
                if(r_classement.getInt("ID_PERSONNE") <= personne.getId_personne())
                {
            
                }
                else
                {
                    classement_personne++;
                }
            }
            classement = classement_personne+"/"+classement_total;
            
            
            quizzList.add(new Quizz(r.getString("NOM"), r.getInt("DUREE_QUIZZ"), r.getInt("NIVEAU"), r_score.getInt("SCORE"), r_maxScore.getInt("SCORE"), classement, classement_total));
        }    
             
    }
}
