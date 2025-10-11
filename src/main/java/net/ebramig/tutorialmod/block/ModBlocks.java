// ESTE ARCHIVO NO ESTÁ TERMINADO. NO CORRER

package net.ebramig.tutorialmod.block;
import net.ebramig.tutorialmod.TutorialMod;
import net.ebramig.tutorialmod.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> UADEOBLOCK = registerBlock("uadeo_block", ()->new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.POINTED_DRIPSTONE)));

    public static final RegistryObject<Block> DRIPPYFACE = registerBlock("drippy_face_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> YELLOWASPHALT = registerBlock("yellow_asphalt_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.POINTED_DRIPSTONE)));

    public static final RegistryObject<Block> ROCKGRASS = registerBlock("rock_grass", () -> new Block(BlockBehaviour.Properties.of()
            .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DIRTYBLOCK = registerBlock("dirty_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1f).sound(SoundType.ROOTED_DIRT)));

    public static final RegistryObject<Block> ASPHALTBLOCK = registerBlock("asphalt_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1f).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final RegistryObject<Block> PURPLEROCK = registerBlock("purple_rock", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.LODESTONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}