package codigoFarmacia.models;

import java.time.LocalDateTime;

public class Funcionario extends Pessoa {

    private double idAcessoSistema;
   
    public Funcionario(String email, String nome, String cpf, LocalDateTime dataNascimento, double idAcesso ) {
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
