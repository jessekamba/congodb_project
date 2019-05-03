/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd_r;

import java.io.IOException;

/**
 *
 * @author JESSE KAMBA
 */
public class Principale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Creer_DB creation_DB= new Creer_DB();
        creation_DB.creerDB();
        
        Creer_Table creation_table= new Creer_Table();
        creation_table.creerTabler();
        // TODO code application logic here
    }
    
}
