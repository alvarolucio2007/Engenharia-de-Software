
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

  protected void sacar(double saque, int quantDias) throws SaldoInsuficienteException, RuntimeException {
    if (saque <= this.saldo && saque >= 0 && quantDias > 30) {
      this.saldo -= saque;
      return;
    } else if (quantDias < 30) {
      throw new OperacaoInvalidaException("Período entre saques muito curto!");
    }
    throw new SaldoInsuficienteException("Quantidade inválida!");
  }
}

interface Tributavel {
  void calcularImposto(ContaCorrente cc);

}

interface Bloqueavel {
  void bloquear(ContaBancaria cb);

  void desbloquear(ContaBancaria cb);

  boolean isAtiva(ContaBancaria cb);
}

class ContaCorrente extends ContaBancaria implements Bloqueavel {
  private double chequeEspecial;

  private boolean ativa = true;
  private static final double imposto = 0.0038;

  @Override
  public void bloquear(ContaBancaria cb) {
    this.ativa = false;
  }

  @Override
  public void desbloquear(ContaBancaria cb) {
    this.ativa = true;
  }

  @Override
  public boolean isAtiva(ContaBancaria cb) {
    return this.ativa;
  }

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

  public double calcularRendimento() {
    return chequeEspecial + saldo;
  }

  @Override
  public void sacar(double saque) throws SaldoInsuficienteException, RuntimeException {
    if (!this.ativa) {
      throw new OperacaoInvalidaException("Conta bloqueada!");
    }
    if (saque <= 0) {
      throw new SaldoInsuficienteException("Valor do saque inválido!");
    }
    double totalDesconto = saque + (saque * imposto);
    double saldoTotalDisponivel = this.saldo + this.chequeEspecial;
    if (totalDesconto > saldoTotalDisponivel) {
      throw new SaldoInsuficienteException("Saldo e cheque especial insuficientes!");
    }
    if (totalDesconto <= this.saldo) {
      this.saldo -= totalDesconto;
    } else {
      double restante = totalDesconto - this.saldo;
      this.saldo = 0;
      this.chequeEspecial -= restante;
    }

  }
}

class ContaPoupanca extends ContaBancaria implements Bloqueavel {
  private static final double imposto = 0.225;
  private static final double rendimento = 0.005;
  private boolean ativa = true;

  public ContaPoupanca(int numero, String titular, double saldo, boolean ativa) {
    super(numero, titular, saldo);
    this.ativa = ativa;
  }

  @Override
  public void bloquear(ContaBancaria cb) {
    this.ativa = false;
  }

  @Override
  public void desbloquear(ContaBancaria cb) {
    this.ativa = true;
  }

  @Override
  public boolean isAtiva(ContaBancaria cb) {
    return this.ativa;
  }

  @Override
  public void sacar(double saque, int quantDias) throws SaldoInsuficienteException, RuntimeException {
    if (quantDias < 30) {
      throw new OperacaoInvalidaException("Intervalo entre saques muito curto!");
    }
    if (!this.ativa) {
      throw new OperacaoInvalidaException("Conta bloqueada!");
    }
    if (saque <= 0) {
      throw new SaldoInsuficienteException("Valor do saque inválido!");
    }
    double totalDesconto = saque + (saque * imposto);
    if (totalDesconto > saldo) {
      throw new SaldoInsuficienteException("Saldo insuficiente!");
    } else {
      this.saldo -= totalDesconto;
    }

  }

  public double calcularRendimento(int quantMeses) {
    return this.saldo * Math.pow(1 + rendimento, quantMeses); // M=P*(1+i)^t
  }

}

class ContaSalario extends ContaBancaria implements Bloqueavel {

  private boolean ativa = true;

  @Override
  public void bloquear(ContaBancaria cb) {
    this.ativa = false;
  }

  @Override
  public void desbloquear(ContaBancaria cb) {
    this.ativa = true;
  }

  @Override
  public boolean isAtiva(ContaBancaria cb) {
    return this.ativa;
  }

  public ContaSalario(int numero, String titular, double saldo) {
    super(numero, titular, saldo);
  }

  @Override
  public void sacar(double saque, int quantDias) throws SaldoInsuficienteException, OperacaoInvalidaException {
    if (quantDias < 30) {
      throw new OperacaoInvalidaException("Intervalo entre saques muito curto!");
    }
    if (!this.ativa) {
      throw new OperacaoInvalidaException("Conta bloqueada!");
    }
    if (saque <= 0) {
      throw new SaldoInsuficienteException("Valor do saque inválido!");
    }
    if (saque > saldo) {
      throw new SaldoInsuficienteException("Saldo insuficiente!");
    } else {
      this.saldo -= saque;
    }
  }
}

public class AtividadeDois {
  public static void main(String[] args) {

  }
}
