package doublePlugin.world;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import doublePlugin.DoublePlugin;
import doublePlugin.file.FileHelper;

public class WorldHelper {
	private static final ArrayList<String> ingnoreList = new ArrayList<>(Arrays.asList("uid.dat", "session.lock"));
	private World world;
	
	public static WorldHelper createWorld(String worldName) {
		return new WorldHelper(new WorldCreator(worldName).createWorld());
	}
	
	public WorldHelper(String worldName) {
		this.world = Bukkit.getWorld(worldName);
	}
	
	public WorldHelper(World world) {
		this.world = world;
	}
	
	public void deleteWorld() {
		File file = world.getWorldFolder();
        Bukkit.getServer().unloadWorld(world, false);
        new FileHelper(file).fileDelete();
        DoublePlugin.sendLog(world.getName() + " World File is Delete");
	}
	
	public boolean unloadWorld(boolean save) {
		DoublePlugin.sendLog(world.getName() + " World File is Unload");
        return world!=null && Bukkit.getServer().unloadWorld(world, save);
	}
	
	public void copyWorld(String newWorldName) {
        new FileHelper(world.getWorldFolder()).copyFile(new File(Bukkit.getWorldContainer(), newWorldName), ingnoreList);
        new WorldCreator(newWorldName).createWorld();
        DoublePlugin.sendLog(world.getName() + " World is Copy to " + newWorldName);
	}
}
