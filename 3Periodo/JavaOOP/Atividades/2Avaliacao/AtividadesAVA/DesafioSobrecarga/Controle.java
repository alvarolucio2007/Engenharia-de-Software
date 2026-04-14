package DesafioSobrecarga;

public class Controle {
  public static void main(String[] args) {
    Area calculadora = new Area("Calculadora de Polígonos");
    try {
      System.out.println("Área Quadrado: " + calculadora.calcularArea(5f));
      System.out.println("Área Retângulo: " + calculadora.calcularArea(5f, 10f));
      System.out.println("Área Trapézio: " + calculadora.calcularArea(1f, 2f, 3f));
    } catch (IllegalArgumentException e) {
      System.err.println("Erro nos valores: " + e);
    }
  }
}
