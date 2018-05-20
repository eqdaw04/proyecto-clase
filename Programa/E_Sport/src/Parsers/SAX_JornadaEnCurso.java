/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import UML.Partido;
import UML.Equipo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;


public class SAX_JornadaEnCurso extends DefaultHandler{

    private ArrayList<Partido> partidos;
    private String expiracion,fecha,lugar,puntuacion;
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
        System.out.println("Atención, esta lista caduca el ");
        
        Iterator it = partidos.iterator();
        while (it.hasNext()){
            System.out.println(it.hasNext());
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
                buffer.delete(0,buffer.length());
                break;
            case "lugar":
                buffer.delete(0,buffer.length());
                break;
            case "Equipo":
                e = new Equipo();
                e.setIdEquipo(Integer.parseInt(attributes.getValue("id_equipo")));
                break;
            case "nombre":
                buffer.delete(0,buffer.length());
                break;
            case "comentario":
                buffer.delete(0,buffer.length());
                break;
            case "puntuacion":
                buffer.delete(0,buffer.length());
                break;
            case "visitante":
                buffer.delete(0,buffer.length());
                break;
            case "jornada":
                buffer.delete(0,buffer.length());
                break;

        }               
    }
    
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch,start,length);
        }
       
      public void endElement(String uri, String localName, String qName) throws SAXException {
          switch(qName){
            case "fecha":
                fecha= buffer.toString();
                break;
            case "hora":
                SimpleDateFormat sp= new SimpleDateFormat("dd/MM/yyyy HH:mm");
                fecha=fecha+" "+buffer.toString();
              try {
                Date dat=sp.parse(fecha);
                Calendar calendar= Calendar.getInstance();
                calendar.setTimeInMillis(dat.getTime());
                p.setFecha(calendar);
              } catch (ParseException ex) {
                  Logger.getLogger(SAX_JornadaEnCurso.class.getName()).log(Level.SEVERE, null, ex);
              } 
                break;
            case "lugar":
                lugar=buffer.toString();
                break;
            case "nombre":
                e.setNombre(buffer.toString());
                break;
            case "comentario":
                e.setComentario(buffer.toString());
                break;
            case "puntuacion":
                puntuacion = buffer.toString();
                break;
            case "visitante":
                if(buffer.toString().equalsIgnoreCase("true")){
                    p.seteVisitante(e);
                    p.setmVisitante(Integer.parseInt(puntuacion));
                }else{
                    e.setLugar(lugar);
                    p.seteLocal(e);
                    p.setmLocal(Integer.parseInt(puntuacion));
                }
                break;
          }
      }   
}
