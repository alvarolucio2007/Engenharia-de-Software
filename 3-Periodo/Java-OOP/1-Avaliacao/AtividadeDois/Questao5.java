package AtividadeDois;

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
}

public class Questao5 {
  public static void main(String[] args) {
    Disciplina novaDisciplina = new Disciplina(5, 0);
    novaDisciplina.pegarResultado();
  }
}
