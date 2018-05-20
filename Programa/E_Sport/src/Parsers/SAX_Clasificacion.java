/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAX_Clasificacion extends DefaultHandler {

    ArrayList <Object> equipos;
    
        private String caracteres;
        private String expiracion;
        Object[] equipo;
    
    public SAX_Clasificacion(){
        equipos = new ArrayList();
}
    
    public ArrayList <Object> metodoraiz() throws Exception{
        parsearclasificacion();
        return equipos;
    }
    
    private void parsearclasificacion()throws Exception{
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse("xml/XML-Clasificacion.xml", this);
      
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
        caracteres="";
        if(qName.equalsIgnoreCase("equipo")){
         equipo = new Object[3];       
         equipo[0] = attributes.getValue("id_equipo");
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
            equipos.add(equipo);
        }else if (qName.equalsIgnoreCase("nombre")){
            equipo[1] = caracteres;
        } else if (qName.equalsIgnoreCase("puntuacion")){
            equipo[2] = caracteres;
            
        }
    }

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }
    
    
}
