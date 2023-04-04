package cirosanchezb.fastgiveaways.commands;

import cirosanchezb.fastgiveaways.FastGiveaways;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomSubCommand extends SubCommand{
    Configuration config;
    String prefix;
    List<String> winnerRandom;
    public RandomSubCommand(Plugin plugin) {
        super();
        this.config = plugin.getConfig();
        this.prefix = ChatColor.translateAlternateColorCodes('&', config.getString("prefix"));
        this.winnerRandom = config.getStringList("messages.winnerRandom");
    }
    @Override
    public String getName() {

        return "Random";
    }

    @Override
    public String getDescription() {

        return "Starts a random Giveaway";
    }

    @Override
    public String getSyntax() {

        return "/fg random <Item>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length > 1){
            String item = args[1];
            player.sendMessage(prefix+ChatColor.WHITE+" Started random giveaway for: "+ChatColor.translateAlternateColorCodes('&', item));

            ArrayList<String> allPlayers = new ArrayList<String>();
            for(Player players : Bukkit.getOnlinePlayers()) {
                allPlayers.add(players.getName());
            }

            Random random = new Random();
            int number = random.nextInt(allPlayers.size());
            String targett = allPlayers.get(number);

            ArrayList<String> winnerMessages = new ArrayList<>();
            for (String message : winnerRandom) {
                if (message.contains("%player%")) { // Check if message contains '%player%'
                    message = message.replace("%player%", targett); // Replace '%player%' with target's name
                }
                if (message.contains("%item%")) { // Check if message contains '%item%'
                    message = message.replace("%item%", item); // Replace '%item%' with the item's type
                }
                winnerMessages.add(message);
            }

            for (int i = 0; i < winnerMessages.size(); i++){
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', winnerMessages.get(i)));
            }

        } else if (args.length == 1){
            player.sendMessage(prefix+ChatColor.RED+" Usage: /fg random <Item>");
        }
    }
}
