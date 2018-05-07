/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_liga;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author yaiza
 */
public class SAX_Liga extends DefaultHandler {

    List jornada;
    private String caracteres;
    private String expiracion;
    
    private Equipo eq;
    private Partido part;
    private Jornada jorn;
    
    public SAX_Liga(){
        jornada = new ArrayList();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    System.out.println("SAX_Liga");
    System.out.println("---");
          
    SAX_Liga ligasax = new SAX_Liga();
    ligasax.metodoraiz();
    }
    
public void metodoraiz(){
    parsearliga();
    printData();
}

private void parsearliga(){
    SAXParserFactory spf = SAXParserFactory.newInstance();

        try {

            SAXParser sp = spf.newSAXParser();

            sp.parse("../XML/XML-Liga.xml", this);

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
    Iterator it = jornada.iterator();
    while (it.hasNext()) {
        System.out.println(it.next().toString());
    }

}
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
        caracteres="";
        if (qName.equalsIgnoreCase("jornada")){
            jorn = new Jornada();
            jorn.setIdJornada(Integer.parseInt(attributes.getValue("id_jornada")));
        }else if (qName.equalsIgnoreCase("partido")){
             part = new Partido(); 
             part.setIdPartido(Integer.parseInt(attributes.getValue("id_partido")));
        }else if (qName.equalsIgnoreCase("equipo")){
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
         if (qName.equalsIgnoreCase("jornada")){
            jornada.add(jorn);
       }
        if (qName.equalsIgnoreCase("partido")){
            jorn.setListapartidos(part);
    } else if (qName.equalsIgnoreCase("fecha")){
        part.setFecha(Date.valueOf(caracteres));
    } else if (qName.equalsIgnoreCase("lugar")){
        part.setLugar(caracteres);
    } else if (qName.equalsIgnoreCase("hora")){
        part.setHora(caracteres);
    }
        
   if (qName.equalsIgnoreCase("equipo")){
       part.setListaequipos(eq);
   } else if (qName.equalsIgnoreCase("nombre")){
       eq.setNombre(caracteres);
   } else if (qName.equalsIgnoreCase("comentario")){
       eq.setComentario(caracteres);
   }  else if (qName.equalsIgnoreCase("puntuacion")){
       eq.setPuntuacion(Integer.parseInt(caracteres));
   }  else if (qName.equalsIgnoreCase("visitante")){
       eq.setVisitante(Boolean.parseBoolean(caracteres));
   }
}
}
