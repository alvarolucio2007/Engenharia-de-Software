class Conta {
  private int numeroConta;
  private String titular;
  private double saldo;

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public Conta(int numeroConta, String titular, double saldo) {
    this.numeroConta = numeroConta;
    this.titular = titular;
    this.saldo = saldo;
  }

  boolean sacar(double valor) {
    if (valor < this.saldo) {
      this.saldo -= valor;
      return true;
    } else {
      return false;
    }
  }

  void depositar(double valor) {
    this.saldo += valor;
  }
}

class Transacao {
  private int idTransacao;
  private double valor;
  private boolean status;

  public int getIdTransacao() {
    return idTransacao;
  }

  public void setIdTransacao(int idTransacao) {
    this.idTransacao = idTransacao;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Transacao(int idTransacao, double valor, boolean status) {
    this.idTransacao = idTransacao;
    this.valor = valor;
    this.status = status;
  }

}

class Banco {
  private int totalTransacoes;

  public int getTotalTransacoes() {
    return totalTransacoes;
  }

  public Banco(int totalTransacoes, Transacao transacao) {
    this.totalTransacoes = totalTransacoes;
  }

  public Banco(int totalTransacoes) {
    this.totalTransacoes = totalTransacoes;
  }

  public void setTotalTransacoes(int totalTransacoes) {
    this.totalTransacoes = totalTransacoes;
  }

  Transacao transferir(Conta origem, Conta destino, double valor) {
    this.totalTransacoes++;
    if (!origem.sacar(valor)) {
      return new Transacao(this.totalTransacoes, valor, false);
    } else {
      double saldoDestino = destino.getSaldo();
      destino.setSaldo(saldoDestino += valor);
      return new Transacao(this.totalTransacoes, valor, true);
    }
  }

}

public class Questao3 {
  public static void main(String[] args) {
    Banco novoBanco = new Banco(0);
    Conta novaContaA = new Conta(1, "Teste da silva", 500);
    Conta novaContaB = new Conta(2, "Walter White", 100);
    novoBanco.transferir(novaContaA, novaContaB, 650);

    novoBanco.transferir(novaContaA, novaContaB, 650)

  }
}
