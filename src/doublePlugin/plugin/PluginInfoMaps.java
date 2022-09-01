package doublePlugin.plugin;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;

import doublePlugin.util.map.InfoMaps;

public class PluginInfoMaps extends InfoMaps {
	private static final String FOLDER_LOC = "info/plugin/";
	private static final HashMap<String, PluginInfoMaps> pluginInfoMaps = new HashMap<>();
	
	public static boolean containsPluginInfoMaps(Plugin plugin) {
		return pluginInfoMaps.containsKey(plugin.getName());
	}
	
	public static PluginInfoMaps getPluginInfoMaps(Plugin plugin) {
		if(!containsPluginInfoMaps(plugin)) {
			pluginInfoMaps.put(plugin.getName(), new PluginInfoMaps(plugin));
		}
		
		return pluginInfoMaps.get(plugin.getName());
	}
	
	public static void saveAllPluginInfoMaps() {
		for(PluginInfoMaps pluginInfoMaps : PluginInfoMaps.pluginInfoMaps.values()) {
			pluginInfoMaps.saveInfoMaps();
		}
	}
	
	private final Plugin plugin;
	private PluginInfoMaps(Plugin plugin) {
		super(FOLDER_LOC + plugin.getName());
		this.plugin = plugin;
	}
		
	public Plugin getPlugin() {
		return this.plugin;
	}
}
