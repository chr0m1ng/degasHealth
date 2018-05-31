/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import tipos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static utils.Utils.createDateFromString;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class FuncionarioDAO {
    
    public static void InserirFuncionario(Funcionario f, Connection conn) throws Exception
    {
        String query;
        Funcionario fExistente = consultarFuncionarioPorCodigo(f.getCodigo(), conn, f.getTipoFuncionario(), f.getTipoCodigo());
        
        if(fExistente == null)
        {
            query = "INSERT INTO " + f.getTipoFuncionario() + "(nome, sexo," + f.getTipoCodigo() + ", nacionalidade, dtNasc, dtAdmiss, dtFormatura) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, f.getNome());
            preparedStmt.setString (2, String.valueOf(f.getSexo()));
            preparedStmt.setInt    (3, f.getCodigo());
            preparedStmt.setString (4, f.getNacionalidade());
            preparedStmt.setDate   (5, new java.sql.Date(f.getDataNascimento().getTime()));
            preparedStmt.setDate   (6, new java.sql.Date(f.getDataAdmissao().getTime()));
            preparedStmt.setDate   (7, new java.sql.Date(f.getDataFormatura().getTime()));
 
            preparedStmt.execute();
        }
        else
            throw new Exception("ERRO! " + f.getTipoCodigo().toUpperCase() + " Já existente!");
        
        
    }
    
    public static Funcionario consultarFuncionarioPorCodigo(int codigo, Connection conn, String tipoFuncionario, String tipoCodigo) throws Exception
    {
        String query;

        query = "SELECT id, nome," + tipoCodigo + ", sexo, nacionalidade, DATE_FORMAT(dtNasc,'%d/%m/%Y') AS dataNasc, DATE_FORMAT(dtAdmiss,'%d/%m/%Y') AS dataAdmiss, DATE_FORMAT(dtFormatura,'%d/%m/%Y') AS dataFormatura FROM " + tipoFuncionario + " WHERE " + tipoCodigo + " = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            switch(tipoFuncionario)
            {
                case "Medico":
                    Medico m = new Medico(rs.getString("nome"), rs.getString("sexo"), rs.getString(tipoCodigo.toLowerCase()), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return m;
                case "Enfermeiro":
                    Enfermeiro e = new Enfermeiro(rs.getString("nome"), rs.getString("sexo"), rs.getString(tipoCodigo.toLowerCase()), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return e;
                case "Auxiliar":
                    Auxiliar a = new Auxiliar(rs.getString("nome"), rs.getString("sexo"), rs.getString(tipoCodigo.toLowerCase()), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return a;
                default:
                    break;
            }
        }
        
        return null;
    }
    
    public static Funcionario consultarFuncionarioPorNome(String nome, Connection conn, String tipoFuncionario, String tipoCodigo) throws Exception
    {
        String query;
        
        query = "SELECT id, nome," + tipoCodigo + ", sexo, nacionalidade, DATE_FORMAT(dtNasc,'%d/%m/%Y') AS dataNasc, DATE_FORMAT(dtAdmiss,'%d/%m/%Y') AS dataAdmiss, DATE_FORMAT(dtFormatura,'%d/%m/%Y') AS dataFormatura FROM " + tipoFuncionario + " WHERE nome = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, nome);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            switch(tipoFuncionario)
            {
                case "Medico":
                    Medico m = new Medico(rs.getString("nome"), rs.getString("sexo"), rs.getString("crm"), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return m;
                case "Enfermeiro":
                    Enfermeiro e = new Enfermeiro(rs.getString("nome"), rs.getString("sexo"), rs.getString("coren"), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return e;
                case "Auxiliar":
                    Auxiliar a = new Auxiliar(rs.getString("nome"), rs.getString("sexo"), rs.getString(tipoCodigo.toLowerCase()), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                    rs.close();
                    return a;
                default:
                    break;
            }
        }
        
        return null;
    }
    
    
    public static String alterarFuncionarPorCodigo(int codigo, String campo, String valor, Connection conn, String tipoFuncionario, String tipoCodigo) throws Exception
    {
        String query;
        
        query = "UPDATE " + tipoFuncionario + " SET " + campo + " = ?  WHERE " + tipoCodigo + " = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        if(campo.equals("DtNasc") || campo.equals("DtAdmiss") || campo.equals("DtFormatura"))
            preparedStmt.setDate(1, new java.sql.Date(createDateFromString(valor).getTime()));
        else
            preparedStmt.setString(1, valor);
        preparedStmt.setInt(2, codigo);
        preparedStmt.execute();
        return "Alteracao executada com sucesso!";
    }
}
