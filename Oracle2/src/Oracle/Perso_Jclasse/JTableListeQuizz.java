/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Perso_Jclasse;

import Oracle.Classe.Connecteur;
import Oracle.Classe.Personne;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Daky
 */
public class JTableListeQuizz extends JTable {
    private Connecteur connecteur;
    private JTable tableau;
    
    public JTableListeQuizz(Connecteur connecteur) throws SQLException {
        this.connecteur = connecteur;
        tableau = new JTable(new TableModelListeQuizz(connecteur));
    }

    /**
     * @return the tableau
     */
    public JTable getTableau() {
        return tableau;
    }

    /**
     * @param tableau the tableau to set
     */
    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }
    
    public void initialize(Personne personne)
    {
        
    }
    
    
}

