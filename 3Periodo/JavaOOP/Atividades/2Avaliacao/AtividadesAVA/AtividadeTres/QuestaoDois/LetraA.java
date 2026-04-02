abstract class Animal {
  protected String nome;
  protected String raca;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public Animal(String nome, String raca) {
    this.nome = nome;
    this.raca = raca;
  }

  protected String caminha() {
    return "Caminhando...";
  }

}

class Cachorro extends Animal {

  public Cachorro(String nome, String raca) {
    super(nome, raca);
  }

  public String latir() {
    return "Latindo...";

  }
}

class Gato extends Animal {

  public Gato(String nome, String raca) {
    super(nome, raca);
  }

  public String miar() {
    return "Miando...";
  }
}
