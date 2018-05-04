/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_clasificacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAX_Clasificacion extends DefaultHandler {

    List equipos;
        private String caracteres;
        private String expiracion;
        
    private Equipo eq;
    
    public SAX_Clasificacion(){
        equipos = new ArrayList();
}
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("SAX_Clasificacion");
        System.out.println ("---");
        
        SAX_Clasificacion clasax = new SAX_Clasificacion();
            clasax.metodoraiz();
    }
    
    public void metodoraiz(){
        parsearclasificacion();
        printData();
    }
    
    private void parsearclasificacion(){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            
            SAXParser sp = spf.newSAXParser();
            
            sp.parse("../../xml/clasificacion/XML-Clasificacion.xml", this);
            
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
    private void printData(){
        System.out.println("Atención, esta lista caduca el " + expiracion);
        
        Iterator it = equipos.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
        caracteres="";
        if(qName.equalsIgnoreCase("equipo")){
         eq = new Equipo();       
         eq.setIdEquipo(Integer.parseInt(attributes.getValue("id_equipo")));
        }

    }
    
    public void characters(char[] ch, int start, int length) throws SAXException { 
        caracteres = new String(ch, start, length);
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException { 
       
        if (qName.equalsIgnoreCase("fecha_expiracion")){
            expiracion = caracteres;
        }
        if (qName.equalsIgnoreCase("equipo")){
            equipos.add(eq);
        }else if (qName.equalsIgnoreCase("nombre")){
            eq.setNombre(caracteres);
        } else if (qName.equalsIgnoreCase("puntuacion")){
            eq.setPuntuacion(Integer.parseInt(caracteres));
            
    }
}
}
