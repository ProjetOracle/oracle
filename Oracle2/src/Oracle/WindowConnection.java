/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Classe.Personne;
import Oracle.Perso_Jclasse.JPersoButton;
import Oracle.Perso_Jclasse.JPersoTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WorkStation
 */

public class WindowConnection extends JFrame implements ActionListener{
    
    Personne personne;
    JPersoTextField login;
    JPersoTextField mdp;
    Label erreur;
    JPersoButton buttonConnection;
    
    public WindowConnection()
    {
        Personne p = new Personne();
        createWindows();
    }
    public WindowConnection(Personne personne)
    {
        this.personne = personne;
        createWindows();
    }
    
    private void createWindows()
    {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(400, 600);
        JPanel content = new JPanel();
       // content.setPreferredSize(this.getSize());
        
        GridBagLayout layout = new GridBagLayout();
        
        
        this.setLayout(layout);
        buttonConnection = new JPersoButton("Connection");
        buttonConnection.addActionListener(this);
        login = new JPersoTextField("login");
        mdp = new JPersoTextField("Password");
        JLabel labelLogin = new JLabel("labelLogin");
        JLabel labelMdp = new JLabel("labelMdp");
        
        labelLogin.setText("Login : ");
        labelMdp.setText("Mot de passe : ");
        erreur = new Label("");
        
        GridBagConstraints gbc = new GridBagConstraints();
       
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.setLocationRelativeTo(null);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(labelLogin,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(login,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(labelMdp,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(mdp,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(buttonConnection,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        this.add(erreur, gbc);
        
        this.setVisible(true);
        
            
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == buttonConnection )
        {
            System.out.println("connection en cour...");
            if(login.getText().length()!=0 || mdp.getText().length()!=0)
            {
                personne.seConnecter(login.getText(),mdp.getText());
            }
            else
            {
                erreur.setText("Veuillez entrer un mot de passe et/ou un login");
                
            }
            
            
            
            
        }
    }
    
}
