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
class Fonction implements SQL_Interface{
    
    Connecteur connecteur;
    
    static ArrayList<Fonction> fonctions;
    
    private int     id;
    private String nom_fonction    = "";
    private boolean admin          = false;
    private boolean doQuizz        = false;
    private boolean createQuizz    = false;
    private boolean deleteQuizz    = false;
    private boolean modifyQuizz    = false;
    private boolean createQuestion = false;
    private boolean deleteQuestion = false;
    private boolean modifyQuestion = false;
    
    /**
     * utilisé pour avoir une liste de fonctions.
     */
    public Fonction() throws SQLException
    {
        fonctions = new ArrayList();
        id = -1;
        initialize();
    }
    
    /**
     * 
     * @param connecteur
     * 
     * constructeur avec connecteur seulement
     */
    public Fonction(Connecteur connecteur) throws SQLException
    {
        fonctions = new ArrayList();
        id = -1;
        this.connecteur = connecteur;
        initialize();
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
        
        initialize(p);
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
    public Fonction(int id_fonction, String nom_fonction, boolean admin, boolean doQuizz, boolean createQuizz, boolean deleteQuizz, boolean modifyQuizz, boolean createQuestion, boolean deleteQuestion, boolean modifyQuestion)
    {
        this.id             = id_fonction;
        this.nom_fonction   = nom_fonction;
        this.admin          = admin;
        this.doQuizz        = doQuizz;
        this.createQuizz    = createQuizz;
        this.deleteQuestion = deleteQuestion;
        this.modifyQuizz    = modifyQuizz;
        this.createQuestion = createQuestion;
        this.deleteQuestion = deleteQuestion;
        this.modifyQuestion = modifyQuestion;
    }
    
    public int getIdFonction()
    {
        return id;
    }
    public String getNomFonction()
    {
        return nom_fonction;
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
    
    public void setNomFonction(String nom)
    {
        nom = nom.toLowerCase();
        char c[] = nom.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        nom = c.toString();
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
    

    @Override
    public void update() throws SQLException {
        String sql ="";
        for(int i = 0; i<fonctions.size(); i++)
        {
            sql = "UPDATE fonctions SET(Fonction, CreateQuizz, DeleteQuizz, ModifyQuizz, CreateQuestion, DeleteQuestion, ModifyQuestion, Admin) Values (";
            sql+= "Fonction = '"     +fonctions.get(i).nom_fonction+"',";
            sql+= "CreateQuizz = "   +fonctions.get(i).createQuizz+",";
            sql+= "DeleteQuizz = "   +fonctions.get(i).deleteQuizz+",";
            sql+= "ModifyQuizz = "   +fonctions.get(i).modifyQuizz+",";
            sql+= "CreateQuestion = "+fonctions.get(i).createQuestion+",";
            sql+= "DeleteQuestion = "+fonctions.get(i).deleteQuestion+",";
            sql+= "ModifyQuestion = "+fonctions.get(i).modifyQuestion+",";
            sql+= "Admin = "         +fonctions.get(i).admin;
            sql +="Where id_fonction = "+fonctions.get(i).id;
            System.out.println(sql);
            connecteur.requete(sql, i);
        }    
        
    }
    public void update(int id_fonction) throws SQLException
    {
            String sql ="";
            sql = "UPDATE fonctions SET(Fonction, CreateQuizz, DeleteQuizz, ModifyQuizz, CreateQuestion, DeleteQuestion, ModifyQuestion, Admin) Values (";
            sql+= "Fonction = '"     +this.nom_fonction+"',";
            sql+= "CreateQuizz = "   +this.createQuizz+",";
            sql+= "DeleteQuizz = "   +this.deleteQuizz+",";
            sql+= "ModifyQuizz = "   +this.modifyQuizz+",";
            sql+= "CreateQuestion = "+this.createQuestion+",";
            sql+= "DeleteQuestion = "+this.deleteQuestion+",";
            sql+= "ModifyQuestion = "+this.modifyQuestion+",";
            sql+= "Admin = "         +this.admin;
            sql +="Where id_fonction = "+this.id;
            System.out.println(sql);
            connecteur.requete(sql, 1);
    }
            
    @Override
    public void insert() {
        String sql = "";
        sql+="'"+this.nom_fonction+"',";
        sql+=this.admin+",";
        sql+=this.doQuizz+",";
        sql+=this.createQuizz+",";
        sql+=this.deleteQuizz+",";
        sql+=this.modifyQuizz+",";
        sql+=this.createQuestion+",";
        sql+=this.deleteQuestion+",";
        sql+=this.modifyQuestion;
        
         sql ="ISERT INTO fonction (fonction, admin, doQuizz, createQuizz, deleteQuizz, modifyQuizz, createQuestion, deleteQuestion, modifyQuestion) VALUES ("+sql+")";
        
         System.out.println(sql);
         connecteur.requete(sql, 1);
    }

    @Override
    public void delete() throws SQLException {
        if(this.id<0)
        {
            System.out.println("Ne peut pas être supprimé");
        }
        else
        {
            delete(this.id);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from fonction where id_fonction = "+id;
        connecteur.requete(sql, 1);
        
        for(Fonction f : fonctions)
        {
            if(f.id == id)
            {
                fonctions.remove(f);
            }
        }
        
    }
    
    
    
    
    
    
    @Override
    public void initialize() throws SQLException {
        ResultSet r = connecteur.requete("Select * From Fonction");
       if(fonctions == null) 
       {
           System.out.println("fonctions n'est pas set, tentative de mise à jour via un id");
           if(this.id <0) 
           {
               System.out.println("fonction n'est pas set - tentative de mise a jour echouee car aucun id valide trouve");
           } 
           else 
           {
               System.out.println("fonction n'est pas set - un id a été trouvé, la fonction update (int id_fonction) est appelée");
               fonctions.add(initialize(id));
           }
       } 
       else 
       {
           while(r.next())
           {
               System.out.println("ajoute de la fonction : id = "+r.getInt("id_fonction")+" - "+r.getString("Fonction")+"");
               fonctions.add(new Fonction(r.getInt("id_fonction"),r.getString("Fonction"), r.getBoolean("admin"), r.getBoolean("doQuizz"),r.getBoolean("createQuizz"), r.getBoolean("deleteQuizz"), r.getBoolean("modifyQuizz"), r.getBoolean("createQuestion"), r.getBoolean("deleteQuestion"), r.getBoolean("modifyQuestion")));
           }
       }
       
       
    }
    
    
    @Override
    public Fonction initialize(int id) throws SQLException{
           
        ResultSet r         =connecteur.requete("SElECT * FROM fonction WHERE id_fonction = "+id+" LIMIT 1");
        r.first();
        this.id             = r.getInt("id_fonction");
        this.admin          = r.getBoolean("admin");
        this.createQuizz    = r.getBoolean("createQuizz");
        this.deleteQuizz    = r.getBoolean("deleteQuizz");
        this.modifyQuizz    = r.getBoolean("modifyQuizz");
        this.createQuestion = r.getBoolean("createQuestion");
        this.deleteQuestion = r.getBoolean("deleteQuestion");
        this.modifyQuestion = r.getBoolean("modifyQuestion");
        return(this);
       }
    
    public Fonction initialize(Personne p) throws SQLException{
        ResultSet r         = connecteur.requete("SELECT id_fonction, admin, createQuizz, deleteQuizz, modifyQuizz, createQuestion, deleteQuestion, modifyQuestion from Personne join Fonction on personne.id_fonction = fonction.id_fonction where id_personne = "+p.getId());
        r.next();
        if(r.wasNull())
        {
            this.id             = r.getInt("id_fonction");
            this.admin          = r.getBoolean("admin");
            this.createQuizz    = r.getBoolean("createQuizz");
            this.deleteQuizz    = r.getBoolean("deleteQuizz");
            this.modifyQuizz    = r.getBoolean("modifyQuizz");
            this.createQuestion = r.getBoolean("createQuestion");
            this.deleteQuestion = r.getBoolean("deleteQuestion");
            this.modifyQuestion = r.getBoolean("modifyQuestion");
        
        }
        else
        {
            if(p.getFonction().id>=0)
            {
                p.setFonction(id-1);
                initialize(p);
            }
            else
            {
                System.out.println("ERREUR : ne peut pas initialiser une fonction. la fonction la plus basse sera prise");
                
            }
        }
        
        return(this);
    }

    
    
}
