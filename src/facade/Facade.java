/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import tipos.*;
import database.*;
import java.sql.Connection;
import static utils.Utils.*;

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
            FuncionarioDAO.InserirFuncionario(m,conn);
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return "Medico inserido!";
    }
    
    public String encontraMedico(String pesquisa)
    {
        try 
        {
            Medico m;
            Connection conn = ConexaoDB.getConexaoMySQL();
            if(isStringInteger(pesquisa))
                m = (Medico) FuncionarioDAO.consultarFuncionarioPorCodigo(Integer.parseInt(pesquisa), conn, "Medico", "CRM");
            else
                m = (Medico) FuncionarioDAO.consultarFuncionarioPorNome(pesquisa, conn, "Medico", "CRM");
            return m.toString();
        } 
        catch (Exception ex) 
        {
            return null;
        }
    }
    
    public String alteraMedico(String crm, String campo, String novoValor)
    {
        String res = null;
        try 
        {
            if(isDadosValidosFuncionario(Integer.parseInt(crm), campo, novoValor, "Medico", "CRM")) 
            {
                try
                {
                    Connection conn = ConexaoDB.getConexaoMySQL();
                    res = FuncionarioDAO.alterarFuncionarPorCodigo(Integer.parseInt(crm), campo, novoValor, conn, "Medico", "CRM");
                    return res;
                }
                catch (Exception ex)
                {
                    System.out.println("facade.Facade.alteraMedico() " + ex.getMessage());
                }
            }
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
        return res;
    }
    
    public String novoEnfermeiro(String nome, String sexo, String coren, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura)
    {
        try
        {
            Enfermeiro e = new Enfermeiro(nome, sexo, coren, nacionalidade, dataNasc, dataAdmissao, dataFormatura);
            Connection conn = ConexaoDB.getConexaoMySQL();
            FuncionarioDAO.InserirFuncionario(e, conn);
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
        return "Enfermeiro inserido!";
    }
    
    public String encontraEnfermeiro(String pesquisa)
    {
        try 
        {
            Enfermeiro e;
            Connection conn = ConexaoDB.getConexaoMySQL();
            if(isStringInteger(pesquisa))
                e = (Enfermeiro) FuncionarioDAO.consultarFuncionarioPorCodigo(Integer.parseInt(pesquisa), conn, "Enfermeiro", "COREN");
            else
                e = (Enfermeiro) FuncionarioDAO.consultarFuncionarioPorNome(pesquisa, conn, "Enfermeiro", "COREN");
            return e.toString();
        } 
        catch (Exception ex) 
        {
            return null;
        }
    }
    
    public String alteraEnfermeiro(String coren, String campo, String novoValor)
    {
        String res = null;
        try 
        {
            if(isDadosValidosFuncionario(Integer.parseInt(coren), campo, novoValor, "Enfermeiro", "COREN")) 
            {
                try
                {
                    Connection conn = ConexaoDB.getConexaoMySQL();
                    res = FuncionarioDAO.alterarFuncionarPorCodigo(Integer.parseInt(coren), campo, novoValor, conn, "Enfermeiro", "COREN");
                    return res;
                }
                catch (Exception ex)
                {
                    System.out.println("facade.Facade.alteraEnfermeiro() " + ex.getMessage());
                }
            }
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
        return res;
    }
    
    public String novoAuxiliar(String nome, String sexo, String coren, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura)
    {
        try
        {
            Auxiliar a = new Auxiliar(nome, sexo, coren, nacionalidade, dataNasc, dataAdmissao, dataFormatura);
            Connection conn = ConexaoDB.getConexaoMySQL();
            FuncionarioDAO.InserirFuncionario(a, conn);
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
        return "Auxiliar/Técnico inserido!";
    }
    
    public String encontraAuxiliar(String pesquisa)
    {
        try 
        {
            Auxiliar a;
            Connection conn = ConexaoDB.getConexaoMySQL();
            if(isStringInteger(pesquisa))
                a = (Auxiliar) FuncionarioDAO.consultarFuncionarioPorCodigo(Integer.parseInt(pesquisa), conn, "Auxiliar", "COREN");
            else
                a = (Auxiliar) FuncionarioDAO.consultarFuncionarioPorNome(pesquisa, conn, "Auxiliar", "COREN");
            return a.toString();
        } 
        catch (Exception ex) 
        {
            return null;
        }
    }
    
    public String alteraAuxiliar(String coren, String campo, String novoValor)
    {
        String res = null;
        try 
        {
            if(isDadosValidosFuncionario(Integer.parseInt(coren), campo, novoValor, "Auxiliar", "COREN")) 
            {
                try
                {
                    Connection conn = ConexaoDB.getConexaoMySQL();
                    res = FuncionarioDAO.alterarFuncionarPorCodigo(Integer.parseInt(coren), campo, novoValor, conn, "Auxiliar", "COREN");
                    return res;
                }
                catch (Exception ex)
                {
                    System.out.println("facade.Facade.alteraAuxiliar() " + ex.getMessage());
                }
            }
        } 
        catch (Exception ex) 
        {
            return ex.getMessage();
        }
        return res;
    }

    private boolean isDadosValidosFuncionario(int codigo, String campo, String novoValor, String tipoFuncionario, String tipoCodigo) throws Exception 
    {
        try 
        {
            if(campo.equals("DtNasc") || campo.equals("DtAdmiss") || campo.equals("DtFormatura"))
            {                                
                Connection conn = ConexaoDB.getConexaoMySQL();
                Funcionario fTest = FuncionarioDAO.consultarFuncionarioPorCodigo(codigo, conn, tipoFuncionario, tipoCodigo);

                switch (campo) 
                {
                    case "DtNasc":
                        fTest.setDataNascimento(novoValor);
                        break;
                    case "DtAdmiss":
                        fTest.setDataAdmissao(novoValor);
                        break;
                    default:
                        fTest.setDataFormatura(novoValor);
                        break;
                }
            }
            return true;
        }
        catch (Exception ex) 
        {
            throw ex;
        }
    }
}
