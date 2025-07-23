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

import prog2_projeto1.controllers.VendedorController;
import prog2_projeto1.models.Vendedor;

public class VendedorView {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Vendedores");
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
        txtNome.setBounds(10, 30, 250, 25);
        panelCadastro.add(txtNome);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, 60, 150, 25);
        panelCadastro.add(lblCpf);

        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(10, 80, 150, 25);
        panelCadastro.add(txtCpf);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(170, 60, 100, 25);
        panelCadastro.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(170, 80, 150, 25);
        panelCadastro.add(txtTelefone);

        JLabel lblSalario = new JLabel("Salário");
        lblSalario.setBounds(10, 110, 250, 25);
        panelCadastro.add(lblSalario);

        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(10, 130, 150, 25);
        panelCadastro.add(txtSalario);

        JLabel lblComissao = new JLabel("Comissão (%)");
        lblComissao.setBounds(170, 110, 250, 25);
        panelCadastro.add(lblComissao);

        JTextField txtComissao = new JTextField();
        txtComissao.setBounds(170, 130, 150, 25);
        panelCadastro.add(txtComissao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 180, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(170, 180, 150, 25);
        panelCadastro.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(340, 180, 150, 25);
        panelCadastro.add(btnDeletar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 180, 150, 25);
        panelCadastro.add(btnLimparCampos);

        // Adiciona o panelCadastro ao tabbedPane
        tabbedPane.addTab("Cadastro", panelCadastro);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Vendedor vendedor = new Vendedor();
                    
                    vendedor.setNome(txtNome.getText());
                    vendedor.setCpf(txtCpf.getText());
                    vendedor.setTelefone(txtTelefone.getText());
                    vendedor.setSalario(Double.valueOf(txtSalario.getText()));
                    vendedor.setComissao(Double.valueOf(txtComissao.getText()));

                    VendedorController vendedorController = new VendedorController();
                    boolean resultado = vendedorController.salvar(vendedor);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Vendedor salvo com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao salvar vendedor!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "Valores numéricos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Vendedor vendedor = new Vendedor();
                    
                    vendedor.setId(Integer.parseInt(txtID.getText()));
                    vendedor.setNome(txtNome.getText());
                    vendedor.setCpf(txtCpf.getText());
                    vendedor.setTelefone(txtTelefone.getText());
                    vendedor.setSalario(Double.valueOf(txtSalario.getText()));
                    vendedor.setComissao(Double.valueOf(txtComissao.getText()));

                    VendedorController vendedorController = new VendedorController();
                    boolean resultado = vendedorController.alterar(vendedor);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Vendedor atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao atualizar vendedor!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID ou valores numéricos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
            txtSalario.setText("");
            txtComissao.setText("");
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Vendedor vendedor = new Vendedor();
                    vendedor.setId(Integer.parseInt(txtID.getText()));

                    VendedorController vendedorController = new VendedorController();
                    boolean resultado = vendedorController.excluir(vendedor);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Vendedor deletado com sucesso!");
                        // Limpar campos após deletar
                        txtID.setText("");
                        txtNome.setText("");
                        txtCpf.setText("");
                        txtTelefone.setText("");
                        txtSalario.setText("");
                        txtComissao.setText("");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao deletar vendedor!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aba 2 - Listagem de Vendedores
        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Nome", "CPF", "Telefone", "Salário", "Comissão" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTitle = tabbedPane.getTitleAt(selectedIndex);

            if ("Lista de Vendedores".equals(selectedTitle)) {
                modeloTabela.setRowCount(0);
                VendedorController vendedorController = new VendedorController();
                List<Vendedor> vendedores = vendedorController.buscarTodos();
                for (Vendedor v : vendedores) {
                    modeloTabela.addRow(new Object[] {
                            v.getId(), v.getNome(), v.getCpf(), v.getTelefone(), 
                            v.getSalario(), v.getComissao()
                    });
                }
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();

                    txtID.setText(tabela.getValueAt(linha, 0).toString());
                    txtNome.setText(tabela.getValueAt(linha, 1).toString());
                    txtCpf.setText(tabela.getValueAt(linha, 2).toString());
                    txtTelefone.setText(tabela.getValueAt(linha, 3).toString());
                    txtSalario.setText(tabela.getValueAt(linha, 4).toString());
                    txtComissao.setText(tabela.getValueAt(linha, 5).toString());
                    
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        // Adiciona o panelTabela ao tabbedPane
        tabbedPane.addTab("Lista de Vendedores", panelTabela);

        tela.setVisible(true);
    }
}
