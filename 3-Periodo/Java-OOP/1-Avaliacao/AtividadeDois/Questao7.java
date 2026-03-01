package AtividadeDois;

class ContaBancaria {
  private double saldoDisponivel;

  public double getSaldoDisponivel() {
    return saldoDisponivel;
  }

  public void setSaldoDisponivel(double saldoDisponivel) {
    this.saldoDisponivel = saldoDisponivel;
  }

  public ContaBancaria(double saldoDisponivel) {
    this.saldoDisponivel = saldoDisponivel;
  }

  boolean sacar(double valor) {
    if (valor <= saldoDisponivel) {
      this.saldoDisponivel -= valor;
      return true;
    } else {
      return false;
    }
  }
}

public class Questao7 {
  public static void main(String[] args) {
    ContaBancaria novaConta = new ContaBancaria(100);
    System.out.println(novaConta.sacar(2));
  }
}
