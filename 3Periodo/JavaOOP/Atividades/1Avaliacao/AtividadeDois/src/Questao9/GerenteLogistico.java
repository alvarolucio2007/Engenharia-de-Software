package Questao9;

class GerenteLogistico {
  private PedidoCompra novoPedidoCompra;
  private Fornecedor novoFornecedor;
  private Produto novoProduto;
  private Estoque novoEstoque;

  public PedidoCompra getNovoPedidoCompra() {
    return novoPedidoCompra;
  }

  public void setNovoPedidoCompra(PedidoCompra novoPedidoCompra) {
    this.novoPedidoCompra = novoPedidoCompra;
  }

  public Fornecedor getNovoFornecedor() {
    return novoFornecedor;
  }

  public GerenteLogistico(PedidoCompra novoPedidoCompra, Fornecedor novoFornecedor, Produto novoProduto,
      Estoque novoEstoque) {
    this.novoPedidoCompra = novoPedidoCompra;
    this.novoFornecedor = novoFornecedor;
    this.novoProduto = novoProduto;
    this.novoEstoque = novoEstoque;
  }

  public void setNovoFornecedor(Fornecedor novoFornecedor) {
    this.novoFornecedor = novoFornecedor;
  }

  public void processarVenda(int qtdVenda, Produto p, Estoque e, Fornecedor f) {
    // 1. Solicita a redução no estoque
    e.reduzirEstoque(qtdVenda);
    System.out.println("Venda de " + qtdVenda + " unidades realizada. Estoque atual: " + e.getQuantidadeAtual());

    // 2. Regra de Negócio: Se quantidadeAtual <= pontoCritico
    if (e.getQuantidadeAtual() <= p.pontoCritico()) {
      System.out.println("\n[ALERTA] Estoque Crítico detectado para " + p.nome() + "!");

      // A. Criar um novo PedidoCompra
      PedidoCompra pedido = new PedidoCompra(999, "Pendente");

      // B. Acionar o Fornecedor
      f.enviarProdutos(20);

      // C. Atualizar o status do pedido
      pedido.setStatus("Enviado");

      // Saída Esperada conforme o prompt:
      System.out.println("Gerando Pedido de Compra com o fornecedor " + f.getNomeEmpresa() +
          ". Status: " + pedido.getStatus() + ".");
    }
  }
}
