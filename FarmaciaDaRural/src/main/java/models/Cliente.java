package models;

import java.time.LocalDate;

public class Cliente extends Pessoa {
   
    private boolean premium;
    private int numeroCompras;

    public Cliente(String email, String nome, String cpf, LocalDate dataNascimento,boolean prem) {
        super(email, nome, cpf, dataNascimento);
        this.premium = prem;
        this.numeroCompras = 0;
    }

      public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void incrementarNumeroCompras() {
        numeroCompras++;
    }

   
}
