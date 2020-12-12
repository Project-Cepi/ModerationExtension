package world.cepi.moderation.commands

import net.minestom.server.MinecraftServer
import net.minestom.server.chat.ChatColor
import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player
import world.cepi.moderation.CommandArguments

class KickCommand: Command("kick") {

    private fun getPlayer(name: String): Player? {
        return MinecraftServer.getConnectionManager().onlinePlayers.firstOrNull { it.username.equals(name, true) }
    }

    init {
        setDefaultExecutor { sender, _ ->
            sender.sendMessage("Usage: /kick <player> <reason>")
        }
        addSyntax({sender, args ->
            val player = sender as Player
            if (getPlayer(args.getWord("player")) != player) player.sendMessage("${ChatColor.BRIGHT_GREEN} + You kicked ${getPlayer(args.getWord("player"))?.displayName}")
            getPlayer(args.getWord("player"))?.kick("You were kicked from the server.")
        }, CommandArguments.playerArg)
        addSyntax({sender, args ->
            val player = sender as Player
            //will add perms later
            val reasonRaw = args.getStringArray("reason")
            var reason = ""
            for (r in reasonRaw) {
                reason += "$r "
            }
            if (getPlayer(args.getWord("player")) != player) player.sendMessage("${ChatColor.BRIGHT_GREEN} + You kicked ${getPlayer(args.getWord("player"))?.displayName}")
            getPlayer(args.getWord("player"))?.kick(reason)
        }, CommandArguments.playerArg, CommandArguments.reasonArg)
    }
}