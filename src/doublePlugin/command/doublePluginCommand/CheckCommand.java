package doublePlugin.command.doublePluginCommand;

import doublePlugin.DoublePlugin;
import doublePlugin.command.CommandNameList;
import doublePlugin.command.MessageList;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.util.map.InfoMaps;
import doublePlugin.util.map.ServerInfoMaps;

public class CheckCommand {

    public void checkCommand(String[] args, NewPlayer sender) {

        if(args.length < 3) {
            sender.sendMessage(MessageList.ERROR_CHECK_EXAMPLE);
            return;
        }

        String target = args[0];
        String type = args[1];
        String key = args[2];
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
        
        checkInfoMaps(sender, infoMaps, type, key);
    }
    
    private void checkInfoMaps(NewPlayer sender, InfoMaps infoMaps, String Type, String key) {
    	switch(Type) {
	        case CommandNameList.DOUBLE :
	            sender.sendMessage((infoMaps.containsDoubleValue(key) ? 
	            "" + infoMaps.getDoubleValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.INTEGER :
	            sender.sendMessage((infoMaps.containsIntegerValue(key) ? 
	            "" + infoMaps.getIntegerValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.ITEMSTACK :
	            if(infoMaps.containsItemStackValue(key)) {
	                sender.getInventory().addItem(infoMaps.getItemStackValue(key));
	            } else {
	                sender.sendMessage(MessageList.ERROR_DATA_KEY);
	            }
	        break;
	        case CommandNameList.LONG :
	            sender.sendMessage((infoMaps.containsLongValue(key) ? 
	            "" + infoMaps.getLongValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.STRING :
	            sender.sendMessage((infoMaps.containsStringValue(key) ? 
	            "" + infoMaps.getStringValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.BOOLEAN :
	            sender.sendMessage((infoMaps.containsBooleanValue(key) ? 
	            "" + infoMaps.getBooleanValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.LOCATION :
	            sender.sendMessage((infoMaps.containsLocationValue(key) ? 
	            "" + infoMaps.getLocationValue(key) : MessageList.ERROR_DATA_KEY));
	        break;
	        case CommandNameList.INVENTORY :
	            if(infoMaps.containsInventoryValue(key)) {
	                sender.openInventory(infoMaps.getInventoryValue(key));
	            } else {
	                sender.sendMessage(MessageList.ERROR_DATA_KEY);
	            }
	        break;
	        default :
	            sender.sendMessage(MessageList.ERROR_DATA_TYPE);
    	}
    	DoublePlugin.sendLog(sender.getUniqueIdtoString() + " useCommand /check " + infoMaps.getFileLoc() + "." + Type + " " + key);
    }
}
