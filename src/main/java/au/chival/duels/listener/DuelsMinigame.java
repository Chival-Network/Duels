package au.chival.duels.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DuelsMinigame extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new DuelsListener(), this);
    }

    public void startDuels(Player player1, Player player2) {
        // Teleport players to the duels arena
        player1.teleport(getDuelsArenaLocation());
        player2.teleport(getDuelsArenaLocation());

        // Start the duels countdown
        new BukkitRunnable() {
            int count = 5;
            public void run() {
                if (count == 0) {
                    // Begin the duels
                    player1.sendMessage("Fight!");
                    player2.sendMessage("Fight!");
                    cancel();
                } else {
                    player1.sendMessage("The duels begin in " + count + " seconds.");
                    player2.sendMessage("The duels begin in " + count + " seconds.");
                }
                count--;
            }
        }.runTaskTimer(this, 20, 20);
    }

    private Location getDuelsArenaLocation() {
        // Get the duels arena location from the plugin's configuration
        // (not shown in this example)
        return null;
    }


        public void endDuel(Player winner, Player loser) {
            // Code to end a duel and declare a winner
        }
    }