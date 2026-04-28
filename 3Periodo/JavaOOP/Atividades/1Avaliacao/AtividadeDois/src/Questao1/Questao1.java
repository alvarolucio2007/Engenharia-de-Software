package src.Questao1;

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
