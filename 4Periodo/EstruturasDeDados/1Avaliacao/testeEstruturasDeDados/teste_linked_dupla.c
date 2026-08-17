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
  novo_node->dado = dado;
  if (esta_vazio(f)) {
    f->primeiro = novo_node; // é ambos primeiro e ultimo se estiver vazio
    f->primeiro->node_anterior = NULL; // não tem vizinhos.
    f->primeiro->node_posterior = NULL;

    f->ultimo = novo_node;
  } else {
    Node *ultimo_node_antigo = f->ultimo;
    f->ultimo = novo_node;
    f->ultimo->node_anterior = ultimo_node_antigo;
    f->ultimo->node_posterior =
        NULL; // Não possui node após, já que é o último.
    ultimo_node_antigo->node_posterior = novo_node;
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
  } else {
    f->primeiro->node_anterior = NULL;
  }
  return true;
}
bool ver_fila_dinamica(FilaDuplamenteEncadeada *f, int *valor) {
  if (esta_vazio(f)) {
    return false;
  }
  *valor = f->primeiro->dado;
  return true;
}
void destruir_fila(FilaDuplamenteEncadeada *f) {
  Node *atual = f->primeiro;
  while (atual != NULL) {
    Node *prox = atual->node_posterior;
    free(atual);
    atual = prox;
  }
  f->primeiro = NULL;
  f->ultimo = NULL;
}
int tamanho_fila(FilaDuplamenteEncadeada *f) {
  int count = 0;
  Node *atual = f->primeiro;
  while (atual != NULL) {
    count++;
    atual = atual->node_posterior;
  }
  return count;
}
