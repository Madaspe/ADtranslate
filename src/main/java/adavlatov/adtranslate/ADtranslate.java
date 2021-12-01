package adavlatov.adtranslate;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class ADtranslate extends JavaPlugin implements Listener {

    char[] lettersArrayEng = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    char[] lettersArrayRus = new char[]{'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э', 'х', 'ъ', 'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю'};

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener) new TranslatePlayerCommands(),  this);
    }

    @Override
    public void onDisable() {
    }
}
