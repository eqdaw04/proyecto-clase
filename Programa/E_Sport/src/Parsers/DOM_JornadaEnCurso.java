/**
 * Clase de creación del parser DOM donde guardaremos los equipos que juegan en la jornada actual de la liga.
 * Fecha de creación de la clase: 19/05/2018
 * @author eqdaw04
 */
package Parsers;

import UML.Partido;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author usuario
 */
public class DOM_JornadaEnCurso {
    private Document doc;
    
    public DOM_JornadaEnCurso() throws Exception {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        doc = builder.newDocument();  
        
    }
    
    public void xmlUltJor (ArrayList <Partido> partidos,int j, String fechas) throws Exception{
        generarDocumento (partidos,j, fechas);
        generarXML();
    }
    public void generarDocumento (ArrayList <Partido> partidos,int j, String fechas){
        Element jornada= doc.createElement("jornada");
        jornada.setAttribute("Id_jornada", String.valueOf(j));
        doc.appendChild(jornada);                 
                    
        Element fechaExp = doc.createElement("fecha_expiracion");
        fechaExp.appendChild(doc.createTextNode(fechas));
        jornada.appendChild(fechaExp);
        
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
            Element comentariol= doc.createElement("comentario");
                comentariol.appendChild(doc.createTextNode(partidos.get(x).geteLocal().getComentario()));
                    equipol.appendChild(comentariol);
            Element puntuacionl= doc.createElement("puntuacion");
                puntuacionl.appendChild(doc.createTextNode(String.valueOf(partidos.get(x).getmLocal())));
                    equipol.appendChild(puntuacionl);
            Element visitantel= doc.createElement("visitante");
                visitantel.appendChild(doc.createTextNode("false"));
                    equipol.appendChild(visitantel);
            
            //Equipo Visitante
            Element equipov= doc.createElement("equipo");
                equipov.setAttribute("id_equipo", String.valueOf(partidos.get(x).geteVisitante().getIdEquipo()));
                    partido.appendChild(equipov);
            Element nombrev= doc.createElement("nombre");
                nombrev.appendChild(doc.createTextNode(partidos.get(x).geteVisitante().getNombre()));
                    equipov.appendChild(nombrev);
            Element comentariov= doc.createElement("comentario");
                comentariov.appendChild(doc.createTextNode(partidos.get(x).geteVisitante().getComentario()));
                    equipov.appendChild(comentariov);
            Element puntuacionv= doc.createElement("puntuacion");
                puntuacionv.appendChild(doc.createTextNode(String.valueOf(partidos.get(x).getmVisitante())));
                    equipov.appendChild(puntuacionv);
           Element visitantev= doc.createElement("visitante");
                visitantev.appendChild(doc.createTextNode("true"));
                    equipov.appendChild(visitantev);
    }   }
    
    public void generarXML () throws Exception{
        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);
        XMLSerializer serializer;
        serializer = new XMLSerializer(new FileOutputStream(new File("xml/JornadaEnCurso.xml")), format);
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
