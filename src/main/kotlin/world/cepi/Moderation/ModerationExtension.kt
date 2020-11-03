package world.cepi.Moderation

import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension;
import world.cepi.Moderation.Commands.KickCommand

class ModerationExtension : Extension() {

    override fun initialize() {
        MinecraftServer.getCommandManager().register(KickCommand())
        logger.info("[ModerationExtension] has been enabled!")
    }

    override fun terminate() {
        logger.info("[ModerationExtension] has been disabled!")
    }

}