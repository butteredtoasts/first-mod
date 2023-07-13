package net.butteredtoasts.rubymod.item.custom;

import net.butteredtoasts.rubymod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerInvWrapper;

public class BreadKnifeItem extends Item {
    public BreadKnifeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide) {
            IItemHandler inventory = new PlayerInvWrapper(pPlayer.getInventory());
            ItemStack bunStack = new ItemStack(ModItems.BUN.get());

            for (int i = 0; i < inventory.getSlots(); i++) {
                if (inventory.getStackInSlot(i).getItem() == Items.BREAD) {
                    inventory.extractItem(i, 1, false);
                    pPlayer.getMainHandItem().hurtAndBreak(1, pPlayer,
                            player -> player.broadcastBreakEvent(player.getUsedItemHand()));
                    if (pPlayer.getInventory().contains(bunStack)) {
                        int slot = pPlayer.getInventory().findSlotMatchingItem(bunStack);
                        pPlayer.getInventory().add(slot, new ItemStack(ModItems.BUN.get(), 2));
                    } else {
                        pPlayer.getInventory().add(pPlayer.getInventory().getFreeSlot(), new ItemStack(ModItems.BUN.get(), 2));
                    }
                }
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}