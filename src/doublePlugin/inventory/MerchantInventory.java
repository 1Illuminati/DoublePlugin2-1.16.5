package doublePlugin.inventory;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import doublePlugin.entity.player.NewPlayer;

public class MerchantInventory {
    private HashMap<String, MerchantRecipe> merchantRecipeMap = new HashMap<>();
	private Merchant merchant;
	
	public MerchantInventory(String name) {
		merchant = Bukkit.createMerchant(name);
	}

	public void setMerchantRecipe(String tradeName, ItemStack resultItem, int tradeNum) {
		setMerchantRecipe(tradeName, resultItem, 1, tradeNum);
	}
	
	public void setMerchantRecipe(String tradeName, ItemStack resultItem, int itemAmount, int tradeNum) {
		ItemStack newResultItem = resultItem.clone();
		newResultItem.setAmount(itemAmount);
		MerchantRecipe merchantRecipe = new MerchantRecipe(newResultItem, tradeNum);
		merchantRecipeMap.put(tradeName, merchantRecipe);
	}

	public void addIngredient(String tradeName, ItemStack tradeItem) {
		addIngredient(tradeName, tradeItem, 1);
	}
	
	public void addIngredient(String tradeName, ItemStack tradeItem, int itemAmount) {
		ItemStack newTradeItem = tradeItem.clone();
		newTradeItem.setAmount(itemAmount);
		merchantRecipeMap.get(tradeName).addIngredient(newTradeItem);
	}
	
	public void openMerchantInventory(NewPlayer p) {
		merchant.setRecipes(getMapToList());
		
		p.openMerchant(merchant, true);
	}

	private List<MerchantRecipe> getMapToList() {
		return (List<MerchantRecipe>) merchantRecipeMap.values();
	}
}
