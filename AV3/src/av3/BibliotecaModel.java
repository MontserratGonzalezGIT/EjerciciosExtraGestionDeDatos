/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av3;

import Controladores.BibliotecaController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import av3.Libro;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author alfas
 */
public class BibliotecaModel {
    
    public static List obtenerLibreria(){
        
        List<Libro> libreria = new ArrayList<>();
        Libro libro  = null;
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new File("libreria.xml"));
            
            //Element raiz = document.getDocumentElement();
            NodeList nodeList = document.getElementsByTagName("libro");
            
            for (int i=0; i < nodeList.getLength();i++){
                
                 
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                
                    Element eElement = (Element) node;
                    libro = new Libro();  
                    libro.setID(Integer.parseInt(eElement.getAttribute("id")));
                    libro.setTitulo(eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    libro.setAutor(eElement.getElementsByTagName("autor").item(0).getTextContent());
                    libro.setAnyo(eElement.getElementsByTagName("anyo").item(0).getTextContent());
                    libro.setEditorial(eElement.getElementsByTagName("editorial").item(0).getTextContent());
                    libro.setNumPagines(eElement.getElementsByTagName("numPagines").item(0).getTextContent());
                    
                }
                    
                libreria.add(libro);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BibliotecaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(BibliotecaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BibliotecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return libreria;
    }
    
    public static void anyadirLibro(Libro libroAnyadir) throws FileNotFoundException, IOException{
        
        List<Libro> libreria = obtenerLibreria();
        libreria.add(libroAnyadir);
        actualizarLibreria(libreria);

    }
    
     public static void actualizarLibreria(List<Libro> libreria) throws FileNotFoundException, IOException{
         
         try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            DOMImplementation dImp = dBuilder.getDOMImplementation();

            Document doc = dImp.createDocument(null, "libreria", null);
            doc.setXmlVersion("1.0");

            for (Libro l : libreria) {
                Element libro = doc.createElement("libro");
                libro.setAttribute("id", String.valueOf(l.getID()));

                Element titulo = doc.createElement("titulo");
                Text tituloTN = doc.createTextNode(l.getTitulo());
                titulo.appendChild(tituloTN);
                libro.appendChild(titulo);

                Element autor = doc.createElement("autor");
                Text autorTN = doc.createTextNode(l.getAutor());
                autor.appendChild(autorTN);
                libro.appendChild(autor);

                Element anyo = doc.createElement("anyo");
                Text anyoTN = doc.createTextNode(l.getAnyo());
                anyo.appendChild(anyoTN);
                libro.appendChild(anyo);

                Element editorial = doc.createElement("editorial");
                Text editorialTN = doc.createTextNode(l.getEditorial());
                editorial.appendChild(editorialTN);
                libro.appendChild(editorial);

                Element nPags = doc.createElement("numPagines");
                Text nPagsTN = doc.createTextNode(String.valueOf(l.getNumPagines()));
                nPags.appendChild(nPagsTN);
                libro.appendChild(nPags);

                doc.getDocumentElement().appendChild(libro);
            }

            Source src = new DOMSource(doc);
            Result res = new StreamResult(new File("libreria.xml"));

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(src, res);
        } catch (Exception e) {
            System.out.print(e);
        }
         
     }
}
