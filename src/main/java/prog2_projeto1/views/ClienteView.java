package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import prog2_projeto1.controllers.ClienteController;
import prog2_projeto1.models.Cliente;

public class ClienteView {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Clientes");
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

        JLabel lblRg = new JLabel("RG");
        lblRg.setBounds(170, 60, 100, 25);
        panelCadastro.add(lblRg);

        JTextField txtRg = new JTextField();
        txtRg.setBounds(170, 80, 150, 25);
        panelCadastro.add(txtRg);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 110, 250, 25);
        panelCadastro.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 130, 200, 25);
        panelCadastro.add(txtTelefone);

        JLabel lblReferencia = new JLabel("Referência Comercial");
        lblReferencia.setBounds(10, 160, 250, 25);
        panelCadastro.add(lblReferencia);

        JTextField txtReferencia = new JTextField();
        txtReferencia.setBounds(10, 180, 400, 25);
        panelCadastro.add(txtReferencia);

        JLabel lblDataNascimento = new JLabel("Data de Nascimento (dd-MM-yyyy)");
        lblDataNascimento.setBounds(10, 210, 250, 25);
        panelCadastro.add(lblDataNascimento);

        JTextField txtDataNascimento = new JTextField();
        txtDataNascimento.setBounds(10, 230, 150, 25);
        panelCadastro.add(txtDataNascimento);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 270, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(170, 270, 150, 25);
        panelCadastro.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(340, 270, 150, 25);
        panelCadastro.add(btnDeletar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 270, 150, 25);
        panelCadastro.add(btnLimparCampos);

        // Adiciona o panelCadastro ao tabbedPane
        tabbedPane.addTab("Cadastro", panelCadastro);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    
                    cliente.setNome(txtNome.getText());
                    cliente.setCpf(txtCpf.getText());
                    cliente.setRg(txtRg.getText());
                    cliente.setTelefone(txtTelefone.getText());
                    cliente.setReferenciaComercial(txtReferencia.getText());

                    // Processar data de nascimento
                    String dataNascimentoStr = txtDataNascimento.getText();
                    if (!dataNascimentoStr.isEmpty()) {
                        try {
                            java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimentoStr);
                            Date dataNascimento = new Date(utilDate.getTime());
                            cliente.setDataNascimento(dataNascimento);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(tela, "Formato de data inválido. Use dd-MM-yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    ClienteController clienteController = new ClienteController();
                    boolean resultado = clienteController.salvar(cliente);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao salvar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    
                    cliente.setId(Integer.parseInt(txtID.getText()));
                    cliente.setNome(txtNome.getText());
                    cliente.setCpf(txtCpf.getText());
                    cliente.setRg(txtRg.getText());
                    cliente.setTelefone(txtTelefone.getText());
                    cliente.setReferenciaComercial(txtReferencia.getText());

                    // Processar data de nascimento
                    String dataNascimentoStr = txtDataNascimento.getText();
                    if (!dataNascimentoStr.isEmpty()) {
                        try {
                            java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimentoStr);
                            Date dataNascimento = new Date(utilDate.getTime());
                            cliente.setDataNascimento(dataNascimento);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(tela, "Formato de data inválido. Use dd-MM-yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    ClienteController clienteController = new ClienteController();
                    boolean resultado = clienteController.alterar(cliente);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao atualizar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtRg.setText("");
            txtTelefone.setText("");
            txtReferencia.setText("");
            txtDataNascimento.setText("");
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setId(Integer.parseInt(txtID.getText()));

                    ClienteController clienteController = new ClienteController();
                    boolean resultado = clienteController.excluir(cliente);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Cliente deletado com sucesso!");
                        // Limpar campos após deletar
                        txtID.setText("");
                        txtNome.setText("");
                        txtCpf.setText("");
                        txtRg.setText("");
                        txtTelefone.setText("");
                        txtReferencia.setText("");
                        txtDataNascimento.setText("");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao deletar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aba 2 - Listagem de Clientes
        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Nome", "CPF", "RG", "Telefone", "Referência Comercial", "Data Nascimento" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTitle = tabbedPane.getTitleAt(selectedIndex);

            if ("Lista de Clientes".equals(selectedTitle)) {
                modeloTabela.setRowCount(0);
                ClienteController clienteController = new ClienteController();
                List<Cliente> clientes = clienteController.buscarTodos();
                for (Cliente c : clientes) {
                    String dataFormatada = "";
                    if (c.getDataNascimento() != null) {
                        dataFormatada = new SimpleDateFormat("dd-MM-yyyy").format(c.getDataNascimento());
                    }
                    modeloTabela.addRow(new Object[] {
                            c.getId(), c.getNome(), c.getCpf(), c.getRg(), 
                            c.getTelefone(), c.getReferenciaComercial(), dataFormatada
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
                    txtCpf.setText(tabela.getValueAt(linha, 2).toString());
                    txtRg.setText(tabela.getValueAt(linha, 3).toString());
                    txtTelefone.setText(tabela.getValueAt(linha, 4).toString());
                    txtReferencia.setText(tabela.getValueAt(linha, 5).toString());
                    txtDataNascimento.setText(tabela.getValueAt(linha, 6).toString());
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        // Adiciona o panelTabela ao tabbedPane
        tabbedPane.addTab("Lista de Clientes", panelTabela);

        tela.setVisible(true);
    }
}