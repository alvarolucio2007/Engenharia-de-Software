package Questao9;

class PedidoCompra {
  private int idPedido;
  private String status;

  public int getIdPedido() {
    return idPedido;
  }

  public PedidoCompra(int idPedido, String status) {
    this.idPedido = idPedido;
    this.status = status;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
