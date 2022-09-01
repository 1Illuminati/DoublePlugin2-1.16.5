package doublePlugin.item.ban.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import doublePlugin.DoublePlugin;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.inventory.InventoryManager;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo;
import doublePlugin.properties.PropertiesInv;
import doublePlugin.inventory.InventoryMaker;
import doublePlugin.util.map.NotNullStrMap;

public class BanItemAddInv extends InventoryManager {
	public static final String INV_CODE = DoublePlugin.pluginName + " Ban Item Register";
	
	public static void openInv(NewPlayer player) {
		player.openInventory(InventoryManager.getInventoryEvent(INV_CODE).getInv(player));
	}

	@Override
	public void open(InventoryOpenEvent event) {}

	@Override
	public void click(InventoryClickEvent event) {}  

	@SuppressWarnings("unchecked")
	@Override
	public void close(InventoryCloseEvent event) {
		NotNullStrMap<BanItemInfo> map = (NotNullStrMap<BanItemInfo>) BanItem.getMap().clone();
		BanItem.clear();
		for (ItemStack itemStack : event.getInventory().getContents()) {
			if (itemStack != null) {
				Material material = itemStack.getType();
				if (map.containsKey(material.toString())) {
					BanItem.addBanItem(material, map.get(material.toString()));
				} else {
					BanItem.addBanItem(itemStack.getType());
				}
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
		InventoryMaker invMaker = new InventoryMaker(54, INV_CODE);
		int index = 0;
		for(BanItemInfo banItemInfo : BanItem.getList()) {
			invMaker.setItem(index++, new ItemStack(banItemInfo.getMaterial()));
		}
		
		return invMaker.getInv();
	}
}
