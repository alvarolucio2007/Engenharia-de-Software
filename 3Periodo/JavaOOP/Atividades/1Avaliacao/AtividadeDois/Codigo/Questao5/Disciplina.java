package Questao5;

class Disciplina {
  private float notaFinal;
  private int presenca;

  public Disciplina(float notaFinal, int presenca) {
    this.notaFinal = (notaFinal > 10) ? 10 : notaFinal;
    this.presenca = (presenca > 100) ? 100 : presenca;
  }

  void pegarResultado() {
    if (notaFinal >= 7 && presenca >= 75) {
      System.out.println("Aprovado!");
    } else if (notaFinal < 7 && presenca < 75) {
      System.out.println("Reprovado tanto por presença quanto por nota!");
    } else if (notaFinal < 7) {
      System.out.println("Reprovado por nota!");
    } else if (presenca < 75) {
      System.out.println("Reprovado por presença!");
    }
  }

  public float getNotaFinal() {
    return notaFinal;
  }

  public void setNotaFinal(float notaFinal) {
    this.notaFinal = notaFinal;
  }

  public int getPresenca() {
    return presenca;
  }

  public void setPresenca(int presenca) {
    this.presenca = presenca;
  }
}
