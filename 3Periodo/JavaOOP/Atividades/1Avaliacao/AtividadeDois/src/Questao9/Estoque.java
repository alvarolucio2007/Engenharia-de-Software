package Questao9;

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

  void adicionarEstoque(int quantidade) {
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
