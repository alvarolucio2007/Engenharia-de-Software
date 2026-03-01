package AtividadeDois;

record Compra(double valorTotal) {
}

class Cupom {
  private String nome;
  private int usosRestantes;
  private int descontoDado;

  public Cupom(int descontoDado, String nome, int usosRestantes) {
    this.descontoDado = descontoDado;
    this.nome = nome;
    this.usosRestantes = usosRestantes;
  }

  public int getDescontoDadoPorcent() {
    return descontoDado;
  }

  public void setDescontoDado(int descontoDado) {
    this.descontoDado = descontoDado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getUsosRestantes() {
    return usosRestantes;
  }

  public void setUsosRestantes(int usosRestantes) {
    this.usosRestantes = usosRestantes;
  }

  boolean testarCupom() {
    if (usosRestantes == 0) {
      System.out.println("Não é possível mais usar o cupom!");
      return false;
    } else if (nome.equals("CONSUMIDOR20")) {
      descontoDado = 20;
      this.usosRestantes -= 1;
      return true;
    } else {
      return false;
    }
  }

}

class Cliente {
  private String tipoCliente;
  private Cupom cupomUsado;

  public String getTipoCliente() {
    return tipoCliente;
  }

  public void setTipoCliente(String tipoCliente) {
    this.tipoCliente = tipoCliente;
  }

  public Cupom getCupomUsado() {
    return cupomUsado;
  }

  public void setCupomUsado(Cupom cupomUsado) {
    this.cupomUsado = cupomUsado;
  }

  public Cliente(String tipoCliente, Cupom cupomUsado) {
    this.tipoCliente = tipoCliente;
    this.cupomUsado = cupomUsado;
  }

}

class ProcessadordeVendas {
  private Cliente cliente;
  private Cupom cupom;
  private double valorBruto;
  private double valorFinal;

  public ProcessadordeVendas(Cliente cliente, Cupom cupom, double valorBruto) {
    this.cliente = cliente;
    this.cupom = cupom;
    this.valorBruto = valorBruto;
    this.valorFinal = valorBruto;
  }

  void processarCompra() {
    System.out.println("--- EXTRATO DE COMPRA ---");
    System.out.println("Valor Original: R$ " + valorBruto);

    if ("VIP".equals(cliente.getTipoCliente())) {
      double descontoVip = valorFinal * 0.05;
      valorFinal -= descontoVip;
      System.out.println("Desconto VIP (5%): R$ " + descontoVip);
    }

    if (cupom.testarCupom()) {
      valorFinal -= 20.00;
      System.out.println("Cupom CONSUMIDOR20 aplicado: R$ 20,00");
    }

    System.out.println("Valor Final a Pagar: R$ " + valorFinal);
    System.out.println("-------------------------");
  }

}

public class Questao10 {
  public static void main(String[] args) {
    Cupom c1 = new Cupom(0, "CONSUMIDOR20", 1); // 1 uso restante
    Cliente v1 = new Cliente("VIP", c1);

    // Primeira tentativa (Deve dar desconto)
    ProcessadordeVendas p1 = new ProcessadordeVendas(v1, c1, 100.0);
    p1.processarCompra();

    // Segunda tentativa (Deve barrar o cupom)
    System.out.println("\nTentando usar o cupom novamente...");
    ProcessadordeVendas p2 = new ProcessadordeVendas(v1, c1, 100.0);
    p2.processarCompra();
  }
}
