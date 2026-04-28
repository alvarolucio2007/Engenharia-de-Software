package src.Questao1;

public class Questao1 {
  public static void main(String[] args) {
    Caminhao novoCaminhao = new Caminhao(5, "Teste", 300, 50.0);
    System.out.println(novoCaminhao.viagemEhPossivel(400));
    novoCaminhao.abastecer(100);

    System.out.println(novoCaminhao.viagemEhPossivel(400));
  }
}
