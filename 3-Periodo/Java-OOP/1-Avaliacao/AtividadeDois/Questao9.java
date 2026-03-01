package AtividadeDois;

record Produto(String nome, double precoUnitario, int pontoCritico) {

}

class Estoque {
  private int quantidadeAtual;
  private String localizacaoCorredor;

  public int getQuantidadeAtual() {
    return quantidadeAtual;
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
