package doublePlugin.item.ban.inventory;

import java.util.Arrays;

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
import doublePlugin.inventory.InventoryMaker;
import doublePlugin.item.ItemBuilder;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo;
import doublePlugin.item.ban.BanItemInfo.BanItemInfoEnum;

public class BanItemInfoInv extends InventoryManager {
	public static final String INV_CODE = DoublePlugin.pluginName + " Ban Item Info";
	
	public static void openInv(NewPlayer player) {
		player.openInventory(InventoryManager.getInventoryEvent(INV_CODE).getInv(player));
	}
	
	private ItemStack temp(BanItemInfo banItemInfo) {
		return new ItemBuilder(banItemInfo.getMaterial()).setLore(Arrays.asList(
				temp2(banItemInfo, BanItemInfoEnum.CRAFT),
				temp2(banItemInfo, BanItemInfoEnum.INV),
				temp2(banItemInfo, BanItemInfoEnum.PLACE),
				temp2(banItemInfo, BanItemInfoEnum.BREAK),
				temp2(banItemInfo, BanItemInfoEnum.CLICK),
				temp2(banItemInfo, BanItemInfoEnum.DROP))).make();
	}
	
	private static String temp2(BanItemInfo banItemInfo, BanItemInfoEnum infoEnum) {
		return "§f" + infoEnum.name() + " : " + (banItemInfo.getAllow(infoEnum) ? "§4불가" : "§2허용");
	}

	@Override
	public void open(InventoryOpenEvent event) {
	
	}

	@Override
	public void click(InventoryClickEvent event) {
		ItemStack itemStack = event.getCurrentItem();
		if(itemStack == null || itemStack.getType() == Material.AIR) {
			return;
		}
		
		if(BanItem.checkBanItem(itemStack.getType())) {
			NewPlayer player = NewPlayer.getNewPlayer((Player) event.getWhoClicked());
			player.setStringValue(BanItemMoreInfoInv.INV_CODE, itemStack.getType().name());
			BanItemMoreInfoInv.openInv(player);
		}
		event.setCancelled(true);
	}

	@Override
	public void close(InventoryCloseEvent event) {
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
			invMaker.setItem(index++, temp(banItemInfo));
		}
		
		return invMaker.getInv();
	}
}
