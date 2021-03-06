/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Classe.Connecteur;
import Oracle.Classe.Personne;
import Oracle.Perso_Jclasse.JPersoButton;
import Oracle.Perso_Jclasse.JPersoTextField;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
/**
 *
 * @author WorkStation
 */

public class WindowConnection extends JFrame implements ActionListener, ComponentListener {
    
    Connecteur connecteur; 
    
    private Personne personne;
    
    
    JPersoTextField login;
    JPersoTextField mdp;
    //Label erreur;
    JTextArea erreur;
    JPersoButton buttonConnection;
    
    public WindowConnection(Connecteur connecteur)
    {
        this.connecteur = connecteur;
        personne = new Personne(connecteur);
        createWindows();
    }
    public WindowConnection(Personne personne)
    {
        this.connecteur = personne.getConnecteur();
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
        JLabel labelLogin = new JLabel("labelLogin", SwingConstants.CENTER);
        JLabel labelMdp = new JLabel("labelMdp", SwingConstants.CENTER);
                
        labelLogin.setText("Login");
        labelMdp.setText("Mot de passe");
        //erreur = new Label("");
        erreur = new JTextArea();
        erreur.setEditable(false);
        erreur.setBackground(this.getBackground());
         
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
        gbc.insets = new Insets(0,0,10,0);
        this.add(login,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0,0,0,0);
        this.add(labelMdp,gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(0,0,20,0);              
        this.add(mdp,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(0,0,0,0);
        this.add(buttonConnection,gbc);

        gbc.gridx = 1;
        gbc.gridheight=4;
        gbc.gridy = 6;   
        this.add(erreur, gbc);
        
        this.setVisible(true);
    
        Oracle.listeFenetres.add(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == buttonConnection )
        {
            this.erreur.setText("");
            this.login.setBackground(Color.white);
            this.mdp.setBackground(Color.white);
            System.out.println("connection en cour...");
            if(login.getText().length()!=0 || mdp.getText().length()!=0)
            {
                try {
                    if(getPersonne().seConnecter(login.getText(),mdp.getText()))
                    {
                        System.out.println("connection etablie");
                        for (int i = 0; i<Oracle.listeFenetres.size(); i++) {
                            if (Oracle.listeFenetres.get(i).getClass().toString().equals("class Oracle.ListeQuizz")) {
                                ListeQuizz tmp = (ListeQuizz)Oracle.listeFenetres.get(i);
                                tmp.affichage(getPersonne());
                                tmp.setVisible(true);
                            }
                            else {
                                JFrame tmp = (JFrame)Oracle.listeFenetres.get(i);
                                tmp.setVisible(false);
                            }
                        }
                        
                    }
                    else
                    {
                        this.erreur.setText("erreur de connection, verifiez votre login et mot de passe");
                        this.login.setBackground(Color.red);
                        this.mdp.setBackground(Color.red);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(WindowConnection.class.getName()).log(Level.SEVERE, null, ex);   
                }   
            }
            else
            {
             
                if(login.getText().length()==0)
                {
                    this.erreur.setText(this.erreur.getText()+" Veuillez rentrer un Login \n");
                    this.login.setBackground(Color.red);
                }
                if(mdp.getText().length()==0)
                {
                    this.erreur.setText(this.erreur.getText()+ " Veuillez rentrer un mot de passe \n");
                    this.mdp.setBackground(Color.red);
                }        
            }     
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the personne
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     * @param personne the personne to set
     */
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
