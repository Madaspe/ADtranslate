package adavlatov.adtranslate;

import java.util.HashMap;
import java.util.Map;

public class TranslatingLetters {

    //значения для перевода
    private static final Map<String, String> letters = new HashMap<String, String>();

    static {

        letters.put("А", "F");
        letters.put("В", "D");
        letters.put("Г", "U");
        letters.put("Д", "L");
        letters.put("Е", "T");
        letters.put("З", "P");
        letters.put("И", "N");
        letters.put("Й", "Q");
        letters.put("К", "R");
        letters.put("Л", "K");
        letters.put("М", "V");
        letters.put("Н", "Y");
        letters.put("О", "J");
        letters.put("П", "G");
        letters.put("Р", "H");
        letters.put("С", "C");
        letters.put("Т", "N");
        letters.put("У", "E");
        letters.put("Ф", "A");
        letters.put("Ц", "W");
        letters.put("Ч", "X");
        letters.put("Ш", "I");
        letters.put("Щ", "O");
        letters.put("Ы", "S");
        letters.put("Ю", ".");
        letters.put("Я", "Z");
        letters.put("а", "f");
        letters.put(".", "/");
        letters.put("в", "d");
        letters.put("г", "u");
        letters.put("д", "l");
        letters.put("е", "t");
        letters.put("з", "p");
        letters.put("и", "b");
        letters.put("й", "q");
        letters.put("к", "r");
        letters.put("л", "k");
        letters.put("м", "v");
        letters.put("н", "y");
        letters.put("о", "j");
        letters.put("п", "g");
        letters.put("р", "h");
        letters.put("с", "c");
        letters.put("т", "n");
        letters.put("у", "e");
        letters.put("ф", "a");
        letters.put("ц", "w");
        letters.put("ч", "x");
        letters.put("ш", "i");
        letters.put("щ", "o");
        letters.put("ы", "s");
        letters.put("я", "z");
        letters.put("Ж", ":");
        letters.put("ю", ".");
        letters.put("ь", "m");
    }

    //перевод текста
    public static String toTranslit(String text) {

        StringBuilder sb = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            String l = text.substring(i, i + 1);

            if (letters.containsKey(l)) {
                sb.append(letters.get(l));
            } else {
                sb.append(l);
            }

        }

        return sb.toString();

    }
}
