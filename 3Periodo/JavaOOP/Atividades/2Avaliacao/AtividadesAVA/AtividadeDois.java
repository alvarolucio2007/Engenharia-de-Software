class Aluno {
  private String nome;
  private String matricula;
  private double notaFinal;

  public Aluno(double notaFinal, String nome, String matricula) {
    var notaValida = (notaFinal >= 0 && notaFinal <= 10);
    var nomeValido = (!nome.isBlank());
    if (notaValida && nomeValido) {
      this.nome = nome;
      this.notaFinal = notaFinal;
      this.matricula = matricula;
    } else {
      System.out.println("Nota inválida ou Nome inválido!");
    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public double getNotaFinal() {
    return notaFinal;
  }

  public void setNotaFinal(double notaFinal) {
    this.notaFinal = notaFinal;
  }

  protected boolean verificarNota(double nota, int corte) {
    if (nota >= corte && nota >= 0 && nota <= 10) {
      return true;
    } else {
      return false;
    }
  }

  public void exibirDados() {
    System.out.println("Nome: " + this.nome + "Matrícula: " + this.matricula + "Nota final: " + this.notaFinal);
  }

}

class AlunoGraduacao extends Aluno {

  public AlunoGraduacao(double notaFinal, String nome, String matricula) {
    super(notaFinal, nome, matricula);
  }

  public boolean verificarAprovacao(double nota) {
    return verificarNota(nota, 7);
  }

  public void ajustarNota(double novaNota) {
    if (verificarNota(novaNota, 7)) {
      this.setNotaFinal(novaNota);
    } else {
      System.out.println("Nota inválida!");
    }
  }
}

class AlunoPosGraduacao extends AlunoGraduacao {

  public AlunoPosGraduacao(double notaFinal, String nome, String matricula) {
    super(notaFinal, nome, matricula);
  }

  @Override
  public boolean verificarAprovacao(double nota) {
    return verificarNota(nota, 6);
  }

}
