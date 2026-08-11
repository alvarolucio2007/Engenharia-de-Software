#include <stdbool.h>
#include <stdlib.h>
typedef struct Node {
  int dado;
  struct Node *node_anterior;
  struct Node *node_posterior;
} Node;
typedef struct FilaDuplamenteEncadeada {
  Node *primeiro;
  Node *ultimo;
} FilaDuplamenteEncadeada;
bool esta_vazio(FilaDuplamenteEncadeada *f) { return f->ultimo == NULL; };
bool criar_node(FilaDuplamenteEncadeada *f, int dado) {
  Node *novo_node = malloc(sizeof(Node));
  if (novo_node == NULL) {
    return false;
  }
  if (esta_vazio(f)) {
    f->primeiro = novo_node; // é ambos primeiro e ultimo se estiver vazio
    f->primeiro->node_anterior = NULL; // não tem vizinhos.
    f->primeiro->node_posterior = NULL;

    f->ultimo = novo_node;
    f->ultimo->node_anterior = NULL;
    f->ultimo->node_posterior = NULL;
  } else {
    Node *ultimo_node_antigo = f->ultimo;
    f->ultimo = novo_node;
    f->ultimo->node_anterior = ultimo_node_antigo;
    f->ultimo->node_posterior =
        NULL; // Não possui node após, já que é o último.
  }
  return true;
}
bool pop_fila_duplamente_encadeada(FilaDuplamenteEncadeada *f, int *saida) {
  if (esta_vazio(f)) {
    return false;
  }
  *saida = f->primeiro->dado;
  Node *prox_no = f->primeiro->node_posterior;
  free(f->primeiro);
  f->primeiro = prox_no;
  if (f->primeiro == NULL) { // último item da lista encadeada dupla
    f->ultimo = NULL;        // fila cabou...
  }
  return true;
}
int view_fila_dinamica(FilaDuplamenteEncadeada *f, int *valor) {
  if (esta_vazio(f)) {
    return -1;
  }
  *valor = f->primeiro->dado;
  return true;
}
