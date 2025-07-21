package prog2_projeto1.DAOs;

import org.apache.log4j.Logger;
import prog2_projeto1.DBConnection;
import prog2_projeto1.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Logger logger = Logger.getLogger(ClienteDAO.class);

    public boolean salvar(Cliente cliente) throws SQLException {
        logger.info("--- Início do método DAO Salvar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertCliente = "INSERT INTO cliente " +
                    "(nome, cpf, rg, telefone, referencia_comercial, data_nascimento) " +
                    "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement1 = connection.prepareStatement(insertCliente);
            preparedStatement1.setString(1, cliente.getNome());
            preparedStatement1.setString(2, cliente.getCpf());
            preparedStatement1.setString(3, cliente.getRg());
            preparedStatement1.setString(4, cliente.getTelefone());
            preparedStatement1.setString(5, cliente.getReferencia_comercial());
            preparedStatement1.setDate(6, cliente.getData_nascimento());
            logger.info("String insert Cliente preparada: " + preparedStatement1);
            int resultado = preparedStatement1.executeUpdate();

            if (resultado > 0) {
                logger.info("Inseriu Cliente: " + resultado);
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

    public boolean alterar(Cliente cliente) throws SQLException {
        logger.info("--- Início do método DAO Alterar ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String updatePessoa = "update cliente set nome = ?, cpf = ?, rg = ?, telefone = ?, referencia_comercial = ?, data_nascimento = ? where id = ?";

            PreparedStatement preparedStatement1 = connection.prepareStatement(updatePessoa);
            preparedStatement1.setString(1, cliente.getNome());
            preparedStatement1.setString(2, cliente.getCpf());
            preparedStatement1.setString(3, cliente.getRg());
            preparedStatement1.setString(4, cliente.getTelefone());
            preparedStatement1.setString(5, cliente.getReferencia_comercial());
            preparedStatement1.setDate(6, cliente.getData_nascimento());
            preparedStatement1.setInt(7, cliente.getId());

            logger.info("String update cliente preparada: " + preparedStatement1);
            int resultadoCliente = preparedStatement1.executeUpdate();

            if (resultadoCliente > 0) {
                logger.info("Retorno maior que zero: " + resultadoCliente);
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

    public boolean excluir(Cliente cliente) throws SQLException {
        logger.info("--- Início do método DAO Excluir ---");

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String insertPessoa = "delete from cliente where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertPessoa);
            preparedStatement1.setInt(1, cliente.getId());
            logger.info("String delete cliente preparada: " + preparedStatement1);
            int resultadoCliente = preparedStatement1.executeUpdate();

            if (resultadoCliente > 0) {
                logger.info("Retorno maior que zero " + resultadoCliente);
                logger.info("--- Fim do método DAO Excluir ---");
                return true;
            } else {
                logger.info("Retorno menor que zero " + resultadoCliente);
                logger.info("--- Fim do método DAO Excluir ---");
                return false;

            }
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar excluir: " + e.getMessage());
            logger.error("--- Fim do método DAO Excluir ---");
            return false;
        }
    }

    public List<Cliente> buscarTodos() throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar Todos ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from cliente";
            List<Cliente> lista = new ArrayList<Cliente>();
            Cliente cliente;

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("CPF"));
                cliente.setRg(resultSet.getString("RG"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setReferencia_comercial(resultSet.getString("referencia_comercial"));
                cliente.setData_nascimento(resultSet.getDate("data_nascimento"));

                lista.add(cliente);
            }

            logger.info("Quantidade de registros pesquisados: " + lista.size());
            logger.info("--- Fim do método DAO Buscar Todos ---");

            return lista;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar todos: " + e.getMessage());
            return null;
        }
    }

    public Cliente buscar(int id) throws SQLException {
        try {
            logger.info("--- Início do método DAO Buscar por Id ---");

            Connection connection = DBConnection.getInstance().getConnection();

            String consulta = "select * from cliente where id = ?";
            Cliente cliente = new Cliente();

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            logger.info("Consulta executada: " + preparedStatement);

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("CPF"));
                cliente.setRg(resultSet.getString("RG"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setReferencia_comercial(resultSet.getString("referencia_comercial"));
                cliente.setData_nascimento(resultSet.getDate("data_nascimento"));
            }

            logger.info("--- Fim do método DAO Buscar por Id ---");

            return cliente;
        } catch (SQLException e) {
            logger.error("Ocorreu um erro ao tentar buscar: " + e.getMessage());
            return null;
        }
    }
}
