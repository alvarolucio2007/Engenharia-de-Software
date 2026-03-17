interface Notificador {
  void enviar(String mensagem);
}

class EmailNotificador implements Notificador {
  @Override
  public void enviar(String mensagem) {
    System.out.println(mensagem);
  }
}

class SistemaAlerta {
  private Notificador servico;

  public SistemaAlerta(Notificador servico) {
    this.servico = servico;
  }

  public void disparar(String msg) {
    servico.enviar(msg);
  }
}
