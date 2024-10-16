package dev.luan.flowers;

import dev.luan.flowers.commands.Flower;
import dev.luan.flowers.commands.FlowerBrush;
import dev.luan.flowers.commands.UndoFlower;
import dev.luan.flowers.listeners.*;
import dev.luan.flowers.managers.FlowerManager;
import dev.luan.flowers.managers.LanguageManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@Getter
public final class BetterFlowers extends JavaPlugin {

    private final FlowerManager flowerManager;

    public BetterFlowers() {
        this.flowerManager = new FlowerManager();
    }

    @Override
    public void onEnable() {

        LanguageManager.readConfig();

        registerCommands();
        registerListener();
    }

    private void registerCommands() {
        final var flowerCommand = getCommand("flower");
        if (flowerCommand != null) {
            flowerCommand.setAliases(List.of("f", "F"));
            flowerCommand.setExecutor(new Flower(this));
        }

        final var flowerBrushCommand = getCommand("flowerbrush");
        if (flowerBrushCommand != null) {
            flowerBrushCommand.setAliases(List.of("fb", "Fb", "fB", "FB"));
            flowerBrushCommand.setExecutor(new FlowerBrush(this));
        }

        final var undoFlowerCommand = getCommand("undoflower");
        if (undoFlowerCommand != null) {
            undoFlowerCommand.setAliases(List.of("uf", "Uf", "uF", "UF"));
            undoFlowerCommand.setExecutor(new UndoFlower(this));
        }
    }

    private void registerListener() {

        final var pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new FlowerToolInteractionListener(this), this);
        pluginManager.registerEvents(new FlowerPlacerOpenListener(this), this);
        pluginManager.registerEvents(new FlowerPlacerUseListener(this), this);
        pluginManager.registerEvents(new FlowerBrushOpenListener(this), this);
        pluginManager.registerEvents(new FlowerBrushUseListener(this), this);
    }
}
