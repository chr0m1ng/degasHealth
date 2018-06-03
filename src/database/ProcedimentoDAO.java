/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tipos.Procedimento;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class ProcedimentoDAO {
    public static void InserirProcedimento(Procedimento p, Connection conn) throws Exception
    {   
        if(consultarProcedimento("codigo", String.valueOf(p.getCodigo()), conn) != null)
            throw new Exception("Código de Procedimento Ja Cadastrado");
        else if(consultarProcedimento("descricao", p.getDescricao(), conn) != null)
            throw new Exception("Descrição de Procedimento Ja Cadastrado");
        else
        {
            String query = "INSERT INTO Procedimento (codigo, descricao, valor) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, p.getCodigo());
            preparedStmt.setString (2, p.getDescricao());
            preparedStmt.setDouble(3, p.getValor());

            preparedStmt.execute();
        }
    }
    
    public static Procedimento consultarProcedimento(String campo, String valor, Connection conn) throws Exception
    {
        String query = "SELECT * FROM Procedimento WHERE " + campo + " = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, valor);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
            return new Procedimento(rs.getString("codigo"), rs.getString("descricao"), rs.getString("valor").replace(".", ","));
        
        return null;
    }
    
    public static String alterarProcedimentoPorCodigo(int codigo, String campo, String novoValor, Connection conn) throws Exception
    {
        if(campo.equals("Descricao") && consultarProcedimento("descricao", campo, conn) != null)
            throw new Exception("Descrição de Procedimento Ja Cadastrado");
        
        String query = "UPDATE Procedimento SET " + campo + " = ? WHERE codigo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, novoValor);
        preparedStmt.setInt(2, codigo);
        preparedStmt.execute();
        return "Procedimento alterado com sucesso";
    }
}
