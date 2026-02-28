package AtividadeDois;

class Semaforo {
  private String cor;

  public Semaforo(String cor) {
    this.cor = cor;
  }

  void trocar() {
    if (cor == "vermelho".toLowerCase()) {
      cor = "verde";
    } else {
      cor = "vermelho";
    }
  }
}

class Veiculo {
  private String placa;
  private String tipo;

  public Veiculo(String placa) {
    this.placa = placa;
  }

}

class Via {
  private String nome;
  private boolean fluxoVeiculos;

  public Via(String nome, boolean fluxoVeiculos) {
    this.nome = nome;
    this.fluxoVeiculos = fluxoVeiculos;
  }
}

class SensorPassagem {
  private int id;
  private boolean estaAtivado;

  public SensorPassagem(int id, boolean estaAtivado) {
    this.estaAtivado = estaAtivado;
    this.id = id;
  }

}

class ControladorCentral {

}
