package world.cepi.moderation.commands

import net.minestom.server.MinecraftServer
import net.minestom.server.chat.ChatColor
import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player
import world.cepi.moderation.CommandArguments
import world.cepi.kstom.command.addSyntax

class KickCommand: Command("kick") {

    private fun getPlayer(name: String): Player? {
        return MinecraftServer.getConnectionManager().onlinePlayers.firstOrNull { it.username.equals(name, true) }
    }

    init {
        setDefaultExecutor { sender, _ ->
            sender.sendMessage("Usage: /kick <player> <reason>")
        }

        addSyntax(CommandArguments.playerArg) { sender, args ->

            val target = args.get(CommandArguments.playerArg).find(sender)[0] as? Player

            if (target == null) {
                sender.sendMessage("Player not found!")
                return@addSyntax
            }

            sender.sendMessage("${ChatColor.BRIGHT_GREEN} + You kicked ${target.displayName}")

            target.kick("You were kicked from the server.")
        }

        addSyntax(CommandArguments.playerArg, CommandArguments.reasonArg) { sender, args ->

            val target = args.get(CommandArguments.playerArg).find(sender)[0] as? Player

            if (target == null) {
                sender.sendMessage("Player not found!")
                return@addSyntax
            }

            val reason = args.get(CommandArguments.reasonArg)

            sender.sendMessage("${ChatColor.BRIGHT_GREEN} + You kicked ${getPlayer(args.getWord("player"))?.displayName}")
            target.kick(reason)
        }
    }
}