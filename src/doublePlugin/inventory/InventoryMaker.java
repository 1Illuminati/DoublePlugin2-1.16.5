package doublePlugin.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryMaker {
	private Inventory inventory;
    
    public InventoryMaker(InventoryType invType, String invName) {
        this(invType, null, invName, null);
    }
    
    public InventoryMaker(int size, String invName) {
        this(size, null, invName, null);
    }
    
    public InventoryMaker(InventoryType invType, String invName, ItemStack filledItem) {
        this(invType, null, invName, filledItem);
    }
    
    public InventoryMaker(int size, String invName, ItemStack filledItem) {
        this(size, null, invName, filledItem);
    }
    
    public InventoryMaker(int size, InventoryHolder inventoryHolder, String invName, ItemStack filledItem) {
        this.inventory = Bukkit.createInventory(inventoryHolder, size, invName);
        filledItem(filledItem);
    }
    
    public InventoryMaker(InventoryType invType, InventoryHolder inventoryHolder, String invName, ItemStack filledItem) {
        this.inventory = Bukkit.createInventory(inventoryHolder, invType, invName);
        filledItem(filledItem);
    }
    
    private void filledItem(ItemStack filledItem) {
    	if(filledItem != null) {
	        for(int index = 0; index < this.inventory.getSize(); index++) {
	            this.inventory.setItem(index, filledItem);
	        }
    	}
    }
    
    public Inventory getInv() {
    	return this.inventory;
    }
    
    public void setItem(int slot, ItemStack itemStack) {
    	this.getInv().setItem(slot, itemStack);
    }
    
    public void addItem(ItemStack... itemStacks) {
    	this.getInv().addItem(itemStacks);
    }
    
}
