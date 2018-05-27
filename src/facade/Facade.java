/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import database.ConexaoDB;
import database.MedicoDAO;
import java.sql.Connection;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */

public class Facade {
    
    public String novoMedico(String nome, String sexo, String crm, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura)
    {
        try
        {
            Medico m = new Medico(nome, sexo, crm, nacionalidade, dataNasc, dataAdmissao, dataFormatura);
            Connection conn = ConexaoDB.getConexaoMySQL();
            MedicoDAO.InserirMedico(m,conn);
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return "Medico inserido!";
    }
}
