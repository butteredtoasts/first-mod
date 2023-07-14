package net.butteredtoasts.rubymod.datagen;

import net.butteredtoasts.rubymod.RubyMod;
import net.butteredtoasts.rubymod.block.ModBlocks;
import net.butteredtoasts.rubymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RubyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.RUBY_STAIRS.get(),
                        ModBlocks.RUBY_SLAB.get(),
                        ModBlocks.RUBY_FENCE.get(),
                        ModBlocks.RUBY_FENCE_GATE.get(),
                        ModBlocks.RUBY_WALL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_ORE.get(),
                        ModBlocks.RUBY_STAIRS.get(),
                        ModBlocks.RUBY_SLAB.get(),
                        ModBlocks.RUBY_FENCE.get(),
                        ModBlocks.RUBY_FENCE_GATE.get(),
                        ModBlocks.RUBY_WALL.get());

        this.tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .add(ModBlocks.RUBY_BLOCK.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTags(BlockTags.MINEABLE_WITH_PICKAXE,
                BlockTags.MINEABLE_WITH_AXE,
                BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE.get(),
                        ModBlocks.RUBY_FENCE_GATE.get(),
                        ModBlocks.RUBY_WALL.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}