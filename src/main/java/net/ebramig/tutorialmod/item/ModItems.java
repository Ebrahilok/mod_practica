package net.ebramig.tutorialmod.item;

import net.ebramig.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
//FItem
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CEVICHE = ITEMS.register("ceviche",
            () -> new Item(new Item.Properties().food(ModFoods.CEVICHE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}