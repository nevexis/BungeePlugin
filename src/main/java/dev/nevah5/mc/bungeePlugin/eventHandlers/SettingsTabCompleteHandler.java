package dev.nevah5.mc.bungeePlugin.eventHandlers;

import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class SettingsTabCompleteHandler implements Listener {
    @EventHandler
    public void onTabComplete(TabCompleteEvent tabCompleteEvent){
        String cursor = tabCompleteEvent.getCursor().toLowerCase();
        if(!cursor.startsWith("/settings ")) return;
        String[] args = cursor.split(" ");
        if(args.length == 1) tabCompleteEvent.getSuggestions().add("globalchat");
        if(args.length == 2) tabCompleteEvent.getSuggestions().add("toggle");
    }
}
