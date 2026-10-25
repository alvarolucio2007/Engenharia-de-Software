#include <stdlib.h>
typedef struct No {
    int dado;
    struct No *prox;
    struct No *ant; /* usado apenas na lista dupla */
} No;
typedef struct { No *inicio; } Lista;
typedef struct { No *inicio; No *fim; } ListaDupla;
// Parte 1
// 1) D
// 2) B
// 3) C
// 4) E
// 5) A
// 6) B
// 7) D
// 8) C
// 9) E
// 10) A
// 11) D
// 12) B
// 13) C
// 14) E
// Parte 2
// 15) (teste de mesa)
// 16) (teste de mesa)
// 17)
No *buscar(Lista *l,int valor){
    No *node=l->inicio;
    while (node!=NULL){
        if (node->dado==valor) {
            return node;
        }
        node=node->prox;
    }
    return NULL;
}
// 18)
//      a)Se a lista for vazia, l->fim é nulo, e pode dar segfault em l->fim->prox=n
//      b)
void inserir_fim(ListaDupla *l,int dado){
    No *n=malloc(sizeof(No));
    n->dado=dado;
    n->prox=NULL;
    if (l->inicio==NULL){
        n->ant=NULL;
        l->inicio=n;
        l->fim=n;
    }else{
        n->ant=l->fim;
        l->fim->prox=n;
        l->fim=n;
    }
}
// 19)Pois teria que percorrer todos os nós até chegar no último, enquanto em uma lista dupla com ponteiro fim já teria acesso direto.
void remover_fim(ListaDupla *l){
    //Lista possui no minimo um nó, regra de negócio
    No *n=l->fim;
    if (l->inicio==l->fim){
        l->inicio=NULL;
        l->fim=NULL;
    }else{
        l->fim->ant->prox=NULL;
        l->fim=l->fim->ant;
    }
    free(n);
}
// 20)
void inverter(Lista *l){
    if (l->inicio==NULL){
        return;
    }
    No *atual=l->inicio;
    No *anterior=NULL;
    No *proximo=NULL;
    while (atual!=NULL){
        proximo=atual->prox;
        atual->prox=anterior;
        anterior=atual;
        atual=proximo;
    }
    l->inicio=anterior;
}
