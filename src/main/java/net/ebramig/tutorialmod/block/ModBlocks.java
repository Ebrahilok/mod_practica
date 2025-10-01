// ESTE ARCHIVO NO ESTÁ TERMINADO. NO CORRER

package net.kaupenjoe.tutorialmod.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("Alexandrite block");

private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
}
private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
    ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
}
}

public static void register(IEventBus eventBus) { BLOCKS.register(eventBus);}



}