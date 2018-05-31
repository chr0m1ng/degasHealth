/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos;

import java.util.Date;
import static utils.Utils.createDateFromString;
import static utils.Utils.formatDateBR;
import static utils.Utils.validateDate;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class Funcionario {
    private String Nome;
    private char Sexo;
    private String Nacionalidade;
    private Date DataNascimento;
    private Date DataAdmissao;
    private Date DataFormatura;
    private String tipoCodigo;
    private int codigo;
    private String tipoFuncionario;
    
    public Funcionario()
    {
    }
    
    public Funcionario(String nome, String sexo, String nacionalidade, String dataNasc, String dataAdmissao, String dataFormatura, String tipoCodigo, int codigo, String tipoFuncionario) throws Exception
    {
        setNome(nome);
        setSexo(sexo);
        setNacionalidade(nacionalidade);
        setDataNascimento(dataNasc);
        setDataAdmissao(dataAdmissao);
        setDataFormatura(dataFormatura);
        setTipoCodigo(tipoCodigo);
        setCodigo(codigo);
        setTipoFuncionario(tipoFuncionario);
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

    public final void setDataNascimento(String DataNascimento) throws Exception {
        if(validateDate(DataNascimento))
        {
            this.DataNascimento = createDateFromString(DataNascimento);
        }
            
        else
            throw new Exception("ERRO! Data Inválida!");
    }

    public Date getDataAdmissao() {
        return DataAdmissao;
    }

    public final void setDataAdmissao(String DataAdmissao) throws Exception {
        if(validateDate(DataAdmissao))
            this.DataAdmissao = createDateFromString(DataAdmissao);
        else
            throw new Exception("ERRO! Data Inválida!");
        if(getDataFormatura() != null && getDataFormatura().after(getDataAdmissao()))
            throw new Exception("ERRO! Inconsistencia de datas: Formatura posterior a admissão!");
    }

    public Date getDataFormatura() {
        return DataFormatura;
    }

    public final void setDataFormatura(String DataFormatura) throws Exception {
        if(validateDate(DataFormatura))
            this.DataFormatura = createDateFromString(DataFormatura);
        else
            throw new Exception("ERRO! Data Inválida!");
        if(getDataFormatura().after(getDataAdmissao()))
            throw new Exception("ERRO! Inconsistencia de datas: Formatura posterior a admissão!");
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public final void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public final void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public final void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    @Override
    public String toString()
    {
        return getNome() + "%" + getSexo() + "%" + getCodigo()+ "%" + getNacionalidade() + "%" + formatDateBR(getDataNascimento()) + "%" + formatDateBR(getDataAdmissao()) + "%" + formatDateBR(getDataFormatura());
    }
}
