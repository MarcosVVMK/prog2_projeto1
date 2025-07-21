package prog2_projeto1.controllers;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.DAOs.ClienteDAO;
import prog2_projeto1.models.Cliente;


public class ClienteController {

    ClienteDAO clienteDAO = new ClienteDAO();
    Logger logger = Logger.getLogger(ClienteController.class);

    public boolean salvar(Cliente cliente) {
        try {
            if (clienteDAO.salvar(cliente)) {
                logger.info("Cliente salvo no controller!");
                return true;
            } else {
                logger.info("Erro ao salvar cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        try {
            if (clienteDAO.alterar(cliente)) {
                logger.info("Cliente alterado no controller!");
                return true;
            } else {
                logger.info("Erro ao alterar cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        try {
            if (clienteDAO.excluir(cliente)) {
                logger.info("Cliente excluido no controller!");
                return true;
            } else {
                logger.info("Erro ao excluir cliente no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Cliente> buscarTodos() {
        try {
            List<Cliente> clientes = clienteDAO.buscarTodos();
            if (clientes != null) {
                logger.info("Cliente salvo no controller!");
                return clientes;
            } else {
                logger.info("Erro ao salvar cliente no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Cliente buscar(int id) {
        try {
            if (clienteDAO.buscar(id) != null) {
                logger.info("Cliente encontrado no controller!");
                return clienteDAO.buscar(id);
            } else {
                logger.info("Erro ao encontrar cliente no controller!");
                return null;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
