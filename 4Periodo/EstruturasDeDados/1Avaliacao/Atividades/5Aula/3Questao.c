#include <stdio.h>
#include <string.h>
#define MAX 5
typedef struct Aluno {
  int matricula;
  char nome[41];
  float nota1;
  float nota2;
} Aluno;
void imprimir_turma(const Aluno t[], int n) {
  for (int i = 0; i < n; i++) {
    Aluno a = t[i];
    printf("%d | %s | %f %f | media %f \n", a.matricula, a.nome, a.nota1,
           a.nota2, (a.nota1 + a.nota2) / 2);
  }
}
Aluno ler_aluno(void) {
  Aluno a;
  printf("Por favor insira a matrícula: \n");
  scanf("%d", &a.matricula);
  printf("Por favor insira a primeira nota: \n");
  scanf("%f", &a.nota1);
  printf("Por favor insira a segunda nota: \n");
  scanf("%f", &a.nota2);
  getchar();
  printf("Por favor insira o nome: \n");
  fgets(a.nome, sizeof(a.nome), stdin);
  a.nome[strcspn(a.nome, "\n")] = '\0';
  return a;
}
float media_da_turma(const Aluno t[], int n) {
  if (n <= 0) {
    return -1;
  }
  float sum_nota = 0.0f;
  for (int i = 0; i < n; i++) {
    sum_nota += t[i].nota1 + t[i].nota2;
  }
  float media_nota = sum_nota / (2 * n);
  return media_nota;
}
float media_aluno_individual(const Aluno *a) {
  return (a->nota1 + a->nota2) / 2;
}
int indice_maior_media(const Aluno t[], int n) {
  if (n <= 0) {
    return -1;
  }
  int max_indice = 0;
  for (int i = 0; i < n; i++) {
    float media_indice = media_aluno_individual(&t[max_indice]);
    if (media_indice < media_aluno_individual(&t[i])) {
      max_indice = i;
    }
  }
  return max_indice + 1;
}
int main() {
  Aluno turma[MAX];
  for (int i = 0; i < MAX; i++) {
    turma[i] = ler_aluno();
  }
  imprimir_turma(turma, MAX);
  printf("%f\n", media_da_turma(turma, MAX));
  printf("%d\n", indice_maior_media(turma, MAX));
  return 0;
}
// O campo não é procurado na execução do produto, mas sim na compilação, que
// faz a aritmética necessária para simplificar massivamente a procura na hora
// da execução.
