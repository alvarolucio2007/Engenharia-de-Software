public class AtividadeUm {
  public static void main(String[] args) {
    try {
      int[] arr = new int[5];
      arr[10] = 5;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Burrão");
    }

  }
}
