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

  RAISE INFO '%',p_nome;
  RAISE INFO '%',p_email;
  RAISE INFO '%',p_telefone;
END;
$$;
CALL consultar_hospede(2);

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
  RAISE INFO 'Valor total: %', quantidade_dias*v_valor_diaria;
END;
$$;
CALL calcular_valor_reserva(1);

CREATE OR REPLACE PROCEDURE calcular_valor_com_desconto(
  v_id_reserva INTEGER
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
  RAISE INFO 'Valor total: %', quantidade_dias*v_valor_diaria - quantidade_dias*v_valor_diaria*v_valor_desconto/100;
END;
$$;
CALL calcular_valor_com_desconto(1,100);
