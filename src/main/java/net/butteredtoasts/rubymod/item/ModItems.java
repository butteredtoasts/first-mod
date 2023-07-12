package net.butteredtoasts.rubymod.item;

import net.butteredtoasts.rubymod.RubyMod;
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


    // Registers items in RubyMod class
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}