package doublePlugin.entity.player;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NewOfflinePlayerObject extends PlayerInfoObject {
    protected OfflinePlayer offlineplayer;

    protected NewOfflinePlayerObject(OfflinePlayer offlineplayer) {
    	super(offlineplayer.getUniqueId());
        this.offlineplayer = offlineplayer;
    }

	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
		offlineplayer.decrementStatistic(arg0, arg1, arg2);
	}

	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		offlineplayer.decrementStatistic(arg0, arg1);
	}

	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		offlineplayer.decrementStatistic(arg0, arg1);
	}

	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		offlineplayer.decrementStatistic(arg0, arg1, arg2);
	}

	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		offlineplayer.decrementStatistic(arg0, arg1);
	}

	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
		offlineplayer.decrementStatistic(arg0);
	}

	public Location getBedSpawnLocation() {
		return offlineplayer.getBedSpawnLocation();
	}

	public long getFirstPlayed() {
		return offlineplayer.getFirstPlayed();
	}

	public long getLastPlayed() {
		return offlineplayer.getLastPlayed();
	}

	public String getName() {
		return offlineplayer.getName();
	}

	public Player getPlayer() {
		return offlineplayer.getPlayer();
	}

	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		return offlineplayer.getStatistic(arg0, arg1);
	}

	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		return offlineplayer.getStatistic(arg0, arg1);
	}

	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		return offlineplayer.getStatistic(arg0);
	}

	public UUID getUniqueId() {
		return offlineplayer.getUniqueId();
	}

	public boolean hasPlayedBefore() {
		return offlineplayer.hasPlayedBefore();
	}

	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0, arg1, arg2);
	}

	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0, arg1, arg2);
	}

	public void incrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0) throws IllegalArgumentException {
		offlineplayer.incrementStatistic(arg0);
	}

	public boolean isBanned() {
		return offlineplayer.isBanned();
	}

	public boolean isOnline() {
		return offlineplayer.isOnline();
	}

	public boolean isOp() {
		return offlineplayer.isOp();
	}

	public boolean isWhitelisted() {
		return offlineplayer.isWhitelisted();
	}

	public Map<String, Object> serialize() {
		return offlineplayer.serialize();
	}

	public void setOp(boolean arg0) {
		offlineplayer.setOp(arg0);
	}

	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
		offlineplayer.setStatistic(arg0, arg1, arg2);
	}

	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		offlineplayer.setStatistic(arg0, arg1);
	}

	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		offlineplayer.setStatistic(arg0, arg1, arg2);
	}

	public void setWhitelisted(boolean arg0) {
		offlineplayer.setWhitelisted(arg0);
	}

    
}
