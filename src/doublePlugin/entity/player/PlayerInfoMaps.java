package doublePlugin.entity.player;

import java.util.HashMap;
import java.util.UUID;

import doublePlugin.util.map.InfoMaps;

public class PlayerInfoMaps extends InfoMaps {
	private static final String FOLDER_LOC = "info/player/";
	private static final HashMap<UUID, PlayerInfoMaps> playerInfoMaps = new HashMap<>();
	
	public static boolean containsInfoMaps(UUID playerUUID) {
		return playerInfoMaps.containsKey(playerUUID);
	}
	
	public static PlayerInfoMaps getInfoMaps(UUID playerUUID) {
		if(!containsInfoMaps(playerUUID)) {
			playerInfoMaps.put(playerUUID, new PlayerInfoMaps(playerUUID));
		}
		
		return playerInfoMaps.get(playerUUID);
	}
    
	private PlayerInfoMaps(UUID playerUUID) {
		super(FOLDER_LOC + playerUUID.toString());
	}
	
	public void setCoolTimeSecond(String coolTimeName, double second) {
        this.getCoolTime().setCoolTimeSecond(coolTimeName, second);
    }

    public void setCoolTimeMinute(String coolTimeName, int minute) {
    	this.getCoolTime().setCoolTimeMinute(coolTimeName, minute);
    }

    public void setCoolTimeHour(String coolTimeName, int hour) {
    	this.getCoolTime().setCoolTimeHour(coolTimeName, hour);
    }

    public void setCoolTimeDay(String coolTimeName, int day) {
    	this.getCoolTime().setCoolTimeDay(coolTimeName, day);
    }

    public void setCoolTimeMonth(String coolTimeName, int month) {
    	this.getCoolTime().setCoolTimeMonth(coolTimeName, month);
    }

    public void setCoolTimeYear(String coolTimeName, int year) {
    	this.getCoolTime().setCoolTimeYear(coolTimeName, year);
    }

    public double getLessCoolTime(String coolTimeName) {
        return this.getCoolTime().getLessCoolTime(coolTimeName);
    }

    public void removeCoolTime(String coolTimeName) {
    	this.getCoolTime().removeCoolTime(coolTimeName);
    }

    public void reduceCoolTime(String coolTimeName, double reduceSecond) {
        this.getCoolTime().reduceCoolTime(coolTimeName, reduceSecond);
    }

    public boolean checkCoolTime(String coolTimeName) {
        return this.getCoolTime().checkCoolTime(coolTimeName);
    }
}
