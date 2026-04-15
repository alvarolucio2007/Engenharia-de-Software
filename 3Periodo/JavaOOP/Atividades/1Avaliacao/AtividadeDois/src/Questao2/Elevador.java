package Questao2;

class Elevador {
  private int andarAtual;
  private int totalAndares;

  public Elevador(int andarAtual, int totalAndares) {
    this.andarAtual = andarAtual;
    this.totalAndares = totalAndares;
  }

  void subir() {
    if (andarAtual < totalAndares) {
      andarAtual += 1;
    } else {
      System.out.println("Não é possível subir!");
    }
  }

  public int getAndarAtual() {
    return andarAtual;
  }

  public void setAndarAtual(int andarAtual) {
    this.andarAtual = andarAtual;
  }

  public int getTotalAndares() {
    return totalAndares;
  }

  public void setTotalAndares(int totalAndares) {
    this.totalAndares = totalAndares;
  }

  void descer() {
    if (andarAtual > 0) {
      andarAtual -= 1;
    } else {
      System.out.println("Não é possível descer!");
    }
  }

}
