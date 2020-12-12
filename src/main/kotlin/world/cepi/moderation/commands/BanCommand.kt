package world.cepi.moderation.commands

import net.minestom.server.MinecraftServer
import net.minestom.server.chat.ChatColor
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player
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

        addSyntax({sender, args ->

            ban(sender, args.getWord("player"), "Banned by an operator")

        }, CommandArguments.playerArg)

        addSyntax({sender, args ->

            var reason = ""
            for (r in args.getStringArray("reason")) {
                reason += " $r"
            }
            reason = reason.replaceFirst(" ", "")

            ban(sender, args.getWord("player"), reason)

        }, CommandArguments.playerArg, CommandArguments.reasonArg)
    }

    private fun ban(sender: CommandSender, playerName: String, reason: String) {
        val player = getPlayer(playerName)

        if (player == null) {
            sender.sendMessage("${ChatColor.RED}Player $playerName doesn't exist.")
            return;
        }

        // TODO: Invoke the actual ban system
    }

}