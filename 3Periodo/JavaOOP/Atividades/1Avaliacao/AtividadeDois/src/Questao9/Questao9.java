package Questao9;

public class Questao9 {
  public static void main(String[] args) {
    PedidoCompra novoPedido = new PedidoCompra(1234, "Pendente");
    Produto novoProduto = new Produto("Doce Azul Vidro", 299.99d, 10);
    Estoque novoEstoque = new Estoque(15, "308 Negra Arroyo Lane, Albuquerque, New Mexico ");
    Fornecedor novoFornecedor = new Fornecedor("Walter White", 1);
    GerenteLogistico novoGerente = new GerenteLogistico(novoPedido, novoFornecedor, novoProduto, novoEstoque);
    novoGerente.processarVenda(7, novoProduto, novoEstoque, novoFornecedor);
  }
}
