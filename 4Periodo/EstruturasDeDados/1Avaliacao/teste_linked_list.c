#include <stdbool.h>
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
  Node novo_node;
  new_node(&novo_node, item);
  p->node_topo = &novo_node;
}
bool is_empty_pilha(PilhaDinamica *p) {
  if (p->node_topo == NULL) {
    return true;
  }
  return false;
}
int pop_pilha_dinamica(PilhaDinamica *p) {
  int valor;
  if (is_empty_pilha(p)) {
    return -1;
  }
  valor = p->node_topo->dado;
  p->node_topo = p->node_topo->proximo;
  return valor;
}
int view_pilha_dinamica(PilhaDinamica *p) { return p->node_topo->dado; }
int tamanho_pilha_dinamica(PilhaDinamica *p) {
  int tamanho = 0;
  Node *node;
  for (node = p->node_topo; node != NULL; node = node->proximo) {
    tamanho++;
  }
  return tamanho;
}
