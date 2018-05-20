/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */
public class preuba extends DefaultHandler{

    public preuba() throws ParserConfigurationException, SAXException {
        SAXParserFactory factoria= SAXParserFactory.newInstance();
        SAXParser saxParser = factoria.newSAXParser();
        File file= new File("ResultadoUltimaJornada.xml");
        
        saxParser.parse(f, dh);
    }
    
}
