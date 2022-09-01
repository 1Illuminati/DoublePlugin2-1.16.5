package doublePlugin.event.entityEvent;

import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.spigotmc.event.entity.EntityMountEvent;

import doublePlugin.properties.PropertiesEnum;
import doublePlugin.properties.ServerProperties;

public class NewEntityEvent {
    public void newEntityMountEvent(EntityMountEvent event) {
        boolean check = ServerProperties.get(PropertiesEnum.RIDING);

        if(!check) {
            event.setCancelled(true);
        }
    }
    
    public void newEntityBreedEvent(EntityBreedEvent event) {
    	boolean check = ServerProperties.get(PropertiesEnum.SEX);

        if(!check) {
            event.setCancelled(true);
        }
    }
    
    public void newFoodLevelChangeEvent(FoodLevelChangeEvent event) {
    	boolean check = ServerProperties.get(PropertiesEnum.HUNGRY);

        if(!check) {
        	if(event.getFoodLevel() < 20) {
        		event.setFoodLevel(20);
        	}
        }
    }
}
