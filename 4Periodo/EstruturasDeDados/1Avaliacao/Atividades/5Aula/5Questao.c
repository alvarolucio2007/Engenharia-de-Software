#include <stdio.h>
#include <string.h>
typedef struct Produto {
  int codigo;
  char nome[21];
  float preco;
  int quantidade;
} Produto;
typedef struct No {
  Produto info;
  struct No *prox;
} No;
void imprimir_lista(const No *p) {
  while (p != NULL) {
    printf("%d | %s | %.2f x %d = %.2f\n", p->info.codigo, p->info.nome,
           p->info.preco, p->info.quantidade,
           p->info.preco * p->info.quantidade);
    p = p->prox;
  }
}
float valor_total(const No *p) {
  float soma = 0;
  while (p != NULL) {
    soma += p->info.preco * p->info.quantidade;
    p = p->prox;
  }
  return soma;
}
int contar(const No *p) {
  int contagem = 0;
  while (p != NULL) {
    contagem++;
    p = p->prox;
  }
  return contagem;
}
No *buscar(No *p, int codigo) {
  while (p != NULL) {
    if (p->info.codigo == codigo) {
      return p;
    }
    p = p->prox;
  }
  return NULL;
}
void aplicar_desconto(No *p, float percentual) {
  while (p != NULL) {
    p->info.preco = p->info.preco - p->info.preco * (percentual / 100);
    p = p->prox;
  }
}

int main() {
  No n1, n2, n3, n4, n5;

  n1.info.codigo = 101;
  strcpy(n1.info.nome, "Teclado");
  n1.info.preco = 150.00f;
  n1.info.quantidade = 10;

  n2.info.codigo = 102;
  strcpy(n2.info.nome, "Mouse");
  n2.info.preco = 80.50f;
  n2.info.quantidade = 25;

  n5.info.codigo = 105;
  strcpy(n5.info.nome, "Vasco");
  n5.info.preco = 100.5f;
  n5.info.quantidade = 25;

  n3.info.codigo = 103;
  strcpy(n3.info.nome, "Monitor");
  n3.info.preco = 900.00f;
  n3.info.quantidade = 5;

  n4.info.codigo = 104;
  strcpy(n4.info.nome, "Mousepad");
  n4.info.preco = 30.00f;
  n4.info.quantidade = 50;

  n1.prox = &n2;
  n2.prox = &n3;
  n5.prox = n2.prox;
  n2.prox = &n5;
  n3.prox = &n4;
  n4.prox = NULL;

  imprimir_lista(&n1);
  printf("%f\n", valor_total(&n1));
  printf("%d\n", contar(&n1));
  printf("%p\n", buscar(&n1, 103));
  aplicar_desconto(&n1, 100);
  imprimir_lista(&n1);
}
// e) O quinto nó entre n2 e n3 pode ser colocado nomralmente na ordem
// originalmente dada, contudo, se invertido, entra em um loop infinito.
// diagrama: n2.prox=n5 , e n5.prox=n2, então fica em um loop infinito entre
// estes 2.
//
// f) O preço que a lista paga é a velocidade de pegar termos, que chega a ser
// O(n) comparado a O(1) em uma lista normal.
//
// g) Malloc.
