/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd_r;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sgbd_r.Creer_DB.path;

/**
 *
 * @author JESSE KAMBA
 */
public class Creer_Table  {
    
     public static void creerTabler() throws IOException{
         String pathTable= Creer_DB.path;
//       String concat="jesse";
//       String name = path1+concat;
         System.out.println(pathTable);
         String ligne=null;
         System.out.println("veuillez taper la requete pour creer une table");
         BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        
         try {
             ligne= reader.readLine();
         } catch (IOException ex) {
             Logger.getLogger(Creer_DB.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         final String separateur=" ";
         String requete[]= ligne.split(separateur);
         String recup_create=requete[0];
         String recup_table=requete[1];
         String tbname=requete[2];
//       File file = new File(path);
         
         
        File fichier = new File(pathTable+"\\"+tbname+".txt") ; 
        PrintWriter out = new PrintWriter(new FileWriter(fichier)) ; 
 

         
     }
    
}
