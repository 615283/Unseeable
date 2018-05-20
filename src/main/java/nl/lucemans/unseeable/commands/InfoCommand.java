package nl.lucemans.unseeable.commands;

import nl.lucemans.unseeable.Unseeable;
import nl.lucemans.unseeable.system.Map;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 20/05/2018
 * See https://lucemans.nl
 */
public class InfoCommand implements BaseCommand {

    // /usa info <mapName>
    public void execute(Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage("Please use /usa info <mapName>");
            return;
        }

        String mapName = args[1];
        Map m = Unseeable.instance.findMap(mapName);
        if (m == null) {
            p.sendMessage("Map could not be found. Do /us list");
            return;
        }

        p.sendMessage("------MapStatus------");
        p.sendMessage("Name: " + m.name);
        p.sendMessage("Min Players: " + m.minPlayers);
        p.sendMessage("Max Players: " + m.maxPlayers);
        p.sendMessage("Spawnpoints: " + (m.spawnPoints.size() < 2 ? ChatColor.RED : ChatColor.GREEN) + m.spawnPoints.size());
        p.sendMessage("IsSetup: " + (m.isSetup() ? "Yes" : "No"));
    }
}
