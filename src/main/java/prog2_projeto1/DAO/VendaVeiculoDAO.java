package prog2_projeto1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.DBConnection;
import prog2_projeto1.models.Cliente;
import prog2_projeto1.models.Veiculo;
import prog2_projeto1.models.VendaVeiculo;
import prog2_projeto1.models.Vendedor;

public class VendaVeiculoDAO {
    Logger logger = Logger.getLogger(VendaVeiculoDAO.class);

    public boolean salvar(VendaVeiculo vendaVeiculo) {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertVendaVeiculo = "INSERT INTO venda_veiculo " +
                    "(veiculo_id, cliente_id, vendedor_id, data_venda, valor_desconto, valor_final) " +
                    "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(insertVendaVeiculo);
            preparedStatement1.setInt(1, vendaVeiculo.getVeiculo().getId());
            preparedStatement1.setInt(2, vendaVeiculo.getCliente().getId());
            preparedStatement1.setInt(3, vendaVeiculo.getVendedor().getId());
            preparedStatement1.setDate(4, java.sql.Date.valueOf(vendaVeiculo.getDataVenda()));
            preparedStatement1.setDouble(5, vendaVeiculo.getValorDesconto());
            preparedStatement1.setDouble(6, vendaVeiculo.getValorFinal());

            logger.info("String insert VendaVeiculo preparada: " + preparedStatement1);
            int resultado = preparedStatement1.executeUpdate();

            if (resultado > 0) {
                logger.info("Inseriu VendaVeiculo: " + resultado);
                logger.info("--- Fim do método DAO Salvar ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultado);
                logger.info("--- Fim do método DAO Salvar ---");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar salvar: " + e.getMessage());
            logger.error("--- Fim do método DAO Salvar ---");
            return false;
        }
    }

    public boolean alterar(VendaVeiculo vendaVeiculo) {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String updateVendaVeiculo = "UPDATE venda_veiculo SET veiculo_id = ?, cliente_id = ?, vendedor_id = ?, data_venda = ?, valor_desconto = ?, valor_final = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateVendaVeiculo);
            preparedStatement.setInt(1, vendaVeiculo.getVeiculo().getId());
            preparedStatement.setInt(2, vendaVeiculo.getCliente().getId());
            preparedStatement.setInt(3, vendaVeiculo.getVendedor().getId());
            preparedStatement.setDate(4, java.sql.Date.valueOf(vendaVeiculo.getDataVenda()));
            preparedStatement.setDouble(5, vendaVeiculo.getValorDesconto());
            preparedStatement.setDouble(6, vendaVeiculo.getValorFinal());
            preparedStatement.setInt(7, vendaVeiculo.getId());

            logger.info("String update VendaVeiculo preparada: " + preparedStatement);
            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0) {
                logger.info("Retorno maior que zero: " + resultado);
                logger.info("--- Fim do método DAO Alterar ---");
                return true;
            } else {
                logger.info("Retorno menor que zero ");
                logger.info("--- Fim do método DAO Alterar ---");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar alterar: " + e.getMessage());
            logger.error("--- Fim do método DAO Alterar ---");
            return false;
        }
    }

    public boolean excluir(VendaVeiculo vendaVeiculo) {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String deleteVendaVeiculo = "DELETE FROM venda_veiculo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteVendaVeiculo);
            preparedStatement.setInt(1, vendaVeiculo.getId());
            
            logger.info("String delete VendaVeiculo preparada: " + preparedStatement);
            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0) {
                logger.info("Retorno maior que zero " + resultado);
                logger.info("--- Fim do método DAO Excluir ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultado);
                logger.info("--- Fim do método DAO Excluir ---");
                return false;
            }
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar excluir: " + e.getMessage());
            logger.error("--- Fim do método DAO Excluir ---");
            return false;
        }
    }

    public List<VendaVeiculo> buscarTodos() {
        try {
            logger.info("--- Início do método DAO Buscar Todos ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "SELECT * FROM venda_veiculo";
            
            List<VendaVeiculo> lista = new ArrayList<>();

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Consulta executada: " + preparedStatement);

            VeiculoDAO veiculoDAO = new VeiculoDAO();
            ClienteDAO clienteDAO = new ClienteDAO();
            VendedorDAO vendedorDAO = new VendedorDAO();
            
            while (resultSet.next()) {
                VendaVeiculo vendaVeiculo = new VendaVeiculo();
                vendaVeiculo.setId(resultSet.getInt("id"));
                
                Veiculo veiculo = veiculoDAO.buscar(resultSet.getInt("veiculo_id"));
                Cliente cliente = clienteDAO.buscar(resultSet.getInt("cliente_id"));
                Vendedor vendedor = vendedorDAO.buscar(resultSet.getInt("vendedor_id"));
                
                vendaVeiculo.setVeiculo(veiculo);
                vendaVeiculo.setCliente(cliente);
                vendaVeiculo.setVendedor(vendedor);
                vendaVeiculo.setDataVenda(resultSet.getDate("data_venda").toLocalDate());
                vendaVeiculo.setValorDesconto(resultSet.getDouble("valor_desconto"));
                vendaVeiculo.setValorFinal(resultSet.getDouble("valor_final"));

                lista.add(vendaVeiculo);
            }

            logger.info("Quantidade de registros pesquisados: " + lista.size());
            logger.info("--- Fim do método DAO Buscar Todos ---");

            return lista;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar todos: " + e.getMessage());
            return null;
        }
    }

    public VendaVeiculo buscar(int id) {
        try {
            logger.info("--- Início do método DAO Buscar por Id ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "SELECT * FROM venda_veiculo WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            logger.info("Consulta executada: " + preparedStatement);

            VendaVeiculo vendaVeiculo = null;
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            ClienteDAO clienteDAO = new ClienteDAO();
            VendedorDAO vendedorDAO = new VendedorDAO();
            
            if (resultSet.next()) {
                vendaVeiculo = new VendaVeiculo();
                vendaVeiculo.setId(resultSet.getInt("id"));
                
                Veiculo veiculo = veiculoDAO.buscar(resultSet.getInt("veiculo_id"));
                Cliente cliente = clienteDAO.buscar(resultSet.getInt("cliente_id"));
                Vendedor vendedor = vendedorDAO.buscar(resultSet.getInt("vendedor_id"));
                
                vendaVeiculo.setVeiculo(veiculo);
                vendaVeiculo.setCliente(cliente);
                vendaVeiculo.setVendedor(vendedor);
                vendaVeiculo.setDataVenda(resultSet.getDate("data_venda").toLocalDate());
                vendaVeiculo.setValorDesconto(resultSet.getDouble("valor_desconto"));
                vendaVeiculo.setValorFinal(resultSet.getDouble("valor_final"));
            }

            logger.info("--- Fim do método DAO Buscar por Id ---");

            return vendaVeiculo;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar: " + e.getMessage());
            return null;
        }
    }
}
