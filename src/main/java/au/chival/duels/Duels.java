package au.chival.duels;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Duels extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("Duels minigame plugin has been enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("duel")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can initiate duels.");
                return false;
            }

            Player player = (Player) sender;
            if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "Usage: /duel <player>");
                return false;
            }

            Player opponent = Bukkit.getServer().getPlayer(args[0]);
            if (opponent == null) {
                player.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
                return false;
            }

            player.sendMessage(ChatColor.GOLD + "You have challenged " + opponent.getName() + " to a duel!");
            opponent.sendMessage(ChatColor.GOLD + player.getName() + " has challenged you to a duel!");

            // Perform duels logic here, such as teleporting players to a duel arena, etc.

            return true;
        }

        return false;
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info("Duels minigame plugin has been disabled.");
    }
}
