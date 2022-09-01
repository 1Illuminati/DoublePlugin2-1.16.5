package doublePlugin.command;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import doublePlugin.DoublePlugin;
import doublePlugin.command.doublePluginCommand.CheckCommand;
import doublePlugin.command.doublePluginCommand.ModifyCommand;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.item.skull.GetSkull;
import doublePlugin.item.startItem.StartItemInv;
import doublePlugin.properties.PropertiesInv;
import doublePlugin.util.DoubleUtil;
import net.minecraft.server.v1_16_R3.EnumItemSlot;

public class MainCommand implements CommandExecutor {
	CheckCommand checkCommand = new CheckCommand();
	ModifyCommand modifyCommand = new ModifyCommand();

	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if(!(commandSender instanceof Player)) {
			return true;
		}
		NewPlayer sender = NewPlayer.getNewPlayer((Player) commandSender);
		
		switch(command.getName()) {
			case CommandNameList.CHECK :
				checkCommand.checkCommand(args, sender);
            break;
            case CommandNameList.MODIFY :
				modifyCommand.modifyCommand(args, sender);
            break;
			case CommandNameList.SKULL :
				skullCommand(args, sender);
			break;
			case CommandNameList.PROPERTIES :
				propertiesCommand(sender);
			break;
			case CommandNameList.START_ITEM :
				startItemCommand(sender);
			break;
			case CommandNameList.TEST :
				test(sender, args[0]);
			break;
		}
		return true;
	}
	
	private void test(NewPlayer sender, String uuid) {
		Bukkit.broadcastMessage(DoubleUtil.getTextureByUUID(UUID.fromString(uuid)));
		Bukkit.broadcastMessage(DoubleUtil.getSkinUrl(uuid));
	}

	private void startItemCommand(NewPlayer sender) {
		if(sender.getBooleanValue(DoublePlugin.pluginName + "기본템")) {
			sender.sendMessage("§4이미 기본템을 지급 받으셨습니다!");
			return;
		}
		
		for(ItemStack item : StartItemInv.getStartItem()) {
			sender.getInventory().addItem(item);
		}
		sender.setBooleanValue(DoublePlugin.pluginName + "기본템", true);
	}
	
	private void propertiesCommand(NewPlayer sender) {
		PropertiesInv.openInv(sender);
	}

	private void skullCommand(String[] args, NewPlayer sender) {
		if(args.length < 1) {
			sender.sendMessage("§4/skull [texture]");
			return;
		}

		String texture = args[0];
		sender.getPlayer().getInventory().addItem(GetSkull.getSkull(texture));
	}
}
