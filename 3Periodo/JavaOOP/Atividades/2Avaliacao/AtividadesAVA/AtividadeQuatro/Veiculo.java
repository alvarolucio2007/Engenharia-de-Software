
abstract class Veiculo {
  private String marca;
  private String modelo;
  private float velocidade;
  private String placa;
  private double capacidadeTanque;
  private double capacidadeAtualTanque;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public float getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(float velocidade) {
    this.velocidade = velocidade;
  }

  public Veiculo(String marca, String modelo, String placa, double capacidadeTanque, double capacidadeAtualTanque) {
    this.marca = marca;
    this.modelo = modelo;
    this.placa = placa;
    this.capacidadeTanque = capacidadeTanque;
    this.capacidadeAtualTanque = capacidadeAtualTanque;
  }

  public Veiculo(String marca, String modelo, float velocidade, String placa, double capacidadeTanque,
      double capacidadeAtualTanque) {
    this.marca = marca;
    this.modelo = modelo;
    this.velocidade = velocidade;
    this.placa = placa;
    this.capacidadeTanque = capacidadeTanque;
    this.capacidadeAtualTanque = capacidadeAtualTanque;
  }

  public void frear() {
    this.velocidade = Math.max(0, this.velocidade - 10);
  }

  public void frear(int decremento) {
    this.velocidade = Math.max(0, this.velocidade - decremento);
  }

  public abstract void exibirStatus();

  public void ligar() {
    System.out.println("Ligando...");
  }

  public void ligar(String modo) {
    System.out.println("Ligando no modo " + modo);
  }

  public void interagir(Veiculo outro) {
    System.out.println("Ultrapassando veículo genérico...");
  }

  public void interagir(Moto outro) {
    System.out.println("Ultrapassando uma moto...");
  }

  public void interagir(Carro outro) {
    System.out.println("Ultrapassando um carro...");
  }

  public void interagir(Caminhao outro) {
    System.out.println("Ultrapassagem mal sucedida! COLISÃO IMINENTE");
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((placa == null) ? 0 : placa.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Veiculo other = (Veiculo) obj;
    if (placa == null) {
      if (other.placa != null)
        return false;
    } else if (!placa.equals(other.placa))
      return false;
    return true;
  }

  public boolean abastecer(double litros) {
    if (litros <= 0 || (capacidadeAtualTanque + litros) > capacidadeTanque) {
      return false;
    }
    this.capacidadeAtualTanque += litros;
    return true;
  }

  public boolean abastecer(double litros, String tipoCombustivel) {
    if (litros <= 0 || (capacidadeAtualTanque + litros) > capacidadeTanque) {
      return false;
    }
    this.capacidadeAtualTanque += litros;
    System.out.println("Abastecendo com combustível " + tipoCombustivel);
    return true;
  }

  public abstract void calcularConsumo();

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public double getCapacidadeTanque() {
    return capacidadeTanque;
  }

  public void setCapacidadeTanque(double capacidadeTanque) {
    this.capacidadeTanque = capacidadeTanque;
  }

  public double getCapacidadeAtualTanque() {
    return capacidadeAtualTanque;
  }

}

class Carro extends Veiculo {

  private int numPortas;

  public Carro(String marca, String modelo, String placa, double capacidadeTanque, double capacidadeAtualTanque,
      int numPortas) {
    super(marca, modelo, placa, capacidadeTanque, capacidadeAtualTanque);
    this.numPortas = numPortas;
  }

  public Carro(String marca, String modelo, float velocidade, String placa, double capacidadeTanque,
      double capacidadeAtualTanque, int numPortas) {
    super(marca, modelo, velocidade, placa, capacidadeTanque, capacidadeAtualTanque);
    this.numPortas = numPortas;
  }

  public void acelerar() {
    if (getCapacidadeAtualTanque() > 0) {
      setVelocidade(getVelocidade() + 10);
    }
  }

  public void acelerar(int incremento) {
    if (getCapacidadeAtualTanque() > 0) {
      setVelocidade(getVelocidade() + incremento);
    }
  }

  @Override
  public String toString() {
    return "Carro: " + getMarca() + " " + getModelo() + "- Velocidade: " + getVelocidade() + " km/h";
  }

  @Override
  public void calcularConsumo() {
    System.out.println("Consumo do carro: médio.");
  }

  @Override
  public void exibirStatus() {
    System.out.println(toString() + "| Portas: " + numPortas);
  }
}

class Moto extends Veiculo {

  private int cilindadas;

  public Moto(String marca, String modelo, String placa, double capacidadeTanque, double capacidadeAtualTanque) {
    super(marca, modelo, placa, capacidadeTanque, capacidadeAtualTanque);
  }

  public Moto(String marca, String modelo, float velocidade, String placa, double capacidadeTanque,
      double capacidadeAtualTanque) {
    super(marca, modelo, velocidade, placa, capacidadeTanque, capacidadeAtualTanque);
  }

  public void acelerar() {
    setVelocidade(getVelocidade() + 15);
  }

  public void acelerar(int incremento) {
    setVelocidade(getVelocidade() + incremento);
  }

  @Override
  public void calcularConsumo() {
    System.out.println("Consumo da moto: baixo.");
  }

  @Override
  public void exibirStatus() {
    System.out.println("Moto: " + getMarca() + " | cilindadas: " + cilindadas);
  }
}

class Caminhao extends Veiculo {

  public Caminhao(String marca, String modelo, String placa, double capacidadeTanque, double capacidadeAtualTanque) {
    super(marca, modelo, placa, capacidadeTanque, capacidadeAtualTanque);
  }

  public Caminhao(String marca, String modelo, float velocidade, String placa, double capacidadeTanque,
      double capacidadeAtualTanque) {
    super(marca, modelo, velocidade, placa, capacidadeTanque, capacidadeAtualTanque);
  }

  @Override
  public void calcularConsumo() {
    System.out.println("Consumo do caminhão: alto.");
  }

  @Override
  public String toString() {
    return "Caminhao []";
  }

  @Override
  public void exibirStatus() {
    System.out.println(toString());
  }

}

class Garagem {
  private Veiculo[] listaVeiculos;

  public Garagem(int capacidade) {
    this.listaVeiculos = new Veiculo[capacidade];
  }

  public boolean adicionarVeiculo(Veiculo novoVeiculo) {
    if (novoVeiculo == null || novoVeiculo instanceof Caminhao)
      return false;
    for (int i = 0; i < listaVeiculos.length; i++) {
      if (listaVeiculos[i] == null) {
        listaVeiculos[i] = novoVeiculo;
        return true;
      }
    }
    return false;
  }

  public boolean removerVeiculo(Veiculo veiculo) {
    if (veiculo == null)
      return false;
    for (int i = 0; i < listaVeiculos.length; i++) {
      if (listaVeiculos[i] != null && listaVeiculos[i].equals(veiculo)) {
        listaVeiculos[i] = null;
        return true;
      }
    }
    return false;
  }

  public Veiculo[] getListaVeiculos() {
    return listaVeiculos;
  }

  public void setListaVeiculos(Veiculo[] listaVeiculos) {
    this.listaVeiculos = listaVeiculos;
  }
}
