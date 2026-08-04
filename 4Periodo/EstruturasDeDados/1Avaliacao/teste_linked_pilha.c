#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
  int dado;
  struct Node *proximo;
} Node;
typedef struct PilhaDinamica {
  Node *node_topo;
} PilhaDinamica;
void new_node(Node *n, int dado) {
  n->dado = dado;
  n->proximo = NULL;
}
void push_pilha_dinamica(PilhaDinamica *p, int item) {
  Node *novo_node = (Node *)malloc(sizeof(Node));
  if (novo_node == NULL) {
    return;
  }
  novo_node->dado = item;
  novo_node->proximo = p->node_topo;
  p->node_topo = novo_node;
}
bool is_empty_pilha(PilhaDinamica *p) {
  if (p->node_topo == NULL) {
    return true;
  }
  return false;
}
bool pop_pilha_dinamica(PilhaDinamica *p, int *saida) {
  if (is_empty_pilha(p)) {
    return false;
  }
  Node *topo = p->node_topo;
  saida = &topo->dado;
  p->node_topo = topo->proximo;
  free(topo);
  return true;
}
int view_pilha_dinamica(PilhaDinamica *p) {
  if (is_empty_pilha(p)) {
    return -1;
  }
  return p->node_topo->dado;
}
int tamanho_pilha_dinamica(PilhaDinamica *p) {
  int tamanho = 0;
  Node *node = p->node_topo;
  while (node != NULL) {
    tamanho++;
    node = node->proximo;
  }
  return tamanho;
}
int main() {
  PilhaDinamica minha_pilha;
  push_pilha_dinamica(&minha_pilha, 1);
  push_pilha_dinamica(&minha_pilha, 2);
  int saida_pop;
  pop_pilha_dinamica(&minha_pilha, &saida_pop);

  printf("%d\n", saida_pop);
  printf("%d\n", view_pilha_dinamica(&minha_pilha));
  return 0;
}
