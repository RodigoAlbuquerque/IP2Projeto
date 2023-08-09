package codigoFarmacia.models;

import java.time.LocalDateTime;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{

    private double idAcessoSistema;
   
    private int numeroDeVendas;

    

    public Funcionario(String email, String nome, String cpf, LocalDateTime dataNascimento, double idAcesso, int nVendas) {
        super(email, nome, cpf, dataNascimento);
        idAcessoSistema = idAcesso;
        numeroDeVendas = nVendas;
    } 

    public double getIdAcessoSistema() {
        return idAcessoSistema;
    }

    public void setIdAcessoSistema(double idAcessoSistema) {
        this.idAcessoSistema = idAcessoSistema;
    }

    public int getNumerodeVendas() {
        return numeroDeVendas;
    }

    public void setNumerodeVendas(int numerodeVendas) {
        this.numeroDeVendas = numerodeVendas;
    }

    @Override
    public int compareTo(Funcionario tFuncionario){
        return (getNumerodeVendas() - tFuncionario.getNumerodeVendas());
    }
}
