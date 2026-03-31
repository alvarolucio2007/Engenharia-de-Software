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

}

class Normal extends Ingresso {

  public Normal(double reais) {
    super(reais);
  }

  private void impromeIngresso() {
    System.out.println("Ingresso Normal");
  }
}
