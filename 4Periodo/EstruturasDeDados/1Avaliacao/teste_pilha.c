#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
typedef struct {
  int tamanho;
  int maxItens;
  int *estrutura;
} Pilha;
void new_pilha(Pilha *p, int capacidade) {
  p->estrutura = (int *)malloc(capacidade * sizeof(int));
  p->tamanho = 0;
  p->maxItens = capacidade;
}
bool esta_cheia(Pilha *p) {
  if (p->tamanho == p->maxItens) {
    return true;
  }
  return false;
}
bool esta_vazia(Pilha *p) {
  if (p->tamanho == 0) {
    return true;
  }
  return false;
}
bool push(Pilha *p, int novo_item) {
  int is_cheia = esta_cheia(p);
  if (is_cheia == 1) {
    return false;
  }
  p->estrutura[p->tamanho] = novo_item;
  p->tamanho += 1;
  return true;
}
bool pop(Pilha *p, int *valor) {
  int is_vazia = esta_vazia(p);
  if (is_vazia == 1) {
    return false;
  }
  p->tamanho--;
  *valor = p->estrutura[p->tamanho];
  return true;
}
bool view(Pilha *p, int *valor) {
  if (esta_vazia(p)) {
    return false;
  }
  *valor = p->estrutura[p->tamanho - 1];
  return true;
}
int qual_tamanho(Pilha *p) { return p->tamanho; }
void free_pilha(Pilha *p) {
  free(p->estrutura);
  p->estrutura = NULL;
  p->tamanho = 0;
  p->maxItens = 0;
}
int main() {
  Pilha minha_pilha;
  new_pilha(&minha_pilha, 10);

  push(&minha_pilha, 5);
  push(&minha_pilha, 10);

  int valor;
  view(&minha_pilha, &valor);
  printf("%d\n", valor); // 10

  free_pilha(&minha_pilha);
  return 0;
}
