-- Script de criação das tabelas do sistema de venda de veículos (PostgreSQL)
-- Baseado nas classes do pacote prog2_projeto1.models

-- Remover tabelas se existirem (ordem inversa devido às FK)
DROP TABLE IF EXISTS venda_veiculo CASCADE;
DROP TABLE IF EXISTS veiculo CASCADE;
DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS vendedor CASCADE;

-- Tabela categoria
CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Tabela cliente
-- Baseada na classe Cliente que herda de PessoaFisica
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(20),
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(100),
    referencia_comercial VARCHAR(255),
    data_nascimento DATE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela vendedor
-- Baseada na classe Vendedor que herda de PessoaFisica
CREATE TABLE vendedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(20),
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(100),
    salario NUMERIC(10,2),
    comissao NUMERIC(5,2),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela veiculo
-- Baseada na classe Veiculo
CREATE TABLE veiculo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ano INTEGER NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    cor VARCHAR(30),
    placa VARCHAR(10) UNIQUE NOT NULL,
    unico_dono BOOLEAN DEFAULT FALSE,
    categoria_id INTEGER,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE SET NULL
);

-- Tabela venda_veiculo
-- Baseada na classe VendaVeiculo
CREATE TABLE venda_veiculo (
    id SERIAL PRIMARY KEY,
    veiculo_id INTEGER NOT NULL,
    cliente_id INTEGER NOT NULL,
    vendedor_id INTEGER NOT NULL,
    valor_desconto NUMERIC(10,2) DEFAULT 0.00,
    valor_final NUMERIC(10,2) NOT NULL,
    data_venda DATE NOT NULL,
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id) ON DELETE CASCADE,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE,
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE
);

-- Inserir dados de exemplo para categoria
INSERT INTO categoria (nome, descricao) VALUES 
('Sedan', 'Veículos sedan de passeio'),
('Hatchback', 'Veículos hatchback compactos'),
('SUV', 'Veículos utilitários esportivos'),
('Caminhonete', 'Veículos de carga leve'),
('Motocicleta', 'Motocicletas e similares');

-- Comentários sobre as tabelas criadas (PostgreSQL):
-- 1. categoria: Armazena as categorias dos veículos
-- 2. cliente: Herda campos de PessoaFisica + campos específicos (referencia_comercial, data_nascimento)
-- 3. vendedor: Herda campos de PessoaFisica + campos específicos (salario, comissao)
-- 4. veiculo: Contém informações do veículo + FK para categoria
-- 5. venda_veiculo: Tabela de relacionamento entre veiculo, cliente e vendedor + dados da venda

-- Observações importantes para PostgreSQL:
-- - Usado SERIAL em vez de INT AUTO_INCREMENT para chaves primárias
-- - Usado INTEGER em vez de INT para compatibilidade
-- - Usado NUMERIC em vez de DECIMAL para valores monetários
-- - Adicionado CASCADE nos DROP TABLE para remover dependências
-- - Mantidas as constraints de chave estrangeira com ações apropriadas
-- - Campo unico_dono como BOOLEAN (nativo do PostgreSQL)
