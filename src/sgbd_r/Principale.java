/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd_r;
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
public class Principale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Creer_DB creation_DB= new Creer_DB();
        creation_DB.creerDB();
//        
        Creer_Table creation_table= new Creer_Table();
        creation_table.creerTabler();
        // TODO code application logic here
        
        
        
    }
    
}
