package doublePlugin.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemFunc {
	
	public static boolean checkNetheriteTool(Material material) {
		return material == Material.NETHERITE_AXE || material == Material.NETHERITE_HOE || material == Material.NETHERITE_SWORD
				|| material == Material.NETHERITE_SHOVEL || material == Material.NETHERITE_PICKAXE;
	}

	public static boolean checkIronTool(Material material) {
		return material == Material.IRON_AXE || material == Material.IRON_HOE || material == Material.IRON_SWORD
				|| material == Material.IRON_SHOVEL || material == Material.IRON_PICKAXE;
	}

	public static boolean checkGoldenTool(Material material) {
		return material == Material.GOLDEN_AXE || material == Material.GOLDEN_HOE || material == Material.GOLDEN_SWORD
				|| material == Material.GOLDEN_SHOVEL || material == Material.GOLDEN_PICKAXE;
	}

	public static boolean checkDiamondTool(Material material) {
		return material == Material.DIAMOND_AXE || material == Material.DIAMOND_HOE
				|| material == Material.DIAMOND_SWORD || material == Material.DIAMOND_SHOVEL
				|| material == Material.DIAMOND_PICKAXE;
	}

	public static boolean checkStoneTool(Material material) {
		return material == Material.STONE_AXE || material == Material.STONE_HOE || material == Material.STONE_SWORD
				|| material == Material.STONE_SHOVEL || material == Material.STONE_PICKAXE;
	}

	public static boolean checkWoodenTool(Material material) {
		return material == Material.WOODEN_AXE || material == Material.WOODEN_HOE || material == Material.WOODEN_SWORD
				|| material == Material.WOODEN_SHOVEL || material == Material.WOODEN_PICKAXE;
	}

	public static boolean checkAxe(Material material) {
		return material == Material.IRON_AXE || material == Material.GOLDEN_AXE || material == Material.STONE_AXE
				|| material == Material.WOODEN_AXE || material == Material.DIAMOND_AXE || material == Material.NETHERITE_AXE;
	}

	public static boolean checkHoe(Material material) {
		return material == Material.IRON_HOE || material == Material.GOLDEN_HOE || material == Material.STONE_HOE
				|| material == Material.WOODEN_HOE || material == Material.DIAMOND_HOE || material == Material.NETHERITE_HOE;
	}

	public static boolean checkShovel(Material material) {
		return material == Material.IRON_SHOVEL || material == Material.GOLDEN_SHOVEL || material == Material.STONE_SHOVEL
				|| material == Material.WOODEN_SHOVEL || material == Material.DIAMOND_SHOVEL|| material == Material.NETHERITE_SHOVEL;
	}

	public static boolean checkPickaxe(Material material) {
		return material == Material.IRON_PICKAXE || material == Material.GOLDEN_PICKAXE
				|| material == Material.STONE_PICKAXE || material == Material.WOODEN_PICKAXE
				|| material == Material.DIAMOND_PICKAXE || material == Material.NETHERITE_PICKAXE;
	}

	public static boolean checkSword(Material material) {
		return material == Material.IRON_SWORD || material == Material.GOLDEN_SWORD || material == Material.STONE_SWORD
				|| material == Material.WOODEN_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD;
	}

	public static boolean checkArmor(Material material) {
		return material == Material.IRON_HELMET || material == Material.IRON_CHESTPLATE
				|| material == Material.IRON_LEGGINGS || material == Material.IRON_BOOTS
				|| material == Material.CHAINMAIL_HELMET || material == Material.CHAINMAIL_CHESTPLATE
				|| material == Material.CHAINMAIL_LEGGINGS || material == Material.CHAINMAIL_BOOTS
				|| material == Material.DIAMOND_HELMET || material == Material.DIAMOND_CHESTPLATE
				|| material == Material.DIAMOND_LEGGINGS || material == Material.DIAMOND_BOOTS
				|| material == Material.LEATHER_HELMET || material == Material.LEATHER_CHESTPLATE
				|| material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_BOOTS
				|| material == Material.GOLDEN_HELMET || material == Material.GOLDEN_CHESTPLATE
				|| material == Material.GOLDEN_LEGGINGS || material == Material.GOLDEN_BOOTS
				|| material == Material.LEATHER_HELMET || material == Material.LEATHER_CHESTPLATE
				|| material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_BOOTS;
	}
	
	public static boolean checkNetheriteArmor(Material material) {
		return material == Material.LEATHER_HELMET || material == Material.LEATHER_CHESTPLATE
				|| material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_BOOTS;
	}

	public static boolean checkLetherArmor(Material material) {
		return material == Material.LEATHER_HELMET || material == Material.LEATHER_CHESTPLATE
				|| material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_BOOTS;
	}

	public static boolean checkGoldenArmor(Material material) {
		return material == Material.GOLDEN_HELMET || material == Material.GOLDEN_CHESTPLATE
				|| material == Material.GOLDEN_LEGGINGS || material == Material.GOLDEN_BOOTS;
	}

	public static boolean checkDiamondArmor(Material material) {
		return material == Material.DIAMOND_HELMET || material == Material.DIAMOND_CHESTPLATE
				|| material == Material.DIAMOND_LEGGINGS || material == Material.DIAMOND_BOOTS;
	}

	public static boolean checkChainMailArmor(Material material) {
		return material == Material.CHAINMAIL_HELMET || material == Material.CHAINMAIL_CHESTPLATE
				|| material == Material.CHAINMAIL_LEGGINGS || material == Material.CHAINMAIL_BOOTS;
	}

	public static boolean checkIronArmor(Material material) {
		return material == Material.IRON_HELMET || material == Material.IRON_CHESTPLATE
				|| material == Material.IRON_LEGGINGS || material == Material.IRON_BOOTS;
	}

	public static boolean checkHelmet(Material material) {
		return material == Material.IRON_HELMET || material == Material.CHAINMAIL_HELMET
				|| material == Material.DIAMOND_HELMET || material == Material.LEATHER_HELMET
				|| material == Material.GOLDEN_HELMET || material == Material.NETHERITE_HELMET;
	}

	public static boolean checkChestPlate(Material material) {
		return material == Material.IRON_CHESTPLATE || material == Material.CHAINMAIL_CHESTPLATE
				|| material == Material.DIAMOND_CHESTPLATE || material == Material.LEATHER_CHESTPLATE
				|| material == Material.GOLDEN_CHESTPLATE || material == Material.NETHERITE_CHESTPLATE;
	}

	public static boolean checkLeggings(Material material) {
		return material == Material.IRON_LEGGINGS || material == Material.CHAINMAIL_LEGGINGS
				|| material == Material.DIAMOND_LEGGINGS || material == Material.LEATHER_LEGGINGS
				|| material == Material.GOLDEN_LEGGINGS || material == Material.NETHERITE_LEGGINGS;
	}

	public static boolean checkBoots(Material material) {
		return material == Material.IRON_BOOTS || material == Material.CHAINMAIL_BOOTS
				|| material == Material.DIAMOND_BOOTS || material == Material.LEATHER_BOOTS
				|| material == Material.GOLDEN_BOOTS || material == Material.NETHERITE_BOOTS;
	}

	public static boolean checkWeapon(Material material) {
		return checkMeleeWeapon(material) || checkProjectileWeapon(material);
	}

	public static boolean checkProjectileWeapon(Material material) {
		return material == Material.BOW;
	}

	public static boolean checkMeleeWeapon(Material material) {
		return checkSword(material) || checkAxe(material);
	}

	public static double getProjectileOriginDamage(ItemStack itemStack) {
		if (!checkProjectileWeapon(itemStack.getType()))
			return 0;
		return 10 + itemStack.getEnchantmentLevel(Enchantment.ARROW_DAMAGE) * 2.5;
	}

	public static double getShapenessDamage(int level) {
		return level > 0 ? 0.5 * (level - 1) + 1 : 0;
	}

	public static double getWormAndUndeadDamage(int level) {
		return level * 2.5;
	}

	public static double getItemOriginDamage(Material material) {
		switch (material) {
		case NETHERITE_AXE :
			return 10;
		case IRON_AXE:
		case STONE_AXE:
		case DIAMOND_AXE:
			return 9;
		case WOODEN_AXE:
		case GOLDEN_AXE:
			return 7;
		case IRON_HOE:
		case STONE_HOE:
		case DIAMOND_HOE:
		case WOODEN_HOE:
		case GOLDEN_HOE:
		case NETHERITE_HOE:
			return 1;
		case IRON_SHOVEL:
			return 4.5;
		case NETHERITE_SHOVEL:
			return 6.5;
		case STONE_SHOVEL:
			return 3.5;
		case DIAMOND_SHOVEL:
			return 5.5;
		case WOODEN_SHOVEL:
		case GOLDEN_SHOVEL:
			return 2.5;
		case IRON_PICKAXE:
			return 4;
		case STONE_PICKAXE:
			return 3;
		case DIAMOND_PICKAXE:
			return 5;
		case WOODEN_PICKAXE:
		case GOLDEN_PICKAXE:
			return 2;
		case IRON_SWORD:
		case NETHERITE_PICKAXE:
			return 6;
		case STONE_SWORD:
			return 5;
		case DIAMOND_SWORD:
			return 7;
		case NETHERITE_SWORD :
			return 8;
		case WOODEN_SWORD:
		case GOLDEN_SWORD:
			return 4;
		default:
			return 1;
		}
	}
}
