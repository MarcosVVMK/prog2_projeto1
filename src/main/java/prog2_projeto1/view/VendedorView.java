package prog2_projeto1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prog2_projeto1.controller.VendedorController;
import prog2_projeto1.model.Vendedor;

public class VendedorView {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Vendedor");
        tela.setSize(800, 400);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        tela.add(panel);
        panel.setLayout(null);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(10, 10, 150, 25);
        panel.add(lblID);

        JTextField txtID = new JTextField();
        txtID.setBounds(10, 30, 100, 25);
        panel.add(txtID);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 60, 150, 25);
        panel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 80, 100, 25);
        panel.add(txtNome);

        JLabel lblCpf = new JLabel("Cpf");
        lblCpf.setBounds(10, 100, 150, 25);
        panel.add(lblCpf);

        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(10, 120, 150, 25);
        panel.add(txtCpf);

        JLabel lblSalario = new JLabel("Salario");
        lblSalario.setBounds(10, 140, 250, 25);
        panel.add(lblSalario);

        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(10, 160, 250, 25);
        panel.add(txtSalario);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 180, 250, 25);
        panel.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 200, 250, 25);
        panel.add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 280, 150, 25);
        panel.add(btnSalvar);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(170, 280, 150, 25);
        panel.add(btnAlterar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(340, 280, 150, 25);
        panel.add(btnExcluir);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 280, 150, 25);
        panel.add(btnLimparCampos);

        btnSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Vendedor vendedor = new Vendedor();
                VendedorController vendedorController = new VendedorController();
                vendedor.setNome(txtNome.getText());
                vendedor.setCpf(txtCpf.getText());
                vendedor.setSalario(Double.valueOf(txtSalario.getText()));
                vendedor.setTelefone(txtTelefone.getText());
                boolean resultado = vendedorController.salvar(vendedor);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Salvo", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar!", "Erro ao salvar!", 0);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtSalario.setText("");
            txtTelefone.setText("");
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vendedor vendedor = new Vendedor();

                vendedor.setId(Integer.parseInt(txtID.getText()));
                vendedor.setNome(txtNome.getText());
                vendedor.setCpf(txtCpf.getText());
                vendedor.setSalario(Double.valueOf(txtSalario.getText()));
                vendedor.setTelefone(txtTelefone.getText());

                VendedorController vendedorController = new VendedorController();
                
                boolean resultado = vendedorController.alterar(vendedor);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Vendedor salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vendedor vendedor = new Vendedor();

                vendedor.setId(Integer.parseInt(txtID.getText()));

                VendedorController vendedorController = new VendedorController();
                
                boolean resultado = vendedorController.excluir(vendedor);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Vendedor deletado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao deletar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tela.setVisible(true);
    }
}
