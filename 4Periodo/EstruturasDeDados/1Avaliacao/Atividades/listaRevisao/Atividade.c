
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
// 7)
