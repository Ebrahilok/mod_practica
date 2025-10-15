package net.ebramig.tutorialmod;
import net.ebramig.tutorialmod.block.ModBlocks;
import net.ebramig.tutorialmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//FBlockEvent
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FBlockEvent {
    //EVT_BUS_RCLICK_FBLOCK
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock Event) {
        Level level = Event.getLevel();
        if (level.isClientSide()) {
            return;
        }
        Player player = Event.getEntity(); ItemStack stack = Event.getItemStack();
        //BLOCK_UADEO FEvSys_EVT★
        //========================================
        //Se establecen varios efectos y se torna mas sombrio incluyendo la aparicion de varios enemigos
        //El warden al parecer se debe invocar a la fuerza
        //========================================
        ServerLevel serverLevel = (ServerLevel)level;
        //Guardar Posicion del bloque===========
        BlockPos pos = Event.getPos(); BlockState state = level.getBlockState(pos);
        if (state.getBlock() == ModBlocks.UADEOBLOCK.get()) {
            if (stack.getItem() == ModItems.ALEXANDRITE.get()) {
                //★EVT_FX_SND★
                level.playSound(null, pos, SoundEvents.WITHER_SPAWN, SoundSource.BLOCKS, 1.0f, 1.0f);
                //EVT_EST_FX_JUGADOR
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1000, 0));
                LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
                if (lightning != null) {
                    //■Calculos■■■■■■■■
                    lightning.moveTo(Vec3.atBottomCenterOf(pos));
                    level.addFreshEntity(lightning);
                }
                serverLevel.setWeatherParameters(0, 6000, true, true);
                //■Invocaciones
                Warden warden = EntityType.WARDEN.create(serverLevel);
                BlockPos spawnPos = pos.north(10);
                if (warden != null) {
                    warden.moveTo(Vec3.atBottomCenterOf(spawnPos.above()));
                    warden.setPersistenceRequired();
                    serverLevel.addFreshEntity(warden);
                }
                //★★★★★Mensajes★★★★★
                player.sendSystemMessage(Component.literal("Has invocado la furia de Mario Erenas"));
                player.sendSystemMessage(Component.literal("Sera mejor que corras...").withStyle(ChatFormatting.RED));
                //Fin
                Event.setCanceled(true);
            }
        }
    }
}
