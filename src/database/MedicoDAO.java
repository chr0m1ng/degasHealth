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
            conn.close();
        }
        catch(SQLException e)
        {
            throw new Exception(e.getMessage());
        }
    }
    
    public static Medico consultarMedicoPorCRM(int CRM, Connection conn) throws Exception
    {
        try 
        {
            String query = "SELECT * FROM Medico WHERE CRM = '" + CRM + "'";
            Statement st = conn.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                Medico m = new Medico(rs.getString("nome"), rs.getString("crm"), rs.getString("sexo"), rs.getString("nacionalidade"), rs.getString("dataNasc"), rs.getString("dataAdmiss"), rs.getString("dataFormatura"));
                rs.close();
                return m;
            }       
            else
                return null;
        } 
        catch (Exception e) 
        {
            throw new Exception(e.getMessage());
        }
    }
}
