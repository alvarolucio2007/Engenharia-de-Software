import java.util.Random;

public class Gerador {
  public static void main(String[] args) {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
    StringBuilder senha = new StringBuilder();
    Random rnd = new Random();

    while (senha.length() < 12) { // Senha de 12 caracteres
      int index = rnd.nextInt(caracteres.length());
      senha.append(caracteres.charAt(index));
    }

    System.out.println("Sua senha segura: " + senha.toString());
  }
}
