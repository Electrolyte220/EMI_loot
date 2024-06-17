package fzzyhmstrs.emi_loot.forge.events;

import fzzyhmstrs.emi_loot.EMILoot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class EMILootForgeEvents {
    @SubscribeEvent
    public void onDatapackSync(OnDatapackSyncEvent event) {
        EMILoot.parser.registerServer(event.getPlayerList().getPlayerList());
    }

    @SubscribeEvent
    public void onPlayerJoin(EntityJoinLevelEvent event) {
        if(event.getEntity() instanceof ServerPlayerEntity player) {
            EMILoot.parser.registerServer(List.of(player));
        }
    }
}
