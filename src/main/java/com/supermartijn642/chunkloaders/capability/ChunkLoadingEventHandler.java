package com.supermartijn642.chunkloaders.capability;

import com.supermartijn642.chunkloaders.ChunkLoaders;
import com.supermartijn642.chunkloaders.packet.PacketFullCapabilityData;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * Created 26/06/2022 by SuperMartijn642
 */
@Mod.EventBusSubscriber
public class ChunkLoadingEventHandler {

    @SubscribeEvent
    public static void onPlayerEnterLevel(PlayerEvent.PlayerChangedDimensionEvent e){
        if(!(e.getEntity() instanceof ServerPlayer))
            return;

        ChunkLoadingCapability capability = ChunkLoadingCapability.get(((ServerPlayer)e.getEntity()).level());
        ChunkLoaders.CHANNEL.sendToPlayer(e.getEntity(), new PacketFullCapabilityData(capability.castServer().writeClientInfo()));
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent e){
        if(!(e.getEntity() instanceof ServerPlayer))
            return;

        ChunkLoadingCapability capability = ChunkLoadingCapability.get(((ServerPlayer)e.getEntity()).level());
        ChunkLoaders.CHANNEL.sendToPlayer(e.getEntity(), new PacketFullCapabilityData(capability.castServer().writeClientInfo()));
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent e){
        if(!(e.getEntity() instanceof ServerPlayer))
            return;

        ChunkLoadingCapability capability = ChunkLoadingCapability.get(((ServerPlayer)e.getEntity()).level());
        ChunkLoaders.CHANNEL.sendToPlayer(e.getEntity(), new PacketFullCapabilityData(capability.castServer().writeClientInfo()));
    }
}
