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
        
        res = facade.novoProcedimento("763236","Ponte de Safena","50000");
        assertEquals("Procedimento Incluido com Sucesso", res);
        
        res = facade.novoProcedimento("763236","Transplante Coração","90000");
        assertEquals("Código de Procedimento Ja Cadastrado", res);
    }
}
