#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Node {
  char *chave;
  char *valor;
  struct Node *proximo;
} Node;
void new_node(struct Node *n, char *chave, char *valor) {
  n->chave = chave;
  n->valor = valor;
  n->proximo = NULL;
  return;
}
typedef struct HashMap {
  int num_elementos;
  int capacidade;
  struct Node **array;
} HashMap;
void newHashMap(struct HashMap *hm) {
  hm->capacidade = 100; // arbitrário
  hm->num_elementos = 0;
  hm->array = (struct Node **)calloc(hm->capacidade, sizeof(struct Node *));
  return;
}
int funcao_hashing(struct HashMap *hm, char *chave) {
  int soma = 0;
  int fator = 31;
  int len = strlen(chave);
  int capacidade = hm->capacidade;

  for (int i = 0; i < len; i++) {
    int valor_char = (int)chave[i];

    soma = (soma + (valor_char * fator)) % capacidade;

    fator = (fator * 31) % __INT16_MAX__; // ou INT16_MAX
  }

  return soma;
}
void insert(struct HashMap *hm, char *chave, char *valor) {
  int bucket_index = funcao_hashing(hm, chave);
  struct Node *novo_node = malloc(sizeof(struct Node)); // criando um novo nó
  new_node(novo_node, chave, valor);     // inserindo valores no nó
  if (hm->array[bucket_index] == NULL) { // sem colisão (happy path)
    hm->array[bucket_index] = novo_node;
  } else { // colisão (sad path)
    novo_node->proximo =
        hm->array[bucket_index]; // Insere no começo da lista encadeada
    hm->array[bucket_index] = novo_node;
  }
  hm->num_elementos++; // aumenta número de elementos
  return;
}
void delete_chave(struct HashMap *hm, char *chave) {
  int bucket_index = funcao_hashing(hm, chave);
  struct Node *node_anterior = NULL;
  struct Node *node_atual =
      hm->array[bucket_index]; // pega o primeiro node da lista encadeada
  while (node_atual != NULL) {
    if (strcmp(chave, node_atual->chave) == 0) {   // achou a chave
      if (node_atual == hm->array[bucket_index]) { // deleta o primeiro node
        hm->array[bucket_index] = node_atual->proximo;
      } else { // deleta o ultimo node ou o primeiro
        node_anterior->proximo = node_atual->proximo;
      }
      free(node_atual);    // libera da memória...
      hm->num_elementos--; // diminui numero de elementos
      break;
    }
    node_anterior = node_atual;
    node_atual = node_atual->proximo;
  }
  return;
}
char *procurar(struct HashMap *hm, char *chave) {
  int bucket_index = funcao_hashing(hm, chave);
  struct Node *bucket_head = hm->array[bucket_index];
  while (bucket_head != NULL) {
    if (strcmp(bucket_head->chave, chave) == 0) {
      return bucket_head->valor;
    }
    bucket_head = bucket_head->proximo;
  }
  char *mensagem_erro = malloc(sizeof(char) * 25);
  strcpy(mensagem_erro, "Vazio.");
  return mensagem_erro;
}
int main() {

  // Initialize hash map
  struct HashMap *mp = (struct HashMap *)malloc(sizeof(struct HashMap));

  newHashMap(mp);

  insert(mp, "Yogaholic", "Anjali");
  insert(mp, "pluto14", "Vartika");
  insert(mp, "elite_Programmer", "Manish");
  insert(mp, "GFG", "GeeksforGeeks");
  insert(mp, "decentBoy", "Mayank");

  printf("%s\n", procurar(mp, "elite_Programmer"));
  printf("%s\n", procurar(mp, "Yogaholic"));
  printf("%s\n", procurar(mp, "pluto14"));
  printf("%s\n", procurar(mp, "decentBoy"));
  printf("%s\n", procurar(mp, "GFG"));

  // Key not inserted
  printf("%s\n", procurar(mp, "randomKey"));

  printf("\nAfter deletion : \n");

  // Delete key
  delete_chave(mp, "decentBoy");

  // Search deleted key
  printf("%s\n", procurar(mp, "decentBoy"));

  return 0;
}
