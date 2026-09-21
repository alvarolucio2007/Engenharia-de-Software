// go:build ignore

#include <stdlib.h>
typedef struct No {
  int dado;
  struct No *prox;
} No;
typedef struct ListaEncadeada {
  No *inicio;
} Lista;
void inserir_inicio(Lista *l, int dado) {
  No *primeiro = NULL;
  primeiro = malloc(sizeof(No));
  if (primeiro == NULL)
    return;
  primeiro->dado = dado;
  primeiro->prox = l->inicio;
  l->inicio = primeiro;
}
void inserir_fim(Lista *l, int dado) {
  if (l == NULL) {
    return;
  }
  No *novo = malloc(sizeof(No));
  if (novo == NULL)
    return;
  novo->dado = dado;
  novo->prox = NULL;

  if (l->inicio == NULL) {
    l->inicio = novo;
    return;
  }
  No *atual = l->inicio;
  while (atual->prox != NULL) {
    atual = atual->prox;
  }
  atual->prox = novo;
}
int remover(Lista *l, int valor) {
  if (l == NULL || l->inicio == NULL) {
    return 0;
  }
  No *atual = l->inicio;
  No *anterior = NULL;

  while (atual != NULL && atual->dado != valor) {
    anterior = atual;
    atual = atual->prox;
  }
  if (atual == NULL) {
    return 0;
  }
  if (anterior == NULL) {
    l->inicio = atual->prox;
  } else {
    anterior->prox = atual->prox;
  }
  free(atual);
  return 1;
}

void liberar(Lista *l) {
  if (l == NULL)
    return;
  No *node_antigo = l->inicio;
  while (node_antigo != NULL) {
    No *node_novo = node_antigo->prox;
    free(node_antigo);
    node_antigo = node_novo;
  }
  l->inicio = NULL;
}
