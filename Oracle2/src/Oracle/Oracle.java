/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import java.util.ArrayList;

/**
 *
 * @author WorkStation
 */
public class Oracle {

    static public ArrayList listeFenetres;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        listeFenetres = new ArrayList();
        WindowConnection w = new WindowConnection();
        Administration admin = new Administration();
        ListeQuizz quizzs = new ListeQuizz();
    }
}