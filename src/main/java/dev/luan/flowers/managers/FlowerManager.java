package dev.luan.flowers.managers;

import dev.luan.flowers.data.BrushData;
import dev.luan.flowers.data.FlowerGroupData;
import dev.luan.flowers.data.Operation;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public final class FlowerManager {

    private final Map<ItemStack, FlowerGroupData> flowers;
    private final Map<ItemStack, BrushData> brushes;
    private final Map<UUID, List<Operation>> operationHistory;

    public FlowerManager() {
        this.flowers = new HashMap<>();
        this.brushes = new HashMap<>();
        this.operationHistory = new HashMap<>();
    }
}