package world.cepi.moderation.commands

import net.minestom.server.MinecraftServer
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player
import world.cepi.kstom.command.addSyntax
import world.cepi.moderation.CommandArguments

class BanCommand : Command("ban") {

    private fun getPlayer(name: String): Player? {
        val player = MinecraftServer.getConnectionManager().onlinePlayers.firstOrNull { it.username.equals(name, true) }

        if (player == null) {
            // TODO: Offline player query
        }

        return player
    }

    init {
        setDefaultExecutor { sender, _ ->
            sender.sendMessage("Usage: /ban <player (online or offline)>")
        }

        addSyntax(CommandArguments.playerArg) { sender, args ->

            val target = args.get(CommandArguments.playerArg).find(sender)[0] as? Player

            if (target == null) {
                sender.sendMessage("Player not found!")
                return@addSyntax
            }

            ban(sender, target, "Banned by an operator")

        }

        addSyntax({sender, args ->

            val target = args.get(CommandArguments.playerArg).find(sender)[0] as? Player

            if (target == null) {
                sender.sendMessage("Player not found!")
                return@addSyntax
            }

            val reason = args.get(CommandArguments.reasonArg)

            ban(sender, target, reason)

        }, CommandArguments.playerArg, CommandArguments.reasonArg)
    }

    private fun ban(sender: CommandSender, player: Player, reason: String) {
        // TODO: Invoke the actual ban system
    }

}