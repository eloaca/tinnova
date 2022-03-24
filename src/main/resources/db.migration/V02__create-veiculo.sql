CREATE TABLE veiculo (
  id BIGINT IDENTITY PRIMARY KEY,
  veiculo VARCHAR(50) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  ano INT NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  vendido TINYINT NOT NULL,
  cor VARCHAR(50) NOT NULL,
  created datetime NOT NULL,
  updated datetime
);
