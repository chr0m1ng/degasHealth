/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import facade.Medico;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class MedicoDAO 
{
    public static void InserirMedico(Medico m, Connection conn) throws Exception
    {
        try
        {
            if(consultarMedicoPorCRM(m.getCRM(), conn) == null)
            {
                String query = "insert into Medico (nome, crm, sexo, nacionalidade, dataNasc, dataAdmiss, dataFormatura) values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, m.getNome());
                preparedStmt.setInt    (2, m.getCRM());
                preparedStmt.setString (3, String.valueOf(m.getSexo()));
                preparedStmt.setString (4, m.getNacionalidade());
                preparedStmt.setDate   (5, new java.sql.Date(m.getDataNascimento().getTime()));
                preparedStmt.setDate   (6, new java.sql.Date(m.getDataAdmissao().getTime()));
                preparedStmt.setDate   (7, new java.sql.Date(m.getDataFormatura().getTime()));

                preparedStmt.execute();
            }
            else
                throw new Exception("ERRO! CRM J� existente!");
        }
        catch(SQLException e)
        {
            throw e;
        }
    }
    
    public static Medico consultarMedicoPorCRM(int CRM, Connection conn) throws Exception
    {
        try 
        {
            String query = "SELECT id, nome, crm, sexo, nacionalidade, DATE_FORMAT(dataNasc,'%d/%m/%Y') AS dataNasc, DATE_FORMAT(dataAdmiss,'%d/%m/%Y') AS dataAdmiss, DATE_FORMAT(dataFormatura,'%d/%m/%Y') AS dataFormatura FROM Medico WHERE crm = '" + CRM + "'";
            Statement st = conn.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                Medico m = new Medico(rs.getString("nome"), rs.getString("sexo"), rs.getString("crm"), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                rs.close();
                return m;
            }       
            else
                return null;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public static Medico consultarMedicoPorNome(String nome, Connection conn) throws Exception
    {
        try 
        {
            String query = "SELECT id, nome, crm, sexo, nacionalidade, DATE_FORMAT(dataNasc,'%d/%m/%Y') AS dataNasc, DATE_FORMAT(dataAdmiss,'%d/%m/%Y') AS dataAdmiss, DATE_FORMAT(dataFormatura,'%d/%m/%Y') AS dataFormatura FROM Medico WHERE nome = '" + nome + "'";
            Statement st = conn.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                Medico m = new Medico(rs.getString("nome"), rs.getString("sexo"), rs.getString("crm"), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                rs.close();
                return m;
            }       
            else
                return null;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
