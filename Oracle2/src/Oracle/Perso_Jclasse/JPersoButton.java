/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Perso_Jclasse;

import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author WorkStation
 */


public class JPersoButton extends JButton{
    protected String name;
    
    public JPersoButton(String name)
    {
        super(name);
        this.name=name;
   }
   
    public JPersoButton(String name, String source)
    {
        super(source);
        this.name = name;
    }
    
    public JPersoButton(JPersoButton j, String source)
    {
        super(source);
        this.name = j.getName();
        copyCaracs(j);
    }
    
    public JPersoButton(JPersoButton j, String source, String nom)
    {
        super(source);
        this.name = name;
        copyCaracs(j);
        
    }
    
    public void copyCaracs(JComponent j)
    {
        this.setBackground(j.getBackground());
        this.setBorder(j.getBorder());
        this.setFont(j.getFont());
        this.setSize(j.getSize());
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
  
}
