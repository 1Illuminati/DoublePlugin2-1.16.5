package doublePlugin.entity.player;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import doublePlugin.scheduler.RunnableEx;
import doublePlugin.scheduler.Scheduler;
import doublePlugin.util.scoreBoard.ScoreBoardHelper;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.inventory.Inventory;

public class NewPlayer extends NewPlayerObject {
	private static final HashMap<UUID, NewPlayer> newPlayerMap = new HashMap<>();
	private static final HashMap<UUID, NewPlayer> npcNewPlayerMap = new HashMap<>();
    
    public static final String PLAYER_HIT_NUM = "DOUBLE_PLUGIN_PLAYER_HIT_NUM";
    public static final String PLAYER_BEAT_NUM = "DOUBLE_PLUGIN_PLAYER_BEAT_NUM";
    public static final String PLAYER_JOIN_COUNT = "DOUBLE_PLUGIN_PLAYER_JOIN_COUNT";
    public static final String PLAYER_CONNECT = "DOUBLE_PLUGIN_PLAYER_CONNECT";
    public static final String NPC = "NPC";
    
    private final HashMap<String, Runnable> runnableMap = new HashMap<>();
    private final NewOfflinePlayer newOfflinePlayer;
    private int atkNum;
    private int defNum;
    private ScoreBoardHelper scoreBoard;
    private final boolean npcPlayer;
    private ScanRunnable scanRunnable;

    protected NewPlayer(Player player) {
    	super(player);
        this.atkNum = 0;
        this.defNum = 0;

        if(!player.hasMetadata(NewPlayer.NPC)) {
        	npcPlayer = true;
        	newOfflinePlayer = null;
        } else {
        	npcPlayer = false;
        	newOfflinePlayer = NewOfflinePlayer.getNewOfflinePlayer(getUniqueId());
        }
        
        loadIndividualScheduler();
    }

    private void loadIndividualScheduler() {
        Scheduler.infiniteRepeatScheduler(new RunnableEx() {

			@Override
			public void function() {
				if (checkCoolTime(NewPlayer.PLAYER_HIT_NUM))
	                atkNum = 0;

	            if (checkCoolTime(NewPlayer.PLAYER_BEAT_NUM))
	                defNum = 0;
	            
	            for(Runnable runnable : runnableMap.values()) {
	            	runnable.run();
	            }
	            
	            if(!getPlayerConnect()) {
	            	removeNewPlayer();
	            	this.stop();
	            }
			}
            
        }, 0, 1);
    }

    public static Collection<NewPlayer> getOnlineNewPlayer() {
        return newPlayerMap.values();
    }

    public static NewPlayer getNewPlayerByName(String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        return player == null ? null : getNewPlayer(player);
    }

    public static NewPlayer getNewPlayerByUUID(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        return player == null ? null : getNewPlayer(player);
    }

    public static NewPlayer getNewPlayerByUUID(String playerUUID) {
        return getNewPlayerByUUID(UUID.fromString(playerUUID));
    }

    public static NewPlayer getNewPlayer(Player player) {
        UUID playerUUID = player.getUniqueId();

        if(player.hasMetadata(NewPlayer.NPC)) {
        	if(!npcNewPlayerMap.containsKey(playerUUID)) {
        		npcNewPlayerMap.put(playerUUID, new NewPlayer(player));
        	}
        	
        	return npcNewPlayerMap.get(playerUUID);
        } else if(!newPlayerMap.containsKey(playerUUID)) {
            newPlayerMap.put(playerUUID, new NewPlayer(player));
        }

        return newPlayerMap.get(playerUUID);
    }
    
    public static boolean containsNewPlayer(Player player) {
    	return newPlayerMap.containsKey(player.getUniqueId());
    }
    
    public boolean checkPlayerNpc() {
    	return this.npcPlayer;
    }
    
    /**
     * npc플레이어 일경우 null 반환한다
     * @return null or NewOfflinePlayer
     */
    public NewOfflinePlayer getNewOfflinePlayer() {
    	return this.newOfflinePlayer;
    }
    
    public ScoreBoardHelper getScoreBoardHelper() {
    	return this.scoreBoard;
    }
    
    public void setScoreBoardHelper(ScoreBoardHelper scoreBoardHelper) {
    	this.scoreBoard = scoreBoardHelper;
    }
    
    public void putRunnable(String code, final Runnable run) {
    	this.runnableMap.put(code, run);
    }
    
    public Runnable getRunnable(String code) {
    	return this.runnableMap.get(code);
    }

    public void removeNewPlayer() {
        UUID playerUUID = player.getUniqueId();
        if(newPlayerMap.containsKey(playerUUID)) {
            newPlayerMap.remove(playerUUID);
        }
    }
    
    public int getAtkNum() {
        return this.atkNum;
    }

    public void addAtkNum(int value) {
        this.atkNum += value;
    }

    public void addAtkNum() {
        this.atkNum++;
    }

    public boolean checkAtkNum(int value) {
        return this.atkNum != 0 && this.atkNum % value == 0;
    }

    public int getDefNum() {
        return this.defNum;
    }

    public void addDefNum(int value) {
        this.defNum += value;
    }

    public void addDefNum() {
        this.defNum++;
    }

    public boolean checkDefNum(int value) {
        return this.defNum != 0 && this.defNum % value == 0;
    }

    public void sendActionBar(String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public String getUniqueIdtoString() {
        return player.getUniqueId().toString();
    }

    /**
     * 인벤토리를 열고 있는 상태에서 인벤토리를 오픈할때 사용해야하며 기존의 close 이벤트를 거치지 않고 인벤토리를 오픈한다
     * @param inv 약간 늦게 오픈할 인벤토리
     */
    public void openInvNotClose(Inventory inv) {
        Scheduler.delayScheduler(new RunnableEx() {

            @Override
            public void function() {
                player.openInventory(inv);
            }
        }, 2);
    }

    public void scannerPlayer(final ScanRunnable runnable) {
        this.scanRunnable = runnable;
    }

    public ScanRunnable getScannerRunnable() {
        return this.scanRunnable;
    }

    public static class ScanRunnable {
        public void run(String str) {

        }
    }
    
    public NewPlayer getNewPlayer() {
    	return this;
    }
    
    /**
     * 플레이어의 접속 여부를 확인한다 대체 어디다가 쓸려고?
     * @return true 접속중 false 나감
     */
    public boolean getPlayerConnect() {
    	return super.getBooleanValue(PLAYER_CONNECT);
    }
    
    public int getPlayerJoinCount() {
    	return super.getIntegerValue(PLAYER_JOIN_COUNT);
    }
}
