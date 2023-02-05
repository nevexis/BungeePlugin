package dev.nevah5.mc.bungeePlugin.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SettingsCommand extends Command {
    public SettingsCommand() {
        super("settings");
    }

    public void execute(CommandSender commandSender, String[] args){
        if(commandSender instanceof ProxiedPlayer){
            String joinedArgs = String.join(" ", args);
            switch (joinedArgs){
                case "globalchat off":
                    //TODO: functionality
                    break;
                default:
                    commandSender.sendMessage(new TextComponent(String.format("%s%sServer %s>> %sIncomplete command.",
                            ChatColor.AQUA,
                            ChatColor.BOLD,
                            ChatColor.DARK_GRAY,
                            ChatColor.LIGHT_PURPLE
                    )));
            }
        }else{
            ProxyServer.getInstance().getLogger().warning("Settings command has to be run by a player.");
        }
    }
}
