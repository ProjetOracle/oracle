/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author WorkStation
 */
public class Personne implements SQL_Interface{
    
    private static ArrayList<Personne> personnes;
    
    Connecteur       connecteur;
    private int      id_personne;
    private String   login;
    private Fonction fonction;
    private static   ArrayList<Quizz> listeOfQuizz;

   
   
    /**
     * 
     */
    public Personne(Connecteur connecteur) {
        this.connecteur = connecteur;
        personnes       = new ArrayList();
        id_personne     = -1;
    }
    
    /**
     * 
     * @param id_personne
     * @param login 
     */
   public Personne(Connecteur connecteur, int id_personne, String login) throws SQLException
   {
       this.connecteur   = connecteur;
       this.listeOfQuizz = new ArrayList<Quizz>();
       this.id_personne  = id_personne;
       this.login        = login;
       fonction          = new Fonction(connecteur, this);
       
   }
   
   /**
    * 
    * @param id_personne
    * @param login
    * @param listeOfQuizz 
    */
   public Personne( Connecteur connecteur, int id_personne, String login, ArrayList listeOfQuizz) throws SQLException
   {    
       this.connecteur   = connecteur;
       this.id_personne  = id_personne;
       this.listeOfQuizz = new ArrayList<Quizz>();
       fonction          = new Fonction(connecteur, this);
   }
   
   /**
    * 
    * @param p 
    */
   public Personne(Personne p)
   {
        this.connecteur  = p.connecteur;
        this.fonction    = p.fonction;
        this.id_personne = p.id_personne;
        this.login       = p.login;
   }
   
   public void setConnecteur(Connecteur connecteur)
   {
       this.connecteur = connecteur;
   }
   public Connecteur getConnecteur()
   {
       return connecteur;
   }
   
   public Fonction getFonction()
   {
       return fonction;
   }
   public int getId()
   {
       return getId_personne();
   }
   
   public boolean  seConnecter(String login, String pwd) throws SQLException
   {
       try{
            ResultSet r = connecteur.requete("SELECT * FROM personne where PSEUDO LIKE '"+login+"' AND MDP LIKE '"+pwd+"'");
            if(!r.next())
            {
                return false;
            }
            else
            {
                System.out.println("Recuperation des informations");
                this.setLogin(r.getString("PSEUDO"));
                this.setId_personne(r.getInt("ID_PERSONNE"));
                //fonction.initialize(r.getInt("ID_FONCTION"));
                initialize();
                return true;
            }
       
      
       }
       catch(NumberFormatException e)
       {
           System.out.println("erreur : "+e);
       }

       return false;
   }
   
   
   
   public void seDeconnecter()
   {
       
       this.setId_personne(-1);
       this.setLogin("");
   }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the id_personne
     */
    public int getId_personne() {
        return id_personne;
    }
     /**
     * @return the personnes
     */
    public static ArrayList<Personne> getPersonnes() {
        return personnes;
    }
    
    /**
     * @param id_personne the id_personne to set
     */
    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
    
    public void setFonction(int id) throws SQLException
    {
        fonction = fonction.initialize(id);
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
    public void delete() throws SQLException {
        if(this.id_personne<0)
        {
            System.out.println("Ne peut pas être supprimée");
        }
        else
        {
            delete(this.id_personne);
        }

    }
    
    @Override
    public void delete(int id) throws SQLException {
        
        for(Personne p : personnes)
        {
            if(p.getId()==id)
            {
                personnes.remove(p);
            }
        }
    }
    @Override
    public Personne initialize(int id) throws SQLException {
        fonction = fonction.initialize(id);
        
        return(this);
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    
    @Override
    public void initialize() throws SQLException {
        String sql = "";
        ResultSet r = connecteur.requete("SELECT * FROM personne");
        if (getPersonnes() ==null)
        {
             System.out.println("personnes n'est pas set, tentative de mise à jour via un id");
            if(this.id_personne<0)
            {
                System.out.println("personnes n'est pas set - tentative de mise a jour echouee car aucun id valide trouve");
            }
            else
            {
               System.out.println("Personnes n'est pas set - un id a été trouvé, la fonction update (int id_fonction) est appelée");
                getPersonnes().add(initialize(id_personne));
            }
        }
        else
        {
            while(r.next())
           {
               System.out.println("ajoute de la personne: id = "+r.getInt("id_personne")+" - "+r.getString("pseudo")+"");
                getPersonnes().add(new Personne(r.getInt("id_personne"), r.getString("pseudo")));
           }
        }
    }

   

    
    
}
