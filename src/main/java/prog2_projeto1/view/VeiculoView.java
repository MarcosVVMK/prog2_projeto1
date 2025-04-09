package prog2_projeto1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import prog2_projeto1.controller.VeiculoController;
import prog2_projeto1.model.Veiculo;

public class VeiculoView extends JFrame {
    private JTextField idField, nomeField, anoField, modeloField, corField, placaField;
    private JCheckBox unicoDonoCheckBox;
    private JButton salvarButton, buscarButton, deletarButton, limparButton;
    private VeiculoController veiculoController;

    public VeiculoView() {
        veiculoController = new VeiculoController();

        setTitle("Gerenciamento de Veículos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Labels e campos de texto
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Ano:"));
        anoField = new JTextField();
        add(anoField);

        add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        add(modeloField);

        add(new JLabel("Cor:"));
        corField = new JTextField();
        add(corField);

        add(new JLabel("Placa:"));
        placaField = new JTextField();
        add(placaField);

        add(new JLabel("Único Dono:"));
        unicoDonoCheckBox = new JCheckBox();
        add(unicoDonoCheckBox);

        salvarButton = new JButton("Salvar");
        buscarButton = new JButton("Buscar");
        deletarButton = new JButton("Deletar");
        limparButton = new JButton("Limpar Campos");

        add(salvarButton);
        add(buscarButton);
        add(deletarButton);
        add(limparButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = new Veiculo(
                        Integer.parseInt(idField.getText()),
                        nomeField.getText(),
                        Integer.parseInt(anoField.getText()),
                        modeloField.getText(),
                        corField.getText(),
                        placaField.getText(),
                        unicoDonoCheckBox.isSelected()
                );
                if (veiculoController.salvar(veiculo)) {
                    JOptionPane.showMessageDialog(null, "Veículo salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar veículo.");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                Veiculo veiculo = veiculoController.buscar(id);
                System.out.println(veiculo.getId());
                if (veiculo.getId() != 0) {
                    nomeField.setText(veiculo.getNome());
                    anoField.setText(String.valueOf(veiculo.getAno()));
                    modeloField.setText(veiculo.getModelo());
                    corField.setText(veiculo.getCor());
                    placaField.setText(veiculo.getPlaca());
                    unicoDonoCheckBox.setSelected(veiculo.isUnicoDono());
                    JOptionPane.showMessageDialog(null, "Veículo encontrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                }
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                Veiculo veiculo = new Veiculo();
                veiculo.setId(id);
                if (veiculoController.excluir(veiculo)) {
                    JOptionPane.showMessageDialog(null, "Veículo deletado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar veículo.");
                }
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nomeField.setText("");
                anoField.setText("");
                modeloField.setText("");
                corField.setText("");
                placaField.setText("");
                unicoDonoCheckBox.setSelected(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new VeiculoView();
    }
}