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
public class TableModelListeQuizz extends AbstractTableModel {
    public Quizz quizzs;
    public String[] nomColonnes = {"Nom", "Durée", "Niveau", "Score", "Classement", "Fini"};
    public String[] classement = {"1", "2", "3"};
    public String[] fini = {"oui", "non", "oui"};
    
    public TableModelListeQuizz(Connecteur connecteur) throws SQLException {
        quizzs = new Quizz(connecteur);
        System.out.println(quizzs);    }
    
    @Override
    public int getRowCount() {
        return classement.length;
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
                return quizzs.getQuizzList().get(rowIndex).getNom();
            case 1:
                return quizzs.getQuizzList().get(rowIndex).getDuree();
            case 2:
                return quizzs.getQuizzList().get(rowIndex).getNiveau();
            case 3:
                return quizzs.getQuizzList().get(rowIndex).getVotreScore();            
            case 4:
                return classement[rowIndex];            
            case 5:
                return fini[rowIndex];            
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}