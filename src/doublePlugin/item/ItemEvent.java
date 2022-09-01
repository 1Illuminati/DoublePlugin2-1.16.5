package doublePlugin.item;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import doublePlugin.entity.player.NewPlayer;

public abstract class ItemEvent {
    private final static HashMap<String, ItemEvent> itemEventMap = new HashMap<>();
    public static ItemEvent getItemEvent(ItemStack itemStack) {
        for(ItemEvent itemEvent : itemEventMap.values()) {
            if(itemEvent.checkItem(itemStack)) {
                return itemEvent;
            }
        }

        return null;
    }
    
    public static ItemEvent getItemEvent(String code) {
    	return itemEventMap.get(code);
    }

    public ItemEvent() {
        itemEventMap.put(getCode(), this);
    }
    
    public abstract String getCode();
    
    public abstract boolean leftClick(NewPlayer p);
	
    public abstract boolean rightClick(NewPlayer p);

    public abstract boolean swapHand(NewPlayer p);

    public abstract boolean dropItem(NewPlayer p);


    public abstract boolean shiftLeftClick(NewPlayer p);

    public abstract boolean shiftRightClick(NewPlayer p);

    public abstract boolean shiftSwapHand(NewPlayer p);

    public abstract boolean shiftDropItem(NewPlayer p);


    public abstract boolean checkItem(ItemStack itemStack);
}
