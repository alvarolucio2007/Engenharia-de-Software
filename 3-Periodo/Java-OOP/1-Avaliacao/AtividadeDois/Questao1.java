package AtividadeDois;

class Video {
  private String titulo;
  private int duracao;
  private boolean estaDandoPlay;

  public Video(String titulo, int duracao, boolean estaDandoPlay) {
    this.titulo = titulo;
    this.duracao = duracao;
    this.estaDandoPlay = true;
  }

  void setPlay(boolean estado) {
    this.estaDandoPlay = estado;
  }

  public void alternarPlay() {
    this.estaDandoPlay = !this.estaDandoPlay;
  }

  void mostrarStat() {
    System.out.println(estaDandoPlay);
  }

}

public class Questao1 {
  public static void main(String[] args) {
    Video novoVideo = new Video("Aprendendo Java", 120, true);
    Video novoVideoDois = new Video("Teste", 1200, false);
    novoVideo.setPlay(true);
    novoVideo.alternarPlay();
    novoVideo.mostrarStat();
    novoVideoDois.mostrarStat();

  }
}
