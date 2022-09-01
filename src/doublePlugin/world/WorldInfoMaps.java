package doublePlugin.world;

import java.util.HashMap;

import org.bukkit.World;

import doublePlugin.util.map.InfoMaps;

public class WorldInfoMaps extends InfoMaps {
	private static final String FILE_LOC = "info/world/";
	private static String IS_SAVE = "isSave";
	private static final HashMap<String, WorldInfoMaps> worldInfoMaps = new HashMap<>();
	
	public static boolean containsWorldInfoMaps(World world) {
		return worldInfoMaps.containsKey(world.getName());
	}
	
	public static WorldInfoMaps getWorldInfoMaps(World world) {
		if(!containsWorldInfoMaps(world)) {
			worldInfoMaps.put(world.getName(), new WorldInfoMaps(world));
		}
		
		return worldInfoMaps.get(world.getName());
	}
	
	public static void saveAllWorldInfoMaps() {
		for(WorldInfoMaps worldInfoMaps : worldInfoMaps.values()) {
			worldInfoMaps.saveInfoMaps();
		}
	}
	
	private final World world;
	private WorldInfoMaps(World world) {
		super(FILE_LOC + world.getName());
		this.world = world;
		super.setBooleanValue(IS_SAVE, true);
	}
	
	public World getWorld() {
		return this.world;
	}
	
	public void remove() {
		worldInfoMaps.remove(this.world.getName());
	}
	
	public boolean getIsSave() {
		return super.getBooleanValue(IS_SAVE);
	}
	
	public void setIsSave(boolean value) {
		super.setBooleanValue(IS_SAVE, value);
	}
}
