import java.util.List;

class Veiculo {
  private String cor, placa;

  public Veiculo(String cor, String placa) {
    this.cor = cor;
    this.placa = placa;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

}

class Motocicleta extends Veiculo {

  public Motocicleta(String cor, String placa) {
    super(cor, placa);
  }

}

class CarroDePasseio extends Veiculo {

  public CarroDePasseio(String cor, String placa) {
    super(cor, placa);
  }

}

class UtilitarioEsportivo extends Veiculo {

  public UtilitarioEsportivo(String cor, String placa) {
    super(cor, placa);
  }

}

class Caminhonete extends Veiculo {

  public Caminhonete(String cor, String placa) {
    super(cor, placa);
  }

}

class Caminhao extends Veiculo {

  public Caminhao(String cor, String placa) {
    super(cor, placa);
  }

}

class Atendimento {
  private String servico;
  private Veiculo veiculo;

  public String getServico() {
    return servico;
  }

  public void setServico(String servico) {
    this.servico = servico;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Atendimento(String servico, Veiculo veiculo) {
    this.servico = servico;
    this.veiculo = veiculo;
  }
}

class Lavajato {
  private List<Atendimento> atendimentos;

  public List<Atendimento> getAtendimentos() {
    return atendimentos;
  }

  public void setAtendimentos(List<Atendimento> atendimentos) {
    this.atendimentos = atendimentos;
  }

  public Lavajato(List<Atendimento> atendimentos) {
    this.atendimentos = atendimentos;
  }

  public void atender(String servico, Veiculo veiculo) {
    this.atendimentos.add(new Atendimento(servico, veiculo));
    System.out.println("Veículo " + veiculo.getPlaca() + " na fila para " + servico);
  }

  public void executarProximoServico() {
    if (!atendimentos.isEmpty()) {
      Atendimento proximo = atendimentos.remove(0);
      System.out.println("Executando " + proximo.getServico() + " no veículo " + proximo.getVeiculo().getPlaca());
    } else {
      System.out.println("Fila vazia!");
    }
  }
}
