package prog2_projeto1.models;

import java.util.Date;

import prog2_projeto1.utils.PessoaFisica;

public class Vendedor extends PessoaFisica {
    private Double salario;
    private Double comissao;

    public Vendedor(int id, String nome, String cpf, String rg, Double salario, Double comissao, String telefone, Date dataCadastro ) {
        this.salario    = salario;
        this.comissao   = comissao;
    }

    public Vendedor() {
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
   
}
