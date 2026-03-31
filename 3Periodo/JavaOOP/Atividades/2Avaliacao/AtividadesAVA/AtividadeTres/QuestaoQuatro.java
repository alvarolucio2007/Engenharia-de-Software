abstract class Imovel {
  protected String endereco;
  protected double valor;

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Imovel(String endereco, double valor) {
    this.endereco = endereco;
    this.valor = valor;
  }

  public abstract double getPrecoFinal();

  public void exibirInformacoes() {
    System.out.println("Endereço: " + this.endereco);
    System.out.println("Valor base: R$ " + this.valor);
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}

class ImovelBom extends Imovel {
  private double valorAdicional;

  public double getValorAdicional() {
    return valorAdicional;
  }

  public void setValorAdicional(double valorAdicional) {
    this.valorAdicional = valorAdicional;
  }

  public ImovelBom(String endereco, double valor, double valorAdicional) {
    super(endereco, valor);
    this.valorAdicional = valorAdicional;
  }

  @Override
  public double getPrecoFinal() {
    return this.valor + this.valorAdicional;
  }

  @Override
  public void exibirInformacoes() {
    super.exibirInformacoes();
    System.out.println("Adicional: R$ " + this.valorAdicional);
    System.out.println("Preço Final (Novo): R$ " + getPrecoFinal());
  }

}

class ImovelRuim extends Imovel {
  private double desconto;

  public double getDesconto() {
    return desconto;
  }

  public void setDesconto(double desconto) {
    this.desconto = desconto;
  }

  public ImovelRuim(String endereco, double valor, double desconto) {
    super(endereco, valor);
    this.desconto = desconto;
  }

  @Override
  public double getPrecoFinal() {
    return this.valor - this.desconto;
  }

  @Override
  public void exibirInformacoes() {
    super.exibirInformacoes();
    System.out.println("Desconto: R$ " + this.desconto);
    System.out.println("Preço Final (Novo): R$ " + getPrecoFinal());
  }
}
