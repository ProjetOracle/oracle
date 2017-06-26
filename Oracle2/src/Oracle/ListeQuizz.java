/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import Oracle.Classe.Connecteur;
import Oracle.Classe.Personne;
import Oracle.Perso_Jclasse.JPersoButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WorkStation
 */
public class ListeQuizz extends JFrame implements ActionListener {
    
    Connecteur connexion = new Connecteur();
    
    public ListeQuizz() {
        createWindow();
    }
    
    public void createWindow() {
        JPanel content = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
    
        Oracle.listeFenetres.add(this);
    }
    
    public void affichage(Personne personne) throws SQLException {
        
        JLabel pseudo = new JLabel("Nom du joueur : " + personne.getLogin());
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
        
        this.setLocationRelativeTo(null);

        String sql = "SELECT * FROM Quizz";
        ResultSet rs = connexion.requete(sql);      
        
        gbc.gridx=1;
        gbc.gridy=4;
        this.add(new JLabel("Id"), gbc);
        
        gbc.gridx=2;
        gbc.gridy=4;
        this.add(new JLabel("Duree"), gbc);
        
        gbc.gridx=3;
        gbc.gridy=4;
        this.add(new JLabel("Nom"), gbc);
        
        gbc.gridx=4;
        gbc.gridy=4;
        this.add(new JLabel("Niveau"), gbc);
        
        int x = 1;
        int y = 5;    
        while(rs.next()) {
            int id = rs.getInt(2);
            gbc.gridx = x;
            gbc.gridy = y;
            this.add(new JTextField(Integer.toString(id)), gbc);
            x++;
            
            int duree = rs.getInt(1);
            gbc.gridx = x;
            gbc.gridy = y;
            this.add(new JTextField(Integer.toString(duree)), gbc);
            x++;
            
            /*int idPersonne = rs.getInt(3);
            gbc.gridx = x;
            gbc.gridy = y;
            this.add(new JTextField(Integer.toString(idPersonne)), gbc);
            x++;*/     
            
            String nom = rs.getString(4);
            gbc.gridx = x;
            gbc.gridy = y;
            this.add(new JTextField(nom), gbc);
            x++;
            
            int niveau = rs.getInt(5);
            gbc.gridx = x;
            gbc.gridy = y;
            this.add(new JTextField(Integer.toString(niveau)), gbc);
            x=1;
            y++;
        }

        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        
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
