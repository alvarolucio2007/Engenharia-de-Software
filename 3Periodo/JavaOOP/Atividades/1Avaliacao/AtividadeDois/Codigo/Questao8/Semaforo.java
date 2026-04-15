package Questao8;

class Semaforo {
  private String cor;

  public Semaforo(String cor) {
    this.cor = cor;
  }

  void trocar() {
    if (this.cor.equals("vermelho")) {
      this.cor = "verde";
    } else if (this.cor.equals("verde")) {
      this.cor = "vermelho";
    }
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}
