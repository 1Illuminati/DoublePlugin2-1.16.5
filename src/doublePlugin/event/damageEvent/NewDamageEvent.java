package doublePlugin.event.damageEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import doublePlugin.entity.player.NewPlayer;
import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;

public class NewDamageEvent {
	public void newEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		boolean check1 = false;
		boolean check2 = false;
		if (event.getDamager() instanceof Player) {
			NewPlayer atkPlayer = NewPlayer.getNewPlayer((Player) event.getDamager());
			check1 = !check1;
			atkPlayer.setCoolTimeSecond(NewPlayer.PLAYER_HIT_NUM, 3);
			atkPlayer.addAtkNum();
		}

		if (event.getEntity() instanceof Player) {
			NewPlayer defPlayer = NewPlayer.getNewPlayer((Player) event.getEntity());
			check2 = !check2;
			defPlayer.setCoolTimeSecond(NewPlayer.PLAYER_BEAT_NUM, 3);
			defPlayer.addDefNum();
		}
		if (check1 && check2) {
			if (!ServerProperties.get(PropertiesEnum.PVP)) {
				event.setCancelled(true);
			}
		}
	}
	
	public void newEntityDamageEvent(EntityDamageEvent event) {
		boolean check = ServerProperties.get(PropertiesEnum.FALLDAMAGE);
		
		if (!check) {
			if (event.getCause() == DamageCause.FALL) {
				event.setCancelled(true);
			}
		}
	}
}
