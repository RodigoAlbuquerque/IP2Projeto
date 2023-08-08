package codigoFarmacia.models;

import java.time.LocalDateTime;

public class Cliente extends Pessoa {
   
    private int numeroDeCompras;

    public Cliente(String email, String nome, String cpf, LocalDateTime dataNascimento) {
        super(email, nome, cpf, dataNascimento);
        numeroDeCompras = 0;
    }

    public int getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public void setNumeroDeCompras(int numeroDeCompras) {
        this.numeroDeCompras = numeroDeCompras;
    }
}
