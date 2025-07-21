package prog2_projeto1.models;

public class VendaVeiculo {

    private int id;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vendedor vendedor;
    private double valorDesconto;
    private double valorFinal;
    private String dataVenda;

    public VendaVeiculo(int id, Veiculo veiculo, Cliente cliente, Vendedor vendedor, double valorDesconto, double valorFinal, String dataVenda) {
        this.id            = id;
        this.veiculo       = veiculo;
        this.cliente       = cliente;
        this.vendedor      = vendedor;
        this.valorDesconto = valorDesconto;
        this.valorFinal    = valorFinal;
        this.dataVenda     = dataVenda;
    }

    public VendaVeiculo() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

}
