package world.cepi.moderation

import net.minestom.server.command.builder.arguments.ArgumentType

object CommandArguments {

    val playerArg = ArgumentType.Word("player")
    val reasonArg = ArgumentType.StringArray("reason")

}