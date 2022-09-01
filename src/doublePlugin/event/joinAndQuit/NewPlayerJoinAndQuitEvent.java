package doublePlugin.event.joinAndQuit;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import doublePlugin.DoublePlugin;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.file.Folder;
import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;
import net.md_5.bungee.api.ChatColor;

public class NewPlayerJoinAndQuitEvent {
	Folder folder = new Folder();

    public void NewPlayerJoinEvent(PlayerJoinEvent e) {
    	Player player = e.getPlayer();
    	if(NewPlayer.containsNewPlayer(player)) {
    		NewPlayer p = NewPlayer.getNewPlayer(player);
    		p.removeNewPlayer();
    	}
    	
        NewPlayer p = NewPlayer.getNewPlayer(player);
        p.addIntegerValue(NewPlayer.PLAYER_JOIN_COUNT, 1);
        p.setBooleanValue(NewPlayer.PLAYER_CONNECT, true);
        p.sendMessage(ChatColor.WHITE + "현재 이 서버는 " + DoublePlugin.pluginName + "을 사용중입니다");
        
        if (!ServerProperties.get(PropertiesEnum.ATKSPEED)) {
        	p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1000D);
        }
    }

    public void NewPlayerQuitEvent(PlayerQuitEvent e) {
        NewPlayer p = NewPlayer.getNewPlayer(e.getPlayer());
        p.setBooleanValue(NewPlayer.PLAYER_CONNECT, false);
        p.saveInfoMaps();
        p.removeNewPlayer();
    }
}
