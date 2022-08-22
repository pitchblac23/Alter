package gg.rsmod.plugins.content.inter.attack

import gg.rsmod.plugins.content.inter.attack.AttackTab.ATTACK_TAB_INTERFACE_ID
import gg.rsmod.plugins.content.inter.attack.AttackTab.ATTACK_STYLE_VARP
import gg.rsmod.plugins.content.inter.attack.AttackTab.DISABLE_AUTO_RETALIATE_VARP
import gg.rsmod.plugins.content.inter.attack.AttackTab.SPECIAL_ATTACK_VARP
import gg.rsmod.plugins.content.inter.attack.AttackTab.setEnergy
import gg.rsmod.game.model.attr.NEW_ACCOUNT_ATTR
import gg.rsmod.plugins.content.combat.Combat
import gg.rsmod.plugins.content.inter.attack.autocasts.AutoCasting

/**
 * First log-in logic (when accounts have just been made).
 */
on_login {
    if (player.attr.getOrDefault(NEW_ACCOUNT_ATTR, false)) {
        setEnergy(player, 100)
    }
    AttackTab.resetRestorationTimer(player)
}

on_timer(AttackTab.SPEC_RESTORE)
{
    AttackTab.restoreEnergy(player)
    AttackTab.resetRestorationTimer(player)
}

/**
 * Attack style buttons
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 4) {
    player.setVarp(ATTACK_STYLE_VARP, 0)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 8) {
    player.setVarp(ATTACK_STYLE_VARP, 1)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 12) {
    player.setVarp(ATTACK_STYLE_VARP, 2)
}

on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 16) {
    player.setVarp(ATTACK_STYLE_VARP, 3)
}

/**
 * Toggle Magic-Defensive attackstyle
 */
on_button(interfaceId = 593, component = 21) {
    player.setVarbit(Combat.DEFENSIVE_MAGIC_CAST_VARBIT, 1)
    AutoCasting.openAutoCastSpellsList(player)
}
/**
 * Toggle Magic-Aggressive attackstyle
 */
on_button(interfaceId = 593, component = 26) {
    player.setVarbit(Combat.DEFENSIVE_MAGIC_CAST_VARBIT, 0)
    AutoCasting.openAutoCastSpellsList(player)
}

/**
 * Toggle auto-retaliate button.
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 30) {
    player.toggleVarp(DISABLE_AUTO_RETALIATE_VARP)
}

/**
 * Toggle special attack.
 */
on_button(interfaceId = ATTACK_TAB_INTERFACE_ID, component = 36) {
    player.toggleVarp(SPECIAL_ATTACK_VARP)
}

/**
 * Disable special attack when switching weapons.
 */
on_equip_to_slot(EquipmentType.WEAPON.id) {
    player.setVarp(SPECIAL_ATTACK_VARP, 0)
}


/**
 * Disable special attack on log-out.
 */
on_logout {
    player.setVarp(SPECIAL_ATTACK_VARP, 0)
}