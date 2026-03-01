package AtividadeDois;

record Compra(double valorTotal) {
}

class Cupom {
  private String nome;
  private int usosRestantes;
  private int descontoDado;

  public Cupom(int descontoDado, String nome, int usosRestantes) {
    this.descontoDado = descontoDado;
    this.nome = nome;
    this.usosRestantes = usosRestantes;
  }

  public int getDescontoDadoPorcent() {
    return descontoDado;
  }

  public void setDescontoDado(int descontoDado) {
    this.descontoDado = descontoDado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getUsosRestantes() {
    return usosRestantes;
  }

  public void setUsosRestantes(int usosRestantes) {
    this.usosRestantes = usosRestantes;
  }

  boolean testarCupom() {
    if (usosRestantes == 0) {
      System.out.println("Não é possível mais usar o cupom!");
      return false;
    } else if (nome.equals("CONSUMIDOR20")) {
      descontoDado = 20;
    }
  }

}

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

class ProcessadordeVendas {
  private int porcDesconto;
  private Cliente cliente;
  private Cupom cupom;
  private double valorTotal;
  private double valorDescontado;

  public ProcessadordeVendas(int porcDesconto, Cliente cliente, Cupom cupom, double valorTotal) {
    this.porcDesconto = porcDesconto;
    this.cliente = cliente;
    this.cupom = cupom;
    this.valorTotal = valorTotal;
  }

  public int getPorcDesconto() {
    return porcDesconto;
  }

  public void setPorcDesconto(int porcDesconto) {
    this.porcDesconto = porcDesconto;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cupom getCupom() {
    return cupom;
  }

  public void setCupom(Cupom cupom) {
    this.cupom = cupom;
  }

  void calcularDesconto(int porcDesconto,Cliente cliente,Cupom,cupom){
    if (!cliente.getTipoCliente().equals("VIP"))&&(cupom.)){
      
    }

  }
}
