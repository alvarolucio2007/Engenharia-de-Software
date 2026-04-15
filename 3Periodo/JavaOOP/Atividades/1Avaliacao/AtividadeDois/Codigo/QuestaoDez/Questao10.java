package QuestaoDez;

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
