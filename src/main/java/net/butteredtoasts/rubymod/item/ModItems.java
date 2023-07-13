package net.butteredtoasts.rubymod.item;

import net.butteredtoasts.rubymod.RubyMod;
import net.butteredtoasts.rubymod.item.custom.BreadKnifeItem;
import net.butteredtoasts.rubymod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Creation of ITEMS to allow individual items to be created
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RubyMod.MOD_ID);

    // List of items added
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BURGER)));
    public static final RegistryObject<Item> BUN = ITEMS.register("bun",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BUN)));
    public static final RegistryObject<Item> MAGMA_BALL = ITEMS.register("magma_ball",
            () -> new FuelItem(new Item.Properties(), 6400));
    public static final RegistryObject<Item> BREAD_KNIFE = ITEMS.register("bread_knife",
            () -> new BreadKnifeItem(new Item.Properties().durability(128)));


    // Registers items in RubyMod class
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}