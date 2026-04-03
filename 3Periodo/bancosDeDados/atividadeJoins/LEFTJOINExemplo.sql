DROP TABLE alunos;
DROP TABLE alunos2;
CREATE TABLE IF NOT EXISTS alunos(
  first_name TEXT,
  AGE INTEGER
);
INSERT INTO alunos VALUES
  ("João",25),
  ("Maria",30);

CREATE TABLE IF NOT EXISTS alunos2(
  first_name TEXT,
  AGE INTEGER
);
INSERT INTO alunos2 VALUES
  ("Fulano",25),
  ("Sicrano",30);
  
  SELECT * FROM alunos;
  SELECT * FROM alunos2;
  
SELECT * FROM alunos LEFT JOIN alunos2 ON alunos.AGE=alunos2.AGE

