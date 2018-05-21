/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import UML.Jornada;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author usuario
 */
public class DOM_Liga {
    private Document doc;
    
    public DOM_Liga() throws ParserConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        doc = builder.newDocument();  
        
    }
    
    public void xmlLiga (ArrayList <Jornada> jornadas) throws IOException, TransformerException{
        Date hoy = new Date();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        int x;
        for(x=0;x<jornadas.size() && hoy.after(jornadas.get(x).getFechaInicio());x++){}
        generarDocumento (jornadas,ff.format(jornadas.get(x-1).getFechaFinal()));
        generarXML();
    }
    public void generarDocumento (ArrayList <Jornada> jornadas,String caduca){
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        Element liga= doc.createElement("liga");
            doc.appendChild(liga);
        Element fechaExp= doc.createElement("fecha_expiracion");
                fechaExp.appendChild(doc.createTextNode(caduca));
                    liga.appendChild(fechaExp);
        for(int x=0;x<jornadas.size();x++){
            Element jornada= doc.createElement("jornada");
                jornada.setAttribute("id_jornada", String.valueOf(jornadas.get(x).getIdJornada()));
                    liga.appendChild(jornada);
            Element fechaInicio=doc.createElement("fecha_inicio");
                fechaInicio.appendChild(doc.createTextNode(ff.format(jornadas.get(x).getFechaInicio())));
                    jornada.appendChild(fechaInicio);
            Element fechaFin=doc.createElement("fecha_fin");
                fechaFin.appendChild(doc.createTextNode(ff.format(jornadas.get(x).getFechaFinal())));
                    jornada.appendChild(fechaFin);
            for (int y=0;y<jornadas.get(x).getListaPartidos().size();y++){
                Element partido= doc.createElement("partido");
                    partido.setAttribute("id_partido", String.valueOf(jornadas.get(x).getListaPartidos().get(y).getIdPartido()));
                        jornada.appendChild(partido);       
            
            //en fecha y hora falta la mascara y todo eso
                Element fecha= doc.createElement("fecha");
                    fecha.appendChild(doc.createTextNode(obtenerFecha(jornadas.get(x).getListaPartidos().get(y).getFecha())));
                        partido.appendChild(fecha);
                Element hora= doc.createElement("hora");
                    hora.appendChild(doc.createTextNode(obtenerHora(jornadas.get(x).getListaPartidos().get(y).getFecha())));
                        partido.appendChild(hora);
                Element lugar= doc.createElement("lugar");
                    lugar.appendChild(doc.createTextNode(jornadas.get(x).getListaPartidos().get(y).geteLocal().getLugar()));
                        partido.appendChild(lugar);
            
            //Equipo Local
                Element equipol= doc.createElement("equipo");
                    equipol.setAttribute("id_equipo",String.valueOf(jornadas.get(x).getListaPartidos().get(y).geteLocal().getIdEquipo()));
                        partido.appendChild(equipol);
                Element nombrel= doc.createElement("nombre");
                    nombrel.appendChild(doc.createTextNode(jornadas.get(x).getListaPartidos().get(y).geteLocal().getNombre()));
                        equipol.appendChild(nombrel);
                Element comentariol= doc.createElement("comentario");
                    comentariol.appendChild(doc.createTextNode(jornadas.get(x).getListaPartidos().get(y).geteLocal().getComentario()));
                        equipol.appendChild(comentariol);
                Element puntuacionl= doc.createElement("puntuacion");
                    puntuacionl.appendChild(doc.createTextNode(String.valueOf(jornadas.get(x).getListaPartidos().get(y).getmLocal())));
                        equipol.appendChild(puntuacionl);
                Element visitantel= doc.createElement("visitante");
                    visitantel.appendChild(doc.createTextNode("false"));
                        equipol.appendChild(visitantel);
            
            //Equipo Visitante
                Element equipov= doc.createElement("equipo");
                    equipov.setAttribute("id_equipo", String.valueOf(jornadas.get(x).getListaPartidos().get(y).geteVisitante().getIdEquipo()));
                        partido.appendChild(equipov);
                Element nombrev= doc.createElement("nombre");
                    nombrev.appendChild(doc.createTextNode(jornadas.get(x).getListaPartidos().get(y).geteVisitante().getNombre()));
                        equipov.appendChild(nombrev);
                Element comentariov= doc.createElement("comentario");
                    comentariov.appendChild(doc.createTextNode(jornadas.get(x).getListaPartidos().get(y).geteVisitante().getComentario()));
                        equipov.appendChild(comentariov);
                Element puntuacionv= doc.createElement("puntuacion");
                    puntuacionv.appendChild(doc.createTextNode(String.valueOf(jornadas.get(x).getListaPartidos().get(y).getmVisitante())));
                        equipov.appendChild(puntuacionv);
                Element visitantev= doc.createElement("visitante");
                    visitantev.appendChild(doc.createTextNode("true"));
                        equipov.appendChild(visitantev);
            }
        }   
    }
    
    public void generarXML () throws TransformerConfigurationException, IOException, TransformerException{
        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);
        XMLSerializer serializer;
        serializer = new XMLSerializer(new FileOutputStream(new File("xml/XML-Liga.xml")), format);
        serializer.serialize(doc);
    }
    
    public String obtenerFecha (Calendar c){
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        return ff.format(c.getTime());
    }
    
    public String obtenerHora (Calendar c){
        SimpleDateFormat ff = new SimpleDateFormat("hh:mm");
        return ff.format(c.getTime());
    }
}
