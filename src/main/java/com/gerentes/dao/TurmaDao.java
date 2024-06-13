package com.gerentes.dao;
import java.sql.PreparedStatement;
import com.gerentes.conexao.Conexao;




public class TurmaDao {
    
    public void cadastrarTurma(TurmaPojo TurmaPojo) {

        Conexao conexao = new Conexao();

        String sql = "insert into turma(id, capacidade, horario) values (?, ?, ?)";

        PreparedStatement ps = null;
        
        try {
            ps = conexao.getConexao().prepareStatement(sql);
    
            ps.setInt(1, TurmaPojo.getId());
            ps.setInt(2, TurmaPojo.getCapacidade());
            ps.setInt(3, TurmaPojo.getHorario());
          
            ps.execute();
            ps.close();

            System.out.println("Dados inseridos com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro com os dados.");
        }
    } 
}