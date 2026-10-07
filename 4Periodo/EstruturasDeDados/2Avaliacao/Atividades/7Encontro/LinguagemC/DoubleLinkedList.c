#include <stdio.h>
#include <stdlib.h>
typedef struct No {
  int dado;
  struct No *ant;
  struct No *prox;
} No;
typedef struct ListaDupla {
  No *inicio;
  No *fim;
} ListaDupla;
void inserir_fim(ListaDupla *l, int dado) {
  No *ultimo = NULL;
  ultimo = malloc(sizeof(No));
  if (ultimo == NULL) {
    printf("sem mais espaço na RAM");
    return;
  }
  ultimo->dado = dado;
  ultimo->prox = NULL;
  if (l->inicio == NULL) {
    ultimo->ant = NULL;
    l->inicio = ultimo;
    l->fim = ultimo;
  }
  ultimo->ant = l->fim;
  l->fim->prox = ultimo;
  l->fim = ultimo;
}
