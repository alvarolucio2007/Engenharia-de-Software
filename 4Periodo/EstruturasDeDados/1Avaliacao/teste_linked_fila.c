#include <stdbool.h>
#include <stdlib.h>
typedef struct Node {
  int dado;
  struct Node *proximo;
} Node;
typedef struct FilaDinamica {
  Node *primeiro;
  Node *ultimo;
  int tamanho;
} FilaDinamica;
bool esta_vazia(FilaDinamica *f) { return f->tamanho == 0; }
bool push_fila_dinamica(FilaDinamica *f, int item) {
  Node *novo_node = malloc(sizeof(Node));
  if (novo_node == NULL) {
    return false;
  }
  if (f->ultimo == NULL) {   // se a fila estiver vazia
    f->primeiro = novo_node; // o primeiro também é o último
    f->ultimo = novo_node;
  } else {
    f->ultimo->proximo = novo_node;
    f->ultimo = novo_node;
  }
  f->tamanho++;
  return true;
}
bool pop_fila_dinamica(FilaDinamica *f, int *saida) {
  if (esta_vazia(f)) {
    return false;
  }
  *saida = f->primeiro
               ->dado; // pega o dado do primeiro da fila, e injeta na saida lá
  Node *prox_no = f->primeiro->proximo;
  free(f->primeiro);
  f->primeiro = prox_no; // fila anda...
  if (f->primeiro == NULL) {
    f->ultimo = NULL; // se o próximo está vazio, fila acabou. devo dar free?
                      // acho q n, toda vez q da pop já da free do node usado
  }
  f->tamanho--;
  return true;
}
int tamanho_fila_dinamica(FilaDinamica *f) { return f->tamanho; }

int view_fila_dinamica(FilaDinamica *f) {
  if (tamanho_fila_dinamica(f) == 0) {
    return -1;
  }
  return f->primeiro->dado;
}
