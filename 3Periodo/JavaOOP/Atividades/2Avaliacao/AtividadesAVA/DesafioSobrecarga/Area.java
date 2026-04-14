package DesafioSobrecarga;

class Area {
  private String tipoPoligono;

  public Area(String tipoPoligono) {
    this.tipoPoligono = tipoPoligono;
  }

  public String getTipoPoligono() {
    return tipoPoligono;
  }

  public void setTipoPoligono(String tipoPoligono) {
    this.tipoPoligono = tipoPoligono;
  }

  public float calcularArea(float lado) throws IllegalArgumentException {
    if (lado > 0) {
      return lado * lado;
    }
    throw new IllegalArgumentException("Lado precisa ser maior que 0");
  }

  public float calcularArea(float base, float altura) throws IllegalArgumentException {
    if (base > 0 && altura > 0) {
      return base * altura;
    }
    throw new IllegalArgumentException("Tanto base quanto altura precisam ser maiores que 0");
  }

  public float calcularArea(float baseMenor, float baseMaior, float altura) throws IllegalArgumentException {
    if (baseMenor > 0 && baseMaior > 0 && altura > 0) {
      return ((baseMenor + baseMaior) * altura) / 2;
    }
    throw new IllegalArgumentException("Ambas as bases e altura precisam ser maiores que 0");
  }
}
