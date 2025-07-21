package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prog2_projeto1.controllers.CategoriaController;
import prog2_projeto1.models.Categoria;

public class CategoriaView extends JFrame {
    public static void main(String[] args) {
    
        JFrame tela = new JFrame("Cadastro de Categoria");
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

        JLabel lblDescricao = new JLabel("Descricao");
        lblDescricao.setBounds(10, 100, 250, 25);
        panel.add(lblDescricao);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 120, 250, 25);
        panel.add(txtDescricao);

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
                Categoria categoria = new Categoria();
                CategoriaController categoriaController = new CategoriaController();
                categoria.setNome(txtNome.getText());
                categoria.setDescricao(txtDescricao.getText());
                boolean resultado = categoriaController.salvar(categoria);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Salvo", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar!", "Erro ao salvar!", 0);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtDescricao.setText("");
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria = new Categoria();

                categoria.setId(Integer.parseInt(txtID.getText()));
                categoria.setNome(txtNome.getText());
                categoria.setDescricao(txtDescricao.getText());

                CategoriaController categoriaController = new CategoriaController();
                
                boolean resultado = categoriaController.alterar(categoria);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Categoria salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Categoria categoria = new Categoria();

                categoria.setId(Integer.parseInt(txtID.getText()));
            
                CategoriaController categoriaController = new CategoriaController();
                
                boolean resultado = categoriaController.excluir(categoria);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Categoria deletado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao deletar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tela.setVisible(true);
    }
}
