package doublePlugin.util.map;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import doublePlugin.DoublePlugin;
import doublePlugin.file.Folder;
import doublePlugin.file.json.JsonReadWrite;
import doublePlugin.util.BukkitClassToStr;
import doublePlugin.util.CoolTime;


public class InfoMaps {
    private static final JsonReadWrite jsonReadWrite = new JsonReadWrite();
    private static final BukkitClassToStr bukkitClassToStr = new BukkitClassToStr();
    private static final Folder folder = new Folder();
    
    private NotNullStrMap<Integer> integerMap;
    private NotNullStrMap<Double> doubleMap;
    private NotNullStrMap<Long> longMap;
    private NotNullStrMap<String> stringMap;
    private NotNullStrMap<Boolean> booleanMap; 
    private NotNullStrMap<ItemStack> itemStackMap;
    private NotNullStrMap<Inventory> inventoryMap;
    private NotNullStrMap<Location> locationMap;
    private final String locationFolder;
    
    private final CoolTime coolTime;

    protected InfoMaps(String locationFolder) {
    	folder.folder(locationFolder);
    	this.locationFolder = locationFolder;
    	integerMap = getMap("integer", Integer.class);
    	doubleMap = getMap("double", Double.class);
    	longMap = getMap("long", Long.class);
    	stringMap = getMap("string", String.class);   	
    	booleanMap = getMap("boolean", Boolean.class);  	
    	itemStackMap = InfoMaps.bukkitClassToStr.bukkitObjInMap(getMap("itemStack", String.class), ItemStack.class);       	
    	inventoryMap = InfoMaps.bukkitClassToStr.bukkitObjInMap(getMap("inventory", String.class), Inventory.class);    
    	locationMap = InfoMaps.bukkitClassToStr.bukkitObjInMap(getMap("location", String.class), Location.class);
    	DoublePlugin.sendLog(locationFolder + "`s infoMaps load");

        this.integerMap.setNormalValue(0);
        this.doubleMap.setNormalValue(0.0);
        this.longMap.setNormalValue(0L);
        this.stringMap.setNormalValue("");
        this.booleanMap.setNormalValue(false);
        this.itemStackMap.setNormalValue(new ItemStack(Material.AIR));
        this.inventoryMap.setNormalValue(Bukkit.createInventory(null, 27));
        this.locationMap.setNormalValue(new Location(Bukkit.getWorld("world"), 0, 0, 0));
        this.coolTime = new CoolTime(this);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> NotNullStrMap<T> getMap(String folder, Class clazz) {
    	try {
    		return InfoMaps.jsonReadWrite.jsonRead(locationFolder + "/" + folder, clazz);
		} catch (IOException e) {
			DoublePlugin.sendLog(folder + " null");
			return new NotNullStrMap<T>();
		}
    }
    
    public CoolTime getCoolTime() {
		return this.coolTime;
	}

    public void saveInfoMaps() {
        try {
        	InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/integer", this.getIntegerMap());
        	InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/double", this.getDoubleMap());
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/long", this.getLongMap());
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/string", this.getStringMap());
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/boolean", this.getBooleanMap());
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/itemStack", InfoMaps.bukkitClassToStr.bukkitObjOutMap(this.getItemStackMap()));
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/inventory", InfoMaps.bukkitClassToStr.bukkitObjOutMap(this.getInventoryMap()));
            InfoMaps.jsonReadWrite.jsonWrite(locationFolder + "/location", InfoMaps.bukkitClassToStr.bukkitObjOutMap(this.getLocationMap()));
            DoublePlugin.sendLog(locationFolder + "`s infoMaps save");
		} catch (IOException e) {
			DoublePlugin.sendLog("§4" + e.getClass().getName() + " 발생");
		}
    }
    
    public String getFileLoc() {
    	return this.locationFolder;
    }
    
    public void copy(InfoMaps infoMaps) {
    	this.integerMap = infoMaps.integerMap;
    	this.booleanMap = infoMaps.booleanMap;
    	this.inventoryMap = infoMaps.inventoryMap;
    	this.locationMap = infoMaps.locationMap;
    	this.longMap = infoMaps.longMap;
    	this.itemStackMap = infoMaps.itemStackMap;
    	this.doubleMap = infoMaps.doubleMap;
    	this.stringMap = infoMaps.stringMap;
    }
    
    /**
     * integer
     */
    public NotNullStrMap<Integer> getIntegerMap() {
        return integerMap;
    }

    public int getIntegerValue(String key) {
        return integerMap.get(key);
    }

    public void setIntegerValue(String key, int value) {
        integerMap.put(key, value);
    }

    public void addIntegerValue(String key, int value) {
        integerMap.put(key, integerMap.get(key) + value);
    }

    public void removeIntegerValue(String key) {
        integerMap.remove(key);
    }

    public boolean containsIntegerValue(String key) {
        return integerMap.containsKey(key);
    }

    public Set<String> getIntegerKeys() {
        return integerMap.keySet();
    }

    public Collection<Integer> getIntegerValues() {
        return integerMap.values();
    }
    
    /**
     * double
     */
    public NotNullStrMap<Double> getDoubleMap() {
        return doubleMap;
    }

    public double getDoubleValue(String key) {
        return doubleMap.get(key);
    }

    public void setDoubleValue(String key, double value) {
        doubleMap.put(key, value);
    }

    public void addDoubleValue(String key, double value) {
        doubleMap.put(key, doubleMap.get(key) + value);
    }

    public void removeDoubleValue(String key) {
        doubleMap.remove(key);
    }

    public boolean containsDoubleValue(String key) {
        return doubleMap.containsKey(key);
    }

    public Set<String> getDoubleKeys() {
        return doubleMap.keySet();
    }

    public Collection<Double> getDoubleValues() {
        return doubleMap.values();
    }
    
    /**
     * long
     */
    public NotNullStrMap<Long> getLongMap() {
        return longMap;
    }

    public long getLongValue(String key) {
        return longMap.get(key);
    }

    public void setLongValue(String key, long value) {
        longMap.put(key, value);
    }

    public void addLongValue(String key, long value) {
        longMap.put(key, longMap.get(key) + value);
    }

    public void removeLongValue(String key) {
        longMap.remove(key);
    }

    public boolean containsLongValue(String key) {
        return longMap.containsKey(key);
    }

    public Set<String> getLongKeys() {
        return longMap.keySet();
    }

    public Collection<Long> getLongValues() {
        return longMap.values();
    }
    
    /**
     * string
     */
    public NotNullStrMap<String> getStringMap() {
        return stringMap;
    }

    public String getStringValue(String key) {
        return stringMap.get(key);
    }

    public void setStringValue(String key, String value) {
        stringMap.put(key, value);
    }

    public void addStringValue(String key, String value) {
        stringMap.put(key, stringMap.get(key) + value);
    }

    public void removeStringValue(String key) {
        stringMap.remove(key);
    }

    public boolean containsStringValue(String key) {
        return stringMap.containsKey(key);
    }

    public Set<String> getStringKeys() {
        return stringMap.keySet();
    }

    public Collection<String> getStringValues() {
        return stringMap.values();
    }
    
    /**
     * boolean
     */
    public NotNullStrMap<Boolean> getBooleanMap() {
        return booleanMap;
    }

    public boolean getBooleanValue(String key) {
        return booleanMap.get(key);
    }

    public void setBooleanValue(String key, boolean value) {
        booleanMap.put(key, value);
    }

    public void removeBooleanValue(String key) {
        booleanMap.remove(key);
    }

    public boolean containsBooleanValue(String key) {
        return booleanMap.containsKey(key);
    }

    public Set<String> getBooleanKeys() {
        return booleanMap.keySet();
    }

    public Collection<Boolean> getBooleanValues() {
        return booleanMap.values();
    }

    
    /**
     * itemStack
     */
    public NotNullStrMap<ItemStack> getItemStackMap() {
        return itemStackMap;
    }

    public ItemStack getItemStackValue(String key) {
        return itemStackMap.get(key);
    }

    public void setItemStackValue(String key, ItemStack value) {
        itemStackMap.put(key, value);
    }

    public void removeItemStackValue(String key) {
        itemStackMap.remove(key);
    }

    public boolean containsItemStackValue(String key) {
        return itemStackMap.containsKey(key);
    }

    public Set<String> getItemStackKeys() {
        return itemStackMap.keySet();
    }

    public Collection<ItemStack> getItemStackValues() {
        return itemStackMap.values();
    }
    
    /**
     * inventory
     */
    public NotNullStrMap<Inventory> getInventoryMap() {
        return inventoryMap;
    }
    
    public Inventory getInventoryValue(String key) {
        return inventoryMap.get(key);
    }

    public void setInventoryValue(String key, Inventory value) {
        inventoryMap.put(key, value);
    }

    public void removeInventoryValue(String key) {
        inventoryMap.remove(key);
    }

    public boolean containsInventoryValue(String key) {
        return inventoryMap.containsKey(key);
    }

    public Set<String> getInventoryKeys() {
        return inventoryMap.keySet();
    }

    public Collection<Inventory> getInventoryValues() {
        return inventoryMap.values();
    }
    
    /**
     * location
     */
    public NotNullStrMap<Location> getLocationMap() {
        return locationMap;
    }
    
    public Location getLocationValue(String key) {
        return locationMap.get(key);
    }

    public void setLocationValue(String key, Location value) {
        locationMap.put(key, value);
    }

    public void addLocationValue(String key, Location value) {
        locationMap.put(key, locationMap.get(key).add(value));
    }

    public void addLocationValue(String key, Vector vec) {
        locationMap.put(key, locationMap.get(key).add(vec));
    }

    public void removeLocationValue(String key) {
        locationMap.remove(key);
    }

    public boolean containsLocationValue(String key) {
        return locationMap.containsKey(key);
    }

    public Set<String> getLocationKeys() {
        return locationMap.keySet();
    }

    public Collection<Location> getLocationValues() {
        return locationMap.values();
    }
}
