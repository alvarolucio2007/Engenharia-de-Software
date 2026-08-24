#include <stdio.h>
int main() {
  int vetor_int[5];
  for (int i = 0; i < 5; i++) {
    int numero_add;
    printf("Qual o inteiro que quer adicionar?\n");
    scanf("%i", &numero_add);
    vetor_int[i] = numero_add;
  }
  int soma = 0;
  for (int i = 0; i < 5; i++) {
    soma += vetor_int[i];
  }
  printf("%i", soma);
  return 0;
}
