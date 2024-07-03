package com.gerentes;


import com.gerentes.dao.PessoaDao;
import com.gerentes.dao.PessoaPojo;
import com.gerentes.modelo.Pessoa;

public class App {
    public static void main( String[] args )
    {
     
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Norberto");
        pessoa.setIdade(49);
        pessoa.setEndereco("Brasil, Cascavel, Paraná");
        
        PessoaPojo pessoaPojo = new PessoaPojo();
        pessoaPojo.setNome(pessoa.getNome());
        pessoaPojo.setIdade(pessoa.getIdade());
        pessoaPojo.setEndereco(pessoa.getEndereco());
        pessoaPojo.setId(7);


       /*
        //Cadastrar
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.cadastrarPessoa(pessoaPojo);
        */

        /* 
        //Alterar
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.alterarPessoa(pessoaPojo);
        */


        
        //Consultar
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.consultarPessoa(pessoaPojo);
        
       

        /* 
        //Remover
        PessoaDao pessoaDao = new PessoaDao();        
        pessoaDao.removerPessoa(pessoaPojo);
        */


        /* 
        System.out.println("Conectado com sucesso");
        */
    }
}