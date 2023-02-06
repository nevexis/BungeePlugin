package dev.nevah5.mc.bungeePlugin.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GlobalChatCommand extends Command {
    public GlobalChatCommand(String command) {
        super(command);
    }

    public void execute(CommandSender commandSender, String[] args){
        if(commandSender instanceof ProxiedPlayer){
            if(commandSender.hasPermission("network.globalchat.hide")) {
                commandSender.sendMessage(new TextComponent(String.format("%s%sServer %s>> %sYou have global chat " +
                        "disabled.",
                        ChatColor.AQUA,
                        ChatColor.BOLD,
                        ChatColor.DARK_GRAY,
                        ChatColor.LIGHT_PURPLE
                )));
            }else{
                String message = String.join(" ", args);
                if(message.equals("")) {
                    commandSender.sendMessage(new TextComponent(String.format("%s%sServer %s>> %s%s",
                            ChatColor.AQUA,
                            ChatColor.BOLD,
                            ChatColor.DARK_GRAY,
                            ChatColor.LIGHT_PURPLE,
                            "Please enter a message. /gc <message>"
                    )));
                    return;
                }
                ProxyServer.getInstance().getPlayers().forEach(p -> {
                    p.sendMessage(new TextComponent(String.format(
                            "%s[%s%sGC%s]%s %s%sAdmin %s%s| %s%s %s>> %s%s",
                            ChatColor.DARK_GRAY,
                            ChatColor.BLUE,
                            ChatColor.BOLD,
                            ChatColor.DARK_GRAY,
                            ChatColor.RESET,
                            ChatColor.RED,
                            ChatColor.BOLD,
                            ChatColor.DARK_GRAY,
                            ChatColor.BOLD,
                            ChatColor.GRAY,
                            commandSender.getName(),
                            ChatColor.DARK_GRAY,
                            ChatColor.RESET,
                            message
                    )));
                });
            }
        }else{
            ProxyServer.getInstance().getLogger().warning("Global Chat has to be run by a player.");
        }
    }
}
