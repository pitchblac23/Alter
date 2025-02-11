import gg.rsmod.game.model.priv.Privilege

/**
 * @author Fritz <frikkipafi@gmail.com>
 */

on_command("broadcast", Privilege.ADMIN_POWER, description = "Broadcast for everyone") {
    val args = player.getCommandArgs()
    player.world.players.forEach {
        it.message("${args.joinToString(" ")}", ChatMessageType.BROADCAST)
    }
}