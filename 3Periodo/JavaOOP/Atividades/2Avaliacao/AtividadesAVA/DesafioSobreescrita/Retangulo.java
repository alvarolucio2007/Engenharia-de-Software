package DesafioSobreescrita;

class Retangulo extends PoligonoRetangular {

  public Retangulo(float altura, float base) {
    super(altura, base);
  }

  @Override
  float calcularArea() {
    return getBase() * getAltura();
  }
}
