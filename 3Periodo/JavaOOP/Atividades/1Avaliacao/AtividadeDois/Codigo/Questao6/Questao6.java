package Questao6;

class Guerreiro {
  private int escudo;
  private int vida;

  public Guerreiro(int escudo, int vida) {
    this.escudo = escudo;
    this.vida = vida;
  }

  void receberDano(int dano) {
    if (dano <= escudo) {
      escudo -= dano;
      System.out.println(escudo + "<-escudo vida->" + vida);
    } else {
      int danoRestante = dano - escudo;
      escudo = 0;
      vida -= danoRestante;
      if (vida <= 0) {
        vida = 0;
        System.out.println("Morreu");
      } else {
        System.out.println(escudo + "<-escudo vida->" + vida);
      }
    }
  }

  public int getEscudo() {
    return escudo;
  }

  public void setEscudo(int escudo) {
    this.escudo = escudo;
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }
}

public class Questao6 {
  public static void main(String[] args) {
    Guerreiro novoGuerreiro = new Guerreiro(100, 100);
    novoGuerreiro.receberDano(150);
  }
}
