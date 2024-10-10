package dev.luan.flowers.commands;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.managers.LanguageManager;
import dev.luan.flowers.menus.FlowerCreationMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record Flower(BetterFlowers betterFlowers) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player player)) return true;
        if (!player.hasPermission("betterflowers.use")) {
            LanguageManager.sendPlayerMessage(player, "permission.use.error");
            return true;
        }

        new FlowerCreationMenu(player, betterFlowers, false).open();
        return false;
    }
}