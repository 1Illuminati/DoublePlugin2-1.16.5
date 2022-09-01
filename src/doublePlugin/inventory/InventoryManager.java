package doublePlugin.inventory;

import java.util.HashMap;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import doublePlugin.entity.player.NewPlayer;

public abstract class InventoryManager {
    public final static HashMap<String, InventoryManager> inventoryMap = new HashMap<>();
    
    public static InventoryManager getInventoryEvent(InventoryView invView) {
        for(InventoryManager inventoryEvent : inventoryMap.values()) {
            if(inventoryEvent.checkInventory(invView)) {
                return inventoryEvent;
            }
        }

        return null;
    }
    
    public static InventoryManager getInventoryEvent(String code) {
    	return inventoryMap.get(code);
    }
    
    public InventoryManager() {
    	inventoryMap.put(getCode(), this);
    }
    
    public boolean checkInventory(InventoryView invView) {
    	return invView.getTitle().equals(getCode());
    }
    
    public abstract String getCode();
    
    public abstract Inventory getInv(NewPlayer player);

    public abstract void open(InventoryOpenEvent event);

    public abstract void click(InventoryClickEvent event);
    
    public abstract void close(InventoryCloseEvent event);
}
