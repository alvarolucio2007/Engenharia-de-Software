package DesafioSobreescrita;

class TrianguloRetangulo extends PoligonoRetangular {

  public TrianguloRetangulo(float altura, float base) {
    super(altura, base);
  }

  @Override
  float calcularArea() {
    return getBase() * getAltura() / 2;
  }
}
