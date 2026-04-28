
package Questao1;

class Caminhao {

  private String placa;
  private double capacidadeTanque;
  private double combustivelAtual;
  private double consumoKmPorLitro;

  public Caminhao(double consumoKmPorLitro, String placa, double capacidadeTanque, double combustivelAtual) {
    this.consumoKmPorLitro = consumoKmPorLitro;
    this.placa = placa;
    this.capacidadeTanque = capacidadeTanque;
    this.combustivelAtual = combustivelAtual;
  }

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

  public double getCombustivelAtual() {
    return combustivelAtual;
  }

  public void setCombustivelAtual(double combustivelAtual) {
    this.combustivelAtual = combustivelAtual;
  }

  public double getConsumoKmPorLitro() {
    return consumoKmPorLitro;
  }

  public void setConsumoKmPorLitro(double consumoKmPorLitro) {
    this.consumoKmPorLitro = consumoKmPorLitro;
  }

  void abastecer(double litros) {
    if (litros + this.combustivelAtual <= this.capacidadeTanque) {
      this.combustivelAtual += litros;
    } else {
      System.out.println("Não é possível abastecer!");
    }
  }

  boolean viagemEhPossivel(int distanciaKm) {
    double consumoViagem = (double) distanciaKm / this.consumoKmPorLitro;
    return this.combustivelAtual >= consumoViagem;
  }
}
