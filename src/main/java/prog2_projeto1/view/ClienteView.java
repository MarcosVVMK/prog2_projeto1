package prog2_projeto1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import prog2_projeto1.controller.ClienteController;
import prog2_projeto1.model.Cliente;

public class ClienteView extends JFrame {
    private JTextField idField, nomeField, cpfField, rgField, telefoneField, referenciaField, dataNascimentoField;
    private JButton salvarButton, buscarButton, deletarButton, limparButton;
    private ClienteController clienteController;

    public ClienteView() {
        clienteController = new ClienteController();

        setTitle("Gerenciamento de Clientes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("RG:"));
        rgField = new JTextField();
        add(rgField);

        add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        add(telefoneField);

        add(new JLabel("Referência Comercial:"));
        referenciaField = new JTextField();
        add(referenciaField);

        add(new JLabel("Data de Nascimento (dd-MM-yyyy):"));
        dataNascimentoField = new JTextField();
        add(dataNascimentoField);

        salvarButton = new JButton("Salvar");
        buscarButton = new JButton("Buscar");
        deletarButton = new JButton("Deletar");
        limparButton = new JButton("Limpar Campos");

        tabbedPane.addTab("Cadastro", panelCadastro);

        add(salvarButton);
        add(buscarButton);
        add(deletarButton);
        add(limparButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = idField.getText().isEmpty() ? 0 : Integer.parseInt(idField.getText());
                    String dataNascimentoStr = dataNascimentoField.getText();
                    Date dataNascimento = null;

                    if (!dataNascimentoStr.isEmpty()) {
                        try {
                            java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimentoStr);
                            dataNascimento = new Date(utilDate.getTime());
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd-MM-yyyy");
                            return;
                        }
                    }

                    Cliente cliente = new Cliente(
                            id,
                            nomeField.getText(),
                            cpfField.getText(),
                            rgField.getText(),
                            telefoneField.getText(),
                            referenciaField.getText(),
                            dataNascimento
                    );

                    if (clienteController.salvar(cliente)) {
                        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar cliente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido para o ID.");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Cliente cliente = clienteController.buscar(id);

                    if (cliente != null && cliente.getId() != 0) {
                        nomeField.setText(cliente.getNome());
                        cpfField.setText(cliente.getCpf());
                        rgField.setText(cliente.getRg());
                        telefoneField.setText(cliente.getTelefone());
                        referenciaField.setText(cliente.getReferencia_comercial());

                        if (cliente.getData_nascimento() != null) {
                            dataNascimentoField.setText(cliente.getData_nascimento().toString());
                        } else {
                            dataNascimentoField.setText("");
                        }

                        JOptionPane.showMessageDialog(null, "Cliente encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    Cliente cliente = new Cliente();
                    cliente.setId(id);

                    if (clienteController.excluir(cliente)) {
                        JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar cliente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });




        JPanel painelTabela = new JPanel();





        setVisible(true);
    }

    private void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        cpfField.setText("");
        rgField.setText("");
        telefoneField.setText("");
        referenciaField.setText("");
        dataNascimentoField.setText("");
    }

    public static void main(String[] args) {
        new ClienteView();
    }
}