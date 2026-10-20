package lol.elishasmile;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerDisconnectEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;

public class Main {

    // Server INIT
    static MinecraftServer server = MinecraftServer.init();

    // Creating World
    static InstanceManager instanceManager = MinecraftServer.getInstanceManager();
    static InstanceContainer instanceContainer = instanceManager.createInstanceContainer();

    static void main() {
        MinecraftServer.getCommandManager().register(new WelcomeTag());

        instanceContainer.setGenerator(unit -> unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));

        // He said, let there be light
        instanceContainer.setChunkSupplier(LightingChunk::new);

        // Events
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(instanceContainer);
            event.getPlayer().setRespawnPoint(new Pos(0, 42, 0));
        });

        globalEventHandler.addListener(PlayerSpawnEvent.class, event -> {
            final Player player = event.getPlayer();

            player.sendMessage(instanceContainer.getTag(WelcomeTag.WELCOME_MESSAGE));
            event.getPlayer().sendMessage("Spawning @ 0,42,0");
        });

        globalEventHandler.addListener(PlayerDisconnectEvent.class, event -> {
            final Player player = event.getPlayer();
            System.out.println("Player " + player.getUsername() + " Disconnected!");
        });


        server.start("0.0.0.0", 25565);
    }
}
