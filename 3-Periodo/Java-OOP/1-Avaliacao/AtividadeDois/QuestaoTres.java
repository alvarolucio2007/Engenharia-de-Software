package AtividadeDois;

class Pet {
  private int fome;

  public Pet(int fome) {
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

public class QuestaoTres {
  public static void main(String[] args) {
    Pet novoPet = new Pet(10);
    novoPet.alimentar();
    novoPet.alimentar();
  }
}
