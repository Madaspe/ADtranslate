package adavlatov.adtranslate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class ADtranslate extends JavaPlugin implements Listener {

    char[] lettersArrayEng = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    char[] lettersArrayRus = new char[]{'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э', 'х', 'ъ', 'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю'};

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

    }

    //перехватывает команду, меняет и выполняет от лица игрока
    //для команд начинающихся с "/"
    @EventHandler
    public void translateWithSlash(PlayerCommandPreprocessEvent preprocessEvent) {

        Player player = preprocessEvent.getPlayer();
        String message = preprocessEvent.getMessage();

        if (message.startsWith("/")) {

            for (int i = 0; i < lettersArrayEng.length; i++) {

                if (lettersArrayEng[i] == message.charAt(1)) {

                    player.performCommand(message.replaceAll("[/._]", ""));
                    preprocessEvent.setCancelled(true);
                    break;

                }
            }
            for (int i = 0; i < lettersArrayRus.length; i++) {

                if (lettersArrayRus[i] == message.charAt(1)) {

                    String[] messageParts = message.split(" ");

                    if (messageParts.length >= 2) {
                        String afterall = "";
                        for (int x = 2; x < messageParts.length; x++) {

                            afterall += messageParts[x] + " ";

                        }

                        String finalMessage = toTranslit(messageParts[0] + " " + messageParts[1]) + " " + afterall;

                        System.out.println(finalMessage.replaceAll("[/._]", ""));
                        player.performCommand(finalMessage.replaceAll("[/._]", ""));
                        preprocessEvent.setCancelled(true);
                        break;

                    }

                    if (messageParts.length <= 2) {

                        player.performCommand(toTranslit(message).replaceAll("[/._]", ""));
                        preprocessEvent.setCancelled(true);
                        break;

                    }

                    else {

                        player.sendMessage("Что-то пошло не так при отправке команды");

                    }
                }
            }
        }
    }








    //перехватывает команду, меняет и выполняет от лица игрока
    //для команд начинающихся с "."
   @EventHandler
    public void onMessageWithDot(AsyncPlayerChatEvent asyncEvent) {

        Player player = asyncEvent.getPlayer();
        String message = asyncEvent.getMessage();


        if (message.startsWith(".")) {

            for (int i = 0; i < lettersArrayEng.length; i++) {

                if (lettersArrayEng[i] == message.charAt(1)) {

                    player.performCommand(message.replaceAll("[/._]", ""));
                    asyncEvent.setCancelled(true);
                    break;

                }
            }
            for (int i = 0; i < lettersArrayRus.length; i++) {

                if (lettersArrayRus[i] == message.charAt(1)) {

                    String[] messageParts = message.split(" ");

                    if (messageParts.length >= 2) {
                        String afterall = "";
                        for (int x = 2; x < messageParts.length; x++) {

                            afterall += messageParts[x] + " ";

                        }

                        String finalMessage = toTranslit(messageParts[0] + " " + messageParts[1]) + " " + afterall;

                        System.out.println(finalMessage.replaceAll("[/._]", ""));
                        player.performCommand(finalMessage.replaceAll("[/._]", ""));
                        asyncEvent.setCancelled(true);
                        break;

                    }

                    if (messageParts.length <= 2) {

                        player.performCommand(toTranslit(message).replaceAll("[/._]", ""));
                        asyncEvent.setCancelled(true);
                        break;

                    }

                    else {

                        player.sendMessage("Что-то пошло не так при отправке команды");

                    }
                }
            }
        }
    }





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

        for (int i = 0; i<text.length(); i++) {
            String l = text.substring(i, i+1);

            if (letters.containsKey(l)) {
                sb.append(letters.get(l));
            }
            else {
                sb.append(l);
            }

        }

        return sb.toString();

    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
