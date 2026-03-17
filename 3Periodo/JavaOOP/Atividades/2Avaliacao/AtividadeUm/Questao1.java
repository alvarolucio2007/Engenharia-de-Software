class Rota {
  double carga;
  Veiculo veiculoRota;
  double autonomiaKmPorLitro;
  double precoCombustivel;
  double distanciaKm;
  String origem;
  boolean emRota;

  public double getCarga() {
    return carga;
  }

  public void setCarga(double carga) {
    this.carga = carga;
  }

  public Veiculo getVeiculoRota() {
    return veiculoRota;
  }

  public void setVeiculoRota(Veiculo veiculoRota) {
    this.veiculoRota = veiculoRota;
  }

  public double getAutonomiaKmPorLitro() {
    return autonomiaKmPorLitro;
  }

  public void setAutonomiaKmPorLitro(double autonomiaKmPorLitro) {
    this.autonomiaKmPorLitro = autonomiaKmPorLitro;
  }

  public double getPrecoCombustivel() {
    return precoCombustivel;
  }

  public void setPrecoCombustivel(double precoCombustivel) {
    this.precoCombustivel = precoCombustivel;
  }

  public double getDistanciaKm() {
    return distanciaKm;
  }

  public void setDistanciaKm(double distanciaKm) {
    this.distanciaKm = distanciaKm;
  }

  double calcularCustoViagem() {
    var custo = (this.distanciaKm / this.autonomiaKmPorLitro) * this.precoCombustivel;
    return custo;
  }

  void gerarManifesto() {
    System.out.println("O motorista " + this.veiculoRota.motoristaVeiculo.getNome() + "partiu de " + getOrigem()
        + "com o veículo " + veiculoRota.getPlaca() + " , carregando " + veiculoRota.getPesoCarga()
        + " kg, com custo de R$ " + calcularCustoViagem());
  }

  public Rota(double carga, Veiculo veiculoRota, double autonomiaKmPorLitro, double precoCombustivel,
      double distanciaKm, String origem, boolean emRota) {
    this.carga = carga;
    this.veiculoRota = veiculoRota;
    this.autonomiaKmPorLitro = autonomiaKmPorLitro;
    this.precoCombustivel = precoCombustivel;
    this.distanciaKm = distanciaKm;
    this.origem = origem;
    this.emRota = emRota;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public boolean isEmRota() {
    return emRota;
  }

  public void setEmRota(boolean emRota) {
    this.emRota = emRota;
  }

}

class Veiculo {
  String placa;
  boolean emManutencao;
  boolean emViagem;
  double capacidadeCarga;
  double pesoCarga;

  public double getPesoCarga() {
    return pesoCarga;
  }

  public void setPesoCarga(double pesoCarga) {
    this.pesoCarga = pesoCarga;
  }

  Motorista motoristaVeiculo;

  void concluirManutencao() {
    this.emManutencao = false;
  }

  public Veiculo(String placa, boolean emManutencao, boolean emViagem, double capacidadeCarga, double pesoCarga,
      Motorista motoristaVeiculo) {
    this.placa = placa;
    this.emManutencao = emManutencao;
    this.emViagem = emViagem;
    this.capacidadeCarga = capacidadeCarga;
    this.pesoCarga = pesoCarga;
    this.motoristaVeiculo = motoristaVeiculo;
  }

  void iniciarViagem() {
    if (this.motoristaVeiculo == null) {
      System.out.println("Não há motorista vinculado a este veículo");
    } else if (!this.motoristaVeiculo.podeDirigir()) {
      System.out.println("Motorista não habilitado");
    } else {
      System.out.println("viagem iniciada com sucesso");
      this.emViagem = true;
    }

  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public boolean isEmManutencao() {
    return emManutencao;
  }

  public void setEmManutencao(boolean emManutencao) {
    this.emManutencao = emManutencao;
  }

  public boolean isEmViagem() {
    return emViagem;
  }

  public void setEmViagem(boolean emViagem) {
    this.emViagem = emViagem;
  }

  public double getCapacidadeCarga() {
    return capacidadeCarga;
  }

  public void setCapacidadeCarga(double capacidadeCarga) {
    this.capacidadeCarga = capacidadeCarga;
  }

  public Motorista getMotoristaVeiculo() {
    return motoristaVeiculo;
  }

  public void setMotoristaVeiculo(Motorista motoristaVeiculo) {
    this.motoristaVeiculo = motoristaVeiculo;
  }
}

class Motorista {
  String nome;
  String cnh;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnh() {
    return cnh;
  }

  public void setCnh(String cnh) {
    this.cnh = cnh;
  }

  public Motorista(String nome, String cnh) {
    this.nome = nome;
    this.cnh = cnh;
  }

  boolean podeDirigir() {
    if (this.cnh == null || this.cnh.equals("")) {
      System.out.println("condutor ausente, ou cnh em branco");
      return false;
    }
    return true;
  }

}
