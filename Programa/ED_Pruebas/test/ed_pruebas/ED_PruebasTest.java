/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v6222
 */
public class ED_PruebasTest {
    
    public ED_PruebasTest() {
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
     * Test of main method, of class ED_Pruebas.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        //ED_Pruebas.main(args);
        
    }

    /**
     * Test of insertar method, of class ED_Pruebas.
     */
    @Test
    public void testInsertar() {
        //System.out.println("insertar");
        //String expResult = "son iguales";
        //String result = ED_Pruebas.insertar();
        //assertEquals(expResult, result);
    }

    /**
     * Test of calcular method, of class ED_Pruebas.
     */
    @Test
    public void testCalcular() {
        System.out.println("calcular");
        int x = 6;
        int y = 5;
        String expResult = "numero 2 es mayor que el numero 1";
        String result = ED_Pruebas.calcular(x, y);
        assertEquals(expResult, result);
    }
    
}
