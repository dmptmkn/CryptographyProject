import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncryptedDecrypted {

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {
        Util.writeMessage("Введите путь к файлу для его " + (flag ? "" : "де") + "шифровки");
        String src = Util.readString();

        Util.writeMessage("Введите ключ");
        int key = Util.readInt();

        Path dest = Util.buildFileName(src, flag ? "_encrypted" : "_decrypted");
        CaesarCipher caesar = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dest)) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptDecrypt = flag ? caesar.encrypt(string, key) : caesar.decrypt(string, key);
                writer.write(encryptDecrypt);
                writer.newLine();
            }
        }
    }
}
