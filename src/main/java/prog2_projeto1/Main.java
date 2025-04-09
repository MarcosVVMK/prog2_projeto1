package prog2_projeto1;

import java.sql.SQLException;

import prog2_projeto1.controller.VeiculoController;
import prog2_projeto1.model.Veiculo;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo(1, "Gol", 1986, "Bola", "Prata", "AAA-1234", true);
        VeiculoController veiculoController = new VeiculoController();
        veiculoController.salvar(veiculo);
        veiculoController.buscar(1);
    }
}