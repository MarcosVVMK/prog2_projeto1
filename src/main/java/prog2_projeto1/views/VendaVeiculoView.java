package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

import prog2_projeto1.controllers.ClienteController;
import prog2_projeto1.controllers.VeiculoController;
import prog2_projeto1.controllers.VendaVeiculoController;
import prog2_projeto1.controllers.VendedorController;
import prog2_projeto1.models.Cliente;
import prog2_projeto1.models.VendaVeiculo;
import prog2_projeto1.models.Veiculo;
import prog2_projeto1.models.Vendedor;

public class VendaVeiculoView {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Cadastro de Vendas de Veículos");
        tela.setSize(900, 450);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        // Tab principal para adicionar abas
        JTabbedPane tabbedPane = new JTabbedPane();
        tela.add(tabbedPane);

        // Aba 1 - Cadastro
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(null);
        
        JLabel lblVeiculo = new JLabel("Veículo");
        lblVeiculo.setBounds(10, 10, 150, 25);
        panelCadastro.add(lblVeiculo);

        JTextField txtID = new JTextField();
        //txtID.setBounds(10, 30, 100, 25);
        panelCadastro.add(txtID);

        // ComboBox para Veículos
        VeiculoController veiculoController = new VeiculoController();
        List<Veiculo> veiculos = veiculoController.buscarTodos();

        JComboBox<Veiculo> comboVeiculo = new JComboBox<>();
        for (Veiculo veiculo : veiculos) {
            comboVeiculo.addItem(veiculo);
        }

        comboVeiculo.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Veiculo) {
                    Veiculo v = (Veiculo) value;
                    setText(v.getNome() + " - " + v.getPlaca());
                }
                return this;
            }
        });
        
        comboVeiculo.setBounds(10, 30, 250, 25);
        panelCadastro.add(comboVeiculo);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 60, 150, 25);
        panelCadastro.add(lblCliente);

        // ComboBox para Clientes
        ClienteController clienteController = new ClienteController();
        List<Cliente> clientes = clienteController.buscarTodos();

        JComboBox<Cliente> comboCliente = new JComboBox<>();
        for (Cliente cliente : clientes) {
            comboCliente.addItem(cliente);
        }

        comboCliente.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente c = (Cliente) value;
                    setText(c.getNome() + " - " + c.getCpf());
                }
                return this;
            }
        });
        
        comboCliente.setBounds(10, 80, 250, 25);
        panelCadastro.add(comboCliente);

        JLabel lblVendedor = new JLabel("Vendedor");
        lblVendedor.setBounds(10, 110, 150, 25);
        panelCadastro.add(lblVendedor);

        // ComboBox para Vendedores
        VendedorController vendedorController = new VendedorController();
        List<Vendedor> vendedores = vendedorController.buscarTodos();

        JComboBox<Vendedor> comboVendedor = new JComboBox<>();
        for (Vendedor vendedor : vendedores) {
            comboVendedor.addItem(vendedor);
        }

        comboVendedor.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, 
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Vendedor) {
                    Vendedor v = (Vendedor) value;
                    setText(v.getNome() + " - " + v.getCpf());
                }
                return this;
            }
        });
        
        comboVendedor.setBounds(10, 130, 250, 25);
        panelCadastro.add(comboVendedor);

        JLabel lblValorDesconto = new JLabel("Valor Desconto (R$)");
        lblValorDesconto.setBounds(280, 60, 150, 25);
        panelCadastro.add(lblValorDesconto);

        JTextField txtValorDesconto = new JTextField();
        txtValorDesconto.setBounds(280, 80, 150, 25);
        panelCadastro.add(txtValorDesconto);

        JLabel lblValorFinal = new JLabel("Valor Final (R$)");
        lblValorFinal.setBounds(280, 110, 150, 25);
        panelCadastro.add(lblValorFinal);

        JTextField txtValorFinal = new JTextField();
        txtValorFinal.setBounds(280, 130, 150, 25);
        panelCadastro.add(txtValorFinal);

        JLabel lblDataVenda = new JLabel("Data da Venda (dd-MM-yyyy)");
        lblDataVenda.setBounds(10, 160, 250, 25);
        panelCadastro.add(lblDataVenda);

        JTextField txtDataVenda = new JTextField();
        txtDataVenda.setBounds(10, 180, 150, 25);
        panelCadastro.add(txtDataVenda);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 220, 150, 25);
        panelCadastro.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(170, 220, 150, 25);
        panelCadastro.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(340, 220, 150, 25);
        panelCadastro.add(btnDeletar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        btnLimparCampos.setBounds(510, 220, 150, 25);
        panelCadastro.add(btnLimparCampos);

        // Adiciona o panelCadastro ao tabbedPane
        tabbedPane.addTab("Cadastro", panelCadastro);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    VendaVeiculo vendaVeiculo = new VendaVeiculo();
                    
                    vendaVeiculo.setVeiculo((Veiculo) comboVeiculo.getSelectedItem());
                    vendaVeiculo.setCliente((Cliente) comboCliente.getSelectedItem());
                    vendaVeiculo.setVendedor((Vendedor) comboVendedor.getSelectedItem());
                    vendaVeiculo.setValorDesconto(Double.valueOf(txtValorDesconto.getText()));
                    vendaVeiculo.setValorFinal(Double.valueOf(txtValorFinal.getText()));

                    // Processar data da venda
                    String dataVendaStr = txtDataVenda.getText();
                    if (!dataVendaStr.isEmpty()) {
                        try {
                            LocalDate dataVenda = LocalDate.parse(dataVendaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            vendaVeiculo.setDataVenda(dataVenda);
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(tela, "Formato de data inválido. Use dd-MM-yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } else {
                        vendaVeiculo.setDataVenda(LocalDate.now());
                    }

                    VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
                    boolean resultado = vendaVeiculoController.salvar(vendaVeiculo);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Venda registrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao registrar venda!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "Valores monetários inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    VendaVeiculo vendaVeiculo = new VendaVeiculo();
                    
                    vendaVeiculo.setId(Integer.parseInt(txtID.getText()));
                    vendaVeiculo.setVeiculo((Veiculo) comboVeiculo.getSelectedItem());
                    vendaVeiculo.setCliente((Cliente) comboCliente.getSelectedItem());
                    vendaVeiculo.setVendedor((Vendedor) comboVendedor.getSelectedItem());
                    vendaVeiculo.setValorDesconto(Double.valueOf(txtValorDesconto.getText()));
                    vendaVeiculo.setValorFinal(Double.valueOf(txtValorFinal.getText()));

                    // Processar data da venda
                    String dataVendaStr = txtDataVenda.getText();
                    if (!dataVendaStr.isEmpty()) {
                        try {
                            LocalDate dataVenda = LocalDate.parse(dataVendaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            vendaVeiculo.setDataVenda(dataVenda);
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(tela, "Formato de data inválido. Use dd-MM-yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
                    boolean resultado = vendaVeiculoController.alterar(vendaVeiculo);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Venda atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao atualizar venda!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID ou valores monetários inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLimparCampos.addActionListener(e -> {
            txtID.setText("");
            comboVeiculo.setSelectedIndex(0);
            comboCliente.setSelectedIndex(0);
            comboVendedor.setSelectedIndex(0);
            txtValorDesconto.setText("");
            txtValorFinal.setText("");
            txtDataVenda.setText("");
        });

        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    VendaVeiculo vendaVeiculo = new VendaVeiculo();
                    vendaVeiculo.setId(Integer.parseInt(txtID.getText()));

                    VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
                    boolean resultado = vendaVeiculoController.excluir(vendaVeiculo);
                    
                    if (resultado) {
                        JOptionPane.showMessageDialog(tela, "Venda deletada com sucesso!");
                        // Limpar campos após deletar
                        txtID.setText("");
                        comboVeiculo.setSelectedIndex(0);
                        comboCliente.setSelectedIndex(0);
                        comboVendedor.setSelectedIndex(0);
                        txtValorDesconto.setText("");
                        txtValorFinal.setText("");
                        txtDataVenda.setText("");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Erro ao deletar venda!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aba 2 - Listagem de Vendas
        JPanel panelTabela = new JPanel();
        panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.Y_AXIS));

        String[] colunas = { "ID", "Veículo", "Cliente", "Vendedor", "Valor Desconto", "Valor Final", "Data Venda" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panelTabela.add(scrollPane);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTitle = tabbedPane.getTitleAt(selectedIndex);

            if ("Lista de Vendas".equals(selectedTitle)) {
                modeloTabela.setRowCount(0);
                VendaVeiculoController vendaVeiculoController = new VendaVeiculoController();
                List<VendaVeiculo> vendas = vendaVeiculoController.buscarTodos();
                for (VendaVeiculo vv : vendas) {
                    String dataFormatada = "";
                    if (vv.getDataVenda() != null) {
                        dataFormatada = vv.getDataVenda().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    }
                    
                    String veiculoNome = vv.getVeiculo() != null ? vv.getVeiculo().getNome() : "N/A";
                    String clienteNome = vv.getCliente() != null ? vv.getCliente().getNome() : "N/A";
                    String vendedorNome = vv.getVendedor() != null ? vv.getVendedor().getNome() : "N/A";
                    
                    modeloTabela.addRow(new Object[] {
                            vv.getId(), veiculoNome, clienteNome, vendedorNome,
                            "R$ " + String.format("%.2f", vv.getValorDesconto()),
                            "R$ " + String.format("%.2f", vv.getValorFinal()),
                            dataFormatada
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
                    
                    // Encontrar e selecionar o veículo correto no combo
                    String veiculoNome = tabela.getValueAt(linha, 1).toString();
                    for (int i = 0; i < comboVeiculo.getItemCount(); i++) {
                        Veiculo v = comboVeiculo.getItemAt(i);
                        if (v.getNome().equals(veiculoNome)) {
                            comboVeiculo.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    // Encontrar e selecionar o cliente correto no combo
                    String clienteNome = tabela.getValueAt(linha, 2).toString();
                    for (int i = 0; i < comboCliente.getItemCount(); i++) {
                        Cliente c = comboCliente.getItemAt(i);
                        if (c.getNome().equals(clienteNome)) {
                            comboCliente.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    // Encontrar e selecionar o vendedor correto no combo
                    String vendedorNome = tabela.getValueAt(linha, 3).toString();
                    for (int i = 0; i < comboVendedor.getItemCount(); i++) {
                        Vendedor v = comboVendedor.getItemAt(i);
                        if (v.getNome().equals(vendedorNome)) {
                            comboVendedor.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    // Remover "R$ " dos valores monetários
                    String valorDesconto = tabela.getValueAt(linha, 4).toString().replace("R$ ", "").replace(",", ".");
                    String valorFinal = tabela.getValueAt(linha, 5).toString().replace("R$ ", "").replace(",", ".");
                    
                    txtValorDesconto.setText(valorDesconto);
                    txtValorFinal.setText(valorFinal);
                    txtDataVenda.setText(tabela.getValueAt(linha, 6).toString());
                    
                    tabbedPane.setSelectedIndex(0);
                }
            }
        });

        // Adiciona o panelTabela ao tabbedPane
        tabbedPane.addTab("Lista de Vendas", panelTabela);

        tela.setVisible(true);
    }
}
