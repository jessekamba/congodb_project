/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd_r;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;

/**
 *
 * @author JESSE KAMBA
 */
public class Creer_Table  {
    
     public static void creerTabler() throws IOException{
         //recuperation du path dans lequel le fichier sera cree
         String pathTable= Creer_DB.path;
//       String concat="jesse";
//       String name = path1+concat;
//         System.out.println(pathTable);
         String ligne=null;
         System.out.println("veuillez taper la requete pour creer une table");
         
         //recuperation du flux clavier de l'utilisateur
         BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        
         try {
             
             ligne= reader.readLine();
         } catch (IOException ex) {
             Logger.getLogger(Creer_DB.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         //decoupage de la requete de la requete en partie a l'aide d un separateur
         final String separateur=" ";
         String requete[]= ligne.split(separateur);
         String recup_create=requete[0];
         String recup_table=requete[1];
         String tbname=requete[2];
         String parentheseOuvrante=requete[3];
         String nomCol=requete[4];
         String typeCol=requete[5];
         String parentheseFermante=requete[6];
    
//       File file = new File(path);
//         if(requete.length != ligne.length()){
//             System.err.println("votre requete est longue ou courte ou encore ne respecte pas la syntaxe du sql");
//         }else {
            
       
            
         //verification de la requete
        if("create".equals(recup_create) && "table".equals(recup_table) || "CREATE".equals(recup_create) && "TABLE".equals(recup_table) ){
            File fichier = new File(pathTable+"\\"+tbname+".xml") ;  
            
            //verification du fichier si celui-ci existe
            if (fichier.exists())
        {
            System.err.println("votre table existe deja dans"+" "+ fichier.getAbsolutePath());
        }
            //creation du fichier
            else{
                 PrintWriter out = new PrintWriter(new FileWriter(fichier));
                 System.out.println("vous avez cree une table"+" "+ tbname);
            }
            
//            File fichier = new File(pathTable+"\\"+tbname+".txt") ; 
        
           
        }
        else{
            System.err.println("veuillez verifier votre requete");
            System.err.println("une requete se rapprochant de la votre est CREATE TABLE TB_NAME");
        }
         
         try {
 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
 
        // élément de racine(nom  de la table)
        Document doc = docBuilder.newDocument();
        Element racine = doc.createElement(tbname);
        doc.appendChild(racine); 
 
        // l'élément nomtable
        Element contact = doc.createElement(tbname);
        racine.appendChild(contact);
 
        // nom de la colone
        Attr nomcolone = doc.createAttribute("nomColone");
        nomcolone.setValue(nomCol);
        contact.setAttributeNode(nomcolone);
 
        // le nom
//         Element nomColone = doc.createElement("nomcolone");
//        nomColone.appendChild(doc.createTextNode(nomCol));
//        contact.appendChild(nomColone);
        
//        type colone
        Attr typecolone = doc.createAttribute("typeColone");
        typecolone.setValue(typeCol);
        contact.setAttributeNode(typecolone);
 
        // le prénom
//        Element typeColone = doc.createElement("type");
//        typeColone.appendChild(doc.createTextNode(typeCol));
//        contact.appendChild(typeColone);
 
        // le mobile
//        Element mobile = doc.createElement("mobile");
//        mobile.appendChild(doc.createTextNode("097745126"));
//        contact.appendChild(mobile);
//  
//        // l'email
//        Element email = doc.createElement("email");
//        email.appendChild(doc.createTextNode("kambajesse@gmail.com"));
//        contact.appendChild(email);
// 
        // Ecrire le contenu dans le fichier xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File(pathTable+"\\"+tbname+".xml"));
        transformer.transform(source, resultat);
 
        System.out.println("Fichier sauvegardé avec succès!");
 
     } catch (ParserConfigurationException pce) {
         pce.printStackTrace();
     } catch (TransformerException tfe) {
         tfe.printStackTrace();
     }
 

         
     }
     public static boolean File_Is_it(String path) throws IOException {
            String fichierCompteURL = path;
        File fichier=new File(path);
        if((fichier.exists())){
             fichier.createNewFile();
             File fichierAgent = fichier;
             return true;
        }
        else
        {
            return false;
        }
    }
        
}
