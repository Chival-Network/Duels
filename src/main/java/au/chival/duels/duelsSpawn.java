package au.chival.duels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

    public class duelsSpawn extends JavaPlugin implements Listener {

        private HashMap<String, Location> playerSpawns = new HashMap<>();

        @Override
        public void onEnable() {
            Bukkit.getPluginManager().registerEvents(this, this);
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        @EventHandler
        public void onDeath(PlayerDeathEvent event) {
            Player player = event.getEntity();
            if (playerSpawns.containsKey(player.getName())) {
                player.teleport(playerSpawns.get(player.getName()));
                player.sendMessage(ChatColor.RED + "You have died in a duel!");
            }
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("setSpawn")) {
                    playerSpawns.put(player.getName(), player.getLocation());
                    player.sendMessage(ChatColor.GREEN + "Duels spawn point set.");
                    return true;
                }
            }
            player.sendMessage(ChatColor.RED + "Usage: /duels setSpawn");
            return false;
        }
    }
