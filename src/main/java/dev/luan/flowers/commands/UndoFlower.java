package dev.luan.flowers.commands;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.data.Operation;
import dev.luan.flowers.managers.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public record UndoFlower(BetterFlowers betterFlowers) implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return true;
        if (!player.hasPermission("betterflowers.undo")) {
            LanguageManager.sendPlayerMessage(player, "permission.undo.error");
            return true;
        }

        var undoPlayer = player;
        int undoTimes = 1;

        if (args.length > 2) {
            LanguageManager.sendPlayerMessage(player, "command.undo.cross");
            return true;
        }

        for (var argument : Arrays.stream(args).toList()) {
            if (isPositiveNumber(argument)) undoTimes = Integer.parseInt(argument);
            if (getPlayer(argument).isPresent()) undoPlayer = getPlayer(argument).get();
        }

        final var operationHistories =  betterFlowers.getFlowerManager().getOperationHistory();
        final var uuid = undoPlayer.getUniqueId();

        if (!operationHistories.containsKey(uuid) || operationHistories.get(uuid).isEmpty()) {

            LanguageManager.sendPlayerMessage(player,"command.undo.nothing");
            return true;
        }

        var history = new ArrayList<>(List.copyOf(operationHistories.get(uuid)));
        var undo = new ArrayList<Operation>();

        for (int index = 0; index < undoTimes; index++) {
            if (index >= history.size()) break;

            var currentOperation = history.get((history.size() - index) - 1);

            if (currentOperation.world() == null) {
                LanguageManager.sendPlayerMessage(player,"command.undo.wrong.world");
                break;
            }

            currentOperation.originalBlocks().forEach((vector, blockData) ->
                    currentOperation.world().setBlockData(vector.toLocation(currentOperation.world()), blockData));

            undo.add(currentOperation);
        }

        history.removeAll(undo);
        operationHistories.put(undoPlayer.getUniqueId(), history);
        LanguageManager.sendPlayerMessage(player,"command.undo.successful");
        return false;
    }

    private boolean isPositiveNumber(String string) {

        try  {

            final var value = Integer.parseInt(string);
            return value > 0;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private Optional<Player> getPlayer(String string) {

        for (var player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(string)) return Optional.of(player);
        }

        return Optional.empty();
    }
}