/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Classe.Connecteur;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author WorkStation
 */
public class Oracle {

    static public ArrayList<JFrame> listeFenetres;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connecteur connecteur = new Connecteur();
        listeFenetres = new ArrayList();
        WindowConnection w = new WindowConnection(connecteur);
        Administration admin = new Administration();
        ListeQuizz quizzs = new ListeQuizz(connecteur);
        QuizzAdmin creerQuizz = new QuizzAdmin();
        Classement classement = new Classement();
    
    }
}