/**
 * Clase de creación del parser DOM Clasificación, en el que guardamos una lista de equipos con su puntuación global y puntuación.
 * Fecha de creación de la clase: 19/05/2018
 * @author eqdaw04
 * 
 */
package Parsers;

import Controladora.Main;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DOM_Clasificacion {
    Document dom;
    
    public DOM_Clasificacion() throws Exception{
        crearDocumento();
    }

    public void ejecutar(String fecha) throws Exception{
        crearDOM(fecha);
        crearXML();
    }
    
    private void crearDocumento() throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        dom = db.newDocument();
    }
    
    private void crearDOM(String fecha) throws Exception{
    
        Element rootEle = dom.createElement("clasificacion");
        dom.appendChild(rootEle);
        
        Element fechaExp = dom.createElement("fecha_expiracion");
        Text fe = dom.createTextNode(fecha);
        fechaExp.appendChild(fe);
        rootEle.appendChild(fechaExp);
        
        Iterator it = Main.resultados().iterator();
        while (it.hasNext()) {
            Object b[] = (Object[]) it.next();
            Element aEle = crearEquipo(b);
            rootEle.appendChild(aEle);
        }
    }
    
    private Element crearEquipo(Object eq[]) {

        Element aEle = dom.createElement("equipo");
        aEle.setAttribute("id_equipo", eq[0].toString());

        Element nomEle = dom.createElement("Nombre");
        Text nomT = dom.createTextNode(eq[1].toString());
        nomEle.appendChild(nomT);
        aEle.appendChild(nomEle);

        Element pEle = dom.createElement("puntuacion");
        Text pe = dom.createTextNode(eq[2].toString());
        pEle.appendChild(pe);
        aEle.appendChild(pEle);

        return aEle;

    }

    private void crearXML() throws Exception{
        OutputFormat format = new OutputFormat(dom);
        format.setIndenting(true);
        XMLSerializer serializer;
        serializer = new XMLSerializer(new FileOutputStream(new File("xml/XML-Clasificacion.xml")), format);
        serializer.serialize(dom);
    }

}