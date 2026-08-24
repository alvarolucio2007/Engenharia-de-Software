#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#define MAX_NOME 100
#define NUM_ALUNOS 3
typedef struct Aluno {
  int matricula;
  float media;
  char nome[MAX_NOME];
} Aluno;
bool validar_aluno(Aluno *a, int matricula, float media, char nome[]) {
  if (matricula < 0) {
    printf("Matrícula menor que 0.\n");
    return false;
  }
  if (media > 10 || media < 0) {
    printf("Média menor que 0 ou maior que 10.\n");
    return false;
  }
  if (strlen(nome) == 0) {
    printf("Nome vazio.\n");
    return false;
  }
  a->matricula = matricula;
  strncpy(a->nome, nome, MAX_NOME - 1);
  a->nome[MAX_NOME - 1] = '\0';
  a->media = media;
  return true;
}
bool atualizar_nota(Aluno *a, float nota) {
  if (nota < 0 || nota > 10) {
    printf("Nota menor que 0 ou maior que 10.\n");
    return false;
  }
  a->media = nota;
  return true;
}

int main() {
  Aluno alunos[NUM_ALUNOS];
  char nome[MAX_NOME] = "\0";

  for (int i = 0; i < NUM_ALUNOS; i++) {
    printf("Qual o nome?\n");
    scanf("%99s", nome);
    float media;
    printf("Qual a média?\n");
    scanf("%f", &media);
    int matricula;
    printf("Qual a matrícula?\n");
    scanf("%i", &matricula);
    if (!validar_aluno(&alunos[i], matricula, media, nome)) {
      return 1;
    }
  }

  float soma = 0;
  for (int i = 0; i < NUM_ALUNOS; i++) {
    soma += alunos[i].media;
  }
  printf("média: %f\n", soma / NUM_ALUNOS);

  printf("Nova nota para o primeiro aluno:\n");
  float nota;
  scanf("%f", &nota);
  if (!atualizar_nota(&alunos[0], nota)) {
    return 1;
  }
  for (int i = 0; i < NUM_ALUNOS; i++) {
    if (alunos[i].media >= 7) {
      printf("%s:Aprovado\n", alunos[i].nome);
    } else if (alunos[i].media >= 5) {
      printf("%s:Prova final\n", alunos[i].nome);
    } else {
      printf("%s:Reprovado\n", alunos[i].nome);
    }
  }
  printf("Fim do Programa");
  return 0;
}
