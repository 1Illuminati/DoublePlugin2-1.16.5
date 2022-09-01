package doublePlugin.entity.player;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class NewOfflinePlayer extends NewOfflinePlayerObject {
    private static final HashMap<UUID, NewOfflinePlayer> newOfflinePlayerMap = new HashMap<>();

    protected NewOfflinePlayer(OfflinePlayer offlinePlayer) {
    	super(offlinePlayer);
    }

    public static NewOfflinePlayer getNewOfflinePlayer(OfflinePlayer offlinePlayer) {
        UUID offlinePlayerUUID = offlinePlayer.getUniqueId();
        if(!NewOfflinePlayer.newOfflinePlayerMap.containsKey(offlinePlayerUUID)) {
            NewOfflinePlayer.newOfflinePlayerMap.put(offlinePlayerUUID, new NewOfflinePlayer(offlinePlayer));
        }

        return NewOfflinePlayer.newOfflinePlayerMap.get(offlinePlayerUUID);
    }
    
    public static NewOfflinePlayer getNewOfflinePlayer(UUID uuid) {
    	return getNewOfflinePlayer(Bukkit.getOfflinePlayer(uuid));
    }
    
    public static NewOfflinePlayer getNewOfflinePlayer(String uuid) {
    	return getNewOfflinePlayer(Bukkit.getOfflinePlayer(UUID.fromString(uuid)));
    }
    
    public static void saveAllOfflinePlayer() {
    	for(NewOfflinePlayer offlinePlayer : newOfflinePlayerMap.values()) {
    		offlinePlayer.saveInfoMaps();
    	}
    }
}
