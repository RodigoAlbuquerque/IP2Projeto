package models;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private double idAcessoSistema;
   
    public Funcionario(String email, String nome, String cpf, LocalDate dataNascimento, double idAcesso ) {
        super(email, nome, cpf, dataNascimento);
        idAcessoSistema = idAcesso;
    
    } 

    public double getIdAcessoSistema() {
        return idAcessoSistema;
    }

    public void setIdAcessoSistema(double idAcessoSistema) {
        this.idAcessoSistema = idAcessoSistema;
    }

   
}
