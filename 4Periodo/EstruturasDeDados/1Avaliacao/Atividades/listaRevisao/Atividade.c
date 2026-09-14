
// Gabaritos:
//  1) B
//  2) a) Pois diferentes algoritmos de busca têm complexidades de tempo
//  diferentes, levando quantidades diferentes de tempo para conseguir o mesmo
//  resultado.
//     b) O computador serve apenas para calcular e apresentar dados,deixando a
//     tomada de decisões para o projetista.
//     c) Aonde a ordem do vetor não importa, por exemplo, em uma lista
//     aleatória de usuários.
//
//  3) C
//  4) trabalho demais mn
//  5)
#include <cstring>
#include <string.h>
int busca_seq(
    int v[], int n,
    int chave) { // tecnicamente nem precisa de um n, so usar sizeof...
  for (int current = 0; current <= n; current++) {
    if (v[current] == chave) {
      return current;
    }
  }
  return -1;
} // Faz 1 comparação (n sendo 1) no melhor caso, e no pior, n.
// 6)B
// 7) a){(h,m) pertencem a N x N | 0<=h<=23 && 0<=m<=59}, criar_horario(int
// hora,int minuto)->Horario; destruir_horario(horario h)->void...
//    b) Pois ambas implmentam a mesama interface .h, mesmo com formatos
//    diferentes, retornando os mesmos resultados. c) TAD é um conceito de
//    interface, enquanto a Estrutura de Dados é a escolha de armazenamento ou
//    implementação.
//    c) Gera forte acoplamento (anti-padrão),e poderia ter dados inválidos.
// 8) #ifdef Horario
//    #define Horario
//    typedef struct horario Horario;
//    Horario criarHorario(int hora,int minuto);
//    bool validarHorario(Horario *h);
//    bool horarioIgual(const Horario *h1, const Horario *h2);
//    void imprimirHorario(const Horario *h1, const Horario *h2);
//    // Esse arquivo diz o que o código deve fazer, e não como, portanto, gera
//    um desacoplamento saudável.
//
// 9) a)  70 em ambas.
//    b)  trabalhão
//    c)  Pois não é ponteiro, é referência, que é deletada automaticamente após
//    a função acabar, e não é anotada no lugar da original. (Vice-versa pra
//    *p=*p+delta)
//
// 10)  D
// 11)
void min_max(int v[], int n, int *menor, int *maior) {
  *menor = v[0];
  *maior = v[0];
  for (int i = 1; i < n; i++) {
    if (v[i] < *menor) {
      *menor = v[i];
    }
    if (v[i] > *maior) {
      *maior = v[i];
    }
  }
  return;
} // não vou fazer a partir da main pq sim, o & é obrigratório para ler o valor
  // do ponteiro *p.
// 12) C
// 13) a)11 e 10 respectivamente
//     b) 1: 1 vez, valor final: 11, 2: 0 vezes, valor final: 10.
//     c) do... while faz o loop uma vez antes de checar a condição, enquanto
//     while checa de primeira. (Verficação de que dados estão normalizados)
// 14) B
// 15) C
// 16) a) não
//     b) 10,20,30,40, erro pois está tentando acessar o 5 (4) índice.
//     c) Endereço do elemento começa em 0, como tem 4, seria até 3 (0,1,2,3), e
//     como C não verifica os limites, ou dá erro ou tenta acessar memória
//     inválida. Correção: Retirar o igual de <=4.
// 17) a)
void copia_vetor(int origem[], int destino[], int n) {
  for (int i = 0; i < n; i++) {
    destino[i] = origem[i];
  }
}
//     b) Pois o nome de um vetor se transformar em um ponteiro constante,que
//     aponta para o primeiro elemento na memória, a atribuição direta falha
//     pois não é possível reatribuir o endereço de memória de um vetor
//     estático.
//  18) a) Na proposta A, é necessário alterar 3 valores, enquanto na B, apenas
//  um, eliminando o risco de dessincronização.
//      b) Na B, basta chamar com acervo[i].codigo, e assim por diante.
//      c) a versão com const Livro *L consome muito menos memória, apenas 8
//      bits ao invés de 72 bytes, e garante a imutabilidade com a keyword
//      const.
//  19) a)
typedef struct {
  int codigo;
  float preco;
  char nome[41];
} Produto;
void aplica_desconto(Produto *p, float pct) {
  p->preco = p->preco - (pct * p->preco / 100);
}
Produto cria_produto(int codigo, const char *nome, float preco) {
  Produto produto;
  produto.preco = preco;
  produto.codigo = codigo;
  strcpy(produto.nome, nome);
  return produto;
}
// c) redundante
// d) A passagem por endereço é obrigatória pois altera o dado original,
// enquando o retorno por valor em cria_produto funciona pois não estamos
// acessando o valor original.
// 20) B
