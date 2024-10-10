package dev.luan.flowers.flowers.placable;

import dev.luan.flowers.flowers.AgebleFlower;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;

public final class AgeFlower extends AgebleFlower {

    public AgeFlower(Material display, Material blockMaterial, String displayName, int age) {
        super(display, blockMaterial, displayName, age);
    }

    public AgeFlower(Material blockMaterial, String displayName, int age) {
        super(blockMaterial, displayName, age);
    }

    @Override
    public void setFlower(Block block) {
        block.setType(this.getBlockMaterial());

        if (block.getBlockData() instanceof Ageable ageable) {
            ageable.setAge(this.getAge());
            block.setBlockData(ageable);
        }
    }
}