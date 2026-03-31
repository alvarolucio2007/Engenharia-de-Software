class Ingresso {
  protected double reais;

  public double getReais() {
    return reais;
  }

  public void setReais(double reais) {
    this.reais = reais;
  }

  public Ingresso(double reais) {
    this.reais = reais;
  }

  protected void imprimeValor() {
    System.out.println(this.reais);
  }
}

class VIP extends Ingresso {
  protected double adicionalVIP;

  public double getAdicionalVIP() {
    return adicionalVIP;
  }

  public void setAdicionalVIP(double adicionalVIP) {
    this.adicionalVIP = adicionalVIP;
  }

  public VIP(double reais, double adicionalVIP) {
    super(reais);
    this.adicionalVIP = adicionalVIP;
  }

  public double getValorVIP() {
    return this.reais + this.adicionalVIP;
  }
}

class CamaroteInferior extends VIP {
  private String localizacao;

  public CamaroteInferior(double reais, double adicionalVIP, String localizacao) {
    super(reais, adicionalVIP);
    this.localizacao = localizacao;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public void imprimeLocalizacao() {
    System.out.println("Localização: " + this.localizacao);
  }
}

class CamaroteSuperior extends VIP {
  private double adicionalCamaroteSuperior;

  public CamaroteSuperior(double reais, double adicionalVIP, double adicionalCamaroteSuperior) {
    super(reais, adicionalVIP);
    this.adicionalCamaroteSuperior = adicionalCamaroteSuperior;
  }

  public double getValorCamaroteSuperior() {
    return this.getValorVIP() + this.adicionalCamaroteSuperior;
  }

  public double getAdicionalCamaroteSuperior() {
    return adicionalCamaroteSuperior;
  }

  public void setAdicionalCamaroteSuperior(double adicionalCamaroteSuperior) {
    this.adicionalCamaroteSuperior = adicionalCamaroteSuperior;
  }

}

class Normal extends Ingresso {

  public Normal(double reais) {
    super(reais);
  }

  public void imprimeIngresso() {
    System.out.println("Ingresso Normal");
  }
}
