package edu.unca.thaithco.TylerPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

/*
 * This is the main class of the sample plug-in
 */
public class TylerPlugin extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
    /*
     * This is called when your plug-in is enabled
     */
    @Override
    public void onEnable() {
        // save the configuration file
        saveDefaultConfig();
        
        // Create the SampleListener
        new TylerPluginListener(this);
        
        // set the command executor for sample
        this.getCommand("sample").setExecutor(new TylerPluginCommandExecutor(this));
        this.getCommand("jump").setExecutor(new TylerPluginCommandExecutor(this));
        this.getCommand("arrows").setExecutor(new TylerPluginCommandExecutor(this));
    }
    
    /*
     * This is called when your plug-in shuts down
     */
    @Override
    public void onDisable() {
        
    }

}
