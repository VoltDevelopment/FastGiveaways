package cirosanchezb.fastgiveaways.commands;

import org.bukkit.entity.Player;

public class TimedSubCommand extends SubCommand {
    @Override
    public String getName() {
        return "timed";
    }

    @Override
    public String getDescription() {
        return "Make a timed giveaway";
    }

    @Override    public String getSyntax() {
        return "/fg timed <time> <Item>";
    }

    @Override
    public void perform(Player player, String[] args) {




    }
}
