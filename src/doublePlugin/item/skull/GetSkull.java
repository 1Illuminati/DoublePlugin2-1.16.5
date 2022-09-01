package doublePlugin.item.skull;

import java.lang.reflect.Field;

import com.mojang.authlib.GameProfile;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import doublePlugin.entity.player.NewPlayer;
import doublePlugin.util.DoubleUtil;

@SuppressWarnings("deprecation")
public class GetSkull {
	public static ItemStack getSkull(String texture) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
        GameProfile profile = DoubleUtil.getGameProfile(texture, null);
        Field profileField = null;
        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        }
        catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        assert profileField != null;
        profileField.setAccessible(true);
        try {
            profileField.set(skullMeta, profile);
        }
        catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }

	public static ItemStack getPlayerSkull(NewPlayer p) {
		SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
		meta.setOwningPlayer(Bukkit.getOfflinePlayer(p.getUniqueId()));
		ItemStack skullItem = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
		skullItem.setItemMeta(meta);
		
		return skullItem;
	}
}
