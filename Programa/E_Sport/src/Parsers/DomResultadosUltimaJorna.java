/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DomResultadosUltimaJorna {
    private Document doc;

    public DomResultadosUltimaJorna() throws ParserConfigurationException {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        doc = builder.newDocument();  
    }
    
    public void generarDocumento (){
        Element partido= doc.createElement("partido");
        partido.setAttribute("id_partido", value);
        doc.appendChild(partido);       
        
        Element fecha= doc.createElement("fecha");
        fecha.appendChild(doc.createTextNode(data));
        partido.appendChild(fecha);
        Element hora= doc.createElement("hora");
        hora.appendChild(doc.createTextNode(data));
        partido.appendChild(hora);
        Element lugar= doc.createElement("lugar");
        lugar.appendChild(doc.createTextNode(data));
        partido.appendChild(lugar);
        Element equipo= doc.createElement("equipo");
        equipo.setAttribute("id_equipo", value);
        partido.appendChild(equipo);
        
        
        Element nombre= doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode(data));
        equipo.appendChild(nombre);
        Element comentario= doc.createElement("comentario");
        comentario.appendChild(doc.createTextNode(data));
        equipo.appendChild(comentario);
        Element puntuacion= doc.createElement("puntuacion");
        puntuacion.appendChild(doc.createTextNode(data));
        equipo.appendChild(puntuacion);
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
}
