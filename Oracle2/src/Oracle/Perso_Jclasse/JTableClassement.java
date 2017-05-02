/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Perso_Jclasse;

import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Daky
 */
public class JTableClassement extends JTable {
    private JTable tableau;
    
    public JTableClassement() {
        tableau = new JTable(new TableModelClassement());
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
    
    
}
