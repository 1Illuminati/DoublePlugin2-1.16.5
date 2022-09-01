package doublePlugin.item;

import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public class ItemBuilder {
	private ItemStack itemStack;
	private ItemMeta itemMeta;
	
	public ItemBuilder(Material material) {
		this.itemStack = new ItemStack(material);
		this.itemMeta = this.itemStack.getItemMeta();
	}
	public ItemBuilder(ItemStack itemStack) {
		this.itemStack = itemStack;
		this.itemMeta = itemStack.getItemMeta();
	}
	public ItemBuilder addEnchantment(Enchantment ench, int level) {
		itemStack.addEnchantment(ench, level);
		return this;
	}
	public ItemBuilder addEnchantments(Map<Enchantment, Integer> enchantments) {
		itemStack.addEnchantments(enchantments);
		return this;
	}
	public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level) {
		itemStack.addUnsafeEnchantment(ench, level);
		return this;
	}
	public ItemBuilder addUnsafeEnchantments(Map<Enchantment, Integer> enchantments) {
		itemStack.addUnsafeEnchantments(enchantments);
		return this;
	}
	public ItemBuilder setAmount(int amount) {
		itemStack.setAmount(amount);
		return this;
	}
	public ItemBuilder setData(MaterialData data) {
		itemStack.setData(data);
		return this;
	}
	public ItemBuilder setDurability(short durability) {
		itemStack.setDurability(durability);
		return this;
	}
	public ItemBuilder setItemMeta(ItemMeta itemMeta) {
		itemStack.setItemMeta(itemMeta);
		return this;
	}
	public ItemBuilder setType(Material type) {
		itemStack.setType(type);
		return this;
	}
	public ItemBuilder addEnchant(Enchantment arg0, int arg1, boolean arg2) {
		itemMeta.addEnchant(arg0, arg1, arg2);
		return this;
	}
	public ItemBuilder addItemFlags(ItemFlag... arg0) {
		itemMeta.addItemFlags(arg0);
		return this;
	}
	public ItemBuilder setDisplayName(String arg0) {
		itemMeta.setDisplayName(arg0);
		return this;
	}
	public ItemBuilder setLocalizedName(String arg0) {
		itemMeta.setLocalizedName(arg0);
		return this;
	}
	public ItemBuilder setLore(List<String> arg0) {
		itemMeta.setLore(arg0);
		return this;
	}
	public ItemBuilder setUnbreakable(boolean arg0) {
		itemMeta.setUnbreakable(arg0);
		return this;
	}
	public ItemBuilder setCustomModelData(Integer data) {
		itemMeta.setCustomModelData(data);
		return this;
	}
	
	public ItemStack make() {
		return this.setItemMeta(this.itemMeta).itemStack;
	}
}
