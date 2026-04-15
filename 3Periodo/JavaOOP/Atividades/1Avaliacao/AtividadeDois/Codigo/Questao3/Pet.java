package Questao3;

class Pet {
  private int fome;

  public Pet(int fome) {
    this.fome = fome;
  }

  public int getFome() {
    return fome;
  }

  public void setFome(int fome) {
    this.fome = fome;
  }

  void alimentar() {
    if (fome < 10 && fome > 0) {
      fome = 0;
    } else if (fome == 0) {
      System.out.println("Não é possível alimentar mais!");
    } else {
      fome -= 10;
    }
  }

}
