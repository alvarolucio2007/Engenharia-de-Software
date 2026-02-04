class Livro {
  String titulo;
  String autor;
  float preco;
  protected int ano;

  public int getAno() {
    return ano;
  }

  public void setAno(int novoAno) {
    if (novoAno > 0) {
      this.ano = novoAno;
    } else {
      System.out.println("Ano AC!");
    }
  }

  public void setPreco(float novoPreco) {
    if (novoPreco > 0) {
      this.preco = novoPreco;

    } else {
      System.out.println("Preço Inválido!");
    }
  }

  void ler() {
    System.out.println(
        "O livro " + titulo + " do autor " + autor + " foi lançado em " + ano + " com o preço de " + preco + ".");
  }
}

class Ebook extends Livro {
  protected double tamanhoArquivo;

  public double getTamanhoArquivo() {
    return tamanhoArquivo;
  }

  public void setTamanhoArquivo(double novoTamanhoArquivo) {
    if (novoTamanhoArquivo > 0) {
      this.tamanhoArquivo = novoTamanhoArquivo;
    } else {
      System.out.println("Tamanho inválido!");
    }
  }

  @Override
  void ler() {
    System.out.println(
        "O livro " + titulo + " do autor " + autor + " foi lançado em " + ano + " com o preço de " + preco + "e contém "
            + tamanhoArquivo + "mB de espaço.");
  }
}

public class AtividadeUm {
  public static void main(String[] args) {
    Ebook meuEbook = new Ebook();
    meuEbook.titulo = "Teste";
    meuEbook.autor = "Teste";
    meuEbook.setPreco(100.0f);
    meuEbook.setAno(100);
    meuEbook.setTamanhoArquivo(1000d);
    meuEbook.ler();
  }
}
