class Eleitor {
  private String nome;
  private int tituloEleitor;
  private boolean jaVotou;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getTituloEleitor() {
    return tituloEleitor;
  }

  public void setTituloEleitor(int tituloEleitor) {
    this.tituloEleitor = tituloEleitor;
  }

  public boolean isJaVotou() {
    return jaVotou;
  }

  public void setJaVotou(boolean jaVotou) {
    this.jaVotou = jaVotou;
  }

  public Eleitor(String nome, int tituloEleitor, boolean jaVotou) {
    this.nome = nome;
    this.tituloEleitor = tituloEleitor;
    this.jaVotou = jaVotou;
  }
}

class UrnaEletronica {
  private int candidatoA; // é contador por alguma razão
  private int candidatoB; // é contador por alguma razão
  private int votosNulos;

  public UrnaEletronica(int candidatoA, int candidatoB, int votosNulos) {
    this.candidatoA = candidatoA;
    this.candidatoB = candidatoB;
    this.votosNulos = votosNulos;
  }

  void registrarVoto(Eleitor e, String opcao) {
    if (e.isJaVotou()) {
      System.out.println("Eleitor já votou!");
    } else {
      if (opcao.equalsIgnoreCase("A")) {
        this.candidatoA += 1;
      } else if (opcao.equalsIgnoreCase("B")) {
        this.candidatoB += 1;
      } else {
        this.votosNulos += 1;
      }
      e.setJaVotou(true);
      System.out.println("Voto confirmado!");
    }
  }

  public int getCandidatoA() {
    return candidatoA;
  }

  public void setCandidatoA(int candidatoA) {
    this.candidatoA = candidatoA;
  }

  public int getCandidatoB() {
    return candidatoB;
  }

  public void setCandidatoB(int candidatoB) {
    this.candidatoB = candidatoB;
  }

  public int getVotosNulos() {
    return votosNulos;
  }

  public void setVotosNulos(int votosNulos) {
    this.votosNulos = votosNulos;
  }
}

public class Questao2 {
  public static void main(String[] args) {
    UrnaEletronica novaUrna = new UrnaEletronica(0, 0, 0);
    Eleitor novoEleitor = new Eleitor("Juarez", 0, false);
    novaUrna.registrarVoto(novoEleitor, "A");
  }
}
