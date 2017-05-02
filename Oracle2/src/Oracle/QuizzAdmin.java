/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Perso_Jclasse.JPersoButton;
import Oracle.Perso_Jclasse.JPersoTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author WorkStation
 */
public class QuizzAdmin  extends JFrame implements ActionListener {
    public QuizzAdmin() {
        createWindow();
    }
    
    JPersoTextField nom;
    JPersoTextField duree;
    JPersoButton addQuestion;
    JPersoButton importQuizz;
    String[] niveaux = {"1","2","3","4","5"};
    JComboBox listeNiveaux;
    
    public void createWindow() {
        JPanel content = new JPanel();
        nom = new JPersoTextField("nomQuizz");
        duree = new JPersoTextField("dureeQuizz");
        addQuestion = new JPersoButton("Ajouter une question");
        importQuizz = new JPersoButton("Importer une question");
        listeNiveaux = new JComboBox(niveaux);
        
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
        this.add(nom,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(duree,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(listeNiveaux,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(addQuestion,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(importQuizz,gbc);
    
        Oracle.listeFenetres.add(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
