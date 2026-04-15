package Questao8;

class ControladorCentral {
  void monitorar(Semaforo semaforo, SensorPassagem sensor, Veiculo veiculo) {
    if (!sensor.estaAtivado()) {
      System.out.println("Sensor de passagem não está ativo.");
    } else if (semaforo.getCor().equals("vermelho")) {
      semaforo.trocar();
      System.out.println("Prioridade detectada para" + veiculo.placa());
      System.out.println("Semáforo agora está verde.");
    }
  }
}
