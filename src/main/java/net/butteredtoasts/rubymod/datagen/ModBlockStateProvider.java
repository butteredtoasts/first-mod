package net.butteredtoasts.rubymod.datagen;

import net.butteredtoasts.rubymod.RubyMod;
import net.butteredtoasts.rubymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RubyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);

        stairsBlock((StairBlock) ModBlocks.RUBY_STAIRS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.RUBY_SLAB.get()), blockTexture(ModBlocks.RUBY_BLOCK.get()), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.RUBY_BUTTON.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.RUBY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.RUBY_FENCE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.RUBY_FENCE_GATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.RUBY_WALL.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.RUBY_DOOR.get(), modLoc("block/ruby_door_bottom"), modLoc("block/ruby_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.RUBY_TRAPDOOR.get(), modLoc("block/ruby_trapdoor"), true, "cutout");

        blockItem(ModBlocks.RUBY_STAIRS);
        blockItem(ModBlocks.RUBY_SLAB);
        blockItem(ModBlocks.RUBY_PRESSURE_PLATE);
        blockItem(ModBlocks.RUBY_FENCE_GATE);
        blockItem(ModBlocks.RUBY_TRAPDOOR, "_bottom");
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("rubymod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("rubymod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}