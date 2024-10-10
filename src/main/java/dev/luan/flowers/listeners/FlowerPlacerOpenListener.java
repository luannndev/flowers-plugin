package dev.luan.flowers.listeners;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.events.FlowerPlacerInteractionEvent;
import dev.luan.flowers.events.types.FlowerInteractionTypes;
import dev.luan.flowers.menus.FlowerCreationMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public record FlowerPlacerOpenListener(BetterFlowers betterFlowers) implements Listener {

    @EventHandler
    public void onFlowerPlacerOpenListener(FlowerPlacerInteractionEvent flowerPlacerInteractionEvent) {
        if (flowerPlacerInteractionEvent.getFlowerTool() != FlowerInteractionTypes.OPEN) return;
        new FlowerCreationMenu(flowerPlacerInteractionEvent.getPlayer(), betterFlowers, flowerPlacerInteractionEvent.getFlowerGroupData(), true).open();
    }
}