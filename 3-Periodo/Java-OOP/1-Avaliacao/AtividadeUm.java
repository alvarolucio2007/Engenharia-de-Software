import java.util.Scanner;

public class AtividadeUm {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double saldo = 1000d;
    System.out.println("1: Consultar Saldo, 2: Depositar Valor, 3: Sacar Valor, 4: Sair");
    int opcao;
    do {
      opcao = scanner.nextInt();
      switch (opcao) {
        case 1:
          System.out.println(saldo);
          break;
        case 2:
          System.out.println("Por favor, insira o valor que voce quer adicionar!");
          double adicionar = scanner.nextDouble();
          if (adicionar < 0) {
            System.out.println("Você não pode depoistar valores menores que 0!");
          } else {
            saldo += adicionar;
          }
          System.out.println("Você agora possui " + saldo);
          break;
        case 3:
          System.out.println("Por favor, insira o valor que quiser retirar! (Tem que ser menor que o saldo.)");
          double remover;
          remover = scanner.nextDouble();
          if (remover <= saldo) {
            saldo -= remover;
          } else {
            System.out.println("Saldo insuficiente!");
          }
          System.out.println("Vocẽ agora possui " + saldo);
          break;
        case 4:
          System.out.println("Obrigado por ter saido do sistema, saindo...");
          break;
        default:
          System.out.println("Por favor, insira apenas de 1 a 4");
          break;
      }
    } while (opcao != 4);
    scanner.close();
  }
}
