/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;
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
public class Administration extends JFrame implements ActionListener {
    public Administration() {
        createWindow();
    }
    
    JPersoButton creerQuizz;
    JPersoButton creerQuestion;
    JPersoButton statistiques;    
    JLabel admin = new JLabel("Administration");
        
    private void createWindow() {

        JPanel content = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
    
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        creerQuizz = new JPersoButton("creerQuizz");
        creerQuizz.setText("Créer un quizz");
        creerQuizz.addActionListener(this);

        creerQuestion = new JPersoButton("creerQuestion");
        creerQuestion.setText("Créer une question");
        creerQuestion.addActionListener(this);
      
        statistiques = new JPersoButton("statistiques");
        statistiques.setText("Statistiques");
        statistiques.addActionListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
       
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.setLocationRelativeTo(null);

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
    
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(admin,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(creerQuizz,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(creerQuestion,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(statistiques,gbc);
    
        Oracle.listeFenetres.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();       
         
        if(source == creerQuestion) {
            System.out.println("Créer question");
        }
        
        if(source == creerQuizz) {
            System.out.println("Créer quizz");
        }

        if(source == statistiques) {
            System.out.println("Statistiques");
        }
        
    }
}