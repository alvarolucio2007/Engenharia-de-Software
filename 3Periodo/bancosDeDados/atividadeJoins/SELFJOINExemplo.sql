
CREATE TABLE IF NOT EXISTS alunos(
  first_name TEXT,
  AGE INTEGER
);
INSERT INTO alunos VALUES
  ('João',25),
  ('Maria',30);
SELECT * FROM alunos;
SELECT 
    a.first_name AS Aluno_A, 
    a.age AS Idade_A,
    b.first_name AS Aluno_B, 
    b.age AS Idade_B
FROM alunos a
JOIN alunos b ON a.age > b.age;
