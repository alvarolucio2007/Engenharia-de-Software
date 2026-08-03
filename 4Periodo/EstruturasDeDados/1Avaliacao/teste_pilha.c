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
int esta_cheia(
    Pilha *p) { // Retorna 0 (false) se não estiver cheia, 1 se estiver.
  if (p->tamanho == p->maxItens) {
    return 1;
  }
  return 0;
}
int esta_vazia(Pilha *p) {
  if (p->tamanho == 0) {
    return 1;
  }
  return 0;
}
int push(Pilha *p, int novo_item) {
  int is_cheia = esta_cheia(p);
  if (is_cheia == 1) {
    return -1;
  }
  p->estrutura[p->tamanho] = novo_item;
  p->tamanho += 1;
  return 0;
}
int pop(Pilha *p) {
  int is_vazia = esta_vazia(p);
  if (is_vazia == 1) {
    return -1;
  }
  p->tamanho--;
  int popped = p->estrutura[p->tamanho];
  return popped;
}
int view(Pilha *p) {
  if (esta_vazia(p)) {
    return -1;
  }
  return p->estrutura[p->tamanho - 1];
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

  printf("%d\n", view(&minha_pilha)); // 10

  free_pilha(&minha_pilha);
  return 0;
}
