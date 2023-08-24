package models;

import java.time.LocalDate;

public class ComprovanteADT {
    
    private double valorDaCompra;
    private String cpf;
    private Double idAcessFuncionario;
    private LocalDate data;

    public ComprovanteADT(double valorDaCompra,String cpf, Double idAcess, LocalDate dt) {
        this.data = dt;
        this.valorDaCompra = valorDaCompra;
        this.cpf = cpf;
        this.idAcessFuncionario = idAcess;
    }

    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }
    
    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the idAcessFuncionario
     */
    public Double getIdAcessFuncionario() {
        return idAcessFuncionario;
    }

    /**
     * @param idAcessFuncionario the idAcessFuncionario to set
     */
    public void setIdAcessFuncionario(Double idAcessFuncionario) {
        this.idAcessFuncionario = idAcessFuncionario;
    }

}
