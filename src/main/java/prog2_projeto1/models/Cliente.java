package prog2_projeto1.models;


import java.sql.Date;

import prog2_projeto1.abstracts.PessoaFisica;

public class Cliente extends PessoaFisica {
    
    private String referenciaComercial;
    private Date dataNascimento;

    public Cliente(int id, String nome, String cpf, String rg, String telefone, String email, String referenciaComercial, Date dataNascimento) {
        super(id, nome, cpf, rg, null, telefone, null, new Date(System.currentTimeMillis()));

        this.referenciaComercial    = referenciaComercial;
        this.dataNascimento         = dataNascimento;
    }

    public Cliente() {}

    public String getReferenciaComercial() {
        return referenciaComercial;
    }

    public void setReferenciaComercial(String referenciaComercial) {
        this.referenciaComercial = referenciaComercial;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
