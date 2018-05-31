/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import tipos.Medico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class MedicoTest {
    
    public MedicoTest() {
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
    public void testMedico() {
        Medico m;
        try 
        {
            m = new Medico("Nardelle Moraes","M","97719","Brasil","26/08/1977","29/06/2012","28/01/2007");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudine%  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudinei  R#drigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudinei  Rodrigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudine%  Rodrigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }   
        try
        {
            m = new Medico("Rudinei  R#drigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudinei  R@drig#es","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudinei  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Rudinei  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Ailton  Carvalho","M","9614","Brasil","26/07/1970","04/10/1999","02/11/1995");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Tarcila do Amaral","F","9614","Brasil","26/07/1970","04/10/1999","02/11/1995");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Larissa Pereira","F","36311","Brasil","22/01/1977","13/08/2005","07/11/1999");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Jonelice  Pinto","F","3566","Portugal","07/02/1989","28/9/2017","22/12/2012");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Alvaro Degas","M","3566","Brasil","05/06/1989","28/09/2017","22/12/2012");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/04/2013","05/07/2011");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","30/2/2013","05/07/2011");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/3/2011","05/07/2013");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            m = new Medico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/05/2013","05/07/2011");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
