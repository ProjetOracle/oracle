/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Perso_Jclasse.JPersoButton;
import Oracle.Perso_Jclasse.JTableClassement;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WorkStation
 */
public class Classement extends JFrame implements ActionListener{
    public Classement() {
        createWindow();
    }
    
    JLabel labelClassement = new JLabel("Classement");
    JPersoButton next;
    JPersoButton previous;
    JLabel labelNomQuizz = new JLabel("Nom du quizz");
    
    
    public void createWindow() {
        JPanel content = new JPanel();
        next = new JPersoButton("Suivant");
        previous = new JPersoButton("Precedent");
        JTableClassement classement = new JTableClassement();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);     

        GridBagConstraints gbc = new GridBagConstraints();
       
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.setLocationRelativeTo(null); 
        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(labelClassement, gbc);
  
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(labelNomQuizz, gbc);    
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(next, gbc);     
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(previous, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(classement.getTableau(), gbc);
        
        Oracle.listeFenetres.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
