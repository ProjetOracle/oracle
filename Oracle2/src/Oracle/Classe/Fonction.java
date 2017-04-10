/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author WorkStation
 */
class Fonction {
    
    Connecteur connecteur;
    
    private boolean admin = false;
    
    private boolean doQuizz = false;
    
    private boolean createQuizz = false;
    private boolean deleteQuizz = false;
    private boolean modifyQuizz = false;
    
    private boolean createQuestion = false;
    private boolean deleteQuestion = false;
    private boolean modifyQuestion = false;
    
    public Fonction(Connecteur connecteur)
    {
        this.connecteur = connecteur;
    }
    
    public Fonction(Connecteur connecteur, Personne p)
    {
        this.connecteur = connecteur;
    }
    
    public Fonction(boolean admin, boolean doQuizz, boolean createQuizz, boolean deleteQuizz, boolean modifyQuizz, boolean createQuestion, boolean deleteQuestion, boolean modifyQuestion)
    {
        this.admin = admin;
        this.doQuizz = doQuizz;
        this.createQuizz = createQuizz;
        this.deleteQuestion = deleteQuestion;
        this.modifyQuizz = modifyQuizz;
        this.createQuestion = createQuestion;
        this.deleteQuestion = deleteQuestion;
        this.modifyQuestion = modifyQuestion;
    }
    
    public boolean getAdmin()
    {
        return admin;
    }
    public boolean getDoQuizz()
    {
        return doQuizz;
    }
    public boolean getCreateQuizz()
    {
        return createQuizz;
    }
    public boolean getDeleteQuizz()
    {
        return deleteQuizz;
    }
    public boolean getDeleteQuestion()
    {
        return deleteQuestion;
    }
    public boolean getModifyQuestion()
    {
        return modifyQuestion;
    }
    
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }
    public void setDoQuizz(boolean doQuizz)
    {
        this.doQuizz = doQuizz;
    }
    public void setCreateQuizz(boolean createQuizz)
    {
        this.createQuizz = createQuizz;
    }
    public void setDeleteQuizz(boolean deleteQuizz)
    {
        this.deleteQuizz = deleteQuizz;
    }
    public void setDeleteQuestion(boolean deleteQuestion)
    {
        this.deleteQuestion = deleteQuestion;
    }
    public void setModifyQuestion(boolean modifyQuestion)
    {
        this.modifyQuestion = modifyQuestion;
    }
     public void setCreateQuestion(boolean createQuestion)
    {
        this.createQuestion = createQuestion;
    }
    
    
    public void initialize(int id_fonction) throws SQLException
    {
        ResultSet r =connecteur.requete("SElECT * FROM fonction WHERE id_fonction = "+id_fonction+" LIMIT 1");
        r.first();
        this.admin = r.getBoolean("admin");
        
        this.createQuizz = r.getBoolean("createQuizz");
        this.deleteQuizz = r.getBoolean("deleteQuizz");
        this.modifyQuizz = r.getBoolean("modifyQuizz");
        
        this.createQuestion = r.getBoolean("createQuestion");
        this.deleteQuestion = r.getBoolean("deleteQuestion");
        this.modifyQuestion = r.getBoolean("modifyQuestion");
        
    }
    
    
}
