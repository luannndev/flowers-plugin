package dev.luan.flowers.commands;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.managers.LanguageManager;
import dev.luan.flowers.menus.FlowerBrushMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public record FlowerBrush(BetterFlowers betterFlowers) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return true;
        if (!player.hasPermission("betterflowers.use")) {
            LanguageManager.sendPlayerMessage(player, "permission.use.error");
            return true;
        }

        new FlowerBrushMenu(betterFlowers, player, false).open();
        return false;
    }
}