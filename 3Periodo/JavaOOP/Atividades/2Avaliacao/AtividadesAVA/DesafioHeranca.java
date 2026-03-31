class Veiculo {
  protected String especie, placa, marca, modelo, chassi, renavam, procedencia, corExterna, corInterna, tipoCombustivel,
      motor, opcionais;
  protected int anoModelo, anoFabricacao, numeroPortas, numeroPassageiros;
  protected double capacidadeMaximaCarga, altura, largura, profundidade, consumoMedio;

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getChassi() {
    return chassi;
  }

  public void setChassi(String chassi) {
    this.chassi = chassi;
  }

  public String getRenavam() {
    return renavam;
  }

  public void setRenavam(String renavam) {
    this.renavam = renavam;
  }

  public String getProcedencia() {
    return procedencia;
  }

  public void setProcedencia(String procedencia) {
    this.procedencia = procedencia;
  }

  public String getCorExterna() {
    return corExterna;
  }

  public void setCorExterna(String corExterna) {
    this.corExterna = corExterna;
  }

  public String getCorInterna() {
    return corInterna;
  }

  public void setCorInterna(String corInterna) {
    this.corInterna = corInterna;
  }

  public String getTipoCombustivel() {
    return tipoCombustivel;
  }

  public void setTipoCombustivel(String tipoCombustivel) {
    this.tipoCombustivel = tipoCombustivel;
  }

  public String getMotor() {
    return motor;
  }

  public void setMotor(String motor) {
    this.motor = motor;
  }

  public String getOpcionais() {
    return opcionais;
  }

  public void setOpcionais(String opcionais) {
    this.opcionais = opcionais;
  }

  public int getAnoModelo() {
    return anoModelo;
  }

  public void setAnoModelo(int anoModelo) {
    this.anoModelo = anoModelo;
  }

  public int getAnoFabricacao() {
    return anoFabricacao;
  }

  public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
  }

  public int getNumeroPortas() {
    return numeroPortas;
  }

  public void setNumeroPortas(int numeroPortas) {
    this.numeroPortas = numeroPortas;
  }

  public int getNumeroPassageiros() {
    return numeroPassageiros;
  }

  public void setNumeroPassageiros(int numeroPassageiros) {
    this.numeroPassageiros = numeroPassageiros;
  }

  public double getCapacidadeMaximaCarga() {
    return capacidadeMaximaCarga;
  }

  public void setCapacidadeMaximaCarga(double capacidadeMaximaCarga) {
    this.capacidadeMaximaCarga = capacidadeMaximaCarga;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getLargura() {
    return largura;
  }

  public void setLargura(double largura) {
    this.largura = largura;
  }

  public double getProfundidade() {
    return profundidade;
  }

  public void setProfundidade(double profundidade) {
    this.profundidade = profundidade;
  }

  public double getConsumoMedio() {
    return consumoMedio;
  }

  public void setConsumoMedio(double consumoMedio) {
    this.consumoMedio = consumoMedio;
  }

  public Veiculo(String especie, String placa, String marca, String modelo, String chassi, String renavam,
      String procedencia, String corExterna, String corInterna, String tipoCombustivel, String motor, String opcionais,
      int anoModelo, int anoFabricacao, int numeroPortas, int numeroPassageiros, double capacidadeMaximaCarga,
      double altura, double largura, double profundidade, double consumoMedio) {
    this.especie = especie;
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.chassi = chassi;
    this.renavam = renavam;
    this.procedencia = procedencia;
    this.corExterna = corExterna;
    this.corInterna = corInterna;
    this.tipoCombustivel = tipoCombustivel;
    this.motor = motor;
    this.opcionais = opcionais;
    this.anoModelo = anoModelo;
    this.anoFabricacao = anoFabricacao;
    this.numeroPortas = numeroPortas;
    this.numeroPassageiros = numeroPassageiros;
    this.capacidadeMaximaCarga = capacidadeMaximaCarga;
    this.altura = altura;
    this.largura = largura;
    this.profundidade = profundidade;
    this.consumoMedio = consumoMedio;
  }

}
