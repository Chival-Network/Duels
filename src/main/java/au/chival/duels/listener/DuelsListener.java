package au.chival.duels.listener;
    import org.bukkit.Bukkit;
    import org.bukkit.entity.Player;
    import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

    public class DuelsListener implements Listener {

        @EventHandler
        public void onPlayerDeath(PlayerDeathEvent event) {
            Player winner = event.getEntity().getKiller();
            Player loser = event.getEntity();
            DuelsMinigame plugin = (DuelsMinigame) Bukkit.getServer().getPluginManager().getPlugin("DuelsMinigame");
            if (winner != null) {
                plugin.endDuel(winner, loser);
            }
        }
    }
