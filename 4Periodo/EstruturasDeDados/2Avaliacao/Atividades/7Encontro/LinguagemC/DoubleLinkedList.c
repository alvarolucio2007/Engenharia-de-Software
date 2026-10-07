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
  } else {
    ultimo->ant = l->fim;
    l->fim->prox = ultimo;
    l->fim = ultimo;
  }
}
void remover(ListaDupla *l, No *alvo) {
  if (l->inicio == alvo) {
    No *temp = l->inicio;
    if (l->inicio->prox != NULL) {
      l->inicio = l->inicio->prox;
      l->inicio->ant = NULL;
    } else {
      l->inicio = NULL;
      l->fim = NULL;
    }
    free(temp);
  }
  if (l->fim == alvo) {
    No *temp = l->fim;
    if (l->fim->ant != NULL) {
      l->fim = l->fim->ant;
      l->fim->prox = NULL;
    } else {
      l->inicio = NULL;
      l->fim = NULL;
    }
    free(l->fim);
    return;
  }
  alvo->ant->prox = alvo->prox;
  alvo->prox->ant = alvo->ant;
  free(alvo);
}
void imprimir_tras(const ListaDupla *l) {
  if (l->fim == NULL) {
    return;
  }
  No *node_atual = l->fim;
  while (node_atual != NULL) {
    printf("%d", node_atual->dado);
    node_atual = node_atual->ant;
  }
  printf("\n");
  return;
}
void imprimir_frente(const ListaDupla *l) {
  if (l->inicio == NULL) {
    return;
  }
  No *node_atual = l->inicio;
  while (node_atual != NULL) {
    printf("%d", node_atual->dado);
    node_atual = node_atual->prox;
  }
  printf("\n");
  return;
}
