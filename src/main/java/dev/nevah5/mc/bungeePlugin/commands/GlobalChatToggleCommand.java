package dev.nevah5.mc.bungeePlugin.commands;

import dev.nevah5.mc.bungeePlugin.BungeePlugin;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.data.DataType;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PermissionNode;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.UUID;

public class GlobalChatToggleCommand extends Command {
    private final BungeePlugin bungeePlugin;
    public GlobalChatToggleCommand(BungeePlugin bungeePlugin) {
        super("gctoggle");
        this.bungeePlugin = bungeePlugin;
    }

    public void execute(CommandSender commandSender, String[] args){
        if(commandSender instanceof ProxiedPlayer){
            if(commandSender.hasPermission("network.globalchat.hide")) {
                updateUserPermissions(
                        ((ProxiedPlayer) commandSender).getUniqueId(),
                        "network.globalchat.hide",
                        true
                );
                commandSender.sendMessage(new TextComponent(String.format("%s%sServer %s>> %s%s",
                        ChatColor.AQUA,
                        ChatColor.BOLD,
                        ChatColor.DARK_GRAY,
                        ChatColor.LIGHT_PURPLE,
                        "Global Chat is shown again."
                )));
            }else{
                updateUserPermissions(
                        ((ProxiedPlayer) commandSender).getUniqueId(),
                        "network.globalchat.hide"
                );
                commandSender.sendMessage(new TextComponent(String.format("%s%sServer %s>> %s%s",
                        ChatColor.AQUA,
                        ChatColor.BOLD,
                        ChatColor.DARK_GRAY,
                        ChatColor.LIGHT_PURPLE,
                        "Global Chat is not shown anymore."
                )));
            }
        }else{
            ProxyServer.getInstance().getLogger().warning("Settings command has to be run by a player.");
        }
    }

    /**
     * Updates the permissions of a user
     * @param uuid the unique user id of the player
     * @param permission the permissions you want to target
     * @param remove boolean if you want to remove the permissions from the user
     */
    public void updateUserPermissions(UUID uuid, String permission, boolean remove){
        LuckPerms luckPerms = bungeePlugin.getLuckPerms();
        User user = luckPerms.getUserManager().getUser(uuid);
        if(user == null) return;
        if(remove){
            user.getData(DataType.NORMAL).remove(PermissionNode.builder(permission).build());
        }else{
            user.getData(DataType.NORMAL).add(PermissionNode.builder(permission).build());
        }
        luckPerms.getUserManager().saveUser(user);
    }

    /**
     * Updates the permissions of a user
     * @param uuid the unique user id of the player
     * @param permission the permissions you want to target
     */
    public void updateUserPermissions(UUID uuid, String permission){
        LuckPerms luckPerms = bungeePlugin.getLuckPerms();
        User user = luckPerms.getUserManager().getUser(uuid);
        if(user == null) return;
        user.getData(DataType.NORMAL).add(PermissionNode.builder(permission).build());
        luckPerms.getUserManager().saveUser(user);
    }
}
