package uk.co.quartzcraft.coap.listeners;

import org.bukkit.event.Listener;
import uk.co.quartzcraft.coap.COAP;
public class PlayerListener implements Listener {

    private COAP plugin;

    public PlayerListener(COAP pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
        this.plugin = pl;
    }
}
