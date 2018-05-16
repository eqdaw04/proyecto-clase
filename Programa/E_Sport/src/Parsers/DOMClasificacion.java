/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import dom.clasificacion.Equipo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMClasificacion {
    
    List lEquipo;
    Document dom;
    
    
    public DOMClasificacion(){
        lEquipo = new ArrayList();
        crearDocumento();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        DOMClasificacion jornada = new DOMClasificacion();
        
        jornada.ejecutar();
    }
    
    public void ejecutar(){
        cargarXML();
        parsearDOM();
        crearDocumento();
        crearDOM();
        crearXML();
    }
    
    private void crearDocumento() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.newDocument();

        } catch (ParserConfigurationException pce) {
            System.out.println("Hay un problema  " + pce);
            System.exit(1);
        }

    }
    
    private void cargarXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("../XML/XML-Liga.xml");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(DOMClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void parsearDOM(){
        
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("equipo");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                Equipo eq = getlEquipo(el);
                lEquipo.add(eq);
            }
        }
    }
    
    private void crearDOM(){
    
        Element rootEle = dom.createElement("clasificacion");
        dom.appendChild(rootEle);
        
        Element fechaExp = dom.createElement("equipo");
        Text fe = dom.createTextNode("HOOOOOOOOOOLLLLLLLLLAAAAAAAAAAAAAAAAAAAAAAAAAA");
        fechaExp.appendChild(fe);
        rootEle.appendChild(fechaExp);
        
        Iterator it = lEquipo.iterator();
        while (it.hasNext()) {
            Equipo b = (Equipo) it.next();
            Element aEle = crearEquipo(b);
            rootEle.appendChild(aEle);
        }
    }
    
    private Element crearEquipo(Equipo eq) {

        Element aEle = dom.createElement("equipo");
        aEle.setAttribute("id_equipo", String.valueOf(eq.getIdEquipo()));

        
        /*
        Element idEq = dom.createElement("idEquipo");
        Text ide = dom.createTextNode(eq.getNombre());
        idEq.appendChild(ide);
        aEle.appendChild(idEq);
        */
        
        Element nomEle = dom.createElement("Nombre");
        Text nomT = dom.createTextNode(eq.getNombre());
        nomEle.appendChild(nomT);
        aEle.appendChild(nomEle);

        Element comEle = dom.createElement("comentario");
        Text ae = dom.createTextNode(eq.getComentario());
        comEle.appendChild(ae);
        aEle.appendChild(comEle);
        
        Element pEle = dom.createElement("puntuacion");
        Text pe = dom.createTextNode(String.valueOf(eq.getPuntuacion()));
        pEle.appendChild(pe);
        aEle.appendChild(pEle);
        
        Element vEle = dom.createElement("visitante");
        Text ve = dom.createTextNode(eq.getVisitante());
        vEle.appendChild(ve);
        aEle.appendChild(vEle);

        return aEle;

    }

    private void crearXML(){
        OutputFormat format = new OutputFormat(dom);
        format.setIndenting(true);
        XMLSerializer serializer;
        try {
            serializer = new XMLSerializer(new FileOutputStream(new File("../XML/XML-Clasificacion.xml")), format);
            serializer.serialize(dom);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DOMClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOMClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Equipo getlEquipo(Element e1) {
        int idEquipo = Integer.parseInt(e1.getAttribute("id_equipo"));
        String nombre = getTextValue(e1, "nombre");
        String comentario = getTextValue(e1, "comentario");
        int puntuacion = getIntValue(e1, "puntuacion");
        String visitante = getTextValue(e1, "visitante");
        Equipo eq = new Equipo(idEquipo, nombre, comentario, puntuacion, visitante);

        return eq;
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
        //in production application you would catch the exception
        return Integer.parseInt(getTextValue(ele, tagName));
    }

}