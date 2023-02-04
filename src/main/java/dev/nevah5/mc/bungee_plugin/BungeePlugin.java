package dev.nevah5.mc.bungee_plugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.util.Optional;

public class BungeePlugin extends Plugin implements Listener {
    @Override
    public void onEnable(){
        getProxy().getPluginManager().registerListener(this, this);
        getLogger().info("Yay! It loads!");
    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        player.setTabHeader(
                new TextComponent(String.format("\n         %sᐅ %s%smc.nevah5.dev %sᐊ         \n\n",
                        ChatColor.GRAY, ChatColor.BLUE,
                        ChatColor.BOLD, ChatColor.GRAY
                )),
                new TextComponent(String.format("\n          %s%sServer:%s  %s          \n\n", ChatColor.YELLOW,
                        ChatColor.BOLD, ChatColor.GRAY,
                        "servername"
                ))
        );
    }
}
