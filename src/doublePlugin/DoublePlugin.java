package doublePlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import doublePlugin.command.CommandNameList;
import doublePlugin.command.MainCommand;
import doublePlugin.entity.player.NewOfflinePlayer;
import doublePlugin.event.MainEvent;
import doublePlugin.file.Folder;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.inventory.BanItemAddInv;
import doublePlugin.item.ban.inventory.BanItemInfoInv;
import doublePlugin.item.ban.inventory.BanItemMoreInfoInv;
import doublePlugin.item.startItem.StartItemInv;
import doublePlugin.plugin.PluginInfoMaps;
import doublePlugin.properties.PropertiesInv;
import doublePlugin.properties.ServerProperties;
import doublePlugin.scheduler.RunnableEx;
import doublePlugin.scheduler.Scheduler;
import doublePlugin.util.map.ServerInfoMaps;

public class DoublePlugin extends JavaPlugin {
	public static boolean reload;
	public static final String pluginName = "DoublePlugin-1.16.5";
	public static Plugin plugin;
	private static PluginInfoMaps doublePluginInfoMap;

	
	private void save() {
		try {
			BanItem.save();
			sendLog("Ban Item Save");
			NewOfflinePlayer.saveAllOfflinePlayer();
			sendLog("All Player Data Save");
			ServerInfoMaps.saveServerInfoMaps();
			sendLog("ServerInfo Save");
			PluginInfoMaps.saveAllPluginInfoMaps();
			sendLog("All PluginInfo Save");
			
			ServerProperties.saveProperties();
			sendLog("ServerProperties Save");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void invLoad() {
		new BanItemAddInv();
		new StartItemInv();
		new PropertiesInv();
		new BanItemInfoInv();
		new BanItemMoreInfoInv();
	}
	
	private void load() {
		plugin = Bukkit.getPluginManager().getPlugin(pluginName);
		sendLog("Plugin Load");
		registerCommand();
		sendLog("Command Load");
		registerEvent();
		sendLog("Event Load");
		new Folder().setDoublePluginFolder();
		sendLog("Folder Load");
		invLoad();
		sendLog("Inventory Load");
		

		try {
			ServerInfoMaps.loadServerInfoMaps();
			sendLog("ServerInfo Load");
			doublePluginInfoMap = PluginInfoMaps.getPluginInfoMaps(plugin);
			sendLog("DoublePluginInfo Load");
			ServerProperties.loadProperties();
			sendLog("ServerProperties Load");
			BanItem.load();
			sendLog("Ban Item Load");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		serverSchduler();
	}
	
	private void serverSchduler() {
		Scheduler.infiniteRepeatScheduler(new RunnableEx() {

			@Override
			public void function() {
				save();
				sendLog("§4-----------------------------");
				sendLog(""); 
				sendLog("");
				sendLog("§4" + pluginName + " 데이터 중간 저장 완료");
				sendLog("");
				sendLog("");
				sendLog("§4-----------------------------");
			}
			
		}, 24000, 24000);
	}
	
	@Override
	public void onEnable() {
		load();
		sendLog("§4-----------------------------");
		sendLog(""); 
		sendLog("");
		sendLog("§4" + pluginName + " 플러그인 적용완료");
		sendLog("");
		sendLog("");
		sendLog("§4-----------------------------");

		reload = false;
	}
	
	@Override
	public void onDisable() {
		reload  = true;
		save();
		sendLog("§4-----------------------------");
		sendLog("");
		sendLog("");
		sendLog("§4" + pluginName + " 플러그인 적용해제");
		sendLog("");
		sendLog("");
		sendLog("§4-----------------------------");
	}
	
	public void registerEvent() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new MainEvent(), this);
	}
	
	public void setCommand(String commandName, MainCommand command) {
		this.getCommand(commandName).setExecutor(command);
	}
	public void registerCommand() {
		this.setCommand(CommandNameList.CHECK, new MainCommand());
		this.setCommand(CommandNameList.MODIFY, new MainCommand());
		this.setCommand(CommandNameList.SKULL, new MainCommand());
		this.setCommand(CommandNameList.PROPERTIES, new MainCommand());
		this.setCommand(CommandNameList.START_ITEM, new MainCommand());
		this.setCommand(CommandNameList.TEST, new MainCommand());
	}

	public static PluginInfoMaps getDoublePluginInfoMap() {
		return DoublePlugin.doublePluginInfoMap;
	}

	public static void sendLog(String log) {
		Bukkit.getConsoleSender().sendMessage("[" + DoublePlugin.pluginName + "] " + log);
	}
}
