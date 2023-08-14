package models;

import java.time.LocalDateTime;

public class Cliente extends Pessoa {
   
    private boolean premium;

    public Cliente(String email, String nome, String cpf, LocalDateTime dataNascimento,boolean prem) {
        super(email, nome, cpf, dataNascimento);
        this.premium = prem;
    }

      public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

   
}
