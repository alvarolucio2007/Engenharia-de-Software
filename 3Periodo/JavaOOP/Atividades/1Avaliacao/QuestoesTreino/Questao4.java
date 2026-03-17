abstract class Funcionario {
  protected String nome;
  protected double salarioBase;

  public Funcionario(String nome, double salarioBase) {
    this.nome = nome;
    this.salarioBase = salarioBase;
  }

  abstract double calcularSalario();
}

class Gerente extends Funcionario {
  private double bonusFixo;

  public Gerente(String nome, double salarioBase) {
    super(nome, salarioBase);
  }

  @Override
  double calcularSalario() {
    return this.salarioBase + this.bonusFixo;
  }

  public Gerente(String nome, double salarioBase, double bonusFixo) {
    super(nome, salarioBase);
    this.bonusFixo = bonusFixo;
  }

}

class Vendedor extends Funcionario {
  private double totalVendas;
  private double comissao;

  @Override
  double calcularSalario() {
    return this.salarioBase + (this.totalVendas * this.comissao);
  }

  public Vendedor(String nome, double salarioBase, double totalVendas, double comissao) {
    super(nome, salarioBase);
    this.totalVendas = totalVendas;
    this.comissao = comissao;
  }

}

public class Questao4 {
  public static void main(String[] args) {
    Funcionario gerente = new Gerente("Gerente", 100, 200);
    Funcionario vendedor = new Vendedor("Vendedor", 100, 50, 0.2);
    System.out.println(gerente.calcularSalario());
    System.out.println(vendedor.calcularSalario());
  }
}
