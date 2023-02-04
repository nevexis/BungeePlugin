package dev.nevah5.mc.bungee_plugin;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BungeePlugin extends Plugin implements Listener {
    @Override
    public void onEnable(){
        getProxy().getPluginManager().registerListener(this, this);
        getLogger().info("Yay! It loads!");
    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxyServer.getInstance().broadcast(new TextComponent(event.getPlayer().getName() + " has joined the network!"));
        getLogger().info(event.getPlayer().getName() + " joined mc.nevah5.dev");
    }
}
