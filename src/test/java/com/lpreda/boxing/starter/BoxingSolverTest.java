package com.lpreda.boxing.starter;

import com.lpreda.boxing.exception.ApplicationException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Case for BoxingSolver class
 * 
 * @author lrpre
 */
public class BoxingSolverTest {

    public BoxingSolverTest() {
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
     * Test of correctAnswer method, of class BoxingSolver.
     * @throws com.lpreda.boxing.exception.ApplicationException
     */
    @Test
    public void testCorrectAnswer() throws ApplicationException {
        System.out.println("correctAnswer");
        String fruitOpt = "1";
        String labelOpt = "3";
        BoxingSolver instance = new BoxingSolver();
        HashMap<String, String> expResult = new HashMap();
        expResult.put("1", "Apple");
        expResult.put("2", "Apple & Orange");
        expResult.put("3", "Orange");
        HashMap<String, String> result = instance.correctAnswer(fruitOpt, labelOpt);
        assertEquals(expResult, result);
    }

    /**
     * Test of correctAnswer method, of class BoxingSolver.
     * @throws com.lpreda.boxing.exception.ApplicationException
     */
    @Test
    public void testIncorrectCorrectAnswer() throws ApplicationException {
        System.out.println("correctAnswer");
        String fruitOpt = "1";
        String labelOpt = "1";
        BoxingSolver instance = new BoxingSolver();
        HashMap<String, String> expResult = new HashMap();
        expResult.put("1", "Apple");
        expResult.put("2", "Apple & Orange");
        expResult.put("3", "Orange");
        HashMap<String, String> result = instance.correctAnswer(fruitOpt, labelOpt);
        assertNotEquals(expResult, result);
    }

}
