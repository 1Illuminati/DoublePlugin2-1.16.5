package doublePlugin.event.chatEvent;

import doublePlugin.entity.player.NewPlayer;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class NewPlayerChatEvent {
    public void newAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        NewPlayer player = NewPlayer.getNewPlayer(event.getPlayer());

        if(player.getScannerRunnable() != null) {
            event.setCancelled(true);
            player.getScannerRunnable().run(event.getMessage());
            player.scannerPlayer(null);
        }
    }
}
