package doublePlugin.command.doublePluginCommand;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import doublePlugin.DoublePlugin;
import doublePlugin.command.CommandNameList;
import doublePlugin.command.MessageList;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.item.ItemBuilder;
import doublePlugin.util.map.InfoMaps;
import doublePlugin.util.map.ServerInfoMaps;

public class ModifyCommand {

    public void modifyCommand(String[] args, NewPlayer sender) {

        if(args.length < 4) {
            sender.sendMessage(MessageList.ERROR_MODIFY_EXAMPLE);
            return;
        }

        String target = args[0];
        String type = args[1];
        String key = args[2];
        String value = args[3];
        InfoMaps infoMaps;
        if(target.equals(CommandNameList.SERVER)) {
        	infoMaps = ServerInfoMaps.getServerInfoMaps();
        } else {
        	
        	NewPlayer player = NewPlayer.getNewPlayerByName(target);
        	if(player == null) {
        		sender.sendMessage(MessageList.ERROR_NOT_PLAYER);
        		return;
        	}
        	infoMaps = player.getPlayerInfoMaps();
        }
        modifyInfoMaps(sender, infoMaps, type, key, value);
    }
    
    private void modifyInfoMaps(NewPlayer sender, InfoMaps infoMaps, String type, String key, String value) {
    	try{
            switch(type) {
                case CommandNameList.DOUBLE :
                	infoMaps.setDoubleValue(key, Double.valueOf(value)); 
                break;
                case CommandNameList.INTEGER :
                	infoMaps.setIntegerValue(key, Integer.valueOf(value));
                break;
                case CommandNameList.ITEMSTACK :
                    ItemStack modfiyItem = sender.getItemInHand();
                    infoMaps.setItemStackValue(key, modfiyItem == null ? new ItemStack(Material.AIR) : new ItemBuilder(modfiyItem.clone()).setAmount(Integer.valueOf(value)).make());
                break;
                case CommandNameList.LONG :
                	infoMaps.setLongValue(key, Long.valueOf(value));
                break;
                case CommandNameList.STRING :
                	infoMaps.setStringValue(key, value);
                break;
                case CommandNameList.BOOLEAN :
                	infoMaps.setBooleanValue(key, Boolean.valueOf(value));
                break;
                case CommandNameList.LOCATION :
                	infoMaps.setLocationValue(key, sender.getLocation());
                break;
                case CommandNameList.INVENTORY :
                break;
                default :
                    sender.sendMessage(MessageList.ERROR_DATA_TYPE);
                return;
            }
        } catch(ClassCastException e) {
            sender.sendMessage(MessageList.ERROR_CLASS_CAST);
            return;
        }
    	
    	DoublePlugin.sendLog(sender.getUniqueIdtoString() + " useCommand /modify " + infoMaps.getFileLoc() + "." + type + " " + key + " " + value);
    	sender.sendMessage(MessageList.COMPLETE_MODIFY);
    }
}
