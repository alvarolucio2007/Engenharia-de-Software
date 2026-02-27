class ArCondicionado {
  private float temp;

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

public class QuestaoQuatro {
  public static void main(String[] args) {
    ArCondicionado novoAr = new ArCondicionado(25);
    novoAr.setTemperatura(29);
  }
}
