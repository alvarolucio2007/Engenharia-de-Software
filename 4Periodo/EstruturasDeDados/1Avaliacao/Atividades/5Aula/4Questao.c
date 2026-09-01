#include <stdio.h>
#include <string.h>
typedef struct Data {
  int dia, mes, ano;
} Data;
typedef struct Emprestimo {
  int codigo;
  char livro[51];
  Data saida;
  Data devolucao;
  float multa_por_dia;
} Emprestimo;

Emprestimo ler_aluno(void) {
  Emprestimo e;
  printf("Por favor insira o código : \n");
  scanf("%d", &e.codigo);
  printf("Por favor insira o nome do livro: \n");
  fgets(e.livro, sizeof(e.livro), stdin);
  e.livro[strcspn(e.livro, "\n")] = '\0';

  Data d;
  printf("Por favor insira o dia da primeira data: \n");
  scanf("%d", &d.dia);
  printf("Por favor insira o mes da primeira data: \n");
  scanf("%d", &d.mes);
  printf("Por favor insira o ano da primeira data: \n");
  scanf("%d", &d.ano);
  e.saida = d;
  printf("Por favor insira o dia da segunda data: \n");
  scanf("%d", &d.dia);
  printf("Por favor insira o mes da segunda data: \n");
  scanf("%d", &d.mes);
  printf("Por favor insira o ano da segunda data: \n");
  scanf("%d", &d.ano);
  e.saida = d;
  printf("Por favor insira a multa por dia: \n");
  scanf("%f", &e.multa_por_dia);
  getchar();
  return e;
}
void imprimir_data(Data d) { printf("%02d/%02d/%d", d.dia, d.mes, d.ano); }
void imprimir_emprestimo(const Emprestimo *e) {
  printf("%d | %s |", e->codigo, e->livro);
  imprimir_data(e->saida);
  printf(" -> ");
  imprimir_data(e->saida);
  printf(" | multa %.2f/dia \n", e->multa_por_dia);
}
int dias_entre(Data a, Data b) {
  int dias_a = (360 * a.ano) + (30 * a.mes) + a.dia;

  int dias_b = (360 * b.ano) + (30 * b.mes) + b.dia;
  return dias_b - dias_a;
}
float multa(const Emprestimo *e, Data hoje) {
  return dias_entre(e->saida, hoje);
}
int main() {
  Emprestimo emprestimos[3] = {{1, "um", {1, 1, 2001}, {2, 2, 2001}, 10},
                               {2, "dois", {1, 2, 2001}, {2, 3, 2001}, 20},
                               {3, "tres", {1, 2, 2001}, {2, 3, 2001}, 20}};
  for (int i = 0; i < 3; i++) {
    imprimir_emprestimo(&emprestimos[i]);
  }
}
// Pois Data d é uma struct extremamente pequena e simples (12 bytes), mas
// imprimir_emprestimo implementa um ponteiro em Emprestimo, pois a struct dele
// é muito grande (84 bytes), portanto utilizar ponteiro (que utiliza apenas 8
// bytes) é mais econômico. E é usado e->saida.dia pois a saida não é um
// ponteiro em si, mas sim um valor, se fosse um ponteiro seria e->saida->dia.
