package com.gerentes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gerentes.conexao.Conexao;


public class PessoaDao {
    
    public void cadastrarPessoa(PessoaPojo pessoaPojo) {

        Conexao conexao = new Conexao();

        String sql = "insert into pessoa(nome, endereco, idade) values (?, ?, ?)";

        PreparedStatement ps = null;
        
        try {
            ps = conexao.getConexao().prepareStatement(sql);
    
            ps.setString(1, pessoaPojo.getNome());
            ps.setString(2, pessoaPojo.getEndereco());
            ps.setInt(3, pessoaPojo.getIdade());
          
            ps.execute();
            ps.close();

            System.out.println("Dados inseridos com sucesso!");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu u3,m erro com os dados.");
        } 
    } 
    //Consultar
        public void consultarPessoa(PessoaPojo pessoaPojo) {

        Conexao conexao = new Conexao();

        String sql = "select nome, endereco, idade from pessoa where id = ?";

        PreparedStatement ps = null;
        
        ResultSet rs = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);


            rs = ps.executeQuery();

            while (rs.next()) {
                // Recuperar os dados do ResultSet
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                int idade = rs.getInt("idade");

                // Exibir os dados (ou processar como necessário)
                System.out.println("Nome: " + nome);
                System.out.println("Endereço: " + endereco);
                System.out.println("Idade: " + idade);
            } 

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao consultar os dados.");
        
      }
    }   public void alterarPessoa(PessoaPojo pessoaPojo) {

        Conexao conexao = new Conexao();

        String sql = "update pessoa set nome = ?, endereco = ?, idade = ? where id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
    
            ps.setString(1, pessoaPojo.getNome());
            ps.setString(2, pessoaPojo.getEndereco());
            ps.setInt(3, pessoaPojo.getIdade());
         
    
            int linhasAfetadas = ps.executeUpdate();
    
            if (linhasAfetadas > 0) {
                System.out.println("Dados da pessoa alterados com sucesso!");
            } else {
                System.out.println("Nenhuma pessoa encontrada para o ID fornecido.");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao alterar os dados da pessoa.");
 }
  
        }    public void removerPessoa(PessoaPojo pessoaPojo) {

            Conexao conexao = new Conexao();

            String sql = "delete from pessoa where id = ?";

            PreparedStatement ps = null;

             try {
                ps = conexao.getConexao().prepareStatement(sql);


                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Pessoa removida com sucesso!");
                } else {
                    System.out.println("Nenhuma pessoa encontrada para o ID fornecido.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um erro ao remover a pessoa.");

        }
}
}

