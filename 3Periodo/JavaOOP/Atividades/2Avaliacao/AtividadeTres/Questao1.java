import java.time.LocalDate;

public class Questao1 {
  public static void main(String[] args) {
    Produto p1 = new Produto("Arroz", 25.5, 11);
    var data = LocalDate.of(2026, 4, 8);
    Perecivel leite = new Perecivel("Leite", 20, 11, data);
    ProdutoImportado perfume = new ProdutoImportado("Perfume", 12.90, 11, 129.90);
    Venda venda = new Venda(p1);
    venda.vender(leite, 12);
    venda.vender(perfume, 12);
    venda.vender(p1, 12);
  }
}

class Produto {

  protected String nome;
  protected double preco;
  protected int estoque;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto(String nome, double preco, int estoque) {
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    if (estoque >= 0) {
      this.estoque = estoque;
    } else {
      System.out.println("Estoque negativo");
    }
  }

  public void adicionarEstoque(int qtd) {
    if (qtd <= 0) {
      System.out.println("Quantidade menor ou igual a 0");
      return;
    }
    this.estoque += qtd;
  }

  public void vender(int qtd) {
    if (qtd <= 0) {
      System.out.println("Quantidade menor que 0");
    } else if (qtd > this.estoque) {
      System.out.println("Quantidade maior que estoque atual");
    }
    this.estoque -= qtd;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    if (preco >= 0) {
      this.preco = preco;
    } else {
      System.out.println("Preço negativo");
    }
  }
}

class Perecivel extends Produto {
  private LocalDate dataValidade;

  public Perecivel(String nome, double preco, int estoque, LocalDate dataValidade) {
    super(nome, preco, estoque);
    this.dataValidade = dataValidade;
  }

  public LocalDate getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(LocalDate dataValidade) {
    this.dataValidade = dataValidade;
  }

  @Override
  public void vender(int qtd) {
    LocalDate hoje = LocalDate.now();

    if (qtd <= 0) {
      System.out.println("Quantidade menor que 0");
    } else if (qtd > this.estoque) {
      System.out.println("Quantidade maior que estoque atual");
    } else if (hoje.isAfter(this.dataValidade)) {
      System.out.println("Produto vencido!");
    }

  }
}

class ProdutoImportado extends Produto {
  private double taxaImportaxao;

  public ProdutoImportado(String nome, double preco, int estoque, double taxaImportaxao) {
    super(nome, preco, estoque);
    this.taxaImportaxao = taxaImportaxao;
  }

  @Override
  public void vender(int qtd) {
    if (qtd <= 0) {
      System.out.println("Quantidade menor que 0");
    } else if (qtd > this.estoque) {
      System.out.println("Quantidade maior que estoque atual");
    }
    this.estoque -= qtd;
    System.out.println("Preço final: " + (this.preco + this.taxaImportaxao));
  }

  public double getTaxaImportaxao() {
    return taxaImportaxao;
  }

  public void setTaxaImportaxao(double taxaImportaxao) {
    this.taxaImportaxao = taxaImportaxao;
  }

}

class Venda {
  private Produto produto;

  public Venda(Produto produto) {

    this.produto = produto;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public void vender(Produto produto, int quantidade) {
    produto.vender(quantidade);
  }

  public void vender(ProdutoImportado produto, int quantidade) {
    produto.vender(quantidade);
  }

  public void vender(Perecivel produto, int quantidade) {
    produto.vender(quantidade);
  }
}
