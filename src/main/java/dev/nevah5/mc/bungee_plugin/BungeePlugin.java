package dev.nevah5.mc.bungee_plugin;

import dev.nevah5.mc.bungee_plugin.commands.GlobalChatCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BungeePlugin extends Plugin implements Listener {
    @Override
    public void onEnable(){
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerCommand(this, new GlobalChatCommand("gc"));
        getProxy().getPluginManager().registerCommand(this, new GlobalChatCommand("globalchat"));
        getLogger().info("Loaded!");
    }

    @EventHandler
    public void onPostLogin(ServerConnectedEvent event) {
        ProxiedPlayer player = event.getPlayer();
        player.setTabHeader(
                new TextComponent(String.format("\n         %sᐅ %s%smc.nevah5.dev %sᐊ         \n\n",
                        ChatColor.GRAY, ChatColor.BLUE,
                        ChatColor.BOLD, ChatColor.GRAY
                )),
                new TextComponent(String.format("\n          %s%sServer:%s  %s          \n\n", ChatColor.YELLOW,
                        ChatColor.BOLD, ChatColor.GRAY,
                        event.getServer().getInfo().getName()
                ))
        );
    }
}
