package dev.luan.flowers.listeners;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.data.Operation;
import dev.luan.flowers.events.FlowerPlacerInteractionEvent;
import dev.luan.flowers.events.types.FlowerInteractionTypes;
import dev.luan.flowers.managers.FlowerManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class FlowerPlacerUseListener implements Listener {

    private final FlowerManager flowerManager;
    private final List<Block> flowerBlocks;

    public FlowerPlacerUseListener(BetterFlowers betterFlowers) {
        this.flowerManager = betterFlowers.getFlowerManager();
        this.flowerBlocks = new ArrayList<>();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onFlowerPlacerInteractionEvent(FlowerPlacerInteractionEvent flowerPlacerInteractionEvent) {
        if (flowerPlacerInteractionEvent.getFlowerTool() != FlowerInteractionTypes.USE) return;
        System.out.println("Called Event");

        final var player = flowerPlacerInteractionEvent.getPlayer();
        final var interactionPoint = flowerPlacerInteractionEvent.getInteractionPoint();
        final var oldBlocks = new HashMap<Vector, BlockData>();

        handleFlowerPlacement(flowerPlacerInteractionEvent, oldBlocks, interactionPoint);
        handleFlowerHistory(flowerPlacerInteractionEvent, oldBlocks);
        player.playSound(interactionPoint, Sound.BLOCK_AMETHYST_BLOCK_RESONATE, 1, 0);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onCustomFlowerPlaceEvent(BlockPhysicsEvent blockPhysicsEvent) {
        var currentBlock = blockPhysicsEvent.getBlock();
        if (flowerBlocks.contains(currentBlock)) blockPhysicsEvent.setCancelled(true);
    }

    private void handleFlowerPlacement(FlowerPlacerInteractionEvent flowerPlacerInteractionEvent, HashMap<Vector, BlockData> oldBlocks, Location currentLocation) {

        final var player = flowerPlacerInteractionEvent.getPlayer();
        final var flowerGroupData = flowerPlacerInteractionEvent.getFlowerGroupData();
        final var flowers = flowerGroupData.flowerData();
        final var values = flowerGroupData.randomizer();
        final var offset = playerLookUp(player) ? -1 : 1;
        if (playerLookUp(player)) currentLocation.add(0, -1, 0);

        for (int i = 0; i < flowers.size(); i++) {
            if (values.get(i) && new Random().nextBoolean()) continue;

            final var currentBlock = currentLocation.getBlock();
            oldBlocks.put(currentBlock.getLocation().toVector(), currentBlock.getBlockData());

            flowerBlocks.add(currentBlock);
            flowers.get(i).getSingleFlower().setFlower(currentBlock);
            currentLocation.add(0, offset, 0);
        }
    }

    private void handleFlowerHistory(FlowerPlacerInteractionEvent flowerPlacerInteractionEvent, HashMap<Vector, BlockData> oldBlocks) {

        final var history = new Operation(oldBlocks, flowerPlacerInteractionEvent.getInteractionPoint().getWorld());
        final var uuid = flowerPlacerInteractionEvent.getPlayer().getUniqueId();

        if (flowerManager.getOperationHistory().containsKey(uuid)) {
            var copy = new ArrayList<>(List.copyOf(flowerManager.getOperationHistory().get(uuid)));
            copy.add(history);

            flowerManager.getOperationHistory().put(uuid, copy);
        } else flowerManager.getOperationHistory().put(uuid, List.of(history));
    }

    private boolean playerLookUp(Player player) {
        return player.getPitch() < 0.0F;
    }
}