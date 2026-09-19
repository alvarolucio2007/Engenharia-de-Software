CREATE TABLE hospedes (
    id_hospede SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefone VARCHAR(20)
);
INSERT INTO hospedes (nome, email, telefone)
VALUES
    ('Ana Oliveira', 'ana@email.com', '86999990001'),
    ('Bruno Santos', 'bruno@email.com', '86999990002'),
    ('Carla Mendes', 'carla@email.com', '86999990003'),
    ('Daniel Costa', 'daniel@email.com', '86999990004');
SELECT * FROM hospedes;

CREATE TABLE reservas (
    id_reserva SERIAL PRIMARY KEY,
    id_hospede INTEGER NOT NULL,
    data_checkin DATE NOT NULL,
    data_checkout DATE NOT NULL,
    valor_diaria NUMERIC(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'ATIVA',

    FOREIGN KEY (id_hospede)
        REFERENCES hospedes(id_hospede)
);
INSERT INTO reservas (
    id_hospede,
    data_checkin,
    data_checkout,
    valor_diaria,
    status
)
VALUES
    (1, '2026-10-10', '2026-10-13', 250.00, 'ATIVA'),
    (2, '2026-10-15', '2026-10-18', 300.00, 'ATIVA'),
    (3, '2026-11-05', '2026-11-07', 200.00, 'ATIVA');
SELECT * FROM reservas;

-- Questão 1
CREATE OR REPLACE PROCEDURE cadastrar_hospede(
  v_nome VARCHAR,
  v_email VARCHAR,
  v_telefone VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
  INSERT INTO hospedes (nome,email,telefone) VALUES (v_nome,v_email,v_telefone);
END;
$$;
CALL cadastrar_hospede('teste','teste@gmail.com','1234567890');

--Questão 2
CREATE OR REPLACE PROCEDURE atualizar_telefone_hospede(
  v_codigo INTEGER,
  v_telefone VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
  UPDATE hospedes SET telefone = v_telefone WHERE id_hospede = v_codigo;
END;
$$;
CALL atualizar_telefone_hospede(1,'0000000000');

-- Questão 3 e 4
CREATE OR REPLACE PROCEDURE consultar_hospede(
  v_codigo_hospede INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
  p_nome VARCHAR;
  p_email VARCHAR;
  p_telefone VARCHAR;
BEGIN
  SELECT nome,email,telefone INTO
  p_nome,p_email,p_telefone
  FROM hospedes WHERE id_hospede = v_codigo_hospede;
  IF p_nome IS NULL THEN
    RAISE EXCEPTION 'Hóspede não existe'; 
  END IF;

  RAISE NOTICE '%',p_nome;
  RAISE NOTICE '%',p_email;
  RAISE NOTICE '%',p_telefone;
END;
$$;
CALL consultar_hospede(2);
--Questão 5,6 e 7
CREATE OR REPLACE PROCEDURE criar_reserva(
  v_codigo_hospede INTEGER,
  v_data_checkin DATE,
  v_data_checkout DATE,
  v_valor_diaria NUMERIC(10,2)
)
LANGUAGE plpgsql
AS $$
BEGIN
  IF (SELECT id_hospede FROM hospedes WHERE id_hospede = v_codigo_hospede) IS NULL THEN
    RAISE EXCEPTION 'Hóspede não existe';
  END IF;
  INSERT INTO reservas (id_hospede,data_checkin,data_checkout,valor_diaria)
  VALUES (v_codigo_hospede, v_data_checkin, v_data_checkout,v_valor_diaria);

END;
$$;

CALL criar_reserva(1,'09-18-26'::date,'09-19-26'::date,10);
--Questão 8 e 9
CREATE OR REPLACE PROCEDURE cancelar_reserva(
  v_id_reserva INTEGER
)
LANGUAGE plpgsql
AS $$
BEGIN
  IF (SELECT id_reserva FROM reservas WHERE id_reserva = v_id_reserva) IS NULL THEN
    RAISE EXCEPTION 'Reserva não existe';
  END IF;
  IF (SELECT status FROM reservas WHERE id_reserva = v_id_reserva) = 'CANCELADA' THEN
    RAISE EXCEPTION 'Reserva já cancelada';
  END IF;

  UPDATE reservas SET status = 'CANCELADA' WHERE id_reserva = v_id_reserva;
END;
$$;
CALL cancelar_reserva(1);
SELECT * FROM reservas;

--Questão 10
CREATE OR REPLACE PROCEDURE calcular_valor_reserva(
  v_id_reserva INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
  quantidade_dias INTEGER;
  v_valor_diaria NUMERIC(10,2);
BEGIN
  SELECT (data_checkout-data_checkin) INTO quantidade_dias FROM reservas WHERE id_reserva=v_id_reserva;
  SELECT valor_diaria INTO v_valor_diaria FROM reservas WHERE id_reserva = v_id_reserva;
  RAISE NOTICE 'Valor total: %', quantidade_dias*v_valor_diaria;
END;
$$;
CALL calcular_valor_reserva(1);
--Questão 11
CREATE OR REPLACE PROCEDURE calcular_valor_com_desconto(
  v_id_reserva INTEGER,
  v_valor_desconto INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
  quantidade_dias INTEGER;
  v_valor_diaria NUMERIC(10,2);
BEGIN
  SELECT (data_checkout-data_checkin) INTO quantidade_dias FROM reservas WHERE id_reserva=v_id_reserva;
  SELECT valor_diaria INTO v_valor_diaria FROM reservas WHERE id_reserva = v_id_reserva;
  RAISE NOTICE 'Valor total: %', quantidade_dias*v_valor_diaria - quantidade_dias*v_valor_diaria*v_valor_desconto/100;
END;
$$;
CALL calcular_valor_com_desconto(1,100);
--Questão 12
CREATE OR REPLACE PROCEDURE finalizar_reserva(
  v_id_reserva INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
  v_status VARCHAR;
  v_valor_total NUMERIC(10,2);
BEGIN
  SELECT status, (data_checkout - data_checkin) * valor_diaria 
  INTO v_status, v_valor_total
  FROM reservas 
  WHERE id_reserva = v_id_reserva;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Reserva % não existe', v_id_reserva;
  END IF;
  IF v_status != 'ATIVA' THEN
    RAISE EXCEPTION 'Reserva não está ativa (Status atual: %)', v_status;
  END IF;

  SELECT (data_checkout - data_checkin) * valor_diaria 
  INTO v_valor_total
  FROM reservas 
  WHERE id_reserva = v_id_reserva;

  RAISE NOTICE 'Valor total: %', v_valor_total;

  UPDATE reservas SET status = 'FINALIZADA' WHERE id_reserva = v_id_reserva;
  RAISE NOTICE 'Reserva finalizada';
END;
$$;
CALL finalizar_reserva(2);

-- Questão 13
CREATE OR REPLACE PROCEDURE alterar_valor_diaria(
  v_id_reserva INTEGER,
  v_novo_diaria NUMERIC(10,2)
)
LANGUAGE plpgsql
AS $$
DECLARE 
  v_status VARCHAR;
BEGIN
  SELECT status 
  INTO v_status
  FROM reservas 
  WHERE id_reserva = v_id_reserva;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Reserva % não existe', v_id_reserva;
  END IF;
  IF v_status != 'ATIVA' THEN
    RAISE EXCEPTION 'Reserva não está ativa (Status atual: %)', v_status;
  END IF;
  IF v_novo_diaria<0 THEN
    RAISE EXCEPTION 'Valor novo é menor que 0';
  END IF;
  UPDATE reservas SET valor_diaria = v_novo_diaria WHERE id_reserva = v_id_reserva;
  RAISE NOTICE 'Reserva atualizada';
END;
$$;
--Questão 14
CREATE OR REPLACE PROCEDURE reabrir_reserva(
  v_id_reserva INTEGER
)
LANGUAGE plpgsql
AS $$
BEGIN
  SELECT status 
  FROM reservas 
  WHERE id_reserva = v_id_reserva;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Reserva % não existe', v_id_reserva;
  END IF;
  IF v_status!='CANCELADA' THEN
    RAISE EXCEPTION 'Reserva não está com status cancelada, mas sim com status %',v_status;
  END IF;
  UPDATE reservas SET v_status = 'ATIVA' WHERE id_reserva = v_id_reserva;
  RAISE NOTICE 'Reserva reaberta';
END;
$$;
--Questão 15
CREATE OR REPLACE PROCEDURE confirmar_reserva(
  v_id_reserva INTEGER
)
LANGUAGE plpgsql
AS $$
DECLARE
  v_status VARCHAR;
  v_id_hospede INTEGER;
  v_diferenca_datas INTEGER;
  v_data_checkin DATE;
  v_data_checkout DATE;
  v_valor_diaria NUMERIC;
BEGIN
  SELECT status,id_hospede INTO v_status,v_id_hospede FROM reservas
  WHERE id_reserva = v_id_reserva;
  IF NOT FOUND THEN 
    RAISE EXCEPTION 'Reserva % não existe',v_id_reserva;
  END IF;
  PERFORM id_hospede FROM hospedes
  WHERE id_hospede=v_id_hospede;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Hóspede % não existe',v_id_hospede;
  END IF;
  IF v_status != 'ATIVA' THEN
    RAISE EXCEPTION 'Reserva % não está ativa',v_id_reserva;
  END IF;
  SELECT (data_checkout-data_checkin) INTO v_diferenca_datas FROM reservas WHERE id_reserva=v_id_reserva;
  IF v_diferenca_datas < 0 THEN
    RAISE EXCEPTION 'Datas inválidas, data checkout é antes de data_checkin';
  END IF;
  SELECT valor_diaria INTO v_valor_diaria FROM reservas WHERE id_reserva=v_id_reserva;
  IF v_valor_diaria < 0  THEN
    RAISE EXCEPTION 'Valor da diária inválida, tem que ser maior que 0';
  END IF;

  RAISE NOTICE 'ID Reserva: % | Hóspede: %', v_id_reserva, v_id_hospede;
  RAISE NOTICE 'Período: % dias', v_diferenca_datas;
  RAISE NOTICE 'Valor total: R$ %', (v_diferenca_datas * v_valor_diaria);
  UPDATE reservas SET status = 'ATIVA' WHERE id_reserva = v_id_reserva;
END;
$$;
CALL confirmar_reserva(3);
