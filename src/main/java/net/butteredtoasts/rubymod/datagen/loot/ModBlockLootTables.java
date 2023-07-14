package net.butteredtoasts.rubymod.datagen.loot;

import net.butteredtoasts.rubymod.block.ModBlocks;
import net.butteredtoasts.rubymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_ORE.get());

        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));

        this.dropSelf(ModBlocks.RUBY_STAIRS.get());
        this.add(ModBlocks.RUBY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RUBY_SLAB.get()));
        this.dropSelf(ModBlocks.RUBY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.RUBY_BUTTON.get());
        this.dropSelf(ModBlocks.RUBY_FENCE.get());
        this.dropSelf(ModBlocks.RUBY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.RUBY_WALL.get());
        this.dropSelf(ModBlocks.RUBY_TRAPDOOR.get());

        this.add(ModBlocks.RUBY_DOOR.get(),
                block -> createDoorTable(ModBlocks.RUBY_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}