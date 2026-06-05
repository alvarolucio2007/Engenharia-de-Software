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
  protected int numero;
  protected String titular;

  protected double saldo;

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

class ContaCorrente extends ContaBancaria {
  private double chequeEspecial;
  private static final double porcImposto = 0.0038;

  public double getChequeEspecial() {
    return chequeEspecial;
  }

  public void setChequeEspecial(double chequeEspecial) throws RuntimeException {
    if (chequeEspecial <= 1000) {
      this.chequeEspecial = chequeEspecial;
      return;
    }
    throw new RuntimeException("Cheque especial tem limite de apenas 1000 reais.");
  }

  public ContaCorrente(int numero, String titular, double saldo, double chequeEspecial) {
    super(numero, titular, saldo);
    this.chequeEspecial = chequeEspecial;
  }

  @Override
  public double calcularRendimento() {
    return chequeEspecial + saldo;
  }

  @Override
  public void sacar(double saque) throws SaldoInsuficienteException {
    if (saque <= this.saldo + this.chequeEspecial && saque >= 0) {
      this.saldo -= saque;
      return;
    }
    throw new SaldoInsuficienteException("Quantidade inválida!");
  }

}

class ContaPoupanca {
}
