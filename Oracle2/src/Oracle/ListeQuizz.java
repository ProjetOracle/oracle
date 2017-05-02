/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Classe.Personne;
import Oracle.Perso_Jclasse.JPersoButton;
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
public class ListeQuizz extends JFrame implements ActionListener {
    
    public ListeQuizz() {
        createWindow();
    }
    
    public void createWindow() {
        JPanel content = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
    
        Oracle.listeFenetres.add(this);
    }
    
    public void affichage(Personne personne) {
        JLabel pseudo = new JLabel(personne.getLogin());
        JPersoButton admin = new JPersoButton("administration");
        admin.setText("Administration");
        admin.addActionListener(this);
        
        JPersoButton classemnt = new JPersoButton("classement");
        classemnt.setText("Classement");
        classemnt.addActionListener(this);
                
        
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
        this.add(pseudo,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(admin,gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(classemnt, gbc);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JPersoButton source = (JPersoButton)e.getSource();       
        if(source.getName() == "administration") {
            for (int i = 0; i<Oracle.listeFenetres.size(); i++) {
                if (Oracle.listeFenetres.get(i).getClass().toString().equals("class Oracle.Administration")) {
                    Administration tmp = (Administration)Oracle.listeFenetres.get(i);
                    tmp.setVisible(true);
                }
                else {
                    JFrame tmp = (JFrame)Oracle.listeFenetres.get(i);
                    tmp.setVisible(false);
                }
            }
        }
        if(source.getName() == "classement") {
            for (int i = 0; i<Oracle.listeFenetres.size(); i++) {
                if (Oracle.listeFenetres.get(i).getClass().toString().equals("class Oracle.Classement")) {
                    Classement tmp = (Classement)Oracle.listeFenetres.get(i);
                    tmp.setVisible(true);
                }
                else {
                    JFrame tmp = (JFrame)Oracle.listeFenetres.get(i);
                    tmp.setVisible(false);
                }
            }
        }   
    }
}
