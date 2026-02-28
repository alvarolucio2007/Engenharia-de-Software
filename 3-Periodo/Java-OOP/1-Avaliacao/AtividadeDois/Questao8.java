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

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}

class Veiculo {
  private String placa;
  private String tipo;

  public Veiculo(String placa) {
    this.placa = placa;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Veiculo() {
  }

}

class Via {
  private String nome;
  private boolean fluxoVeiculos;

  public Via(String nome, boolean fluxoVeiculos) {
    this.nome = nome;
    this.fluxoVeiculos = fluxoVeiculos;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean isFluxoVeiculos() {
    return fluxoVeiculos;
  }

  public void setFluxoVeiculos(boolean fluxoVeiculos) {
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isEstaAtivado() {
    return estaAtivado;
  }

  public void setEstaAtivado(boolean estaAtivado) {
    this.estaAtivado = estaAtivado;
  }

}

class ControladorCentral {

}
