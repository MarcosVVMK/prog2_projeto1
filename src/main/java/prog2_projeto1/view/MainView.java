package prog2_projeto1.view;

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
        setTitle("Emprestimo de Veiculos");
        setSize(600, 400);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar        = new JMenuBar();
        JMenu menuCadastro      = new JMenu("Cadastros");
        JMenu menuRelatorios    = new JMenu("Relatórios");

        JMenuItem itemVeiculo   = new JMenuItem("Veículos");
        JMenuItem itemCategoria = new JMenuItem("Categorias");
        JMenuItem itemRel1      = new JMenuItem("Relatório 1");
        JMenuItem itemRel2      = new JMenuItem("Relatório 2");

        JSeparator separator = new JSeparator();

        menuCadastro.add(itemVeiculo);
        menuCadastro.add(separator);
        menuCadastro.add(itemCategoria);

        menuRelatorios.add(itemRel1);
        menuRelatorios.add(itemRel2);

        menuBar.add(menuCadastro);
        menuBar.add(menuRelatorios);

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
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            new MainView().setVisible(true);
        });
    }
}
