#include <stdbool.h>
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
bool esta_cheia(Fila *f) {
  return ((f->ultimo + 1) % f->maxItens) == f->primeiro;
}
bool esta_vazia(Fila *f) { return f->primeiro == f->ultimo; }
bool push(Fila *f, int novo_item) {
  if (esta_cheia(f)) {
    return false;
  }
  f->estrutura[f->ultimo] = novo_item;
  f->ultimo = (f->ultimo + 1) % f->maxItens;
  return true;
}
bool pop(Fila *f, int *valor) {
  if (esta_vazia(f)) {
    return false;
  }
  *valor = f->estrutura[f->primeiro];
  f->primeiro = (f->primeiro + 1) % f->maxItens;
  return true;
}
bool view(Fila *f, int *valor) {
  if (esta_vazia(f)) {
    return false;
  }
  *valor = f->estrutura[f->primeiro];

  return true;
}
