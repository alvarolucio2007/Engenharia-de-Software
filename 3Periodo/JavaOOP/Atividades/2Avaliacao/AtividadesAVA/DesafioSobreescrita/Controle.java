package DesafioSobreescrita;

public class Controle {
  public static void main(String[] args) {
    Retangulo novoRetangulo = new Retangulo(10, 2);
    TrianguloRetangulo novoTrianguloRetangulo = new TrianguloRetangulo(10, 2);
    var areaRetangulo = novoRetangulo.calcularArea();
    System.out.println("Área retângulo: " + areaRetangulo);
    var areaTrianguloRetangulo = novoTrianguloRetangulo.calcularArea();
    System.out.println("Área Triângulo Retângulo: " + areaTrianguloRetangulo);
  }

}
