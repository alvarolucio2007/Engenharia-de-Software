import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

abstract class Aluno {
  private String nome;
  private String matricula;
  private double notaFinal;

  public abstract boolean verificarAprovacao();

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Aluno aluno = (Aluno) o;
    return Objects.equals(matricula, aluno.matricula);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matricula);
  }

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

  @Override
  public boolean verificarAprovacao() {
    return this.getNotaFinal() >= 7;
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
  public boolean verificarAprovacao() {
    return this.getNotaFinal() >= 6;
  }

}

class Professor {
  protected String nome;
  protected int matricula;
  protected double salario;

  boolean verificarSalario(double salario) {
    if (salario > 0) {
      return true;
    } else {
      return false;
    }
  }

  public void aumentarSalario(double valor) {
    if (valor > 0) {
      this.setSalario(this.salario + valor);
    }
  }

  public Professor(String nome, int matricula, double salario) {
    if (verificarSalario(salario)) {
      this.nome = nome;
      this.matricula = matricula;
      this.salario = salario;
    } else {
      System.out.println("Salário inválido!");
    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getMatricula() {
    return matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    if (verificarSalario(salario)) {
      this.salario = salario;
    }
  }
}

class ProfessorTemporario extends Professor {
  private int contratoDuracaoRestante;

  public ProfessorTemporario(String nome, int matricula, double salario, int contratoDuracaoRestante) {
    super(nome, matricula, salario);
    this.contratoDuracaoRestante = contratoDuracaoRestante;
  }

  @Override
  public void setSalario(double salario) {
    if (verificarSalario(salario) && (contratoDuracaoRestante) > 0) {
      this.salario = salario;
    } else if (!verificarSalario(salario)) {
      System.out.println("Salário menor que 0.");
    } else if (contratoDuracaoRestante <= 0) {
      System.out.println("Contrato acabado!");
    }
  }

  public int getContratoDuracaoRestante() {
    return contratoDuracaoRestante;
  }

  public void setContratoDuracaoRestante(int contratoDuracaoRestante) {
    this.contratoDuracaoRestante = contratoDuracaoRestante;
  }
}

class Disciplina {
  private String nome;
  private List<Aluno> listAluno = new ArrayList<>();
  private Professor professor;

  private List<Aluno> limparListaAluno(List<Aluno> listaAluno) {
    Set<Aluno> setLimpo = new LinkedHashSet<>(listaAluno);
    return new ArrayList<>(setLimpo);
  }

  public Disciplina(String nome, List<Aluno> listAluno, Professor professor) {
    if (professor == null) {
      System.out.println("Disciplina precisa de um professor.");
    }
    this.nome = nome;
    this.listAluno = limparListaAluno(listAluno);
    this.professor = professor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Aluno> getListaaluno() {
    return this.listAluno;
  }

  public void setListaaluno(List<Aluno> listaaluno) {
    this.listAluno = limparListaAluno(listaaluno);
  }

  public Professor getProfessor() {
    return this.professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

}
