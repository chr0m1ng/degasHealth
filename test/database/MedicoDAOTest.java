/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import facade.Medico;
import java.sql.Connection;
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
public class MedicoDAOTest {
    
    public MedicoDAOTest() {
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

//    @Test
//    public void testInserirMedico() 
//    {
//        try 
//        {
//            Connection conn = ConexaoDB.getConexaoMySQL();
//            Medico m = new Medico("Nardelle Moraes","M","97719","Brasil","26/08/1977","29/06/2012","28/01/2007");
//            MedicoDAO.InserirMedico(m, conn);
//        } 
//        catch (Exception e) 
//        {
//            System.out.println(e.getMessage());
//        }
//    }
    
    @Test
    public void testConsultarMedicoPorCRM()
    {
        try
        {
            Medico m;
            Connection conn = ConexaoDB.getConexaoMySQL();
            m = MedicoDAO.consultarMedicoPorCRM(97719, conn);
            assertEquals(m == null, false);
            m = MedicoDAO.consultarMedicoPorCRM(46193, conn);
            assertEquals(m == null, false);
            m = MedicoDAO.consultarMedicoPorCRM(0, conn);
            assertEquals(m == null, true);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
