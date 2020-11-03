package world.cepi.Moderation.Commands

import net.minestom.server.MinecraftServer
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player

class KickCommand: Command("kick") {

    fun getPlayer(name: String): Player? {
        return MinecraftServer.getConnectionManager().onlinePlayers.firstOrNull { it.username.equals(name, true) }
    }

    init {
        setDefaultExecutor {sender, _ ->
            sender.sendMessage("Usage: /kick <player> <reason>")
        }
        val playerArg = ArgumentType.Word("player")
        addSyntax({sender, args ->
            val player = sender as Player
            //will add perms later
            getPlayer(args.getWord("player"))?.kick("get kicked lol")
        }, playerArg)
    }
}