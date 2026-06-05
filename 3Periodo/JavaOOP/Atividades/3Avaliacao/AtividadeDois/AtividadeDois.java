class SaldoInsuficienteException extends RuntimeException {

  public SaldoInsuficienteException() {
  }

  public SaldoInsuficienteException(String message) {
    super(message);
  }

}

class OperacaoInvalidaException extends RuntimeException {

  public OperacaoInvalidaException() {
  }

  public OperacaoInvalidaException(String message) {
    super(message);
  }

}

abstract class ContaBancaria {
  private int numero;
  private String titular;

  private double saldo;

  public ContaBancaria(int numero, String titular, double saldo) {
    this.numero = numero;
    if (checarTitular(this.titular)) {
      this.titular = titular;
    }
    this.saldo = saldo;
  }

  private boolean checarTitular(String titular) {
    return titular != null && !titular.trim().isEmpty();
  }

  protected abstract double calcularRendimento();

  protected void depositar(double deposito) throws OperacaoInvalidaException {
    if (deposito >= 0) {
      this.saldo += deposito;
      return;
    }
    throw new OperacaoInvalidaException("Quantidade inválida!");
  }

  protected void sacar(double saque) throws SaldoInsuficienteException {
    if (saque <= this.saldo && saque >= 0) {
      this.saldo -= saque;
      return;
    }
    throw new SaldoInsuficienteException("Quantidade inválida!");
  }
}

interface Tributavel {
  void calcularImposto(ContaCorrente cc);

  void calcularImposto(ContaPoupanca cp);
}

interface Bloqueavel {
  void bloquear(ContaBancaria cb);

  void desbloquear(ContaBancaria cb);

  boolean isAtiva(ContaBancaria cb);
}

class ContaCorrente {
  private double chequeEspecial;
  private double porcImposto;
}

class ContaPoupanca {
}
