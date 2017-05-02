/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.SQLException;

/**
 *
 * @author WorkStation
 */
public class Reponse implements SQL_Interface{
    int        id;
    String     intitule;
    String     imagePath;
    boolean    isGood;
    Connecteur connecteur;
    
    public Reponse(int id, String intitule, String imagePath, boolean isGood, Connecteur connecteur)
    {
        this.id        = id;
        this.intitule  = intitule;
        this.imagePath = imagePath;
        this.isGood    = isGood;
    }
    
    
    public void setIntitule(String intitule)
    {
        this.intitule = intitule;
    }
    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }
    public void setIsGood(boolean isGood)
    {
        this.isGood = isGood;
    }
    public String getIntitule()
    {
        return intitule;
    }
    public String getImagePath()
    {
        return imagePath;
    }
    public boolean getIsGood()
    {
        return isGood;
    }
    public int getID()
    {
        return id;
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
