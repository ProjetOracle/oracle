/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

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
    private boolean goodresponse;
    
    
    private ArrayList reponses = new ArrayList<Reponse>();
    
    public Question(Connecteur connecteur)
    {
    
    }
    
    public Question(int id_question, String intitule, String imagePath, ArrayList<Reponse> reponses)
    {
        this.id_question  = id_question;
        this.intitule     = intitule;
        this.imagePath    = imagePath;
        this.reponses     = reponses;
        this.goodresponse = false;
    }
    
    public Question(Question q)
    {
        this.id_question  = q.id_question;
        this.connecteur   = q.connecteur;
        this.imagePath    = q.imagePath;
        this.intitule     = q.intitule;
        this.reponses     = q.reponses;
        this.goodresponse = q.goodresponse;
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
    
    public void setGoodResponse(boolean goodresponse)
    {
        this.goodresponse = goodresponse;
    }
    public boolean getGoodResponse()
    {
        return goodresponse;
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

    @Override
    public void initialize() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object initialize(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
