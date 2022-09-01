package doublePlugin.event.actEvent;

import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import doublePlugin.entity.player.NewPlayer;
import doublePlugin.item.ItemEvent;
import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo.BanItemInfoEnum;
import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;

public class NewPlayerActEvent {
	public void newPlayerInteractEvent(PlayerInteractEvent event) {
		if(event.getHand() == EquipmentSlot.OFF_HAND) {
			return;
		}
		
		
		NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
		ItemStack itemStack = player.getItemInHand();
		if(itemStack == null || itemStack.getType() == Material.AIR) {
			return;
		}
		
		if(BanItem.checkBanItem(itemStack.getType())) {
			if(BanItem.getBanitemInfo(itemStack.getType()).getAllow(BanItemInfoEnum.CLICK)) {
				event.setCancelled(true);
				return;
			}
		}
		
		Action action = event.getAction();
		if(action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {
			Material material = event.getClickedBlock().getType();
			if(BanItem.checkBanItem(material)) {
				if(BanItem.getBanitemInfo(material).getAllow(BanItemInfoEnum.CLICK)) {
					event.setCancelled(true);
					return;
				}
			}
		}

		ItemEvent itemEvent = ItemEvent.getItemEvent(itemStack);
		if(itemEvent != null) {
			Boolean eventCancelled = false;
			switch(action) {
				case LEFT_CLICK_AIR:
				case LEFT_CLICK_BLOCK:
					if(player.isSneaking()) {
						eventCancelled = itemEvent.shiftLeftClick(player);
					} else {
						eventCancelled = itemEvent.leftClick(player);
					}
				break;
				case RIGHT_CLICK_AIR:
				case RIGHT_CLICK_BLOCK:
					if(player.isSneaking()) {
						eventCancelled = itemEvent.shiftRightClick(player);
					} else {
						eventCancelled = itemEvent.rightClick(player);
					}
				break;
				default:
				break;
			}

			event.setCancelled(eventCancelled);
		}

	}

	public void newPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
		NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
		ItemStack itemStack = player.getItemInHand();
		if(itemStack == null || itemStack.getType() == Material.AIR) {
			return;
		}
		
		if(!ServerProperties.get(PropertiesEnum.LEFT)) {
			event.setCancelled(true);
			return;
		}

		ItemEvent itemEvent = ItemEvent.getItemEvent(itemStack);
		if(itemEvent != null) {
			Boolean eventCancelled = false;
			if(player.isSneaking()) {
				eventCancelled = itemEvent.shiftSwapHand(player);
			} else {
				eventCancelled = itemEvent.swapHand(player);
			}
			event.setCancelled(eventCancelled);
		}
	}

	public void newPlayerDropItemEvent(PlayerDropItemEvent event) {
		NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());
		ItemStack itemStack = player.getItemInHand();
		if(itemStack == null || itemStack.getType() == Material.AIR) {
			return;
		}
		
		if(!ServerProperties.get(PropertiesEnum.DROP)) {
			event.setCancelled(true);
			return;
		}
		
		if(BanItem.getBanitemInfo(itemStack.getType()).getAllow(BanItemInfoEnum.DROP)) {
			event.setCancelled(true);
			return;
		}

		ItemEvent itemEvent = ItemEvent.getItemEvent(itemStack);
		if(itemEvent != null) {
			Boolean eventCancelled = false;
			if(player.isSneaking()) {
				eventCancelled = itemEvent.dropItem(player);
			} else {
				eventCancelled = itemEvent.shiftDropItem(player);
			}
			event.setCancelled(eventCancelled);
		}
	}
}
