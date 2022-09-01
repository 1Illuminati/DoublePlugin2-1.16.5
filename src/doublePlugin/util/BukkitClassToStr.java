package doublePlugin.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import doublePlugin.util.map.NotNullStrMap;

public class BukkitClassToStr {
	private static final String SERIALIZER_STR = "§§§§§§";

	public <T> NotNullStrMap<T> bukkitObjInMap(NotNullStrMap<String> map, Class<T> clazz) {
		NotNullStrMap<T> result = new NotNullStrMap<>();
		for (String key : map.keySet()) {
			result.put(key, bukkitObjIn(map.get(key), clazz));
		}
		return result;
	}

	public <T> NotNullStrMap<String> bukkitObjOutMap(NotNullStrMap<T> map) {
		NotNullStrMap<String> result = new NotNullStrMap<>();
		for (String key : map.keySet()) {
			result.put(key, bukkitObjOut(map.get(key)));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T bukkitObjIn(String byteBukkitStr, Class<T> clazz) {
		T result = null;
		if(clazz == Inventory.class) {
			result = (T) this.stringToInventory(byteBukkitStr);
		} else {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(byteBukkitStr));
			try {
				BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
				result = (T) dataInput.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public <T> String bukkitObjOut(Object bukkitClass) {
		if(bukkitClass.getClass() == Inventory.class) {
			return inventoryToString((Inventory) bukkitClass);
		}

		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
			dataOutput.writeObject(bukkitClass);
			dataOutput.close();
			return Base64Coder.encodeLines(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String inventoryToString(Inventory inventory) {
		StringBuilder result = new StringBuilder(inventory.getType().name()).append(SERIALIZER_STR).append(inventory.getSize());
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack is = inventory.getItem(i);
            String itemStackStr = bukkitObjOut(is);
            result.append(SERIALIZER_STR).append(itemStackStr);
        }
        
        return result.toString();
	}
	
    public Inventory stringToInventory (String invString) {
        String[] serializedBlocks = invString.split(SERIALIZER_STR);
        InventoryType invType = InventoryType.valueOf(serializedBlocks[0]);
        int invSize = Integer.valueOf(serializedBlocks[1]);
        Inventory deserializedInventory;
        
        switch(invType) {
        case CHEST : 
        	deserializedInventory = Bukkit.createInventory(null, invSize);
        break;
        default :
        	deserializedInventory = Bukkit.getServer().createInventory(null, invType);
        }
       
        for (int i = 2; i < serializedBlocks.length; i++) {
            deserializedInventory.setItem(i - 2, bukkitObjIn(invString, ItemStack.class));
        }
       
        return deserializedInventory;
    }
}
