package gg.rsmod.plugins.content.npcs.npcInfo.lesser_demons
import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula

val LESSERDEMONS = arrayOf(Npcs.LESSER_DEMON,Npcs.LESSER_DEMON_2006,Npcs.LESSER_DEMON_2007,Npcs.LESSER_DEMON_2008,Npcs.LESSER_DEMON_2018,Npcs.LESSER_DEMON_3982,Npcs.LESSER_DEMON_7247,Npcs.LESSER_DEMON_7248,Npcs.LESSER_DEMON_7656)

LESSERDEMONS.forEach { lesserdemon ->
    on_npc_combat(npc = lesserdemon) {
        npc.queue {
            combat(this)
        }
    }

}

suspend fun combat(it: QueueTask) {
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return

    while (npc.canEngageCombat(target)) {
        npc.facePawn(target)
        if (npc.moveToAttackRange(it, target, distance = 6, projectile = true) && npc.isAttackDelayReady()) {
            if (world.chance(1, 4) && npc.canAttackMelee(it, target, moveIfNeeded = false)) {
                melee_attack(npc, target)
            } else {
                when (world.random(3)) {
                    0 -> melee_attack(npc, target)
                }
            }
            npc.postAttackLogic(target)
        }
        it.wait(1)
        target = npc.getCombatTarget() ?: break
    }

    npc.resetFacePawn()
    npc.removeCombatTarget()
}

fun melee_attack(npc: Npc, target: Pawn) {
    if (world.chance(1, 2)) {
        // Headbutt attack
        npc.prepareAttack(CombatClass.MELEE, CombatStyle.STAB, AttackStyle.ACCURATE)
        npc.animate(69)
    } else {
        // Claw attack
        npc.prepareAttack(CombatClass.MELEE, CombatStyle.SLASH, AttackStyle.AGGRESSIVE)
        npc.animate(69)
    }
    if (MeleeCombatFormula.getAccuracy(npc, target) >= world.randomDouble()) {
        target.hit(world.random(15), type = HitType.HIT, delay = 1)
    } else {
        target.hit(damage = 0, type = HitType.BLOCK, delay = 1)
    }
}