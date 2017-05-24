/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Perso_Jclasse;

import Oracle.Classe.Connecteur;
import Oracle.Classe.Personne;
import Oracle.Classe.Quizz;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daky
 */
public class TableModelClassement extends AbstractTableModel {
    private Connecteur connecteur;
    
    public Quizz[] quizzs;
    public Personne joueurs;
    public String[] nomColonnes = {"Pseudo", "Score"};
    
    public TableModelClassement(Connecteur connecteur) {
        this.connecteur = connecteur;
        quizzs = new Quizz[]{
            new Quizz ("NomQuizz", 15, 3, 12, 16, "test", 1),
            new Quizz ("NomQuizz2", 17, 4, 13, 17, "test2", 0),
            new Quizz ("NomQuizz", 15, 3, 12, 16, "test", 1),
            new Quizz ("NomQuizz2", 17, 4, 13, 17, "test2", 0),               
        
        };
    
        joueurs = new Personne(connecteur);
    }
    
    @Override
    public int getRowCount() {
        return quizzs.length;
    }
 
    @Override
    public int getColumnCount() {
        return nomColonnes.length;
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return nomColonnes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return joueurs.getPersonnes().get(rowIndex).getLogin();
            case 1:
                return quizzs[rowIndex].getMeilleurScore();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}
