package doublePlugin.entity;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class EntityFunc {

    public static boolean checkUndeadEntity(LivingEntity entity) {
        return checkUndeadEntity((Entity) entity);
    }

    public static boolean checkUndeadEntity(Entity entity) {
        return entity.getType() == EntityType.ZOMBIE ||
                entity.getType() == EntityType.HUSK ||
                entity.getType() == EntityType.STRAY ||
                entity.getType() == EntityType.ZOMBIE_VILLAGER ||
                entity.getType() == EntityType.ZOMBIE_HORSE ||
                entity.getType() == EntityType.WITHER_SKELETON ||
                entity.getType() == EntityType.SKELETON ||
                entity.getType() == EntityType.SKELETON_HORSE ||
                entity.getType() == EntityType.WITHER ||
                entity.getType() == EntityType.DROWNED ||
                entity.getType() == EntityType.PHANTOM ||
                entity.getType() == EntityType.STRAY ||
                entity.getType() == EntityType.ZOMBIFIED_PIGLIN;
	}

    public static boolean checkWormEntity(LivingEntity entity) {
        return checkWormEntity((Entity) entity);
    }
	
	public static boolean checkWormEntity(Entity entity) {
        return entity.getType() == EntityType.SILVERFISH ||
                entity.getType() == EntityType.SPIDER ||
                entity.getType() == EntityType.CAVE_SPIDER ||
                entity.getType() == EntityType.BEE ||
                entity.getType() == EntityType.ENDERMITE;
	}
	
	public static Biome getBiome(Entity entity) {
		Location loc = entity.getLocation();
		return entity.getWorld().getBlockAt(loc).getBiome();
	}
}
