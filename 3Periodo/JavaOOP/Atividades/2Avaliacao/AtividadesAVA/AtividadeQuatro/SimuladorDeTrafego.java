
public class SimuladorDeTrafego {
  public static void main(String[] args) {
    Carro carro1 = new Carro("Toyota", "Etios", "1234-ABC", 50, 10, 4);
    Moto moto1 = new Moto("Honda", "Pop100", "5678-XYZ", 15, 5);
    Caminhao caminhao1 = new Caminhao("Vuuv", "N sei n sou rico", "1011-JKL", 10, 100);
    System.out.println("Teste de combustível:");
    carro1.setCapacidadeTanque(0);
    carro1.acelerar(); // vai dar erro...
    if (carro1.getVelocidade() == 0) {
      System.out.println("O carro não acelerou...");
    }
    System.out.println("Teste de interação na pista:");
    moto1.interagir(carro1);
    carro1.interagir(caminhao1);
    System.out.println("Status de consumo:");
    moto1.calcularConsumo();
    caminhao1.calcularConsumo();
    System.out.println("Abastecimento:");
    if (!moto1.abastecer(20)) { // capacidade maxima é 15
      System.out.println("Erro: Capacidade de tangue excedida!");
    }
    moto1.abastecer(5);
  }
}
