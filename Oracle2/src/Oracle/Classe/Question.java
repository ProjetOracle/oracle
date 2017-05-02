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
public class Question implements SQL_Interface{
    
    Connecteur connecteur;
    
    private int     id_question;
    private String  intitule;
    private String  imagePath;
    
    
    private ArrayList<Question>questions = new ArrayList<Question>();
    private ArrayList<Reponse> reponses = new ArrayList<Reponse>();
    
    public Question(Connecteur connecteur)
    {
        this.connecteur = connecteur;
        this.id_question = -1;
    }
    
    public Question(int id_question, String intitule, String imagePath, ArrayList<Reponse> reponses)
    {
        this.id_question  = id_question;
        this.intitule     = intitule;
        this.imagePath    = imagePath;
        this.reponses     = reponses;
        
    }
    
    public Question(Question q)
    {
        this.id_question  = q.id_question;
        this.connecteur   = q.connecteur;
        this.imagePath    = q.imagePath;
        this.intitule     = q.intitule;
        this.reponses     = q.reponses;
        
    }
    
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }
    public ArrayList<Reponse> getReponses()
    {
        return reponses;
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
    public ArrayList getReponse()
    {
        return reponses;
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
       
    }
    
     @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize() throws SQLException {
        ResultSet r = connecteur.requete("Select * From Question");
        
        while (r.next())
        {
                ResultSet r2 = connecteur.requete("SELECT reponse.id_reponse, reponse.intitule, reponse.image, Question_reponse.est_juste from Question_reponse join Question on Question_reponse.id_question = Question.id_question where id_question = "+r.getInt("id_question"));
                ArrayList<Reponse>rep = new ArrayList<Reponse>();    
                while(r2.next())
                {
                    rep.add(new Reponse(r2.getInt("id_question"),r2.getString("intitule"), r2.getString("image"),r2.getBoolean("est_juste"), connecteur));
                }
                
                
                questions.add(new Question(r.getInt("id_question"), r.getString("intitule"), r.getString("image"), rep));
        }
    }

    @Override
    public Question initialize(int id) throws SQLException {
        
        for(Question q : questions)
        {
            if(q.getIdQuestion() == id)
            {
                return(q);
            }
        }
        
        ResultSet r = connecteur.requete("Select * from Question where id_question "+id);
        r.next();
        
        this.id_question = id;
        this.imagePath = r.getString("image");
        this.intitule = r.getString("intitule");
        
        ResultSet r2 = connecteur.requete("Select * from question_reponse join reponse on question_reponse.id_reponse = reponse.id_reponse where id_question = "+r.getInt("id_question"));
        while(r.next())
        {
          this.reponses.add(new Reponse(r2.getInt("id_reponse"),r2.getString("intitule"),r2.getString("image"),r.getBoolean("est_juste"),connecteur));
        }
        
        questions.add(this);
        return(this);
    }

   
}
