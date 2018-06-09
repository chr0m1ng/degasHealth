/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tipos.Equipamento;
import tipos.Material;
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
    
    public static int obterIdDBProcedimentoPorCodigo(int codigo, Connection conn) throws Exception
    {
        String query = "SELECT id FROM Procedimento WHERE codigo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        if(rs.next())
            return rs.getInt("id");
        else
            throw new Exception("Codigo de Procedimento não Existe");
    }

    public static void inserirMaterialEmProcedimento(String codigoProcedimento, String codigoMaterial, Connection conn) throws Exception
    {
        String query;
        Material matExistente = MaterialDAO.consultarMaterialPorCodigo(Integer.valueOf(codigoMaterial), conn);
        Procedimento pExistente = consultarProcedimento("codigo", codigoProcedimento, conn);
        ArrayList<Material> matsExistentesEmP = consultarMateriaisEmProcedimento(Integer.valueOf(codigoProcedimento), conn);
        
        if(matExistente == null)
            throw new Exception("Erro: Material não existe");
        else if(pExistente == null)
            throw new Exception("Erro: Procedimento não existente");
        
        for(Material mat: matsExistentesEmP)
            if(mat.getCodigo() == Integer.valueOf(codigoMaterial))
                throw new Exception("Erro: Material já foi adicionado");
        
        query = "INSERT INTO MaterialProcedimento (id_material, id_procedimento, codigoProcedimento, codigoMaterial) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, MaterialDAO.obterIdDBMaterialPorCodigo(matExistente.getCodigo(), conn));
        preparedStmt.setInt(2, obterIdDBProcedimentoPorCodigo(pExistente.getCodigo(), conn));
        preparedStmt.setInt(3, pExistente.getCodigo());
        preparedStmt.setInt(4, matExistente.getCodigo());

        preparedStmt.execute();
            
    }
    
    public static ArrayList<Material> consultarMateriaisEmProcedimento(int codigo, Connection conn) throws Exception
    {
        ArrayList<Material> materiais = new ArrayList();
        
        String query = "SELECT Material.* FROM Material INNER JOIN MaterialProcedimento MP ON Material.id = MP.id_material WHERE codigoProcedimento = ? ORDER BY MP.id";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        while(rs.next())
            materiais.add(new Material(rs.getString("codigo"), rs.getString("descricao"), rs.getString("valor")));
        
        return materiais;
    }
    
    public static void inserirEquipamentoEmProcedimento(String codigoProcedimento, String codigoEquipamento, Connection conn) throws Exception
    {
        String query;
        Equipamento eqExistente = EquipamentoDAO.consultarEquipamentoPorCodigo(Integer.valueOf(codigoEquipamento), conn);
        Procedimento pExistente = consultarProcedimento("codigo", codigoProcedimento, conn);
        ArrayList<Equipamento> eqExistentesEmP = consultarEquipamentosEmProcedimento(Integer.valueOf(codigoProcedimento), conn);
        
        if(eqExistente == null)
            throw new Exception("Erro: Equipamento não existe");
        else if(pExistente == null)
            throw new Exception("Erro: Procedimento não existente");
        
        for(Equipamento eq: eqExistentesEmP)
            if(eq.getCodigo() == Integer.valueOf(codigoEquipamento))
                throw new Exception("Erro: Material já foi adicionado");
        
        query = "INSERT INTO EquipamentoProcedimento (id_equipamento, id_procedimento, codigoProcedimento, codigoEquipamento) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, EquipamentoDAO.obterIdDBEquipamentoPorCodigo(eqExistente.getCodigo(), conn));
        preparedStmt.setInt(2, obterIdDBProcedimentoPorCodigo(pExistente.getCodigo(), conn));
        preparedStmt.setInt(3, pExistente.getCodigo());
        preparedStmt.setInt(4, eqExistente.getCodigo());

        preparedStmt.execute();
            
    }
    
    public static ArrayList<Equipamento> consultarEquipamentosEmProcedimento(int codigo, Connection conn) throws Exception
    {
        ArrayList<Equipamento> equipamentos = new ArrayList();
        
        String query = "SELECT Equipamento.* FROM Equipamento INNER JOIN EquipamentoProcedimento E ON Equipamento.id = E.id_equipamento WHERE codigoProcedimento = ? ORDER BY E.id";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, codigo);
        
        ResultSet rs = preparedStmt.executeQuery();
        
        while(rs.next())
            equipamentos.add(new Equipamento(rs.getString("codigo"), rs.getString("descricao"), rs.getString("valor")));
        
        return equipamentos;
    }
}
