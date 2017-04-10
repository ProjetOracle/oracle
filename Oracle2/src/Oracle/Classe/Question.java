/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.util.ArrayList;

/**
 *
 * @author WorkStation
 */
public class Question {
    
    Connecteur connecteur;
    
    private int    id_question;
    private String intitule;
    private String imagePath;
    
    private ArrayList reponses = new ArrayList<Reponse>();
    
    public Question(Connecteur connecteur)
    {
    
    }
    
    public Question(int id_question, String intitule, String imagePath, ArrayList<Reponse> reponses)
    {
    
    }
    
    public Question(Question q)
    {
        this.id_question = q.id_question;
        this.connecteur  = q.connecteur;
        this.imagePath   = q.imagePath;
        this.intitule    = q.intitule;
        this.reponses    = q.reponses;
    }
    
    public int getIdQuestion()
    {
        return id_question;
    }
    
    public String getIntitule()
    {
        return intitule;
    }
    public String getImagePath()
    {
        return imagePath;
    }
    
}
