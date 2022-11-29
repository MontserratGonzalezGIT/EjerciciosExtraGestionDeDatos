/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen3;

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
import examen3.Incidencia;
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
 * @author Alex Pastor Sales
 * 
 */
public class modelIncidencias {
    
    public static List obtenerIncidencias(){
        
        List<Incidencia> incidencias = new ArrayList<>();
        Incidencia incidencia  = null;
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new File("datos.xml"));
            
            NodeList nodeList = document.getElementsByTagName("incidencia");
            
            for (int i=0; i < nodeList.getLength();i++){
                
                 
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                
                    Element eElement = (Element) node;
                    incidencia = new Incidencia();  
                    incidencia.setId(Integer.parseInt(eElement.getAttribute("id")));
                    incidencia.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    incidencia.setApellidos(eElement.getElementsByTagName("apellidos").item(0).getTextContent());
                    incidencia.setInci(eElement.getElementsByTagName("inci").item(0).getTextContent());
                    
                }
                    
                incidencias.add(incidencia);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return incidencias;
    }
    
    public static void anyadirIncidencia(Incidencia incidenciaAnyadir) throws FileNotFoundException, IOException{
        
        List<Incidencia> incidencias = obtenerIncidencias();
        incidencias.add(incidenciaAnyadir);
        actualizarIncidencias(incidencias);

    }
    
     public static void actualizarIncidencias(List<Incidencia> incidencias) throws FileNotFoundException, IOException{
         
         try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            DOMImplementation dImp = dBuilder.getDOMImplementation();

            Document doc = dImp.createDocument(null, "incidencias", null);
            doc.setXmlVersion("1.0");

            for (Incidencia i : incidencias) {
                Element incidencia = doc.createElement("incidencia");
                incidencia.setAttribute("id", String.valueOf(i.getId()));

                Element nombre = doc.createElement("nombre");
                Text nombreTN = doc.createTextNode(i.getNombre());
                nombre.appendChild(nombreTN);
                incidencia.appendChild(nombre);

                Element apellidos = doc.createElement("apellidos");
                Text apellidosTN = doc.createTextNode(i.getApellidos());
                apellidos.appendChild(apellidosTN);
                incidencia.appendChild(apellidos);

                Element inci = doc.createElement("inci");
                Text inciTN = doc.createTextNode(i.getInci());
                inci.appendChild(inciTN);
                incidencia.appendChild(inci);

                doc.getDocumentElement().appendChild(incidencia);
            }

            Source src = new DOMSource(doc);
            Result res = new StreamResult(new File("datos.xml"));

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
