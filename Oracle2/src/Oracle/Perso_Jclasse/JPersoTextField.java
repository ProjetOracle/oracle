/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle.Perso_Jclasse;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author WorkStation
 */
public class JPersoTextField extends JTextField{
    protected String name;
    
    public JPersoTextField(String name)
    {
        this.name = name;
    }
    
    public JPersoTextField(JPersoTextField j)
    {
        this.name = j.getName();
       copyCaracs(j);
    }
    
    public JPersoTextField(JPersoTextField j, String name)
    {
        this.name = name;
        copyCaracs(j);
        
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
   public void copyCaracs(JComponent j)
    {
        this.setBackground(j.getBackground());
        this.setBorder(j.getBorder());
        this.setFont(j.getFont());
        this.setSize(j.getSize());
        
    }
    
    
    
}
