package dev.luan.flowers.flowers.placable;

import dev.luan.flowers.flowers.WaterloggableFlower;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Candle;

@Getter
public final class CandleFlower extends WaterloggableFlower {

    private final boolean isLit;
    private final int candles;

    public CandleFlower(Material display, Material blockMaterial, String displayName, boolean isWaterlogged, boolean isLit, int candles) {
        super(display, blockMaterial, displayName, isWaterlogged);
        this.candles = candles;
        this.isLit = isLit;
    }

    public CandleFlower(Material blockMaterial, String displayName, boolean isWaterlogged, boolean isLit, int candles) {
        super(blockMaterial, displayName, isWaterlogged);
        this.candles = candles;
        this.isLit = isLit;
    }

    @Override
    public void setFlower(Block block) {
        block.setType(this.getBlockMaterial());

        if (block.getBlockData() instanceof Candle candle) {
            candle.setCandles(this.candles);
            candle.setLit(this.isLit);
            candle.setWaterlogged(this.isWaterlogged());
            block.setBlockData(candle);
        }
    }
}