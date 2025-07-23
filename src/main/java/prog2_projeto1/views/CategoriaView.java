package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
import prog2_projeto1.models.Categoria;

public class CategoriaView extends JFrame {
    public static void main(String[] args) {
    
        JFrame tela = new JFrame("Cadastro de Categoria");
        tela.setSize(800, 400);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(null);

        tabbedPane.addTab("Cadastro", panelCadastro);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 10, 150, 25);
        panelCadastro.add(lblNome);

        JTextField txtID = new JTextField();
        //txtID.setBounds(10, 30, 100, 25);
        panelCadastro.add(txtID);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 30, 250, 25);
        panelCadastro.add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição");
        lblDescricao.setBounds(10, 60, 250, 25);
        panelCadastro.add(lblDescricao);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 80, 400, 25);
        panelCadastro.add(txtDescricao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 280, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(170, 280, 150, 25);
        panelCadastro.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(340, 280, 150, 25);
        panelCadastro.add(btnDeletar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 280, 150, 25);
        panelCadastro.add(btnLimparCampos);

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

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria = new Categoria();

                categoria.setId(Integer.parseInt(txtID.getText()));
                categoria.setNome(txtNome.getText());
                categoria.setDescricao(txtDescricao.getText());

                CategoriaController categoriaController = new CategoriaController();
                
                boolean resultado = categoriaController.alterar(categoria);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Categoria atualizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao atualizar categoria!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Categoria categoria = new Categoria();

                categoria.setId(Integer.parseInt(txtID.getText()));
            
                CategoriaController categoriaController = new CategoriaController();
                
                boolean resultado = categoriaController.excluir(categoria);
                if (resultado) {
                    JOptionPane.showMessageDialog(tela, "Categoria deletada com sucesso!");
                    // Limpar campos após deletar
                    txtID.setText("");
                    txtNome.setText("");
                    txtDescricao.setText("");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao deletar categoria!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtDescricao.setText("");
        });

         // Aba 2 - Listagem de Categorias
        JPanel panelTabela = new JPanel();

        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Nome", "Descrição" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTitle = tabbedPane.getTitleAt(selectedIndex);

            if ("Lista de Categorias".equals(selectedTitle)) {
                modeloTabela.setRowCount(0);
                CategoriaController categoriaController = new CategoriaController();
                List<Categoria> categorias = categoriaController.buscarTodos();
                for (Categoria v : categorias) {
                    modeloTabela.addRow(new Object[] {
                            v.getId(), v.getNome(), v.getDescricao()
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
                    txtDescricao.setText(tabela.getValueAt(linha, 2).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        // Adiciona o panelTabela ao tabbedPane
        tabbedPane.addTab("Lista de Categorias", panelTabela);

        tela.setVisible(true);
    }
}
