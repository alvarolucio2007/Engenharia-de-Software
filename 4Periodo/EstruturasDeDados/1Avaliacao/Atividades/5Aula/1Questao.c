#include <stdio.h>
#include <string.h>
typedef struct Produto {
  int codigo;
  char nome[21];
  float preco;
} Produto;
void promocao(Produto p) { p.preco = p.preco / 2.0f; }
void reajuste(Produto *p) { p->preco = p->preco * 2.0f; }
int main(void) {
  Produto a;
  a.codigo = 100;
  strcpy(a.nome, "Teclado");
  a.preco = 80.0f;
  Produto b = a;
  b.codigo = 200;
  strcpy(b.nome, "Mouse");
  printf("1: %d %s %.2f\n", a.codigo, a.nome, a.preco);
  printf("2: %d %s %.2f\n", b.codigo, b.nome, b.preco);
  promocao(a);
  printf("3: %.2f\n", a.preco);
  reajuste(&a);
  printf("4: %.2f\n", a.preco);
  Produto *p = &b;
  p->preco = 50.0f;
  printf("5: %.2f %.2f\n", b.preco, (*p).preco);
  return 0;
}
// a) 100 Teclado 80.00 ;  200 Mouse 80.00 ; 80.00 ; 160.00 ; 50.00 50.00 ;
//
// b) Pois todos os valores foram copiados de A para B, até o preço, e foi
// mudado apenas o código e nome, deixando o preço intacto.
//
// c) Apenas reajuste altera A, pois utiliza o ponteiro para A, enquanto
// promocao apenas referencia A sem ponteiros.
//
// d) Pois não foi copiado, então o vetor está nulo.
