/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.clasificacion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.util.Scanner;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMClasificacion {

    List equipos;
        Document dom;
        
        public DOMClasificacion(){
            parsearXML();
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        DOMClasificacion jornada = new DOMClasificacion();
        
        jornada.ejecutar();
    }
    
    public void ejecutar(){
        String opcion = "0";
        Scanner sc = new Scanner(System.in);
        
         do {                
                
             System.out.println("Elige la opcion que quieres realizar");
             System.out.println ("1- Leer el fichero Clasificacion.xml");
             System.out.println("2- Salir");
             
             opcion = sc.nextLine();
             
             switch (opcion){
                 case "1":
                     
                    equipos = new ArrayList();
                     leerDocumento();
                     mostrarDocumento();
                     break;
                     
                 case "2":
                     System.out.println("Has salido del archivo 'Clasificacion'");
                     break;
             }
             
            } while (!opcion.equals("4"));
               printToFile();
               System.out.println("Fichero generado correctamente.");
    }
    
    private void parsearXML(){
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            dom = db.parse("../../xml/Clasificacion/XML-Clasificacion.xml");
            
        } catch (ParserConfigurationException pce) {
             System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
            System.exit(1);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private void leerDocumento(){
        
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("equipo");
        
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                
                Element el = (Element) nl.item(i);
                
                Equipo e = getEquipo(el);
                
                equipos.add(e);
            }
    }
}
    
    private Equipo getEquipo (Element elem){
        
        int idEquipo = Integer.parseInt(elem.getAttribute("id_equipo")); 
        String nombre = getTextValue(elem, "nombre");
        int puntuacion = getIntValue(elem, "puntuacion");
        
        Equipo e = new Equipo(idEquipo, puntuacion, nombre);
        
        return e;
    }
    
    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    private int getIntValue(Element ele, String tagName) {

        return Integer.parseInt(getTextValue(ele, tagName));
        
    }
    
    private void mostrarDocumento(){
        
        System.out.println("Equipos de la clasificacion"+ equipos.size());
        
        Iterator it = equipos.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    
    private void printToFile(){
        try {
             OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("../../xml/Clasificacion/XML-Clasificacion.xml")), format);

            serializer.serialize(dom);
        } catch (IOException ie) {
             ie.printStackTrace();
        }
    }
    
}