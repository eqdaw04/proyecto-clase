/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import UML.Partido;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author usuario
 */
public class DomResultadosUltimaJornada {
    private Document doc;
    
    public DomResultadosUltimaJornada() throws ParserConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        doc = builder.newDocument();  
        
    }
    
    public void xmlResUltJor (ArrayList <Partido> partidos) throws IOException, TransformerException{
        generarDocumento (partidos);
        generarXML();
    }
    public void generarDocumento (ArrayList <Partido> partidos){
        Element jornada= doc.createElement("jornada");
        jornada.setAttribute("Id_jornada", "1");
        doc.appendChild(jornada);
        for(int x=0;x<partidos.size();x++){
            Element partido= doc.createElement("partido");
            partido.setAttribute("id_partido", String.valueOf(partidos.get(x).getIdPartido()));
            jornada.appendChild(partido);       
            
            //en fecha y hora falta la mascara y todo eso
            Element fecha= doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(obtenerFecha(partidos.get(x).getFecha())));
                    partido.appendChild(fecha);
            Element hora= doc.createElement("hora");
                hora.appendChild(doc.createTextNode(obtenerHora(partidos.get(x).getFecha())));
                    partido.appendChild(hora);
            Element lugar= doc.createElement("lugar");
                lugar.appendChild(doc.createTextNode(partidos.get(x).geteLocal().getLugar()));
                    partido.appendChild(lugar);
            
            //Equipo Local
            Element equipol= doc.createElement("equipo");
                equipol.setAttribute("id_equipo",String.valueOf(partidos.get(x).geteLocal().getIdEquipo()));
                    partido.appendChild(equipol);
            Element nombrel= doc.createElement("nombre");
                nombrel.appendChild(doc.createTextNode(partidos.get(x).geteLocal().getNombre()));
                    equipol.appendChild(nombrel);
            //hacer pruebas con esto; que pasa si se hace if? en algunos se crea y otros no? o da error??
            Element comentariol= doc.createElement("comentario");
                comentariol.appendChild(doc.createTextNode(partidos.get(x).geteLocal().getComentario()));
                    equipol.appendChild(comentariol);
            Element puntuacionl= doc.createElement("puntuacion");
                puntuacionl.appendChild(doc.createTextNode(String.valueOf(partidos.get(x).getmLocal())));
                    equipol.appendChild(puntuacionl);
            
            //Equipo Visitante
            Element equipov= doc.createElement("equipo");
                equipov.setAttribute("id_equipo", String.valueOf(partidos.get(x).geteVisitante().getIdEquipo()));
                    partido.appendChild(equipov);
            Element nombrev= doc.createElement("nombre");
                nombrev.appendChild(doc.createTextNode(partidos.get(x).geteVisitante().getNombre()));
                    equipov.appendChild(nombrev);
            //hacer pruebas con esto; que pasa si se hace if? en algunos se crea y otros no? o da error??
            Element comentariov= doc.createElement("comentario");
                comentariov.appendChild(doc.createTextNode(partidos.get(x).geteVisitante().getComentario()));
                    equipov.appendChild(comentariov);
            Element puntuacionv= doc.createElement("puntuacion");
                puntuacionv.appendChild(doc.createTextNode(String.valueOf(partidos.get(x).getmVisitante())));
                    equipov.appendChild(puntuacionv);
        }
    }
    
    public void generarXML () throws TransformerConfigurationException, IOException, TransformerException{
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformador= factoria.newTransformer();
        
        Source source= new DOMSource(doc);
        File archivo = new File("ResultadoUltimaJornada.xml");
        FileWriter fw = new FileWriter(archivo);
        PrintWriter pw = new PrintWriter(fw);
        Result rs = new StreamResult(pw);
        
        transformador.transform(source, rs);
    }
    
    public String obtenerFecha (Calendar c){
        SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
        return ff.format(c.getTime());
    }
    
    public String obtenerHora (Calendar c){
        SimpleDateFormat ff = new SimpleDateFormat("hh24:mm");
        return ff.format(c.getTime());
    }
}
