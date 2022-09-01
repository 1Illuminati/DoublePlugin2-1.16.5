package doublePlugin.properties;

import java.util.Arrays;

import org.bukkit.Bukkit;
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
import doublePlugin.item.ban.inventory.BanItemAddInv;
import doublePlugin.item.ban.inventory.BanItemInfoInv;
import doublePlugin.item.startItem.StartItemInv;
import net.md_5.bungee.api.ChatColor;

public class PropertiesInv extends InventoryManager {
	public static final String INV_CODE = DoublePlugin.pluginName + " Server Properties";
	
	public static void openInv(NewPlayer player) {
		player.openInventory(InventoryManager.getInventoryEvent(INV_CODE).getInv(player));
	}
	
	private ItemStack temp(PropertiesEnum pro, Material material, String explain) {
		String name = pro.name();
		Boolean check = ServerProperties.get(pro);
		return MakeItem.makeItem((check ? "§4" : "§2") + pro.name(), material, Arrays.asList("§f" + explain, "§f클릭시 " + name + "을 " + (check ? "활성화" : "비활성화") + " 합니다"));
	}

	@Override
	public void open(InventoryOpenEvent event) {}

	@Override
	public void click(InventoryClickEvent event) {
		ItemStack itemStack = event.getCurrentItem();
		event.setCancelled(true);
		
		if(itemStack == null) {
			return;
		}
		
		if(!itemStack.getItemMeta().hasDisplayName()) {
			return;
		}
		
		NewPlayer player = NewPlayer.getNewPlayer((Player) event.getWhoClicked());
		PropertiesEnum pro = PropertiesEnum.valueOf(ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()));
		
		if(pro == null) {
			return;
		}
		
		switch(pro) {
			case BAN_ITEM_REGISTER :
				BanItemAddInv.openInv(player);
			break;
			case BAN_ITEM_SYSTEM :
				BanItemInfoInv.openInv(player);
			break;
			case START_ITEM :
				StartItemInv.openInv(player);
			break;
			default :
				ServerProperties.change(pro);
				openInv(player);
		}
	}

	@Override
	public void close(InventoryCloseEvent event) {
		Bukkit.broadcastMessage("TEST");
	}

	@Override
	public String getCode() {
		return INV_CODE;
	}

	@Override
	public Inventory getInv(NewPlayer player) {
		InventoryMaker invMaker = new InventoryMaker(27, INV_CODE);
		invMaker.setItem(0, temp(PropertiesEnum.LEFT, Material.SHIELD, "서버내에서 왼손의 사용을 금지시킵니다"));
		invMaker.setItem(1, temp(PropertiesEnum.RIDING, Material.SADDLE, "서버내의 모든 탈것에 타게될경우 그것을 취소시켜버립니다"));
		invMaker.setItem(2, temp(PropertiesEnum.ATKSPEED, Material.IRON_SWORD, "서버에 입장시 모든 유저는 기존 마크의 공속이 제거됩니다"));
		invMaker.setItem(3, temp(PropertiesEnum.ENCHANT, Material.ENCHANTED_BOOK, "모루와 인챈트테이블을 우클릭해도 각각의 인벤토리가 뜨지 않습니다"));
		invMaker.setItem(4, temp(PropertiesEnum.SEX, Material.EGG, "모든 번식이 가능한 개체들은 심영이 됩니다"));
		invMaker.setItem(5, temp(PropertiesEnum.HUNGRY, Material.BREAD, "배고픔이 닳지 않습니다"));
		invMaker.setItem(6, temp(PropertiesEnum.FALLDAMAGE, Material.DIAMOND_BOOTS, "낙뎀을 받지 않습니다"));
		invMaker.setItem(7, temp(PropertiesEnum.PVP, Material.IRON_SWORD, "플레이어를 때릴수 없습니다"));
		invMaker.setItem(8, temp(PropertiesEnum.PLACE, Material.STONE, "블럭설치가 불가능합니다"));
		invMaker.setItem(9, temp(PropertiesEnum.BREAK, Material.DIAMOND_PICKAXE, "블럭을 캘수 없습니다"));
		
		invMaker.setItem(24, MakeItem.makeItem("§f" + PropertiesEnum.START_ITEM.name(), Material.CHEST, "§f기본템 등록으로 이동합니다"));
		invMaker.setItem(25, MakeItem.makeItem("§f" + PropertiesEnum.BAN_ITEM_REGISTER.name(), Material.BARRIER, "§f밴 아이템 등록으로 이동합니다"));
		invMaker.setItem(26, MakeItem.makeItem("§f" + PropertiesEnum.BAN_ITEM_SYSTEM.name(), Material.BARRIER, "§f밴 아이템 설정으로 이동합니다"));
		
		return invMaker.getInv();
	}

}
