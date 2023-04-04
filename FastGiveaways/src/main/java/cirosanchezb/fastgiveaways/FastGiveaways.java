package cirosanchezb.fastgiveaways;

import cirosanchezb.fastgiveaways.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FastGiveaways extends JavaPlugin {

    Configuration config = getConfig();
    public static String prefix;
    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("fg").setExecutor(new CommandManager(this));
        prefix = config.getString("prefix");
        // Message
        onEnableMessage();
    }

    @Override
    public void onDisable() {

        // Message
        onDisableMessage();
    }

    public void onEnableMessage(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f--------------->&d&l[Fast Giveaways]&f<---------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Volt &fDevelopment Plugin"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fMore info: &9dsc.gg/voltdev"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fPlugin: &aEnabled"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f--------------->&d&l[Fast Giveaways]&f<---------------"));
    }

    public void onDisableMessage(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f--------------->&d&l[Fast Giveaways]&f<---------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Volt &fDevelopment Plugin"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fMore info: &9dsc.gg/voltdev"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fPlugin: &cDisabled"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f--------------->&d&l[Fast Giveaways]&f<---------------"));
    }

    public Configuration Config(){
        return config;
    }
}
