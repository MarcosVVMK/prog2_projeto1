package prog2_projeto1.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class MainView  extends JFrame{
    public MainView(){
        setTitle("Venda de Veiculos");
        setSize(600, 400);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar            = new JMenuBar();
        JMenu menuCadastro          = new JMenu("Cadastros");

        JMenuItem itemVeiculo       = new JMenuItem("Veículos");
        JMenuItem itemCategoria     = new JMenuItem("Categorias");
        JMenuItem itemCliente       = new JMenuItem("Clientes");
        JMenuItem itemVendedor      = new JMenuItem("Vendedores");
        JMenuItem itemVendaVeiculo  = new JMenuItem("Vendas");

        JSeparator separator = new JSeparator();

        menuCadastro.add(itemCategoria);
        menuCadastro.add(separator);
        menuCadastro.add(itemVeiculo);
        menuCadastro.add(separator);
        menuCadastro.add(itemCliente);
        menuCadastro.add(separator);
        menuCadastro.add(itemVendedor);
        menuCadastro.add(separator);
        menuCadastro.add(itemVendaVeiculo);

        menuBar.add(menuCadastro);

        setJMenuBar(menuBar);

        itemVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VeiculoView.main(null);
            }
        });

        itemCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CategoriaView.main(null);
            }
        });

        itemCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ClienteView.main(null);
            }
        });

        itemVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VendedorView.main(null);
            }
        });

        itemVendaVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VendaVeiculoView.main(null);
            }
        });
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            new MainView().setVisible(true);
        });
    }
}
