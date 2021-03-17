package world.cepi.moderation

import net.minestom.server.command.builder.arguments.ArgumentType

object CommandArguments {

    val playerArg = ArgumentType.Entity("reason").onlyPlayers(true).singleEntity(true)
    val reasonArg = ArgumentType.String("reason")

}