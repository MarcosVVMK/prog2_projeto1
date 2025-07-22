package prog2_projeto1.utils;

import java.util.Date;
import java.util.List;

import prog2_projeto1.interfaces.IMetodos;


public abstract class EntidadeBase implements IMetodos{

    private int id;
    private Date dataCadastro;

    public EntidadeBase(int id, Date dataCadastro) {
        this.id = id;
        this.dataCadastro = dataCadastro;
    }

    public EntidadeBase() {
        this.id = 0;
        this.dataCadastro = new Date();
    }

    @Override
    public boolean salvar() {
        return true;
    }

    @Override
    public boolean alterar() {
        return true;
    }

    @Override
    public boolean excluir() {
        return true;
    }

    @Override
    public Object buscar() {
        return null;
    }

    @Override
    public Object buscarPor() {
        return null;
    }
    
    @Override
    public List<Object> buscarTodos() {
        return null;
    }

    public boolean validaData( Object data) {
        return false;
    }

    public boolean validaId(int id) {
        return id > 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (validaId(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID inválido");
        }
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        if (validaData(dataCadastro)) {
            this.dataCadastro = dataCadastro;
        } else {
            throw new IllegalArgumentException("Data inválida");
        }
    }
}
