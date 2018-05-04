/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_jornada.en.curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAX_JornadaEnCurso extends DefaultHandler{

    List equipo;
    List partido;
        private String caracteres;
        private String expiracion;
        
    private Partido part;
    private Equipo eq;
    
    public SAX_JornadaEnCurso(){

        partido = new ArrayList();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("SAX_JornadaEnCurso");
        System.out.println("---");
        
        SAX_JornadaEnCurso jecsax = new SAX_JornadaEnCurso();
        jecsax.metodoraiz();
    }
    
    public void metodoraiz(){
        parsearjornada();
        printData();
    }
    
    private void parsearjornada(){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            
            SAXParser sp = spf.newSAXParser();
            
            sp.parse("../../xml/clasificacion/XML-Jornada-en-curso.xml", this);
            
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
        
        Iterator it = partido.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
        
        caracteres="";
        if(qName.equalsIgnoreCase("partido")){
            part = new Partido();
            part.setIdPartido(Integer.parseInt(attributes.getValue("id_partido")));
        } else if (qName.equalsIgnoreCase("equipo")){
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
          if (qName.equalsIgnoreCase("partido")){
              partido.add(part);
              

          } else if (qName.equalsIgnoreCase("fecha_partido")){
             part.setFechaPartido(caracteres);
          } else if (qName.equalsIgnoreCase("hora_inicio")){
              part.setHoraInicio(caracteres);        
          } else if (qName.equalsIgnoreCase("hora_fin")){
              part.setHoraFin(caracteres);
          }
          
        if (qName.equalsIgnoreCase("equipo")){
            part.setListaequipos(eq);
        
        } else if (qName.equalsIgnoreCase("nombre")){
            eq.setNombre(caracteres);
        }
      }   
}
