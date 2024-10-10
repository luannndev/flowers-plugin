package dev.luan.flowers.listeners;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.events.FlowerBrushInteractionEvent;
import dev.luan.flowers.events.types.FlowerInteractionTypes;
import dev.luan.flowers.menus.FlowerBrushMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public record FlowerBrushOpenListener(BetterFlowers betterFlowers) implements Listener {

    @EventHandler
    public void onFlowerBrushInteractionEvent(FlowerBrushInteractionEvent flowerBrushInteractionEvent) {
        if (flowerBrushInteractionEvent.getFlowerTool() != FlowerInteractionTypes.OPEN) return;
        new FlowerBrushMenu(betterFlowers, flowerBrushInteractionEvent.getPlayer(), flowerBrushInteractionEvent.getBrushData(), true).open();
    }
}