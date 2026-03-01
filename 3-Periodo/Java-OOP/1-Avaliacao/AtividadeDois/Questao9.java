package AtividadeDois;

record Produto(String nome, double precoUnitario, int pontoCritico) {

}

class Estoque {
  private int quantidadeAtual;
  private String localizacaoCorredor;

  public int getQuantidadeAtual() {
    return quantidadeAtual;
  }

  public Estoque(int quantidadeAtual, String localizacaoCorredor) {
    this.quantidadeAtual = quantidadeAtual;
    this.localizacaoCorredor = localizacaoCorredor;
  }

  public void setQuantidadeAtual(int quantidadeAtual) {
    this.quantidadeAtual = quantidadeAtual;
  }

  public String getLocalizacaoCorredor() {
    return localizacaoCorredor;
  }

  public void setLocalizacaoCorredor(String localizacaoCorredor) {
    this.localizacaoCorredor = localizacaoCorredor;
  }

  void aducionarEstoque(int quantidade) {
    if (quantidade > 0) {
      this.quantidadeAtual += quantidade;
    } else {
      System.out.println("quantidade tem que ser >=0");
    }
  }

  void reduzirEstoque(int quantidade) {
    if (quantidade <= quantidadeAtual) {
      this.quantidadeAtual -= quantidade;
    } else {
      System.out.println("quantidade tem que ser >=0");
    }
  }

}

class Fornecedor {
  private String nomeEmpresa;
  private int tempoEntregaDias;

  public Fornecedor(String nomeEmpresa, int tempoEntregaDias) {
    this.nomeEmpresa = nomeEmpresa;
    this.tempoEntregaDias = tempoEntregaDias;
  }

  public Fornecedor(String nomeEmpresa) {
    this.nomeEmpresa = nomeEmpresa;
  }

  public String getNomeEmpresa() {
    return nomeEmpresa;
  }

  public void setNomeEmpresa(String nomeEmpresa) {
    this.nomeEmpresa = nomeEmpresa;
  }

  public int getTempoEntregaDias() {
    return tempoEntregaDias;
  }

  public void setTempoEntregaDias(int tempoEntregaDias) {
    this.tempoEntregaDias = tempoEntregaDias;
  }

  int enviarProdutos(int quantidade) {
    return quantidade;
  }
}

class PedidoCompra {
  private int idPedido;
  private String status;

  public int getIdPedido() {
    return idPedido;
  }

  public PedidoCompra(int idPedido, String status) {
    this.idPedido = idPedido;
    this.status = status;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}

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
}
