package dev.luan.flowers.menus;

import dev.luan.flowers.BetterFlowers;
import dev.luan.flowers.data.FlowerData;
import dev.luan.flowers.data.FlowerGroupData;
import dev.luan.flowers.flowers.SingleFlower;
import dev.luan.flowers.flowers.placable.FlowerGroup;
import dev.luan.flowers.managers.LanguageManager;
import dev.luan.flowers.utils.BukkitPlayerInventory;
import dev.luan.flowers.utils.CandleCollection;
import dev.luan.flowers.utils.FlowerCollection;
import dev.luan.flowers.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FlowerCreationMenu extends BukkitPlayerInventory {

    private final List<FlowerData> personalFlower;
    private final List<Boolean> isGroup;
    private final List<Boolean> randomizer;
    private final Player player;
    private final ItemStack active;
    private final ItemStack notActive;
    private final ItemStack wholeCategoryRan;
    private final ItemStack wholeCategory;
    private final BetterFlowers betterFlowers;
    private final boolean isEditing;

    public FlowerCreationMenu(Player player, BetterFlowers betterFlowers, boolean isEditing) {
        super(LanguageManager.getComponent("gui.flower.title"), 6);

        this.player = player;
        this.betterFlowers = betterFlowers;
        this.isEditing = isEditing;

        this.personalFlower = new ArrayList<>();
        this.randomizer = new ArrayList<>();
        this.isGroup = new ArrayList<>();

        this.active = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.yes.no"))
                .build();

        this.notActive = new ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.group.no.no"))
                .build();

        this.wholeCategoryRan = new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.yes.yes"))
                .build();

        this.wholeCategory = new ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.no.yes"))
                .build();
    }

    public FlowerCreationMenu(Player player, BetterFlowers betterFlowers, FlowerGroupData flowerGroupData, boolean isEditing) {
        super(LanguageManager.getComponent("gui.flower.title"), 6);

        this.player = player;
        this.betterFlowers = betterFlowers;

        this.personalFlower = new ArrayList<>(flowerGroupData.flowerData());
        this.randomizer = new ArrayList<>(flowerGroupData.randomizer());
        this.isGroup = new ArrayList<>(flowerGroupData.isGroup());
        this.isEditing = isEditing;

        this.active = new ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.yes.no"))
                .build();

        this.notActive = new ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.group.no.no"))
                .build();

        this.wholeCategoryRan = new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.yes.yes"))
                .build();

        this.wholeCategory = new ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.randomizer.no.yes"))
                .build();
    }

    public void open() {

        this.closeActions.add(() -> {
            personalFlower.clear();
            randomizer.clear();
            isGroup.clear();
        });

        generateCategories();
        openInventory(player);
    }

    private void generateFlowerOverlay() {

        final var empty = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setName(("gui.flower.item.display.placeholder"))
                .build();

        for (var index = 27; index < 54; index++) {
            if (index >= 36 && index <= 44) continue;
            this.setSlot(index, empty, this::cancelClick);
        }

        for (var index = 0; index < 9; index++) {
            if (index >= randomizer.size() || index >= isGroup.size()) break;
            if (isGroup.get(index) && randomizer.get(index)) setSlot(45 + index, wholeCategoryRan, this::cancelClick);
            if (isGroup.get(index) && !randomizer.get(index)) setSlot(45 + index, wholeCategory, this::cancelClick);
            if (!isGroup.get(index) && randomizer.get(index)) setSlot((45 + index), active, this::cancelClick);
            if (!isGroup.get(index) && !randomizer.get(index)) setSlot((45 + index), notActive, this::cancelClick);
        }

        for (var index = 0; index < personalFlower.size(); index++) {
            final var singleFlower = personalFlower.get(index);

            setSlot((36 + index), new ItemBuilder(singleFlower.getDisplay())
                    .setName("gui.flower.item.display.flower", "%flower%", singleFlower.getName() + " ID " + index)
                    .build(), this::cancelClick);
        }

        setSlot(29, new ItemBuilder(Material.ECHO_SHARD)
                .setName(("gui.flower.item.display.create"))
                .build(), this::onCreateClick);

        setSlot(30, new ItemBuilder(Material.STRUCTURE_VOID)
                .setName(("gui.flower.item.display.back"))
                .build(), this::onBackClick);

        setSlot(32, new ItemBuilder(Material.BARRIER)
                .setName(("gui.flower.item.display.delete"))
                .build(), this::onDeleteClick);

        setSlot(33, new ItemBuilder(Material.REDSTONE)
                .setName(("gui.flower.item.display.remove"))
                .build(), this::onRemoveClick);
    }

    private void generateCategories() {

        clearSlots();
        generateFlowerOverlay();

        final var flowers = List.copyOf(Arrays.stream(FlowerCollection.values()).toList());

        for (int index = 0; index < 28; index++) {

            if (index > flowers.size()) break;
            if (index == flowers.size()) {
                this.setSlot(index, new ItemBuilder(Material.CANDLE)
                                .setName(("gui.flower.item.display.candle")).build(),
                        this::createCandleCategories);
                break;
            }

            final var currentFlowers = flowers.get(index).getFlowerGroup();

            setSlot(index, new ItemBuilder(currentFlowers.getDisplay())
                            .setName("gui.flower.item.display.flower", "%flower%", currentFlowers.getDisplayName())
                            .setLore(("gui.flower.item.lore.flowers")).build(),
                    inventoryClickEvent -> onCategoryClick(inventoryClickEvent, currentFlowers)
            );
        }
    }

    private void createCandleCategories(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);

        clearSlots();
        generateFlowerOverlay();

        final var candles = List.copyOf(Arrays.stream(CandleCollection
                .values()).toList());

        for (int index = 0; index < 28; index++) {

            if (index >= candles.size()) break;
            final var currentCandle = candles.get(index).getFlowerGroup();

            setSlot(index, new ItemBuilder(currentCandle.getDisplay())
                            .setName("gui.flower.item.display.flower", "%flower%", currentCandle.getDisplayName())
                            .setLore(("gui.flower.item.lore.flowers")).build(),
                    clickEvent -> onCategoryClick(clickEvent, currentCandle)
            );
        }
    }

    private void generateSubCategories(FlowerGroup flowerGroup) {

        clearSlots();
        generateFlowerOverlay();

        for (int index = 0; index < 53; index++) {

            if (index >= flowerGroup.getFlowers().size()) break;

            final var singleFlower = flowerGroup.getFlowers().get(index);
            final var item = new ItemBuilder(singleFlower.getDisplay())
                    .setName("gui.flower.item.display.flower", "%flower%", singleFlower.getDisplayName())
                    .setLore(("gui.flower.item.lore.flower")).build();

            setSlot(index, item, inventoryClickEvent -> onSubCategoryClick(inventoryClickEvent, singleFlower)
            );
        }
    }

    private void cancelClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    private void onCreateClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);

        if (personalFlower.isEmpty()) {
            player.getInventory().close();
            return;
        }

        if (isEditing) {
            final var placer = player.getInventory().getItemInMainHand();
            final var flowerGroupData = new FlowerGroupData(List.copyOf(personalFlower), List.copyOf(randomizer), List.copyOf(isGroup));
            betterFlowers.getFlowerManager().getFlowers().put(placer, flowerGroupData);
            LanguageManager.sendPlayerMessage(player, "gui.flower.message.edit");
            player.getInventory().close();
            return;
        }

        final var currentMil = String.valueOf(System.currentTimeMillis());
        final var description = new ArrayList<>(List.copyOf(LanguageManager.getComponents("gui.flower.item.lore.description")));

        for (var singleFlower : personalFlower) {
            final var lore = LanguageManager.getComponent("gui.flower.item.lore.placeholder", "%flower%", singleFlower.getName());
            description.add(lore);
        }

        final var placer = new ItemBuilder(Material.BLAZE_POWDER)
                .setName("gui.flower.item.display.name", "%id%", currentMil)
                .setLore(description).build();

        player.getInventory().addItem(placer);
        LanguageManager.sendPlayerMessage(player, "gui.flower.message.create");

        final var flowerGroupData = new FlowerGroupData(List.copyOf(personalFlower), List.copyOf(randomizer), List.copyOf(isGroup));
        betterFlowers.getFlowerManager().getFlowers().put(placer, flowerGroupData);

        player.getInventory().close();
    }

    private void onBackClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
        generateCategories();
    }

    private void onRemoveClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);

        if (!personalFlower.isEmpty() && !randomizer.isEmpty() && !isGroup.isEmpty()) {
            personalFlower.remove(personalFlower.size() - 1);
            randomizer.remove(randomizer.size() - 1);
            isGroup.remove(isGroup.size() - 1);
        }

        player.playSound(player.getLocation(), Sound.BLOCK_COMPOSTER_EMPTY, 1, 0);
        generateCategories();
    }

    private void onDeleteClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);

        personalFlower.clear();
        randomizer.clear();
        generateCategories();
    }

    private void onCategoryClick(InventoryClickEvent inventoryClickEvent, FlowerGroup flowerGroup) {
        final var currentData = new FlowerData(flowerGroup.getFlowers(), flowerGroup.getDisplayName(), flowerGroup.getDisplay());

        inventoryClickEvent.setCancelled(true);

        if (!inventoryClickEvent.isShiftClick()) {
            generateSubCategories(flowerGroup);
            return;
        }

        if (personalFlower.size() > 8) {
            LanguageManager.sendPlayerMessage(player, "gui.flower.message.limit");
            return;
        }

        if (inventoryClickEvent.isRightClick()) randomizer.add(true);
        else randomizer.add(false);
        isGroup.add(true);

        personalFlower.add(currentData);
        player.playSound(player.getLocation(), Sound.BLOCK_CAVE_VINES_PLACE, 1, 0);
        generateCategories();
    }

    private void onSubCategoryClick(InventoryClickEvent inventoryClickEvent, SingleFlower singleFlower) {
        inventoryClickEvent.setCancelled(true);

        if (personalFlower.size() > 8) {
            LanguageManager.sendPlayerMessage(player, "gui.flower.message.limit");
            return;
        }

        if (inventoryClickEvent.isRightClick()) randomizer.add(true);
        else randomizer.add(false);
        isGroup.add(false);

        personalFlower.add(new FlowerData(singleFlower));
        player.playSound(player.getLocation(), Sound.BLOCK_CAVE_VINES_PLACE, 1, 0);
        generateCategories();
    }
}