package doublePlugin.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import doublePlugin.event.damageEvent.NewDamageEvent;
import doublePlugin.event.entityEvent.NewEntityEvent;
import doublePlugin.event.joinAndQuit.NewPlayerJoinAndQuitEvent;
import doublePlugin.event.InventoryEvent.NewInventoryEvent;
import doublePlugin.event.actEvent.NewPlayerActEvent;
import doublePlugin.event.blockEvent.NewBlockEvent;

public class MainEvent implements Listener {
    private final NewPlayerJoinAndQuitEvent newPlayerJoinAndQuitEvent = new NewPlayerJoinAndQuitEvent();
    private final NewDamageEvent newDamageEvent = new NewDamageEvent();
    private final NewPlayerActEvent newPlayerActEvent = new NewPlayerActEvent();
    private final NewInventoryEvent newInventoryEvent = new NewInventoryEvent();
    private final NewBlockEvent newBlockEvent = new NewBlockEvent();
    private final NewEntityEvent newEntityEvent = new NewEntityEvent();
    
    
    @EventHandler
    public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
    	newDamageEvent.newEntityDamageByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void playerJoinEvent(PlayerJoinEvent e) {
        newPlayerJoinAndQuitEvent.NewPlayerJoinEvent(e);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerQuitEvent(PlayerQuitEvent e) {
        newPlayerJoinAndQuitEvent.NewPlayerQuitEvent(e);
    }
    
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
    	this.newPlayerActEvent.newPlayerInteractEvent(e);
    }

    @EventHandler
    public void playerDropItemEvent(PlayerDropItemEvent e) {
    	this.newPlayerActEvent.newPlayerDropItemEvent(e);
    }

    @EventHandler
    public void playerSwapHandItemsEvent(PlayerSwapHandItemsEvent e) {
    	this.newPlayerActEvent.newPlayerSwapHandItemsEvent(e);
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent e) {
    	this.newInventoryEvent.newInventoryClickEvent(e);
    }

    @EventHandler
    public void inventoryCloseEvent(InventoryCloseEvent e) {
    	this.newInventoryEvent.newInventoryCloseEvent(e);
    }

    @EventHandler
    public void inventoryOpenEvent(InventoryOpenEvent e) {
    	this.newInventoryEvent.newInventoryOpenEvent(e);
    }
    
    @EventHandler
    public void blockBreakEvent(BlockBreakEvent e) {
    	this.newBlockEvent.newBlockBreakEvent(e);
    }
    
    @EventHandler
    public void blockPlaceEvent(BlockPlaceEvent e) {
    	this.newBlockEvent.newBlockPlaceEvent(e);
    }

    @EventHandler
    public void entityMountEvent(EntityMountEvent e) {
    	this.newEntityEvent.newEntityMountEvent(e);
    }
    @EventHandler
    public void craftItemEvent(CraftItemEvent e) {
    	this.newInventoryEvent.newCraftItemEvent(e);
    }
    
    @EventHandler
    public void entityDamageEvent(EntityDamageEvent e) {
    	this.newDamageEvent.newEntityDamageEvent(e);
    }
    
    @EventHandler
    public void foodLevelChangeEvent(FoodLevelChangeEvent e) {
    	this.newEntityEvent.newFoodLevelChangeEvent(e);
    }
}
