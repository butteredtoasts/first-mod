package net.butteredtoasts.rubymod.item;

import net.butteredtoasts.rubymod.RubyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    // Registry object for Creative Mode Tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RubyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUBY_TAB = CREATIVE_MODE_TABS.register("ruby_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.ruby_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.RUBY.get());
                    }).build());

    // Registers the Creative Mode Tab in RubyMod class
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}