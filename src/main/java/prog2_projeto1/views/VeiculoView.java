package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import prog2_projeto1.controllers.CategoriaController;
import prog2_projeto1.controllers.VeiculoController;
import prog2_projeto1.models.Categoria;
import prog2_projeto1.models.Veiculo;

public class VeiculoView {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Veículos");
        tela.setSize(800, 400);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        // Tab principal para adicionar abas
        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        // Aba 1 - Cadastro
        JPanel panelCadastro = new JPanel();

        panelCadastro.setLayout(null);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 10, 150, 25);
        panelCadastro.add(lblNome);

        JTextField txtID = new JTextField();
        //txtID.setBounds(10, 30, 100, 25);
        panelCadastro.add(txtID);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 30, 200, 25);
        panelCadastro.add(txtNome);

        JLabel lblAno = new JLabel("Ano");
        lblAno.setBounds(10, 60, 150, 25);
        panelCadastro.add(lblAno);

        JTextField txtAno = new JTextField();
        txtAno.setBounds(10, 80, 150, 25);
        panelCadastro.add(txtAno);

        JLabel lblCategoriaDropdown = new JLabel("Categoria");
        lblCategoriaDropdown.setBounds(170, 60, 100, 25);
        panelCadastro.add(lblCategoriaDropdown);

        CategoriaController categoriaController = new CategoriaController();

        List<Categoria> categorias = categoriaController.buscarTodos();

        JComboBox<Categoria> comboCategoria = new JComboBox<>();
        for (Categoria categoria : categorias) {
            comboCategoria.addItem(categoria);
        }

        // Set a custom renderer to display the category name
        comboCategoria.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Categoria) {
                    setText(((Categoria) value).getNome());
                }
                return this;
            }
        });
        
        comboCategoria.setBounds(170, 80, 150, 25);
        panelCadastro.add(comboCategoria);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(10, 110, 250, 25);
        panelCadastro.add(lblModelo);

        JTextField txtModelo = new JTextField();
        txtModelo.setBounds(10, 130, 300, 25);
        panelCadastro.add(txtModelo);

        JLabel lblCor = new JLabel("Cor");
        lblCor.setBounds(10, 160, 250, 25);
        panelCadastro.add(lblCor);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(10, 180, 200, 25);
        panelCadastro.add(txtCor);

        JLabel lblPlaca = new JLabel("Placa");
        lblPlaca.setBounds(220, 160, 250, 25);
        panelCadastro.add(lblPlaca);

        JTextField txtPlaca = new JTextField();
        txtPlaca.setBounds(220, 180, 150, 25);
        panelCadastro.add(txtPlaca);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 230, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(170, 230, 150, 25);
        panelCadastro.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(340, 230, 150, 25);
        panelCadastro.add(btnDeletar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 230, 150, 25);
        panelCadastro.add(btnDeletar);

        // Adiciona o panelCadastro ao tabbedPane
        tabbedPane.addTab("Cadastro", panelCadastro);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = new Veiculo();

                System.out.println(txtID);

                veiculo.setNome(txtNome.getText());
                veiculo.setAno(Integer.parseInt(txtAno.getText()));
                veiculo.setUnicoDono(true);
                veiculo.setCategoria((Categoria) comboCategoria.getSelectedItem());
                veiculo.setModelo(txtModelo.getText());
                veiculo.setCor(txtCor.getText());
                veiculo.setPlaca(txtPlaca.getText());

                VeiculoController veiculoController = new VeiculoController();
                    
                boolean resultado = veiculoController.salvar(veiculo);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Veículo salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = new Veiculo();

                veiculo.setId(Integer.parseInt(txtID.getText()));
                veiculo.setNome(txtNome.getText());
                veiculo.setAno(Integer.parseInt(txtAno.getText()));
                veiculo.setModelo(txtModelo.getText());
                veiculo.setCor(txtCor.getText());
                veiculo.setPlaca(txtPlaca.getText());
                veiculo.setUnicoDono(true);

                VeiculoController veiculoController = new VeiculoController();
                
                boolean resultado = veiculoController.alterar(veiculo);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Veículo salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao salvar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtAno.setText("");
            txtModelo.setText("");
            txtCor.setText("");
            txtPlaca.setText("");
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(Integer.parseInt(txtID.getText()));
                veiculo.setNome(txtNome.getText());
                veiculo.setAno(Integer.parseInt(txtAno.getText()));
                veiculo.setModelo(txtModelo.getText());
                veiculo.setCor(txtCor.getText());
                veiculo.setPlaca(txtPlaca.getText());
                veiculo.setUnicoDono(true);

                VeiculoController veiculoController = new VeiculoController();
                
                boolean resultado = veiculoController.excluir(veiculo);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Veículo deletado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao deletar veículo!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aba 2 - Listagem de Veículos
        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Nome", "Ano", "Modelo", "Cor", "Placa" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTitle = tabbedPane.getTitleAt(selectedIndex);

            if ("Lista de Veículos".equals(selectedTitle)) {
                modeloTabela.setRowCount(0);
                VeiculoController veiculoController = new VeiculoController();
                List<Veiculo> veiculos = veiculoController.buscarTodos();
                for (Veiculo v : veiculos) {
                    modeloTabela.addRow(new Object[] {
                            v.getId(), v.getNome(), v.getAno(), v.getModelo(), v.getCor(), v.getPlaca()
                    });
                }
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();

                    txtID.setText(tabela.getValueAt(linha, 0).toString());
                    txtNome.setText(tabela.getValueAt(linha, 1).toString());
                    txtAno.setText(tabela.getValueAt(linha, 2).toString());
                    txtModelo.setText(tabela.getValueAt(linha, 3).toString());
                    txtCor.setText(tabela.getValueAt(linha, 4).toString());
                    txtPlaca.setText(tabela.getValueAt(linha, 5).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        // Adiciona o panelTabela ao tabbedPane
        tabbedPane.addTab("Lista de Veículos", panelTabela);

        tela.setVisible(true);
    }
}
