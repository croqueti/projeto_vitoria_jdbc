package com.gerentes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gerentes.conexao.Conexao;


public class PessoaDao {
    

    //Inserir
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

            ps.setInt(1, pessoaPojo.getId());

            rs = ps.executeQuery();

            while (rs.next()) {
               
                pessoaPojo.setNome(rs.getString(1));    
                pessoaPojo.setEndereco(rs.getString(2));     
                pessoaPojo.setIdade(rs.getInt(3));
                
                // Exibir os dados (ou processar como necessário)
                //System.out.println("Nome: " + nome);
                //System.out.println("Endereço: " + endereco);
                //System.out.println("Idade: " + idade);
            } 
            System.out.println("Dados consultados com sucesso.");
            System.out.println(pessoaPojo.toString());


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ocorreu um erro ao consultar os dados.");
            
        }
    }   
    
    //Alterar
    public void alterarPessoa(PessoaPojo pessoaPojo) {

        Conexao conexao = new Conexao();

        String sql = "UPDATE pessoa SET nome = ?, endereco = ?, idade = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, pessoaPojo.getNome());
            ps.setString(2, pessoaPojo.getEndereco());
            ps.setInt(3, pessoaPojo.getIdade());
            ps.setInt(4, pessoaPojo.getId());
     
            ps.execute();
            ps.close();
            System.out.println("Dados da pessoa alterados com sucesso!");
    
    
            } catch (SQLException e) {
            e.printStackTrace();
                System.out.println("Ocorreu um erro ao alterar os dados da pessoa.");
            }
  
    }    
        
        
        
    //Remover  
    public void removerPessoa(PessoaPojo pessoaPojo) {

            Conexao conexao = new Conexao();

            String sql = "delete from pessoa where id = ?";

            PreparedStatement ps = null;

             try {
                ps = conexao.getConexao().prepareStatement(sql);


                ps.setInt(1, pessoaPojo.getId());

                ps.execute();
                ps.close();
    
                System.out.println("Dados deletados com sucesso!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

}
}
