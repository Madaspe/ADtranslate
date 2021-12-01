package adavlatov.adtranslate;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static adavlatov.adtranslate.TranslatingLetters.toTranslit;

public class TranslatePlayerCommands extends ADtranslate implements Listener {

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

                    } else {

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

                    } else {

                        player.sendMessage("Что-то пошло не так при отправке команды");

                    }
                }
            }
        }
    }
}
