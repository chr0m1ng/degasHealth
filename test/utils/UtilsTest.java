package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static utils.Utils.*;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class UtilsTest {
    
    public UtilsTest() {
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
    
    @Test
    public void testFindSpecialChar() 
    {
        int res;
        res = findSpecialChar("Rudinei Rodrigues");
        assertEquals(res, -1);
        res = findSpecialChar("Rudine%  Rodrigues");
        assertEquals(res, 6);
        res = findSpecialChar("s@stetest");
        assertEquals(res, 1);
    }
    
    @Test
    public void testValidateDate()
    {
        try {
            boolean res;
            
            res = validateDate("12/02/1984");
            assertEquals(res, true);
            res = validateDate("31/04/2013");
            assertEquals(res, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
