package world.cepi.moderation.commands
import net.minestom.server.command.CommandSender
import net.minestom.server.command.builder.Arguments
import net.minestom.server.command.builder.Command
import net.minestom.server.entity.Player

class BanCommand : Command("test") {
    init {
        addSyntax({ sender: CommandSender, args: Arguments ->
            val player = sender as Player;
        })
    }
}