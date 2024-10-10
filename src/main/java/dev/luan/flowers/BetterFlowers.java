package dev.luan.flowers;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class BetterFlowers extends JavaPlugin {

    @Override
    public void onEnable() {


        registerCommands();
        registerListener();
    }

    private void registerCommands() {

    }

    private void registerListener() {

    }
}
