import gg.rsmod.game.model.priv.Privilege

on_command("shop", Privilege.ADMIN_POWER, description = "Open shop by name.") {
    val args = player.getCommandArgs()
    player.openShop(args.joinToString(" "))
}
