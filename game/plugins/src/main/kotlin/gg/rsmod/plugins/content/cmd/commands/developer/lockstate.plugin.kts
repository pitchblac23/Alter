import gg.rsmod.game.model.priv.Privilege

on_command("lock", Privilege.DEV_POWER, description = "lock player") {
    player.message("<col=801700>Locked</col>")
    player.lock()
}

on_command("unlock", Privilege.DEV_POWER, description = "Unlock player") {
    player.message("<col=178000>Unlocked</col>")
    player.unlock()
}
