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
    
    private boolean admin          = false;
    private boolean doQuizz        = false;
    private boolean createQuizz    = false;
    private boolean deleteQuizz    = false;
    private boolean modifyQuizz    = false;
    private boolean createQuestion = false;
    private boolean deleteQuestion = false;
    private boolean modifyQuestion = false;
    
    /**
     * 
     * @param connecteur
     * 
     * constructeur avec connecteur seulement
     */
    public Fonction(Connecteur connecteur)
    {
        this.connecteur = connecteur;
    }
    
    /**
     * 
     * @param connecteur
     * @param p
     * 
     * constructeur de recopie de fonction
     */
    public Fonction(Connecteur connecteur, Personne p) throws SQLException
    {
        this.connecteur = connecteur;
        initialize(p.getId_personne());
    }
    
    /**
     * 
     * @param admin
     * @param doQuizz
     * @param createQuizz
     * @param deleteQuizz
     * @param modifyQuizz
     * @param createQuestion
     * @param deleteQuestion
     * @param modifyQuestion 
     * 
     * constructeur via les fonctions à rentrer.
     */
    public Fonction(boolean admin, boolean doQuizz, boolean createQuizz, boolean deleteQuizz, boolean modifyQuizz, boolean createQuestion, boolean deleteQuestion, boolean modifyQuestion)
    {
        this.admin          = admin;
        this.doQuizz        = doQuizz;
        this.createQuizz    = createQuizz;
        this.deleteQuestion = deleteQuestion;
        this.modifyQuizz    = modifyQuizz;
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
    
    /***
     * 
     * @param id_fonction Give the function to search
     * @throws SQLException
     * 
     * initialise la fonction à rechercher.
     */
    public void initialize(int id_fonction) throws SQLException
    {
        ResultSet r         =connecteur.requete("SElECT * FROM fonction WHERE id_fonction = "+id_fonction+" LIMIT 1");
        r.first();
        this.admin          = r.getBoolean("admin");
        this.createQuizz    = r.getBoolean("createQuizz");
        this.deleteQuizz    = r.getBoolean("deleteQuizz");
        this.modifyQuizz    = r.getBoolean("modifyQuizz");
        this.createQuestion = r.getBoolean("createQuestion");
        this.deleteQuestion = r.getBoolean("deleteQuestion");
        this.modifyQuestion = r.getBoolean("modifyQuestion");
        
    }
    
    
}
