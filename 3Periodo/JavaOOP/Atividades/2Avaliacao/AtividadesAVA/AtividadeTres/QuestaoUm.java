abstract class Funcionario {
  protected String nome;
  protected double salario;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
  }

  boolean addAumento(double valor) {
    if (valor > 0) {
      this.salario += valor;
      return true;
    }
    return false;
  }

  void ganhoAnual() {
    System.out.println(salario * 12);
  }

  void exibeDados() {
    System.out.println("Nome: " + this.nome + "\n Salário: " + this.salario);
  }
}

class Assistente extends Funcionario {
  protected String matricula;

  public Assistente(String nome, double salario, String matricula) {
    super(nome, salario);
    this.matricula = matricula;
  }

  @Override
  void exibeDados() {
    super.exibeDados();
    System.out.println("Matrícula: " + this.matricula);
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

}

class AssistenteTecnico extends Assistente {
  private double bonus;

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public AssistenteTecnico(String nome, double salario, String matricula, double bonus) {
    super(nome, salario, matricula);
    this.bonus = bonus;
  }

  @Override
  void ganhoAnual() {
    System.out.println((salario * 12) + bonus);
  }
}

class AssitenteAdministrativo extends Assistente {
  private String turno;

  private double adicionalNoturno;

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public double getAdicionalNoturno() {
    return adicionalNoturno;
  }

  public void setAdicionalNoturno(double adicionalNoturno) {
    this.adicionalNoturno = adicionalNoturno;
  }

  public AssitenteAdministrativo(String nome, double salario, String matricula, String turno, double adicionalNoturno) {
    super(nome, salario, matricula);
    this.turno = turno;
    this.adicionalNoturno = adicionalNoturno;
  }

  @Override
  void ganhoAnual() {
    System.out.println((salario * 12) + (adicionalNoturno));
  }

}
