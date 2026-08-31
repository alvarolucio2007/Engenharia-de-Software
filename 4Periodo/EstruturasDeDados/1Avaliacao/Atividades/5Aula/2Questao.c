#include <stdio.h>
#include <string.h>
typedef struct Aluno {
  int matricula;
  char nome[41];
  float nota1;
  float nota2;
} Aluno;
void imprimir(const Aluno *a) {
  printf("%d | %s | %f %f | media %f \n", a->matricula, a->nome, a->nota1,
         a->nota2, (a->nota1 + a->nota2) / 2);
}
Aluno ler_aluno(void) {
  Aluno a;
  printf("Por favor insira a matrícula: \n");
  scanf("%d", &a.matricula);
  printf("Por favor insira a primeira nota: \n");
  scanf("%f", &a.nota1);
  printf("Por favor insira a segunda nota: \n");
  scanf("%f", &a.nota2);
  getchar();
  printf("Por favor insira o nome: \n");
  fgets(a.nome, sizeof(a.nome), stdin);
  a.nome[strcspn(a.nome, "\n")] = '\0';
  return a;
}
int main() {
  Aluno a;
  a.matricula = 1;
  a.nota1 = 2.0;
  a.nota2 = 10.0;
  strcpy(a.nome, "Teste...\0");
  imprimir(&a);
  Aluno aluno_2 = ler_aluno();
  imprimir(&aluno_2);
}
// d) Para evitar a cópia da struct e impedir alterações acidentais nos dados,
// mas ler_aluno retorna Aluno por valor para copiar e transferir a struct
// criada na stack para a função que a chamou. ;
// Retornar &a causaria um erro de ponteiro pendente (dangling pointer), já que
// a variável local a é destrída da memória assim que a função acaba, deixando o
// ponteiro apontando para um endereço inválido.
//
