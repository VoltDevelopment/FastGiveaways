package cirosanchezb.fastgiveaways.commands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class NumberSubCommand extends SubCommand {
    Configuration config;
    String prefix;
    List<String> winnerNumber;
    public NumberSubCommand(Plugin plugin) {
        super();
        this.config = plugin.getConfig();
        this.prefix = ChatColor.translateAlternateColorCodes('&', config.getString("prefix"));
        this.winnerNumber = config.getStringList("messages.winnerNumber");
    }

    @Override
    public String getName() {
        return "number";
    }

    @Override
    public String getDescription() {
        return "Make a giveaway till number is said";
    }

    @Override
    public String getSyntax() {
        return "/fg number <Number> <Item>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length > 1){

        } else if (args.length == 1) {
            player.sendMessage(prefix+ChatColor.RED+" Usage: /fg number <Number> <Item>");
        }
    }
}
