package DesafioSobreescrita;

abstract class PoligonoRetangular {
  protected float base;
  protected float altura;

  abstract float calcularArea();

  public PoligonoRetangular(float altura, float base) {
    this.altura = altura;
    this.base = base;
  }

  public float getBase() {
    return base;
  }

  public void setBase(float base) {
    this.base = base;
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    this.altura = altura;
  }

}
