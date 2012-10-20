package com.dah5.bukkit.plugin.myessentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MyEssentials extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("Plugin enabled!");
	}
	 
	public void onDisable() { 
		getLogger().info("Plugin disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kick")) {
			if(sender.hasPermission("myessentials.kick")){
				if(args[0] != "") {
					if(sender.getServer().getPlayer(args[0]).isOnline()) {
						if(sender.getServer().getPlayer(args[0]).hasPermission("myessentials.kick.exempt")) {
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + "You cannot kick " + args[0] + " from the server.");
						} else {
							sender.getServer().getPlayer(args[0]).kickPlayer("You were kicked by " + sender.getName());
							sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " kicked " + args[0] + " from the server.");
						}
					} else {
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + args[0] + " is not online.");
					}
				} else {
					sender.getServer().getPlayer(sender.getName()).kickPlayer("You kicked yourself from the server.");
					sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " kicked himself from the server.");
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Esseitnals] " + ChatColor.RED + "You don't have permission to use that command.");
				return false;
			}
		} else if(cmd.getName().equalsIgnoreCase("ban")) {
			if(sender.hasPermission("myessentials.ban")){
				if(args[0] != "") {
					if(sender.getServer().getPlayer(args[0]).isOnline()) {
						if(sender.getServer().getPlayer(args[0]).hasPermission("myessentials.ban.exempt")) {
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + "You cannot ban " + args[0] + " from the server.");
						} else {
							sender.getServer().getPlayer(args[0]).setBanned(true);
							sender.getServer().getPlayer(args[0]).kickPlayer(sender.getName() + " chose to ban you from this server.");
							sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " banned " + args[0] + " from the server.");
						}
					} else {
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + args[0] + " is not online.");
					}
				} else {
					sender.getServer().getPlayer(sender.getName()).setBanned(true);
					sender.getServer().getPlayer(sender.getName()).kickPlayer("You banned yourself from the server.");
					sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " banned himself from the server.");
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Esseitnals] " + ChatColor.RED + "You don't have permission to use that command.");
				return false;
			}
		} else if(cmd.getName().equalsIgnoreCase("banip")) {
			if(sender.hasPermission("myessentials.banip")){
				if(args[0] != "") {
					if(sender.getServer().getPlayer(args[0]).isOnline()) {
						if(sender.getServer().getPlayer(args[0]).hasPermission("myessentials.banip.exempt")) {
							sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + "You cannot ban that user's IP address.");
						} else {
							sender.getServer().getPlayer(args[0]).setBanned(true);
							sender.getServer().banIP(sender.getServer().getPlayer(args[0]).getAddress().getHostName());
							sender.getServer().getPlayer(args[0]).kickPlayer("Your IP address has been banned from the server.");
							sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " banned " + args[0] + "'s IP address from the server.");
						}
					} else {
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + ChatColor.RED + args[0] + " is not online.");
					}
				} else {
					sender.getServer().getPlayer(sender.getName()).setBanned(true);
					sender.getServer().banIP(sender.getServer().getPlayer(sender.getName()).getAddress().getHostName());
					sender.getServer().getPlayer(sender.getName()).kickPlayer("You banned your own IP address from the server.");
					sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[My Essentials] " + sender.getName() + " banned his own IP address from the server.");
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Esseitnals] " + ChatColor.RED + "You don't have permission to use that command.");
				return false;
			}
		} else if(cmd.getName().equalsIgnoreCase("myessentials")) {
			if(sender.hasPermission("myessentials.myessentials")){
				sender.getServer().getPluginManager().getPlugin("MyEssentials").reloadConfig();
				sender.sendMessage(ChatColor.DARK_PURPLE + "[My Essentials] Plugin reloaded.");
				return true;
			} else {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Esseitnals] " + ChatColor.RED + "You don't have permission to use that command.");
				return false;
			}
		} else if(cmd.getName().equalsIgnoreCase("pluginlist")) {
			if(sender.hasPermission("myessentials.pluginlist")){
				String pluginList = "Plugin List: ";
				for(Plugin plugin : sender.getServer().getPluginManager().getPlugins()){
					if(plugin.isEnabled()) {
						pluginList += ChatColor.GREEN + plugin.getName() + ChatColor.WHITE + ", ";
					} else {
						pluginList += ChatColor.RED + plugin.getName() + ChatColor.WHITE + ", ";
					}
				}
				sender.sendMessage(ChatColor.WHITE + pluginList + " (" + sender.getServer().getPluginManager().getPlugins().length + " plugins)");
				return true;
			} else {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "[My Esseitnals] " + ChatColor.RED + "You don't have permission to use that command.");
				return false;
			}
		} else {
			return false;
		}
	}
	
}
