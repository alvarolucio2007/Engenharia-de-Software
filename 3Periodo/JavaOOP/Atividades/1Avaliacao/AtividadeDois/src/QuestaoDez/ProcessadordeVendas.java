
package QuestaoDez;

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
