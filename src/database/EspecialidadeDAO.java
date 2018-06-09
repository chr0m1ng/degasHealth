/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tipos.Especialidade;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class EspecialidadeDAO {
    
    public static void InserirEspecialidade(Especialidade esp, Connection conn) throws Exception
    {
        String query;
        boolean flag = false;
        Especialidade espExistente = consultarEspecialidadePorCodigo(esp.getCodigo(), conn);
        if(espExistente != null)
            flag = true;
        espExistente = consultarEspecialidadePorDescricao(esp.getDescricao(), conn);
        if(espExistente != null)
            flag = true;
        
        if(!flag)
        {
            query = "INSERT INTO Especialidade (codigo, descricao) VALUES (?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, esp.getCodigo());
            preparedStmt.setString (2, esp.getDescricao());
 
            preparedStmt.execute();
        }
        else
            throw new Exception("Especialidade já cadastrada");
        
        
    }

    public static Especialidade consultarEspecialidadePorCodigo(int codigo, Connection conn) throws Exception
    {
        String query = "SELECT * FROM Especialidade WHERE codigo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            Especialidade esp = new Especialidade(rs.getString("codigo"), rs.getString("descricao"));
            rs.close();
            return esp;
        }
        return null;
    }
    
    public static Especialidade consultarEspecialidadePorDescricao(String descricao, Connection conn) throws Exception
    {
        String query = "SELECT * FROM Especialidade WHERE descricao = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, descricao);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            Especialidade esp = new Especialidade(rs.getString("codigo"), rs.getString("descricao"));
            rs.close();
            return esp;
        }
        return null;
    }
}
