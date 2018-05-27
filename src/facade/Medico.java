/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import database.ConexaoDB;
import database.MedicoDAO;
import java.sql.Connection;
import java.util.Date;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class Medico {
    private String Nome;
    private char Sexo;
    private int CRM;
    private String Nacionalidade;
    private Date DataNascimento;
    private Date DataAdmissao;
    private Date DataFormatura;
    
    public Medico(String nome, String sexo, String crm, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura) throws Exception
    {
        setNome(nome);
        setSexo(sexo);
        setCRM(crm);
        setNacionalidade(nacionalidade);
        setDataNascimento(dataNasc);
        setDataAdmissao(dataAdmissao);
        setDataFormatura(dataFormatura);
    }
    
    public String getNome() {
        return Nome;
    }

    public final void setNome(String Nome) throws Exception{
        int pos = utils.Utils.findSpecialChar(Nome);
        if(pos == -1)
            this.Nome = Nome;
        else
            throw new Exception("ERRO! Caracter '" + Nome.charAt(pos) + "' Invalido!");
    }

    public char getSexo() {
        return Sexo;
    }

    public final void setSexo(String Sexo) {
        this.Sexo = Sexo.charAt(0);
    }

    public int getCRM() {
        return CRM;
    }

    public final void setCRM(String CRM) throws Exception {
        try
        {
            this.CRM = Integer.parseInt(CRM);
            Connection conn = ConexaoDB.getConexaoMySQL();
            Medico m = MedicoDAO.consultarMedicoPorCRM(this.CRM, conn);
            if(m != null)
                throw new Exception("ERRO! CRM J� existente!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public final void setNacionalidade(String Nacionalidade) throws Exception {
        int pos = utils.Utils.findSpecialChar(Nacionalidade);
        if(pos == -1)
            this.Nacionalidade = Nacionalidade;
        else
            throw new Exception("ERRO! Caracter '" + Nacionalidade.charAt(pos) + "' Invalido!");
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public final void setDataNascimento(String DataNascimento) {
        this.DataNascimento = new Date(DataNascimento);
    }

    public Date getDataAdmissao() {
        return DataAdmissao;
    }

    public final void setDataAdmissao(String DataAdmissao) {
        this.DataAdmissao = new Date(DataAdmissao);
    }

    public Date getDataFormatura() {
        return DataFormatura;
    }

    public final void setDataFormatura(String DataFormatura) {
        this.DataFormatura = new Date(DataFormatura);
    }
    
}
