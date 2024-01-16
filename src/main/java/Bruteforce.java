import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Bruteforce {

    @SneakyThrows
    public void bruteForce() {
        Util.writeMessage("Введите адрес зашифрованного файла");
        String src = Util.readString();
        Path dst = Util.buildFileName(src, "_brutforce");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

        }


    }
}

// считать содержимое файлы в переменную типа String
// при получении строки нужно ее дешифровать через цикл который идет пока i < ALPHABET.length()
// полученные варианты расшифрованного текста нужно валидировать
// валидация происходит через разбиение валидируемого текста по проблелу и проверку каждого слова на длину
// если длина больше 28, то это точно некорректный текст
// если проверка прошла, то проверить, что в тексте содержится хотя бы одна из следующих последовательность ": " "! ". " и тп
// если проверка прошла, то предложить пользователю на валидацию кусок расшифрованного текста