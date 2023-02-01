package dev.nevah5.mc.bungee_plugin_template;

import net.md_5.bungee.api.plugin.Plugin;

public class PluginClass extends Plugin {
    @Override
    public void onEnable(){
        getLogger().info("Yay! It loads!");
    }

//    @EventHandler
//    public void onPostLogin(PostLoginEvent event) {
//        event.getPlayer().sendMessage(new TextComponent("Example"));
//    }
}
