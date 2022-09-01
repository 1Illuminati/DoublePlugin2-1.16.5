package doublePlugin.event.blockEvent;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import doublePlugin.item.ban.BanItem;
import doublePlugin.item.ban.BanItemInfo.BanItemInfoEnum;
import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;

public class NewBlockEvent {
	public void newBlockPlaceEvent(BlockPlaceEvent event) {
		if(!ServerProperties.get(PropertiesEnum.PLACE)) {
			event.setCancelled(true);
			return;
		}
		
		Material material = event.getBlock().getType();
		if(BanItem.checkBanItem(material)) {
			if(BanItem.getBanitemInfo(material).getAllow(BanItemInfoEnum.PLACE)) {
				event.setCancelled(true);
				return;
			}
		}
	}
	
	public void newBlockBreakEvent(BlockBreakEvent event) {
		if(!ServerProperties.get(PropertiesEnum.BREAK)) {
			event.setCancelled(true);
			return;
		}
		
		Material material = event.getBlock().getType();
		if(BanItem.checkBanItem(material)) {
			if(BanItem.getBanitemInfo(material).getAllow(BanItemInfoEnum.BREAK)) {
				event.setCancelled(true);
				return;
			}
		}
	}
}
