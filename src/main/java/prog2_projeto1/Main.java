package prog2_projeto1;

import java.sql.SQLException;

import prog2_projeto1.controller.VeiculoController;

public class Main {
    public static void main(String[] args) {
        // Veiculo veiculo = new Veiculo();
        // veiculo.setNome("Gol");
        // veiculo.setAno(1986);
        // veiculo.setModelo("Bola");
        // veiculo.setCor("Prata");
        // veiculo.setPlaca("AAA-1234");
        // veiculo.setUnicoDono(true);
        VeiculoController veiculoController = new VeiculoController();
        veiculoController.buscar(1);
    }
}