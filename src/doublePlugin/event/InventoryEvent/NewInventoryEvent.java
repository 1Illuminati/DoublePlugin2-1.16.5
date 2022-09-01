package doublePlugin.event.InventoryEvent;

import org.bukkit.Material;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import doublePlugin.DoublePlugin;
import doublePlugin.inventory.InventoryManager;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo.BanItemInfoEnum;
import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;

public class NewInventoryEvent {
	
    public void newInventoryClickEvent(InventoryClickEvent event) {
    	InventoryManager inventoryAdmin = InventoryManager.getInventoryEvent(event.getView());
    	boolean check = this.checkBanItem(event.getCurrentItem(), inventoryAdmin);
    	
    	if(check) {
    		event.setCancelled(true);
    		return;
    	}
    	
        if(inventoryAdmin != null){
            inventoryAdmin.click(event);
        }
    }

    public void newInventoryCloseEvent(InventoryCloseEvent event) {
    	InventoryView invView = event.getView();
        InventoryManager inventoryAdmin = InventoryManager.getInventoryEvent(invView);
        if(inventoryAdmin != null){
            inventoryAdmin.close(event);
        }
    }

    public void newInventoryOpenEvent(InventoryOpenEvent event) {
    	
    	if(!ServerProperties.get(PropertiesEnum.ENCHANT)) {
        	InventoryType invType = event.getInventory().getType();
        	if(invType == InventoryType.ANVIL || invType == InventoryType.ENCHANTING) {
        		event.setCancelled(true);
        		return;
        	}
        }
    	
        InventoryManager inventoryAdmin = InventoryManager.getInventoryEvent(event.getView()); 
        if(inventoryAdmin != null){
            inventoryAdmin.open(event);
        }
    }  
    
    public void newCraftItemEvent(CraftItemEvent event) {
    	Material material = event.getCurrentItem().getType();
		if(BanItem.checkBanItem(material)) {
			boolean check = BanItem.getBanitemInfo(material).getAllow(BanItemInfoEnum.CRAFT);
			
	    	if(check) {
	    		event.setCancelled(true);
	    		return;
	    	}
    	}
    }
    
    private boolean checkBanItem(ItemStack itemStack, InventoryManager... inventoryAdmins) {
    	if(itemStack == null) {
    		return false;
    	}
    	
    	for(InventoryManager inventoryAdmin : inventoryAdmins) {
    		if(inventoryAdmin != null) {
    			if(inventoryAdmin.getCode().startsWith(DoublePlugin.pluginName)) {
    				return false;
    			}
    		}
    	}
    	Material material = itemStack.getType();
		if(BanItem.checkBanItem(material)) {
			return BanItem.getBanitemInfo(material).getAllow(BanItemInfoEnum.INV);
		}
		return false;
    }
}
