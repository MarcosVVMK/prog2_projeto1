package prog2_projeto1.model;

public class Vendedor {
    private int id;
    private String nome;
    private String cpf;
    private Double salario;
    private String telefone;

    public Vendedor(int id, String nome, String cpf, Double salario, String telefone) {
        this.id         = id;
        this.nome       = nome;
        this.cpf        = cpf;
        this.salario    = salario;
        this.telefone   = telefone;
    }

    public Vendedor() {
    }

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

}
