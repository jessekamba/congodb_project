/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd_r;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JESSE KAMBA
 */
public class Creer_DB {
    
     public static void creerDB() {
    
        String ligne=null;
        System.out.println("veuillez taper la requete pour creer votre base de donneee");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        
         try {
             ligne= reader.readLine();
         } catch (IOException ex) {
             Logger.getLogger(Creer_DB.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
           
    final String separateur=" ";
//    String chaine_a_decouper=ligne;
    String requete[]= ligne.split(separateur);
//    System.out.println(mots[1]);
//    System.out.println(chaine_a_decouper.split(separateur));
//    int compte=0;
//        for (int i = 0; i < mots.length; i++) {
//           System.out.println(mots[i]);
//            compte++;
//        }

    String recup_create=requete[0];
    String recup_database=requete[1];
    String dbname=requete[2];
    
    if ("create".equals(recup_create) && "database".equals(recup_database))
    {
    String path="C:\\Users\\JESSE KAMBA\\Documents\\projet\\java\\"+dbname;
    File file = new File(path);
//    boolean test= file.exists();
//        System.out.println(test);
    if (file.exists())
        {
            System.err.println("votre base de donnee existe deja dans"+" "+ file.getAbsolutePath());
        }
    else
        {
            if(file.mkdir())
            {
                System.out.println("votre base de donnee creer dans"+" "+ file.getAbsolutePath());
            }else{
            System.err.println("une erreur interne s'est produite");
            }
        }
     }else {
        System.err.println("veuillez verifier votre requete");
        System.err.println("la requete se rapprochant de la votre est 'CREATE DATABASE DATABASE_NAME'");
    }
        
//        System.out.println("la requete est "+ ligne);
    }
    
}
