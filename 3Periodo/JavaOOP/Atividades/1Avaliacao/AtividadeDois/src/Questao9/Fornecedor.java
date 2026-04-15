package Questao9;

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
