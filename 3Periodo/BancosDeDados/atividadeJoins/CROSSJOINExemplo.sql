
CREATE TABLE IF NOT EXISTS alunos(
  first_name TEXT,
  AGE INTEGER
);
INSERT INTO alunos VALUES
  ('João',25),
  ('Maria',30);

CREATE TABLE IF NOT EXISTS alunos2(
  first_name TEXT,
  AGE INTEGER
);
INSERT INTO alunos2 VALUES
  ('Fulano',15),
  ('Sicrano',20);
  
  SELECT * FROM alunos;
  SELECT * FROM alunos2;
  
SELECT * FROM alunos CROSS JOIN alunos2

