package edu.unca.thaithco.TylerPlugin;

import java.text.MessageFormat;

import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * This is a sample event listener
 */
public class TylerPluginListener implements Listener {
    private final TylerPlugin plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public TylerPluginListener(TylerPlugin plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final EntityType entityType = event.getRightClicked().getType();

        event.getPlayer().sendMessage(MessageFormat.format(
                "You interacted with a {0} it has an id of {1}",
                entityType.getName(),
                entityType.getTypeId()));
    }
    
    
    /*
     * Causes lightning to strike an entity when right clicked
     */
    @EventHandler
    public void killWithLightning(PlayerInteractEntityEvent event){
    	final Creature entity = (Creature) event.getRightClicked();
    	
    		entity.getLocation().getWorld().strikeLightning(entity.getLocation());
    		entity.getLocation().getWorld().strikeLightningEffect(entity.getLocation());
    		plugin.getLogger().info("A " + entity.getType().getName() + " is getting killed by lightning!");
    		
    }
    
}
