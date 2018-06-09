/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class Main {
    public static void main (String argv[])
    {
        Facade facade = new Facade();
        String res;
        
        res = facade.materialProcedimento("763236","5927"); // Ponte de Safena consome Stinter card�aco
        assertEquals("Material Incluido com sucesso no procedimento", res);

    }
}
