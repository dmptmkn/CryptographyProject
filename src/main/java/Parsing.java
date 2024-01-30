import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parsing {

    @SneakyThrows
    public void parse() {
        Util.writeMessage("Введите путь к файлу зашифрованному файлу");
        String src = Util.readString();

        while (true) {
            Util.writeMessage("Введите путь к файлу для сбора статистики");
            String statSrc = Util.readString();

            Path dest = Util.buildFileName(src, "_parsing");

            List<Map.Entry<Character, Integer>> srcList = getDecryptKeyMap(new HashMap<>(), src);
            List<Map.Entry<Character, Integer>> statList = getDecryptKeyMap(new HashMap<>(), statSrc);

            Map<Character, Character> decryptedCharMap = new HashMap<>();

            if (srcList.size() <= statList.size()) {
                for (int i = 0; i < srcList.size(); i++) {
                    decryptedCharMap.put(srcList.get(i).getKey(), statList.get(i).getKey());
                }

                try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
                     BufferedWriter writer = Files.newBufferedWriter(dest)) {
                    while (reader.ready()) {
                        Character nextChar = (char) reader.read();
                        writer.write(decryptedCharMap.get(nextChar));
                    }
                }
                Util.writeMessage("Файл расшифрован!");
                break;
            } else {
                Util.writeMessage("Предоставьте, пожалуйста, другой файл для набора статистики!");
            }
        }

    }

    @SneakyThrows
    private List<Map.Entry<Character, Integer>> getDecryptKeyMap(Map<Character, Integer> map, String path) {
        for (char aChar : Files.readString(Path.of(path)).toCharArray()) {
            map.merge(aChar, 1, Integer::sum);
        }

        return map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toList();
    }
}
