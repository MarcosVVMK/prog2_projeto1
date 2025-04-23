package prog2_projeto1.model;


import java.sql.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String referencia_comercial;
    private Date data_nascimento;

    public Cliente(int id, String nome, String cpf, String rg, String telefone, String referencia_comercial, Date data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.referencia_comercial = referencia_comercial;
        this.data_nascimento = data_nascimento;
    }

    public Cliente() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getReferencia_comercial() {
        return referencia_comercial;
    }

    public void setReferencia_comercial(String referencia_comercial) {
        this.referencia_comercial = referencia_comercial;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
