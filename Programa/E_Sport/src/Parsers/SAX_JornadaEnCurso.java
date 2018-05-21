/**
 * Clase de creación del parser SAX de jornada en curso.
 * Fecha de creación de la clase: 19/05/2018
 * @author  eqdaw04
 */
package Parsers;

import UML.Partido;
import UML.Equipo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    
    public ArrayList<Partido> metodoraiz() throws Exception{
        parsearjornada();
        return partidos;
    }
    
    private void parsearjornada() throws Exception{
        SAXParserFactory spf = SAXParserFactory.newInstance();  
        SAXParser sp = spf.newSAXParser();
        sp.parse("xml/JornadaEnCurso.xml", this);
        
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
            case "equipo":
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
                SimpleDateFormat ff = new SimpleDateFormat("yyyy-mm-dd hh:mm");
                Calendar fechas = Calendar.getInstance();
                fecha += " " + buffer.toString();
          {
              try {
                  fechas.setTime(ff.parse(fecha));
              } catch (ParseException ex) {
                  Logger.getLogger(SAX_JornadaEnCurso.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
                p.setFecha(fechas);
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
