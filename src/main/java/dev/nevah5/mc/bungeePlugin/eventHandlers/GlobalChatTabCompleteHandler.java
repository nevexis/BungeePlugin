package dev.nevah5.mc.bungeePlugin.eventHandlers;

import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

@Deprecated
public class GlobalChatTabCompleteHandler implements Listener {
    @EventHandler
    public void onTabComplete(TabCompleteEvent tabCompleteEvent){
        String cursor = tabCompleteEvent.getCursor().toLowerCase();
        if(!(cursor.startsWith("/gc") || cursor.startsWith("/globalchat"))) return;
        tabCompleteEvent.setCancelled(true);
        tabCompleteEvent.getSuggestions().add("<message>");
    }
}
