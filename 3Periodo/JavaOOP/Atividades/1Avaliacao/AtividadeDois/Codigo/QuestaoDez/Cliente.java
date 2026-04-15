package QuestaoDez;

class Cliente {
  private String tipoCliente;
  private Cupom cupomUsado;

  public String getTipoCliente() {
    return tipoCliente;
  }

  public void setTipoCliente(String tipoCliente) {
    this.tipoCliente = tipoCliente;
  }

  public Cupom getCupomUsado() {
    return cupomUsado;
  }

  public void setCupomUsado(Cupom cupomUsado) {
    this.cupomUsado = cupomUsado;
  }

  public Cliente(String tipoCliente, Cupom cupomUsado) {
    this.tipoCliente = tipoCliente;
    this.cupomUsado = cupomUsado;
  }

}
