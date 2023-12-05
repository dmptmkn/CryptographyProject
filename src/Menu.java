import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие, введя его номер");
            System.out.println("1 - зашифровать текст в файле");
            System.out.println("2 - расшифровать текст в файле");
            System.out.println("3 - подобрать ключ, используя \"грубую силу\"");
            System.out.println("4 - расшифровать текст методом синтаксического анализа");
            System.out.println("5 - выход из программы");

            switch (scan.nextLine()) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> System.out.println("3 - подобрать ключ, используя \"грубую силу\"");
                case "4" -> System.out.println("4 - расшифровать текст методом синтаксического анализа");
                case "5" -> {return;}
            }
        }
    }
}