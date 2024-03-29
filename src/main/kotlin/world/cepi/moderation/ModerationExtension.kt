package world.cepi.moderation

import net.minestom.server.MinecraftServer
import net.minestom.server.extensions.Extension;
import world.cepi.moderation.commands.BanCommand
import world.cepi.moderation.commands.KickCommand

class ModerationExtension : Extension() {

    override fun initialize() {
        MinecraftServer.getCommandManager().register(KickCommand())
        MinecraftServer.getCommandManager().register(BanCommand())

        logger.info("[ModerationExtension] has been enabled!")
    }

    override fun terminate() {
        logger.info("[ModerationExtension] has been disabled!")
    }

}