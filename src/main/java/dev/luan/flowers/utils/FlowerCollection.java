package dev.luan.flowers.utils;

import dev.luan.flowers.flowers.placable.*;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Bamboo;

import java.util.List;

@Getter
public enum FlowerCollection {

    BAMBOO(new FlowerGroup(Material.BAMBOO, "Bamboo", List.of(
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:0;LEAVES:NONE]", 0, Bamboo.Leaves.NONE),
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:1;LEAVES:NONE]", 1, Bamboo.Leaves.NONE),
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:0;LEAVES:SMALL]", 0, Bamboo.Leaves.SMALL),
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:1;LEAVES:SMALL]", 1, Bamboo.Leaves.SMALL),
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:0;LEAVES:LARGE]", 0, Bamboo.Leaves.LARGE),
            new BambooFlower(Material.BAMBOO, "Bamboo [AGE:1;LEAVES:LARGE]", 1, Bamboo.Leaves.LARGE)))),

    SEA_PICKLES(new FlowerGroup(Material.SEA_PICKLE, "Sea Pickles", List.of(
            new ClusterFlower(Material.SEA_PICKLE, "Sea Pickles [AMOUNT:1]", 1),
            new ClusterFlower(Material.SEA_PICKLE, "Sea Pickles [AMOUNT:2]", 2),
            new ClusterFlower(Material.SEA_PICKLE, "Sea Pickles [AMOUNT:3]", 3),
            new ClusterFlower(Material.SEA_PICKLE, "Sea Pickles [AMOUNT:4]", 4)))),

    PINK_FLOWERS(new FlowerGroup(Material.PINK_PETALS, "Pink Flowers", List.of(
            new ClusterFlower(Material.PINK_PETALS, "Pink Petals [AMOUNT:1]", 1),
            new ClusterFlower(Material.PINK_PETALS, "Pink Petals [AMOUNT:2]", 2),
            new ClusterFlower(Material.PINK_PETALS, "Pink Petals [AMOUNT:3]", 3),
            new ClusterFlower(Material.PINK_PETALS, "Pink Petals [AMOUNT:4]", 4)))),

    TURTLE_EGG(new FlowerGroup(Material.TURTLE_EGG, "Turtle Egg", List.of(
            new ClusterFlower(Material.TURTLE_EGG, "Turtle Egg [AMOUNT:1]", 1),
            new ClusterFlower(Material.TURTLE_EGG, "Turtle Egg [AMOUNT:2]", 2),
            new ClusterFlower(Material.TURTLE_EGG, "Turtle Egg [AMOUNT:3]", 3),
            new ClusterFlower(Material.TURTLE_EGG, "Turtle Egg [AMOUNT:4]", 4)))),

    WHEAT(new FlowerGroup(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat", List.of(
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:0]", 0),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:1]", 1),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:2]", 2),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:3]", 3),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:4]", 4),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:5]", 5),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:6]", 6),
            new AgeFlower(Material.WHEAT_SEEDS, Material.WHEAT, "Wheat [AGE:7]", 7),
            new DefaultFlower(Material.HAY_BLOCK, "Hay")))),

    CARROT(new FlowerGroup(Material.CARROT, "Carrot", List.of(
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:0]", 0),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:1]", 1),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:2]", 2),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:3]", 3),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:4]", 4),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:5]", 5),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:6]", 6),
            new AgeFlower(Material.CARROT, Material.CARROTS, "Carrot [AGE:7]", 7)))),

    POTATO(new FlowerGroup(Material.POTATO, "Potato", List.of(
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:0]", 0),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:1]", 1),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:2]", 2),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:3]", 3),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:4]", 4),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:5]", 5),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:6]", 6),
            new AgeFlower(Material.POTATO, Material.POTATOES, "Potato [AGE:7]", 7)))),

    BERRY_BUSH(new FlowerGroup(Material.SWEET_BERRIES, "Berry Bush", List.of(
            new AgeFlower(Material.SWEET_BERRIES, Material.SWEET_BERRY_BUSH, "Berry Bush [AGE:0]", 0),
            new AgeFlower(Material.SWEET_BERRIES, Material.SWEET_BERRY_BUSH, "Berry Bush [AGE:1]", 1),
            new AgeFlower(Material.SWEET_BERRIES, Material.SWEET_BERRY_BUSH, "Berry Bush [AGE:2]", 2),
            new AgeFlower(Material.SWEET_BERRIES, Material.SWEET_BERRY_BUSH, "Berry Bush [AGE:3]", 3)
    ))),

    NETHER_WART(new FlowerGroup(Material.NETHER_WART, "Nether Wart", List.of(
            new AgeFlower(Material.NETHER_WART, "Nether Wart [AGE:0]", 0),
            new AgeFlower(Material.NETHER_WART, "Nether Wart [AGE:1]", 1),
            new AgeFlower(Material.NETHER_WART, "Nether Wart [AGE:2]", 2),
            new AgeFlower(Material.NETHER_WART, "Nether Wart [AGE:3]", 3)
    ))),

    MELON(new FlowerGroup(Material.MELON, Material.MELON_STEM, "Melon", List.of(
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:0]", 0),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:1]", 1),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:2]", 2),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:3]", 3),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:4]", 4),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:5]", 5),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:6]", 6),
            new AgeFlower(Material.MELON_SEEDS, Material.MELON_STEM, "Melon [AGE:7]", 7),
            new DefaultFlower(Material.MELON, "Melon")))),

    PUMPKIN(new FlowerGroup(Material.PUMPKIN, Material.PUMPKIN_STEM, "Pumpkin", List.of(
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:0]", 0),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:1]", 1),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:2]", 2),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:3]", 3),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:4]", 4),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:5]", 5),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:6]", 6),
            new AgeFlower(Material.PUMPKIN_SEEDS, Material.PUMPKIN_STEM, "Pumpkin [AGE:7]", 7),
            new DefaultFlower(Material.PUMPKIN, "Pumpkin")))),

    BEETROOT(new FlowerGroup(Material.BEETROOT, "Beetroot", List.of(
            new AgeFlower(Material.BEETROOT, Material.BEETROOTS, "Beetroot [AGE:0]", 0),
            new AgeFlower(Material.BEETROOT, Material.BEETROOTS, "Beetroot [AGE:1]", 1),
            new AgeFlower(Material.BEETROOT, Material.BEETROOTS, "Beetroot [AGE:2]", 2),
            new AgeFlower(Material.BEETROOT, Material.BEETROOTS, "Beetroot [AGE:3]", 3)))),

    TORCH_FLOWER(new FlowerGroup(Material.TORCHFLOWER, "Torchflower", List.of(
            new AgeFlower(Material.TORCHFLOWER_SEEDS, Material.TORCHFLOWER_CROP, "Torchflower Crop [AGE:0]", 0),
            new AgeFlower(Material.TORCHFLOWER_SEEDS, Material.TORCHFLOWER_CROP, "Torchflower Crop [AGE:1]", 1),
            new DefaultFlower(Material.TORCHFLOWER, "Torchflower")))),

    PITCHER_PLANT(new FlowerGroup(Material.PITCHER_PLANT, "Pitcher Plant", List.of(
            new AgeFlower(Material.PITCHER_POD, Material.PITCHER_CROP, "Pitcher Crop [AGE:0]", 0),
            new AgeFlower(Material.PITCHER_POD, Material.PITCHER_CROP, "Pitcher Crop [AGE:1]", 1),
            new AgeFlower(Material.PITCHER_POD, Material.PITCHER_CROP, "Pitcher Crop [AGE:2]", 2),
            new AgeFlower(Material.PITCHER_POD, Material.PITCHER_CROP, "Pitcher Crop [AGE:4]", 3),
            new DoubleFlower(Material.PITCHER_PLANT, "Pitcher Plant [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.PITCHER_PLANT, "Pitcher Plant [TOP]", Bisected.Half.TOP)))),

    DOUBLE(new FlowerGroup(Material.TALL_GRASS, "Double Plants", List.of(
            new DoubleFlower(Material.TALL_GRASS, "Tall Grass [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.TALL_GRASS, "Tall Grass [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.LARGE_FERN, "Large Fern [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.LARGE_FERN, "Large Fern [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.SUNFLOWER, "Sunflower [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.SUNFLOWER, "Sunflower [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.LILAC, "Lilac [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.LILAC, "Lilac [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.ROSE_BUSH, "Rose Bush [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.ROSE_BUSH, "Rose Bush [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.PEONY, "Peony [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.PEONY, "Peony [TOP]", Bisected.Half.TOP),
            new DoubleFlower(Material.SMALL_DRIPLEAF, "Small Dripleaf [BOTTOM]", Bisected.Half.BOTTOM),
            new DoubleFlower(Material.SMALL_DRIPLEAF, "Small Dripleaf [TOP]", Bisected.Half.TOP)))),

    SAPLINGS(new FlowerGroup(Material.OAK_SAPLING, "Saplings", List.of(
            new DefaultFlower(Material.OAK_SAPLING, "Oak Sapling"),
            new DefaultFlower(Material.SPRUCE_SAPLING, "Spruce Sapling"),
            new DefaultFlower(Material.BIRCH_SAPLING, "Birch Sapling"),
            new DefaultFlower(Material.JUNGLE_SAPLING, "Jungle Sapling"),
            new DefaultFlower(Material.ACACIA_SAPLING, "Acacia Sapling"),
            new DefaultFlower(Material.DARK_OAK_SAPLING, "Dark Oak Sapling"),
            new DefaultFlower(Material.MANGROVE_PROPAGULE, "Mangrove Propagule"),
            new DefaultFlower(Material.CHERRY_SAPLING, "Cherry Sapling"),
            new DefaultFlower(Material.AZALEA, "Azalea"),
            new DefaultFlower(Material.FLOWERING_AZALEA, "Flowering Azalea"),
            new DefaultFlower(Material.BROWN_MUSHROOM, "Brown Mushroom"),
            new DefaultFlower(Material.RED_MUSHROOM, "Red Mushroom"),
            new DefaultFlower(Material.CRIMSON_FUNGUS, "Crimson Fungus"),
            new DefaultFlower(Material.WARPED_FUNGUS, "Warped Fungus")))),

    POTTED_SAPLINGS(new FlowerGroup(Material.DECORATED_POT, Material.DECORATED_POT, "Potted Saplings", List.of(
            new DefaultFlower(Material.OAK_SAPLING, Material.POTTED_OAK_SAPLING, "Potted Oak Sapling"),
            new DefaultFlower(Material.SPRUCE_SAPLING, Material.POTTED_SPRUCE_SAPLING, "Potted Spruce Sapling"),
            new DefaultFlower(Material.BIRCH_SAPLING, Material.POTTED_BIRCH_SAPLING, "Potted Birch Sapling"),
            new DefaultFlower(Material.JUNGLE_SAPLING, Material.POTTED_JUNGLE_SAPLING, "Potted Jungle Sapling"),
            new DefaultFlower(Material.ACACIA_SAPLING, Material.POTTED_ACACIA_SAPLING, "Potted Acacia Sapling"),
            new DefaultFlower(Material.DARK_OAK_SAPLING, Material.POTTED_DARK_OAK_SAPLING, "Potted Dark Oak Sapling"),
            new DefaultFlower(Material.MANGROVE_PROPAGULE, Material.POTTED_MANGROVE_PROPAGULE, "Potted Mangrove Propagule"),
            new DefaultFlower(Material.CHERRY_SAPLING, Material.POTTED_CHERRY_SAPLING, "Potted Cherry Sapling"),
            new DefaultFlower(Material.AZALEA, Material.POTTED_AZALEA_BUSH, "Potted Azalea"),
            new DefaultFlower(Material.FLOWERING_AZALEA, Material.POTTED_FLOWERING_AZALEA_BUSH, "Potted Flowering Azalea"),
            new DefaultFlower(Material.BROWN_MUSHROOM, Material.POTTED_BROWN_MUSHROOM, "Potted Brown Mushroom"),
            new DefaultFlower(Material.RED_MUSHROOM, Material.POTTED_RED_MUSHROOM, "Potted Red Mushroom"),
            new DefaultFlower(Material.CRIMSON_FUNGUS, Material.POTTED_CRIMSON_FUNGUS, "Potted Crimson Fungus"),
            new DefaultFlower(Material.WARPED_FUNGUS, Material.POTTED_WARPED_FUNGUS, "Potted Warped Fungus")))),

    DEFAULT_FLOWERS(new FlowerGroup(Material.POPPY, "Flowers", List.of(
            new DefaultFlower(Material.FLOWER_POT, "Flower Pot"),
            new DefaultFlower(Material.DECORATED_POT, "Decorated Pot"),
            new DefaultFlower(Material.DANDELION, "Dandelion"),
            new DefaultFlower(Material.POPPY, "Poppy"),
            new DefaultFlower(Material.BLUE_ORCHID, "Blue Orchid"),
            new DefaultFlower(Material.ALLIUM, "Allium"),
            new DefaultFlower(Material.AZURE_BLUET, "Azure Bullet"),
            new DefaultFlower(Material.RED_TULIP, "Red Tulip"),
            new DefaultFlower(Material.ORANGE_TULIP, "Orange Tulip"),
            new DefaultFlower(Material.WHITE_TULIP, "White Tulip"),
            new DefaultFlower(Material.PINK_TULIP, "Pink Tulip"),
            new DefaultFlower(Material.OXEYE_DAISY, "Oxeye Daisy"),
            new DefaultFlower(Material.LILY_OF_THE_VALLEY, "Lily of the Valley"),
            new DefaultFlower(Material.CORNFLOWER, "Cornflower"),
            new CaveVinePlant(Material.GLOW_BERRIES, Material.CAVE_VINES_PLANT, "Glow Berries Plant [BERRIES]", 0, true),
            new CaveVinePlant(Material.GLOW_BERRIES, Material.CAVE_VINES_PLANT, "Glow Berries Plant", 0, false),
            new CaveVinePlant(Material.GLOW_BERRIES, Material.CAVE_VINES, "Glow Berries [BERRIES]", 0, true),
            new CaveVinePlant(Material.GLOW_BERRIES, Material.CAVE_VINES, "Glow Berries", 0, false),
            new DefaultFlower(Material.WITHER_ROSE, "Wither Rose"),
            new DefaultFlower(Material.SPORE_BLOSSOM, "Spore Blossom")))),

    WATER(new FlowerGroup(Material.WATER_BUCKET, "Waterplants", List.of(
            new WaterFlower(Material.HORN_CORAL, "Horn Coral [WATERLOGGED]", true),
            new WaterFlower(Material.HORN_CORAL_FAN, "Horn Coral Fan [WATERLOGGED]", true),
            new WaterFlower(Material.TUBE_CORAL, "Tube Coral [WATERLOGGED]", true),
            new WaterFlower(Material.TUBE_CORAL_FAN, "Tube Coral Fan [WATERLOGGED]", true),
            new WaterFlower(Material.BRAIN_CORAL, "Brain Coral [WATERLOGGED]", true),
            new WaterFlower(Material.BRAIN_CORAL_FAN, "Brain Coral Fan [WATERLOGGED]", true),
            new WaterFlower(Material.FIRE_CORAL, "Fire Coral [WATERLOGGED]", true),
            new WaterFlower(Material.FIRE_CORAL_FAN, "Fire Coral Fan [WATERLOGGED]", true),
            new WaterFlower(Material.SEAGRASS, "Seagrass [WATERLOGGED]", true),
            new WaterFlower(Material.HORN_CORAL, "Horn Coral", false),
            new WaterFlower(Material.HORN_CORAL_FAN, "Horn Coral Fan", false),
            new WaterFlower(Material.TUBE_CORAL, "Tube Coral", false),
            new WaterFlower(Material.TUBE_CORAL_FAN, "Tube Coral Fan", false),
            new WaterFlower(Material.BRAIN_CORAL, "Brain Coral", false),
            new WaterFlower(Material.BRAIN_CORAL_FAN, "Brain Coral Fan", false),
            new WaterFlower(Material.FIRE_CORAL, "Fire Coral", false),
            new WaterFlower(Material.FIRE_CORAL_FAN, "Fire Coral Fan", false),
            new WaterFlower(Material.SEAGRASS, "Seagrass", false)))),

    DEFAULT_VEGETATION(new FlowerGroup(Material.SHORT_GRASS, "Vegetation", List.of(
            new DefaultFlower(Material.SHORT_GRASS, "Grass"),
            new DefaultFlower(Material.FERN, "Fern"),
            new DefaultFlower(Material.DEAD_BUSH, "Dead Bush"),
            new DefaultFlower(Material.CRIMSON_ROOTS, "Crimson Roots"),
            new DefaultFlower(Material.WEEPING_VINES, "Weeping Vines"),
            new DefaultFlower(Material.WEEPING_VINES, "Weeping Vines Plant"),
            new DefaultFlower(Material.WARPED_ROOTS, "Warped Roots"),
            new DefaultFlower(Material.NETHER_SPROUTS, "Nether Sprouts"),
            new DefaultFlower(Material.TWISTING_VINES, "Twisting Vines Plant"),
            new DefaultFlower(Material.TWISTING_VINES, "Twisting Vines"),
            new DefaultFlower(Material.HANGING_ROOTS, "Hanging Roots"),
            new DefaultFlower(Material.CACTUS, "Cactus"),
            new DefaultFlower(Material.SUGAR_CANE, "Sugar Cane")))),

    POTTED_FLOWERS(new FlowerGroup(Material.FLOWER_POT, "Potted Flowers", List.of(
            new DefaultFlower(Material.DANDELION, Material.POTTED_DANDELION, "Potted Dandelion"),
            new DefaultFlower(Material.POPPY, Material.POTTED_POPPY, "Potted Poppy"),
            new DefaultFlower(Material.BLUE_ORCHID, Material.POTTED_BLUE_ORCHID, "Potted Blue Orchid"),
            new DefaultFlower(Material.ALLIUM, Material.POTTED_ALLIUM, "Potted Allium"),
            new DefaultFlower(Material.AZURE_BLUET, Material.POTTED_AZURE_BLUET, "Potted Azure Bullet"),
            new DefaultFlower(Material.RED_TULIP, Material.POTTED_RED_TULIP, "Potted Red Tulip"),
            new DefaultFlower(Material.ORANGE_TULIP, Material.POTTED_ORANGE_TULIP, "Potted Orange Tulip"),
            new DefaultFlower(Material.WHITE_TULIP, Material.POTTED_WHITE_TULIP, "Potted White Tulip"),
            new DefaultFlower(Material.PINK_TULIP, Material.POTTED_PINK_TULIP, "Potted Pink Tulip"),
            new DefaultFlower(Material.OXEYE_DAISY, Material.POTTED_OXEYE_DAISY, "Potted Oxeye Daisy"),
            new DefaultFlower(Material.LILY_OF_THE_VALLEY, Material.POTTED_LILY_OF_THE_VALLEY, "Potted Lily of the Valley"),
            new DefaultFlower(Material.CORNFLOWER, Material.POTTED_CORNFLOWER, "Potted Cornflower"),
            new DefaultFlower(Material.WITHER_ROSE, Material.POTTED_WITHER_ROSE, "Potted Wither Rose"),
            new DefaultFlower(Material.TORCHFLOWER, Material.POTTED_TORCHFLOWER, "Potted Torchflower"),
            new DefaultFlower(Material.CRIMSON_ROOTS, Material.POTTED_CRIMSON_ROOTS, "Potted Crimson Roots"),
            new DefaultFlower(Material.WARPED_ROOTS, Material.POTTED_WARPED_ROOTS, "Potted Warped Roots"),
            new DefaultFlower(Material.FERN, Material.POTTED_FERN, "Potted Fern"),
            new DefaultFlower(Material.DEAD_BUSH, Material.POTTED_DEAD_BUSH, "Potted Dead Bush"),
            new DefaultFlower(Material.CACTUS, Material.POTTED_CACTUS, "Potted Cactus"),
            new DefaultFlower(Material.BAMBOO, Material.POTTED_BAMBOO, "Potted Bamboo")))),

    FENCE(new FlowerGroup(Material.OAK_FENCE, "Fence", List.of(
            new DefaultFlower(Material.OAK_FENCE, "Oak Fence"),
            new DefaultFlower(Material.SPRUCE_FENCE, "Spruce Fence"),
            new DefaultFlower(Material.DARK_OAK_FENCE, "Dark Oak Fence"),
            new DefaultFlower(Material.BIRCH_FENCE, "Birch Fence"),
            new DefaultFlower(Material.JUNGLE_FENCE, "Jungle Fence"),
            new DefaultFlower(Material.ACACIA_FENCE, "Acacia Fence"),
            new DefaultFlower(Material.MANGROVE_FENCE, "Mangrove Fence"),
            new DefaultFlower(Material.CHERRY_FENCE, "Cherry Fence"),
            new DefaultFlower(Material.BAMBOO_FENCE, "Bamboo Fence"),
            new DefaultFlower(Material.NETHER_BRICK_FENCE, "Nether Brick Fence"),
            new DefaultFlower(Material.WARPED_FENCE, "Warped Fence"),
            new DefaultFlower(Material.CRIMSON_FENCE, "Crimson Fence"),
            new DefaultFlower(Material.END_ROD, "End Rod"),
            new DefaultFlower(Material.LIGHTNING_ROD, "Lightning Rod"),
            new DefaultFlower(Material.CHAIN, "Chain")))),

    GLASS(new FlowerGroup(Material.GREEN_STAINED_GLASS, "Glass Pains", List.of(
            new DefaultFlower(Material.WHITE_STAINED_GLASS_PANE, "White Stained Glass Pane"),
            new DefaultFlower(Material.LIGHT_GRAY_STAINED_GLASS_PANE, "Light Gray Stained Glass Pane"),
            new DefaultFlower(Material.GRAY_STAINED_GLASS_PANE, "Gray Stained Glass Pane"),
            new DefaultFlower(Material.BLACK_STAINED_GLASS_PANE, "Black Stained Glass Pane"),
            new DefaultFlower(Material.BROWN_STAINED_GLASS_PANE, "Brown Stained Glass Pane"),
            new DefaultFlower(Material.RED_STAINED_GLASS_PANE, "Red Stained Glass Pane"),
            new DefaultFlower(Material.ORANGE_STAINED_GLASS_PANE, "Orange Stained Glass Pane"),
            new DefaultFlower(Material.YELLOW_STAINED_GLASS_PANE, "Yellow Stained Glass Pane"),
            new DefaultFlower(Material.LIME_STAINED_GLASS_PANE, "Lime Stained Glass Pane"),
            new DefaultFlower(Material.GREEN_STAINED_GLASS_PANE, "Green Stained Glass Pane"),
            new DefaultFlower(Material.CYAN_STAINED_GLASS_PANE, "Cyan Stained Glass Pane"),
            new DefaultFlower(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "Light Blue Stained Glass Pane"),
            new DefaultFlower(Material.BLUE_STAINED_GLASS_PANE, "Blue Stained Glass Pane"),
            new DefaultFlower(Material.PURPLE_STAINED_GLASS_PANE, "Purple Stained Glass Pane"),
            new DefaultFlower(Material.MAGENTA_STAINED_GLASS_PANE, "Magenta Stained Glass Pane"),
            new DefaultFlower(Material.PINK_STAINED_GLASS_PANE, "Pink Stained Glass Pane"),
            new DefaultFlower(Material.IRON_BARS, "Iron Bars")))),

    LEAVES(new FlowerGroup((Material.OAK_LEAVES), "Leaves", List.of(
            new LeaveFlower(Material.OAK_LEAVES, "Oak Leaves", true),
            new LeaveFlower(Material.SPRUCE_LEAVES, "Spruce Leaves", true),
            new LeaveFlower(Material.DARK_OAK_LEAVES, "Dark Oak Leaves", true),
            new LeaveFlower(Material.BIRCH_LEAVES, "Birch Leaves", true),
            new LeaveFlower(Material.JUNGLE_LEAVES, "Jungle Leaves", true),
            new LeaveFlower(Material.ACACIA_LEAVES, "Acacia Leaves", true),
            new LeaveFlower(Material.MANGROVE_LEAVES, "Mangrove Leaves", true),
            new LeaveFlower(Material.CHERRY_LEAVES, "Cherry Leaves", true),
            new LeaveFlower(Material.AZALEA_LEAVES, "Azalea Leaves", true),
            new LeaveFlower(Material.FLOWERING_AZALEA_LEAVES, "Flowering Azalea Leaves", true)))),

    PLACEHOLDER(new FlowerGroup(Material.DIAMOND_BLOCK, "PLACEHOLDER/AIR", List.of(
            new DefaultFlower(Material.DIAMOND_BLOCK, "Diamond BLock"),
            new DefaultFlower(Material.LAPIS_BLOCK, "Lapis Block"),
            new DefaultFlower(Material.EMERALD_BLOCK, "Emerald Block"),
            new DefaultFlower(Material.BARRIER, "Barrier"),
            new DefaultFlower(Material.STRUCTURE_VOID, Material.AIR, "Air"))));

    private final FlowerGroup flowerGroup;

    FlowerCollection(FlowerGroup flowerGroup) {
        this.flowerGroup = flowerGroup;
    }
}