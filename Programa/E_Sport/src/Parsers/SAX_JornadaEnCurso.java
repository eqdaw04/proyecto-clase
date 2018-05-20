/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import UML.Partido;
import UML.Equipo;
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
import sax_jornada.en.curso.Equipo;
import sax_jornada.en.curso.Partido;

public class SAX_JornadaEnCurso extends DefaultHandler{

    private ArrayList<Partido> partidos;
    private String expiracion;
    private StringBuilder buffer=new StringBuilder();        
    private Partido p;
    private Equipo e;
    
    public SAX_JornadaEnCurso(){

        partidos = new ArrayList();
    }
    
    
    public void metodoraiz(){
        parsearjornada();
        printData();
    }
    
    private void parsearjornada(){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            
            SAXParser sp = spf.newSAXParser();
            
            sp.parse("JornadaEnCurso.xml", this);
            
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
        
        Iterator it = partidos.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
        switch (qName){
            case "partido":
                p = new Partido();
                p.setIdPartido(Integer.parseInt(attributes.getValue("id_partido")));
                partidos.add(p);     
                break;
            case "fecha":
                buffer.delete(0,buffer.length());
                break;
            case "hora":
                break;
            case "lugar":
                break;
            case "Equipo":
                break;
            case "nombre":
                break;
            case "comentario":
                break;
            case "puntuacion":
                break;
            case "visitante":
                break;
        }               
    }
    
        public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }
       
      public void endElement(String uri, String localName, String qName) throws SAXException {
          switch(qName){
             case "partido":
                break;
            case "fecha":
                break;
            case "hora":
                break;
            case "lugar":
                p.se
                break;
            case "Equipo":
                
                break;
            case "nombre":
                e.setNombre(buffer.toString());
                break;
            case "comentario":
                e.setComentario(buffer.toString());
                break;
            case "puntuacion":
                //variable local o visitante
                break;
            case "visitante":
                
                break;
            case "jornada":
                break;
          }
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
