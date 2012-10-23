package edu.unca.thaithco.TylerPlugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class TylerPluginCommandExecutor implements CommandExecutor {
    private final TylerPlugin plugin;

    /*
     * This command executor needs to know about its plugin from which it came from
     */
    public TylerPluginCommandExecutor(TylerPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (command.getName().equalsIgnoreCase("sample") && sender.hasPermission("sample.message") && args.length > 0) {
    		Player p = (Player) sender;
    		p.sendMessage("setting message");
            this.plugin.getConfig().set("sample.message", Joiner.on(' ').join(args));
            return true;
        }
        else if (command.getName().equalsIgnoreCase("jump") && sender.hasPermission("jump") && args.length > 0){
        	Player p = (Player) sender;
        	p.sendMessage("inside jump else if command\nJump force: " + args[0]);
        	p.setVelocity(new Vector(0,Double.parseDouble(args[0])/10, 0));
        	plugin.getLogger().info(sender.getName() + " jumped with a force of " + args[0]);
        	return true;
        }
        else if (command.getName().equalsIgnoreCase("arrows") && sender.hasPermission("arrows") && args.length > 0){
        	int force;
        	float arg3,
        	      arg4;
        	Player p = (Player) sender;
        	p.sendMessage("Inside arrows else if");
        	if(args.length == 1){
        		force = 10;
        		arg3 = 1;
        		arg4 = 1;
        	}
        	else{
        		force = Integer.parseInt(args[1])/10;
        		if(args.length > 2) {
        			arg3 = Float.parseFloat(args[2]);
        			arg4 = Float.parseFloat(args[3]);
        		}
        		else {
        		arg3 = 1;
        		arg4 = 1;
        		}
        	}
        	double threshold1, threshold2, threshold3;
        	for(int i = 0; i < Integer.parseInt(args[0]); i++){
        		 threshold1 = force * (new Random().nextDouble());
        		 threshold2 = force * (new Random().nextDouble());
        		 threshold3 = force * (new Random().nextDouble());
        		 p.getWorld().spawnArrow(p.getLocation(), new Vector(-threshold1, -threshold2, -threshold3), arg3, arg4);
        	}
        	p.getInventory().addItem(new ItemStack(Material.APPLE, 1));
        	return true;
        }
        else {
        	Player p = (Player) sender;
        	p.sendMessage("could not activate a command");
            return false;
        }
    }

}
