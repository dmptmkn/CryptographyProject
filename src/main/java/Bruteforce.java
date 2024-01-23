import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Bruteforce {

    private static final int MAX_WORD_LENGTH = 28;

    @SneakyThrows
    public void bruteForce() {
        Util.writeMessage("Введите адрес зашифрованного файла");
        String src = Util.readString();
        Path dst = Util.buildFileName(src, "_brutforce");
        StringBuilder builder = new StringBuilder();

        CaesarCipher caesar = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                builder.append(line).append(System.lineSeparator());
                list.add(line);
            }
            for (int i = 0; i < caesar.alphabetLength(); i++) {
                String result = caesar.decrypt(builder.toString(), i);
                if (isValidated(result)) {
                    for (String str : list) {
                        String decrypted = caesar.decrypt(str, i);
                        writer.write(decrypted);
                        writer.newLine();
                    }
                    Util.writeMessage("Содержимое расшифровано. Ключ расшифровки: " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidated(String text) {
        boolean isValidated = false;
        for (String word : text.split(" ")) {
            if (word.length() > MAX_WORD_LENGTH) {
                break;
            }
        }
        if (text.contains(", ") || text.contains(". ")
                || text.contains("! ") || text.contains("? ")
                || text.contains("; ") || text.contains(": ")) {
            isValidated = true;
        }
        while (isValidated) {
            Util.writeMessage(text);
            Util.writeMessage("Подходит ли вариант расшифровки? Да/Нет");
            String answer = Util.readString();
            if (answer.equalsIgnoreCase("да")) {
                return true;
            } else if (answer.equalsIgnoreCase("нет")) {
                isValidated = false;
            } else {
                Util.writeMessage("Для ответа введите \"Да\" или \"Нет\"");
            }
        }
        return false;
    }
}

// создать класс Brutforce-2 и попробовать дооптимизировать задачу: воспользоваться Files.readAllLines
// создать класс Brutforce-3 и решить задачу через методы Files.readString() и Files.writeString()