import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Util {

    private static final String EXCEPTION_MESSAGE = "Ошибка ввода! Попробуйте еще раз!";
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private Util() {}

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string;
        try {
            string = CONSOLE.readLine();
        } catch (IOException e) {
            writeMessage(EXCEPTION_MESSAGE);
            string = readString();
        }
        return string;
    }

    public static int readInt() {
        System.out.println();

        int number;
        try {
            number = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage(EXCEPTION_MESSAGE);
            number = readInt();
        }
        return number;
    }
}



/*
написать метод который добавляет суффикс к файлу предоставленному пользователем
суффикс каждый раз разный и добавляет
 */