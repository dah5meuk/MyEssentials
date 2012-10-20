package com.dah5.myessentials;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyEssentials extends JavaPlugin {

	@Override
    public void onEnable(){
		getLogger().info("Plugin has been enabled!");
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("Plugin has been disabled!");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("myessentials")){
    		sender.sendMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": Made by DAH5 for CraftBukkit 1.3.2 R2.0.");
    		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("stephehm93")){
    		sender.sendMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": StephEhm93 is the girlfriend of DAH5.");
    		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("saw")){
    		//Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "save-all");
    		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": Saving worlds, expect lag...");
    		List<World> worlds = this.getServer().getWorlds();
        	for (World world : worlds) {
        		world.save();
        		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": Saving world \"" + world.getName() + "\"");
        	}
        	Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": All worlds saved.");
    		return true;
    	}
    	return false; 
    }
    
    public void onPlayerJoin(PlayerJoinEvent event) {
    	event.setJoinMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": is installed on this server.");
    	event.setJoinMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": Type " + ChatColor.GOLD + "/help myessentials" + ChatColor.WHITE + " for commands.");
    }
    
    public void onPlayerQuit(PlayerQuitEvent event) {
    	event.setQuitMessage(ChatColor.GOLD + "[My Essentials]" + ChatColor.WHITE + ": " + event.getPlayer().getDisplayName() + " has now left the server.");
    }
	
}
