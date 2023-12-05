import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {

    public void encryptedDecrypted(boolean flag) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для его " + (flag ? "" : "де") + "шифровки");

        String src = scanner.nextLine();

        System.out.println("Введите ключ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите путь к файлу, в которой требуется записать результат:");
        String dest = scanner.nextLine();
        CaesarCipher caesar = new CaesarCipher();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptDecrypt = flag ? caesar.encrypt(string, key): caesar.decrypt(string, key);
                writer.write(encryptDecrypt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
