
public class Menu {
    public static void main(String[] args) {

        while (true) {
            Util.writeMessage("""
                    Выберите действие, введя его номер
                    1 - зашифровать текст в файле
                    2 - расшифровать текст в файле
                    3 - подобрать ключ, используя "грубую силу"
                    4 - расшифровать текст методом синтаксического анализа
                    5 - выход из программы""");
            switch (Util.readString()) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> new Bruteforce().bruteForce();
                case "4" -> System.out.println("4 - расшифровать текст методом синтаксического анализа");
                case "5" -> {return;}
            }
        }
    }
}