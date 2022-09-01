package doublePlugin.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import doublePlugin.item.skull.GetSkull;

@SuppressWarnings("deprecation")
public class MakeItem extends GetSkull {

    public static ItemStack makeItem(String display, Material material, List<String> lore, int data, boolean unbreakable) {
        ItemStack itemStack = new MaterialData(material, (byte) data).toItemStack(1);
        setItemMeta(itemStack, display, lore, unbreakable);
        return itemStack;
    }  

    public static ItemStack makeItem(String display, Material material, String explain, int data, boolean unbreakable) {
        List<String> lore = new ArrayList<>();
        lore.add(explain);
        return makeItem(display, material, lore, data, unbreakable);
    }

    public static ItemStack makeItem(String display, Material material, List<String> lore, int data) {
        return makeItem(display, material, lore, data, false);
    }

    public static ItemStack makeItem(String display, Material material, String explain, int data) {
        return makeItem(display, material, explain, data, false);
    }

    public static ItemStack makeItem(String display, Material material, List<String> lore) {
        return makeItem(display, material, lore, 0, false);
    }

    public static ItemStack makeItem(String display, Material material, String explain) {
        return makeItem(display, material, explain, 0, false);
    }

    public static ItemStack makeItem(String display, Material material, int data, boolean unbreakable) {
        return makeItem(display, material, new ArrayList<>(), data, unbreakable);
    }

    public static ItemStack makeItem(String display, Material material, int data) {
        return makeItem(display, material, new ArrayList<>(), data, false);
    }

    public static ItemStack makeItem(String display, Material material, boolean unbreakable) {
        return makeItem(display, material, new ArrayList<>(), 0, unbreakable);
    }

    public static ItemStack makeItem(String display, Material material) {
        return makeItem(display, material, new ArrayList<>(), 0, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, List<String> lore, int data, boolean unbreakable) {
        ItemStack itemStack = getSkull(texture);
        setItemMeta(itemStack, display, lore, unbreakable);
        return itemStack;
    }

    public static ItemStack makeSkullItem(String display, String texture, String explain, int data, boolean unbreakable) {
        List<String> lore = new ArrayList<>();
        lore.add(explain);
        return makeSkullItem(display, texture, lore, data, unbreakable);
    }

    public static ItemStack makeSkullItem(String display, String texture, List<String> lore, int data) {
        return makeSkullItem(display, texture, lore, data, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, String explain, int data) {
        return makeSkullItem(display, texture, explain, data, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, List<String> lore) {
        return makeSkullItem(display, texture, lore, 0, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, String explain) {
        return makeSkullItem(display, texture, explain, 0, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, int data, boolean unbreakable) {
        return makeSkullItem(display, texture, new ArrayList<>(), data, unbreakable);
    }

    public static ItemStack makeSkullItem(String display, String texture, int data) {
        return makeSkullItem(display, texture, new ArrayList<>(), data, false);
    }

    public static ItemStack makeSkullItem(String display, String texture, boolean unbreakable) {
        return makeSkullItem(display, texture, new ArrayList<>(), 0, unbreakable);
    }

    public static ItemStack makeSkullItem(String display, String texture) {
        return makeSkullItem(display, texture, new ArrayList<>(), 0, false);
    }

    public static ItemStack getAir() {
        return new ItemStack(Material.AIR);
    }

    private static void setItemMeta(ItemStack itemStack, String display, List<String> lore, boolean unbreakable) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(display);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(unbreakable);
        itemStack.setItemMeta(itemMeta);
    }
}
