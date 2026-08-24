#include <stdio.h>
#include <string.h>
int questao_um() {
  int vetor_int[5];
  int soma = 0;
  for (int i = 0; i < 5; i++) {
    printf("Qual o inteiro que quer adicionar?\n");
    scanf("%d", &vetor_int[i]);
    soma += vetor_int[i];
  }
  return soma;
}
int questao_dois() {
  int vetor_int[10];
  printf("Qual o primeiro inteiro que quer adicionar?\n");
  scanf("%i", &vetor_int[0]);
  int maior = vetor_int[0];
  for (int i = 1; i < 10; i++) {
    printf("Qual o inteiro que quer adicionar?\n");
    scanf("%d", &vetor_int[i]);
    if (vetor_int[i] > maior) {
      maior = vetor_int[i];
    }
  }
  return maior;
}
int questao_tres() {
  int vetor_int[10];
  for (int i = 0; i < 10; i++) {
    printf("Qual o inteiro que quer adicionar?\n");
    scanf("%i", &vetor_int[i]);
  }
  int primeira_ocorrencia;
  printf("Qual o inteiro que quer verificar se existe?\n");
  scanf("%d", &primeira_ocorrencia);
  for (int i = 0; i < 10; i++) {
    if (vetor_int[i] == primeira_ocorrencia) {
      return i;
    }
  }
  return -1;
}
int questao_quatro() {
  int matriz_int[3][3];
  int soma = 0;
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      printf("Qual o inteiro que quer adicionar na linha %d e coluna %d ?\n", i,
             j);
      scanf("%d", &matriz_int[i][j]);
      soma += matriz_int[i][j];
    }
  }
  return soma;
}
int questao_cinco() {
  int matriz_int[3][4];
  printf("Qual o número inteiro que deseja adicionar no local (0,0)? \n");
  scanf("%i", &matriz_int[0][0]);
  int maior = matriz_int[0][0];
  for (int i = 1; i < 3; i++) {
    for (int j = 1; j < 4; j++) {
      printf("Qual o inteiro que quer adicionar na linha %d e coluna %d ?\n", i,
             j);
      scanf("%d", &matriz_int[i][j]);
      if (matriz_int[i][j] > maior) {
        maior = matriz_int[i][j];
      }
    }
  }
  return maior;
}
typedef struct {
  int codigo;
  float preco;
  int quantidade;
  char nome[];
} Produto;
float questao_seis(Produto p) { return p.preco * p.quantidade; }
typedef struct {
  char nome[50];
  float nota_1;
  float nota_2;
} Aluno;
void questao_sete(Aluno aluno_1, Aluno aluno_2, Aluno aluno_3, Aluno aluno_4,
                  Aluno aluno_5) {
  Aluno alunos[5] = {aluno_1, aluno_2, aluno_3, aluno_4, aluno_5};
  for (int i = 0; i < 5; i++) {
    float soma_notas = alunos[i].nota_1 + alunos[i].nota_2;
    float media = soma_notas / 2.0;
    printf("Média do aluno %s: %.2f\n", alunos[i].nome, media);
  }
  return;
}
