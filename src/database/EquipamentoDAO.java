/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tipos.Equipamento;
import tipos.Tombo;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class EquipamentoDAO {

    public static void InserirEquipamento(Equipamento eqp, Connection conn) throws Exception {
        String query;
        
        Equipamento eqpExistente = consultarEquipamentoPorCodigo(eqp.getCodigo(), conn);
        
        if(eqpExistente == null)
        {
            query = "INSERT INTO Equipamento (codigo, descricao, valor) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, eqp.getCodigo());
            preparedStmt.setString(2, eqp.getDescricao());
            preparedStmt.setDouble(3, eqp.getValor());
            
            preparedStmt.execute();
        }
        else
            throw new Exception("Equipamento já cadastrado");
    }

    public static Equipamento consultarEquipamentoPorCodigo(int codigo, Connection conn) throws Exception
    {
        String query = "SELECT * FROM Equipamento WHERE codigo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            Equipamento eqp = new Equipamento(rs.getString("codigo"), rs.getString("descricao"), rs.getString("valor"));
            rs.close();
            return eqp;
        }
        return null;
    }

    public static void inserirTombo(Tombo t, Connection conn) throws Exception {
        String query;
        Equipamento eqpExistente = consultarEquipamentoPorCodigo(t.getCodigoEquipamento(), conn);
        Tombo tExistente = consultarTomboPorCodigoTombo(t.getCodigoTombo(), conn);

        if(eqpExistente == null)
            throw new Exception("Erro: Equipamento não existe");
        else if(tExistente != null)
            throw new Exception("Erro: Tombo já existente");
        else
        {
            query = "INSERT INTO Tombo (codigoEquipamento, codigoTombo) VALUES (?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, t.getCodigoEquipamento());
            preparedStmt.setString(2, t.getCodigoTombo());
            
            preparedStmt.execute();
        }
            
    }

    public static Tombo consultarTomboPorCodigoTombo(String codigoTombo, Connection conn) throws Exception {
        String query = "SELECT * FROM Tombo WHERE codigoTombo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, codigoTombo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
        {
            Tombo t = new Tombo(rs.getString("codigoEquipamento"), rs.getString("codigoTombo"));
            rs.close();
            return t;
        }
        return null;
    }
    
    public static int obterIdDBEquipamentoPorCodigo(int codigo, Connection conn) throws Exception
    {
        String query = "SELECT id FROM Equipamento WHERE codigo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
            return rs.getInt("id");
        else
            throw new Exception("Codigo de Equipamento não Existe");
    }
    
}
