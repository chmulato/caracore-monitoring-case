-- ==============================================================================
-- Velsis Monitoramento - Script de Criação do Banco (PostgreSQL)
-- ==============================================================================

-- Tabela de Configurações Gerais
CREATE TABLE configuracao (
    id BIGSERIAL PRIMARY KEY,
    ip_teste_internet VARCHAR(255) NOT NULL,
    timeout_internet INTEGER NOT NULL,
    periodicidade_internet INTEGER NOT NULL, -- em segundos
    limite_disco_percentual DOUBLE PRECISION NOT NULL,
    periodicidade_disco INTEGER NOT NULL, -- em segundos
    periodicidade_camera INTEGER NOT NULL -- em segundos
);

-- Tabela de Câmeras Cadastradas
CREATE TABLE camera (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    ip VARCHAR(255) NOT NULL,
    porta_http INTEGER,
    porta_rtsp INTEGER,
    usuario VARCHAR(255),
    senha VARCHAR(255),
    ativa BOOLEAN DEFAULT true
);

-- Tabela de Alertas Gerados
CREATE TABLE alerta (
    id BIGSERIAL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL, -- 'internet', 'disco', 'camera'
    mensagem TEXT NOT NULL,
    severidade VARCHAR(20) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    camera_id BIGINT REFERENCES camera(id) -- Opcional, nulo se não for alerta de câmera
);

-- Tabela de Monitoramento de Internet
CREATE TABLE monitoramento_internet (
    id BIGSERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    tempo_resposta BIGINT,
    mensagem_erro TEXT
);

-- Tabela de Monitoramento de Disco
CREATE TABLE monitoramento_disco (
    id BIGSERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    espaco_total BIGINT NOT NULL,
    espaco_utilizado BIGINT NOT NULL,
    espaco_livre BIGINT NOT NULL,
    percentual_utilizado DOUBLE PRECISION NOT NULL,
    alerta_gerado BOOLEAN NOT NULL
);

-- Tabela de Monitoramento das Câmeras (Ping + RTSP)
CREATE TABLE monitoramento_camera (
    id BIGSERIAL PRIMARY KEY,
    camera_id BIGINT NOT NULL REFERENCES camera(id),
    data_hora TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    tempo_ping BIGINT,
    resultado_frame VARCHAR(255),
    mensagem_erro TEXT
);
