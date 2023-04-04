package cirosanchezb.fastgiveaways.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

import static cirosanchezb.fastgiveaways.FastGiveaways.prefix;

public class CommandManager implements CommandExecutor {
    private ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager(Plugin plugin){
        subCommands.add(new RandomSubCommand(plugin));
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (strings.length > 0){
                for (int i = 0; i < subCommands.size(); i++){
                    if (strings[i].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(player, strings);
                    }
                }
            } else if (strings.length == 0){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.WHITE+"   Help Page"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/fg help: &fShows this page."));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/fg random <Item>: &fStarts a random giveaway"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/fg number <Item> <Number>: &fStarts a number giveaway."));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/fg timed <Item> <Time>: &fStarts a timed giveaway"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/fg reload: &fReloads the plugin config."));
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubCommands(){
        return subCommands;
    }
}
