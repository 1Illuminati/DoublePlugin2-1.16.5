package doublePlugin.item.startItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import doublePlugin.DoublePlugin;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.inventory.InventoryManager;
import doublePlugin.properties.PropertiesInv;
import doublePlugin.inventory.InventoryMaker;
import doublePlugin.util.map.InfoMaps;

public class StartItemInv extends InventoryManager {
	public static final String INV_CODE = DoublePlugin.pluginName + " Start Item";
	private static final List<ItemStack> startItemList = new ArrayList<>();

	public static void openInv(NewPlayer player) {
		player.openInventory(InventoryManager.getInventoryEvent(INV_CODE).getInv(player));
	}
	
	public static List<ItemStack> getStartItem() {
		return startItemList;
	}

	@Override
	public void open(InventoryOpenEvent event) {}

	@Override
	public void click(InventoryClickEvent event) {}  

	@Override
	public void close(InventoryCloseEvent event) {
		InfoMaps infoMaps = DoublePlugin.getDoublePluginInfoMap();
		startItemList.clear();
		for(int i = 0; i < 54; i++) {
			ItemStack item = event.getInventory().getItem(i);
			if(item != null) {
				infoMaps.setItemStackValue(INV_CODE + i, item);
				startItemList.add(item);
			}
		}
		
		PropertiesInv.openInv(NewPlayer.getNewPlayer((Player) event.getPlayer()));
	}

	@Override
	public String getCode() {
		return INV_CODE;
	}

	@Override
	public Inventory getInv(NewPlayer player) {
		InfoMaps infoMaps = DoublePlugin.getDoublePluginInfoMap();
		InventoryMaker invMaker = new InventoryMaker(54, INV_CODE);
		for(int i = 0; i < 54; i++) {
			if(infoMaps.containsItemStackValue(INV_CODE + i)) {
				invMaker.setItem(i, infoMaps.getItemStackValue(INV_CODE + i));
			}
		}
		
		return invMaker.getInv();
	}
}
