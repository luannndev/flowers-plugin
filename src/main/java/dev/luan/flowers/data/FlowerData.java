package dev.luan.flowers.data;

import dev.luan.flowers.flowers.SingleFlower;
import lombok.Getter;
import org.bukkit.Material;

import java.util.List;
import java.util.Random;

@Getter
public final class FlowerData {

    private final List<SingleFlower> flowers;
    private final String name;
    private final Material display;

    public FlowerData(SingleFlower singleFlower) {
        this.flowers = List.of(singleFlower);
        this.name = singleFlower.getDisplayName();
        this.display = singleFlower.getDisplay();
    }

    public FlowerData(List<SingleFlower> singleFlowers, String string, Material display) {
        this.flowers = singleFlowers;
        name = string;
        this.display = display;
    }

    public SingleFlower getSingleFlower() {
        return flowers.get(new Random().nextInt(flowers.size()));
    }
}
