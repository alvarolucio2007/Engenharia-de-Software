package Questao4;

class ArCondicionado {
  private float temp;

  public float getTemp() {
    return temp;
  }

  public void setTemp(float temp) {
    this.temp = temp;
  }

  public ArCondicionado(float temp) {
    this.temp = temp;
  }

  void setTemperatura(float novaTemp) {
    if (novaTemp > 16 && novaTemp < 28) {
      temp = novaTemp;
    } else {
      System.out.println("Temperatura não está entre 16 e 28 graus!");
    }
  }
}
