/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import UML.Equipo;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase para crear pruebas unitarias.
 * Fecha de creación de la clase: 18/05/2018
 * @author eqdaw04
 */

public class EmparejamientoTest {
    
    public EmparejamientoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularPartido method, of class Emparejamiento.
     */
    @Test
    public void testCalcularPartido() throws Exception {
        System.out.println("calcularPartido");
        Calendar fecha = null;
        int horaF = 0;
        Emparejamiento instance = new Emparejamiento();
        instance.calcularPartido(fecha, horaF);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarArray method, of class Emparejamiento.
     */
    @Test
    public void testLlenarArray() throws Exception {
        System.out.println("llenarArray");
        int j = 0;
        int p = 0;
        int e = 0;
        Emparejamiento instance = new Emparejamiento();
        instance.llenarArray(j, p, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarBBDD method, of class Emparejamiento.
     */
    @Test
    public void testInsertarBBDD() throws Exception {
        System.out.println("insertarBBDD");
        int e = 0;
        int horizontal = 0;
        Emparejamiento instance = new Emparejamiento();
        instance.insertarBBDD(e, horizontal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlJPEquipoL method, of class Emparejamiento.
     */
    @Test
    public void testGetlJPEquipoL() {
        System.out.println("getlJPEquipoL");
        Emparejamiento instance = new Emparejamiento();
        Equipo[][] expResult = null;
        Equipo[][] result = instance.getlJPEquipoL();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlJPEquipoL method, of class Emparejamiento.
     */
    @Test
    public void testSetlJPEquipoL() {
        System.out.println("setlJPEquipoL");
        Equipo[][] lJPEquipoL = null;
        Emparejamiento instance = new Emparejamiento();
        instance.setlJPEquipoL(lJPEquipoL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlJPEquipoV method, of class Emparejamiento.
     */
    @Test
    public void testGetlJPEquipoV() {
        System.out.println("getlJPEquipoV");
        Emparejamiento instance = new Emparejamiento();
        Equipo[][] expResult = null;
        Equipo[][] result = instance.getlJPEquipoV();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlJPEquipoV method, of class Emparejamiento.
     */
    @Test
    public void testSetlJPEquipoV() {
        System.out.println("setlJPEquipoV");
        Equipo[][] lJPEquipoV = null;
        Emparejamiento instance = new Emparejamiento();
        instance.setlJPEquipoV(lJPEquipoV);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDato method, of class Emparejamiento.
     */
    @Test
    public void testGetDato() {
        System.out.println("getDato");
        Emparejamiento instance = new Emparejamiento();
        String expResult = "";
        String result = instance.getDato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDato method, of class Emparejamiento.
     */
    @Test
    public void testSetDato() {
        System.out.println("setDato");
        String dato = "";
        Emparejamiento instance = new Emparejamiento();
        instance.setDato(dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
