package prog2_projeto1.controllers;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import prog2_projeto1.DAOs.CategoriaDAO;
import prog2_projeto1.models.Categoria;

public class CategoriaController {
    
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    Logger logger = Logger.getLogger(CategoriaController.class);

    public boolean salvar(Categoria categoria) {
        try {
            if (categoriaDAO.salvar(categoria)) {
                logger.info("Categoria salva no controller!");
                return true;
            } else {
                logger.info("Erro ao salvar categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean alterar(Categoria categoria) {
        try {
            if (categoriaDAO.alterar(categoria)) {
                logger.info("Categoria alterada no controller!");
                return true;
            } else {
                logger.info("Erro ao alterar categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
    public boolean excluir(Categoria categoria) {
        try {
            if (categoriaDAO.excluir(categoria)) {
                logger.info("Categoria excluida no controller!");
                return true;
            } else {
                logger.info("Erro ao excluir categoria no controller!");
                return false;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
    public List<Categoria> buscarTodos() {
        try {
            List<Categoria> categorias = categoriaDAO.buscarTodos();
            logger.info("Categorias buscadas com sucesso no controller!");
            return categorias;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    public Categoria buscar(int id) {
        try {
            Categoria categoria = categoriaDAO.buscar(id);
            logger.info("Categoria buscada com sucesso no controller!");
            return categoria;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
