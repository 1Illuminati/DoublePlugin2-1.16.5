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
import doublePlugin.item.MakeItem;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo;
import doublePlugin.item.ban.BanItemInfo.BanItemInfoEnum;
import net.md_5.bungee.api.ChatColor;

public class BanItemMoreInfoInv extends InventoryManager {
	public static final String INV_CODE = DoublePlugin.pluginName + " Ban Item More Info";
	
	public static void openInv(NewPlayer player) {
		player.openInventory(InventoryManager.getInventoryEvent(INV_CODE).getInv(player));
	}
	
	private ItemStack temp(BanItemInfo info, BanItemInfoEnum infoEnum, String explain, Material material) {
		boolean check = info.getAllow(infoEnum);
		return MakeItem.makeItem((check ? "§4" : "§a") + infoEnum.name(), material, Arrays.asList("§f" + explain, "§f클릭시 " + infoEnum.name() +"을 " + (check ? "허용" : "비허용") + "합니다"));
	}

	@Override
	public void open(InventoryOpenEvent event) {

	}

	@Override
	public void click(InventoryClickEvent event) {
		ItemStack itemStack = event.getCurrentItem();
		event.setCancelled(true);
		
		if(itemStack == null || itemStack.getType() == Material.AIR) {
			return;
		}
		
		if(!itemStack.getItemMeta().hasDisplayName()) {
			return;
		}
		
		NewPlayer player = NewPlayer.getNewPlayer((Player) event.getWhoClicked());
		String display = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
		BanItemInfo info = BanItem.getBanitemInfo(Material.valueOf(player.getStringValue(INV_CODE)));
		BanItemInfoEnum infoEnum = BanItemInfoEnum.valueOf(display);
		
		if(infoEnum == null) {
			return;
		}
		
		info.setAllow(infoEnum, !info.getAllow(infoEnum));
	}

	@Override
	public void close(InventoryCloseEvent event) {}

	@Override
	public String getCode() {
		return INV_CODE;
	}

	@Override
	public Inventory getInv(NewPlayer player) {
		InventoryMaker invMaker = new InventoryMaker(18, INV_CODE);
		String infoStr = player.getStringValue(INV_CODE);
		BanItemInfo info = BanItem.getBanitemInfo(Material.valueOf(infoStr));
		
		invMaker.setItem(0, temp(info, BanItemInfoEnum.CRAFT, "조합을 금지시킵니다", Material.CRAFTING_TABLE));
		invMaker.setItem(2, temp(info, BanItemInfoEnum.INV, "조합포함 인벤토리 관련 이동 이벤트를 취소시킵니다", Material.CHEST));
		invMaker.setItem(4, temp(info, BanItemInfoEnum.PLACE, "해당 블럭 설치를 모두 취소시킵니다", Material.DIRT));
		invMaker.setItem(6, temp(info, BanItemInfoEnum.BREAK, "해당 블럭 파괴를 모두 취소시킵니다", Material.STONE_PICKAXE));
		invMaker.setItem(8, temp(info, BanItemInfoEnum.CLICK, "해당 아이템 좌,우 클릭을 모두 취소시킵니다", Material.BARRIER));
		invMaker.setItem(8, temp(info, BanItemInfoEnum.DROP, "해당 아이템의 드랍을 전부 취소시킵니다", Material.STONE));
		
		return invMaker.getInv();
	}
}


