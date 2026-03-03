package AtividadeDois;

class Semaforo {
  private String cor;

  public Semaforo(String cor) {
    this.cor = cor;
  }

  void trocar() {
    if (this.cor.equals("vermelho")) {
      this.cor = "verde";
    } else if (this.cor.equals("verde")) {
      this.cor = "vermelho";
    }
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}

record Veiculo(String placa, String tipo) {
}

record Via(String nome, boolean fluxoVeiculos) {
}

record SensorPassagem(int id, boolean estaAtivado) {
}

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
