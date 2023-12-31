package models;

import java.time.LocalDate;



public abstract class Pessoa {
    private String email;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private int idade;

    public Pessoa(String email, String nome, String cpf, LocalDate dataNascimento) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        calcularIdade(dataNascimento);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    private void calcularIdade(LocalDate dataNascimento){
        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        int idadeAtual = anoAtual - dataNascimento.getYear();
        setIdade(idadeAtual);
    }
}
