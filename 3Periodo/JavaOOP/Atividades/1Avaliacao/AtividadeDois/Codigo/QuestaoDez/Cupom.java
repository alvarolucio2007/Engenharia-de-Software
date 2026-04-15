package QuestaoDez;

class Cupom {
  private String nome;
  private int usosRestantes;
  private int descontoDado;

  public Cupom(int descontoDado, String nome, int usosRestantes) {
    this.descontoDado = descontoDado;
    this.nome = nome;
    this.usosRestantes = usosRestantes;
  }

  public int getDescontoDadoPorcent() {
    return descontoDado;
  }

  public void setDescontoDado(int descontoDado) {
    this.descontoDado = descontoDado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getUsosRestantes() {
    return usosRestantes;
  }

  public void setUsosRestantes(int usosRestantes) {
    this.usosRestantes = usosRestantes;
  }

  boolean testarCupom() {
    if (usosRestantes == 0) {
      System.out.println("Não é possível mais usar o cupom!");
      return false;
    } else if (nome.equals("CONSUMIDOR20")) {
      descontoDado = 20;
      this.usosRestantes -= 1;
      return true;
    } else {
      return false;
    }
  }

}
