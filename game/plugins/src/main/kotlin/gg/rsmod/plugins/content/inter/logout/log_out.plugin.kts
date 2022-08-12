package gg.rsmod.plugins.content.inter.logout

import gg.rsmod.game.message.impl.LogoutFullMessage
import gg.rsmod.game.model.timer.ACTIVE_COMBAT_TIMER

/**
 * Logout button.
 */
on_button(interfaceId = 182, component = 8) {
    if (!player.timers.has(ACTIVE_COMBAT_TIMER)) {
        player.requestLogout()
        player.write(LogoutFullMessage())
        player.channelClose()
    } else {
        player.message("You can't log out until 10 seconds after the end of combat.")
    }
}

on_button(interfaceId = 182, component = 3) {
    player.openInterface(interfaceId = 69, dest = InterfaceDestination.TAB_AREA)
}
on_button(interfaceId = 69, component = 3) {
    player.closeInterface(69)
}
on_button(interfaceId = 69, component = 23) {
    if (!player.timers.has(ACTIVE_COMBAT_TIMER)) {
        player.requestLogout()
        player.write(LogoutFullMessage())
        player.channelClose()
    } else {
        player.message("You can't log out until 10 seconds after the end of combat.")
    }
}