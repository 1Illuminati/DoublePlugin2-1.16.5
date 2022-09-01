package doublePlugin.entity.player;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import doublePlugin.util.CoolTime;
import doublePlugin.util.map.InfoMaps;
import doublePlugin.util.map.NotNullStrMap;

public class PlayerInfoObject {
	PlayerInfoMaps playerInfoMaps;
	public PlayerInfoObject(UUID playerUUID) {
		this.playerInfoMaps = PlayerInfoMaps.getInfoMaps(playerUUID);
	}
	public void setCoolTimeSecond(String coolTimeName, double second) {
		playerInfoMaps.setCoolTimeSecond(coolTimeName, second);
	}
	public void setCoolTimeMinute(String coolTimeName, int minute) {
		playerInfoMaps.setCoolTimeMinute(coolTimeName, minute);
	}
	public void setCoolTimeHour(String coolTimeName, int hour) {
		playerInfoMaps.setCoolTimeHour(coolTimeName, hour);
	}
	public void setCoolTimeDay(String coolTimeName, int day) {
		playerInfoMaps.setCoolTimeDay(coolTimeName, day);
	}
	public void setCoolTimeMonth(String coolTimeName, int month) {
		playerInfoMaps.setCoolTimeMonth(coolTimeName, month);
	}
	public void setCoolTimeYear(String coolTimeName, int year) {
		playerInfoMaps.setCoolTimeYear(coolTimeName, year);
	}
	public double getLessCoolTime(String coolTimeName) {
		return playerInfoMaps.getLessCoolTime(coolTimeName);
	}
	public void removeCoolTime(String coolTimeName) {
		playerInfoMaps.removeCoolTime(coolTimeName);
	}
	public void reduceCoolTime(String coolTimeName, double reduceSecond) {
		playerInfoMaps.reduceCoolTime(coolTimeName, reduceSecond);
	}
	public boolean checkCoolTime(String coolTimeName) {
		return playerInfoMaps.checkCoolTime(coolTimeName);
	}
	public PlayerInfoMaps getPlayerInfoMaps() {
		return playerInfoMaps;
	}
	public CoolTime getCoolTime() {
		return playerInfoMaps.getCoolTime();
	}
	public void saveInfoMaps() {
		playerInfoMaps.saveInfoMaps();
	}
	public String getFileLoc() {
		return playerInfoMaps.getFileLoc();
	}
	public void copy(InfoMaps infoMaps) {
		playerInfoMaps.copy(infoMaps);
	}
	public NotNullStrMap<Integer> getIntegerMap() {
		return playerInfoMaps.getIntegerMap();
	}
	public int getIntegerValue(String key) {
		return playerInfoMaps.getIntegerValue(key);
	}
	public void setIntegerValue(String key, int value) {
		playerInfoMaps.setIntegerValue(key, value);
	}
	public void addIntegerValue(String key, int value) {
		playerInfoMaps.addIntegerValue(key, value);
	}
	public void removeIntegerValue(String key) {
		playerInfoMaps.removeIntegerValue(key);
	}
	public boolean containsIntegerValue(String key) {
		return playerInfoMaps.containsIntegerValue(key);
	}
	public Set<String> getIntegerKeys() {
		return playerInfoMaps.getIntegerKeys();
	}
	public Collection<Integer> getIntegerValues() {
		return playerInfoMaps.getIntegerValues();
	}
	public NotNullStrMap<Double> getDoubleMap() {
		return playerInfoMaps.getDoubleMap();
	}
	public double getDoubleValue(String key) {
		return playerInfoMaps.getDoubleValue(key);
	}
	public void setDoubleValue(String key, double value) {
		playerInfoMaps.setDoubleValue(key, value);
	}
	public void addDoubleValue(String key, double value) {
		playerInfoMaps.addDoubleValue(key, value);
	}
	public void removeDoubleValue(String key) {
		playerInfoMaps.removeDoubleValue(key);
	}
	public boolean containsDoubleValue(String key) {
		return playerInfoMaps.containsDoubleValue(key);
	}
	public Set<String> getDoubleKeys() {
		return playerInfoMaps.getDoubleKeys();
	}
	public Collection<Double> getDoubleValues() {
		return playerInfoMaps.getDoubleValues();
	}
	public NotNullStrMap<Long> getLongMap() {
		return playerInfoMaps.getLongMap();
	}
	public long getLongValue(String key) {
		return playerInfoMaps.getLongValue(key);
	}
	public void setLongValue(String key, long value) {
		playerInfoMaps.setLongValue(key, value);
	}
	public void addLongValue(String key, long value) {
		playerInfoMaps.addLongValue(key, value);
	}
	public void removeLongValue(String key) {
		playerInfoMaps.removeLongValue(key);
	}
	public boolean containsLongValue(String key) {
		return playerInfoMaps.containsLongValue(key);
	}
	public Set<String> getLongKeys() {
		return playerInfoMaps.getLongKeys();
	}
	public Collection<Long> getLongValues() {
		return playerInfoMaps.getLongValues();
	}
	public NotNullStrMap<String> getStringMap() {
		return playerInfoMaps.getStringMap();
	}
	public String getStringValue(String key) {
		return playerInfoMaps.getStringValue(key);
	}
	public void setStringValue(String key, String value) {
		playerInfoMaps.setStringValue(key, value);
	}
	public void addStringValue(String key, String value) {
		playerInfoMaps.addStringValue(key, value);
	}
	public void removeStringValue(String key) {
		playerInfoMaps.removeStringValue(key);
	}
	public boolean containsStringValue(String key) {
		return playerInfoMaps.containsStringValue(key);
	}
	public Set<String> getStringKeys() {
		return playerInfoMaps.getStringKeys();
	}
	public Collection<String> getStringValues() {
		return playerInfoMaps.getStringValues();
	}
	public NotNullStrMap<Boolean> getBooleanMap() {
		return playerInfoMaps.getBooleanMap();
	}
	public boolean getBooleanValue(String key) {
		return playerInfoMaps.getBooleanValue(key);
	}
	public void setBooleanValue(String key, boolean value) {
		playerInfoMaps.setBooleanValue(key, value);
	}
	public void removeBooleanValue(String key) {
		playerInfoMaps.removeBooleanValue(key);
	}
	public boolean containsBooleanValue(String key) {
		return playerInfoMaps.containsBooleanValue(key);
	}
	public Set<String> getBooleanKeys() {
		return playerInfoMaps.getBooleanKeys();
	}
	public Collection<Boolean> getBooleanValues() {
		return playerInfoMaps.getBooleanValues();
	}
	public NotNullStrMap<ItemStack> getItemStackMap() {
		return playerInfoMaps.getItemStackMap();
	}
	public ItemStack getItemStackValue(String key) {
		return playerInfoMaps.getItemStackValue(key);
	}
	public void setItemStackValue(String key, ItemStack value) {
		playerInfoMaps.setItemStackValue(key, value);
	}
	public void removeItemStackValue(String key) {
		playerInfoMaps.removeItemStackValue(key);
	}
	public boolean containsItemStackValue(String key) {
		return playerInfoMaps.containsItemStackValue(key);
	}
	public Set<String> getItemStackKeys() {
		return playerInfoMaps.getItemStackKeys();
	}
	public Collection<ItemStack> getItemStackValues() {
		return playerInfoMaps.getItemStackValues();
	}
	public NotNullStrMap<Inventory> getInventoryMap() {
		return playerInfoMaps.getInventoryMap();
	}
	public Inventory getInventoryValue(String key) {
		return playerInfoMaps.getInventoryValue(key);
	}
	public void setInventoryValue(String key, Inventory value) {
		playerInfoMaps.setInventoryValue(key, value);
	}
	public void removeInventoryValue(String key) {
		playerInfoMaps.removeInventoryValue(key);
	}
	public boolean containsInventoryValue(String key) {
		return playerInfoMaps.containsInventoryValue(key);
	}
	public Set<String> getInventoryKeys() {
		return playerInfoMaps.getInventoryKeys();
	}
	public Collection<Inventory> getInventoryValues() {
		return playerInfoMaps.getInventoryValues();
	}
	public NotNullStrMap<Location> getLocationMap() {
		return playerInfoMaps.getLocationMap();
	}
	public Location getLocationValue(String key) {
		return playerInfoMaps.getLocationValue(key);
	}
	public void setLocationValue(String key, Location value) {
		playerInfoMaps.setLocationValue(key, value);
	}
	public void addLocationValue(String key, Location value) {
		playerInfoMaps.addLocationValue(key, value);
	}
	public void addLocationValue(String key, Vector vec) {
		playerInfoMaps.addLocationValue(key, vec);
	}
	public void removeLocationValue(String key) {
		playerInfoMaps.removeLocationValue(key);
	}
	public boolean containsLocationValue(String key) {
		return playerInfoMaps.containsLocationValue(key);
	}
	public Set<String> getLocationKeys() {
		return playerInfoMaps.getLocationKeys();
	}
	public Collection<Location> getLocationValues() {
		return playerInfoMaps.getLocationValues();
	}
}
