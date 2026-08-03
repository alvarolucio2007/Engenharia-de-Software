#include <stdlib.h>
typedef struct {
  int primeiro;
  int ultimo;
  int *estrutura;
  int maxItens;
} Fila;
void new_fila(Fila *f, int capacidade) {
  f->estrutura = (int *)malloc(capacidade * sizeof(int));
  f->primeiro = 0;
  f->ultimo = 0;
  f->maxItens = capacidade;
}
int esta_cheia(Fila *f) {
  return ((f->ultimo + 1) % f->maxItens) == f->primeiro;
}
int esta_vazia(Fila *f) { return f->primeiro == f->ultimo; }
int push(Fila *f, int novo_item) {
  if (esta_cheia(f)) {
    return -1;
  }
  f->estrutura[f->ultimo] = novo_item;
  f->ultimo = (f->ultimo + 1) % f->maxItens;
  return 0;
}
int pop(Fila *f) {
  if (esta_vazia(f)) {
    return -1;
  }
  int valor = f->estrutura[f->primeiro];
  f->primeiro = (f->primeiro + 1) % f->maxItens;
  return valor;
}
int view(Fila *f) {
  if (esta_vazia(f)) {
    return -1;
  }
  return f->estrutura[f->primeiro];
}
