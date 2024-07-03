package com.gerentes.dao;

import com.gerentes.modelo.Pessoa;

public class PessoaPojo {
    private String nome;
    private String endereco;
    private int idade;
    private int id;

    @Deprecated
    public PessoaPojo(){
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa criarPessoa() {
        return new Pessoa(getNome(), endereco, idade);
    }

    @Override
    public String toString() {
        return "PessoaPojo [nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", id=" + id + "]";
    }

    
    
}