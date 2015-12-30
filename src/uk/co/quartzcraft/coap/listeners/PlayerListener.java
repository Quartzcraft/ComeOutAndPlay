package uk.co.quartzcraft.coap.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.quartzcraft.coap.COAP;
import uk.co.quartzcraft.coap.data.CPlayer;
import uk.co.quartzcraft.core.util.Util;

import java.util.UUID;

public class PlayerListener implements Listener {

    private COAP plugin;

    public PlayerListener(COAP pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
        this.plugin = pl;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoinLow(PlayerJoinEvent join) {
        Player player = join.getPlayer();
        CPlayer cPlayer = new CPlayer(player);
        UUID UUID = player.getUniqueId();
    }
}
