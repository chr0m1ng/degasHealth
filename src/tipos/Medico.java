/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos;


/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class Medico extends Funcionario{
    
    public Medico()
    {
        super();
    }
    
    public Medico(String nome, String sexo, String crm, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura) throws Exception
    {
        super(nome, sexo, nacionalidade, dataNasc, dataAdmissao, dataFormatura, "CRM", Integer.parseInt(crm), "Medico");
    }
    
}