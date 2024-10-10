package dev.luan.flowers.data;

import java.util.List;

public record FlowerGroupData(List<FlowerData> flowerData, List<Boolean> randomizer, List<Boolean> isGroup) {}