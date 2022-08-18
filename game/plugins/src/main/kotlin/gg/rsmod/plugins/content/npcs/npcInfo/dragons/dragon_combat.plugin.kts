package gg.rsmod.plugins.content.npcs.npcInfo.dragons

import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.DragonfireFormula
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy

on_npc_combat(Npcs.GREEN_DRAGON, Npcs.GREEN_DRAGON_261, Npcs.GREEN_DRAGON_262, Npcs.GREEN_DRAGON_263, Npcs.GREEN_DRAGON_264,  Npcs.GREEN_DRAGON_7868, Npcs.GREEN_DRAGON_7869, Npcs.GREEN_DRAGON_7870, Npcs.GREEN_DRAGON_8073, Npcs.GREEN_DRAGON_8076, Npcs.GREEN_DRAGON_8082,
    Npcs.BLUE_DRAGON, Npcs.BLUE_DRAGON_266, Npcs.BLUE_DRAGON_267, Npcs.BLUE_DRAGON_268, Npcs.BLUE_DRAGON_269, Npcs.BLUE_DRAGON_4385, Npcs.BLUE_DRAGON_5878, Npcs.BLUE_DRAGON_5879, Npcs.BLUE_DRAGON_5880, Npcs.BLUE_DRAGON_5881, Npcs.BLUE_DRAGON_5882, Npcs.BLUE_DRAGON_8074, Npcs.BLUE_DRAGON_8077, Npcs.BLUE_DRAGON_8083,
    Npcs.RED_DRAGON, Npcs.RED_DRAGON_248, Npcs.RED_DRAGON_249, Npcs.RED_DRAGON_250, Npcs.RED_DRAGON_251, Npcs.RED_DRAGON_8075, Npcs.RED_DRAGON_8078, Npcs.RED_DRAGON_8079,
    Npcs.BLACK_DRAGON, Npcs.BLACK_DRAGON_253, Npcs.BLACK_DRAGON_254, Npcs.BLACK_DRAGON_255, Npcs.BLACK_DRAGON_256, Npcs.BLACK_DRAGON_257, Npcs.BLACK_DRAGON_258, Npcs.BLACK_DRAGON_259, Npcs.BLACK_DRAGON_7861, Npcs.BLACK_DRAGON_7862, Npcs.BLACK_DRAGON_7863, Npcs.BLACK_DRAGON_8084, Npcs.BLACK_DRAGON_8085) {
    npc.queue {
        combat(this)
    }
}

suspend fun combat(it: QueueTask) {
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return

    while (npc.canEngageCombat(target)) {
        npc.facePawn(target)
        if (npc.moveToAttackRange(it, target, distance = 1, projectile = true) && npc.isAttackDelayReady()) {
            if (world.chance(1, 2) && npc.canAttackMelee(it, target, moveIfNeeded = true)) {
                melee_attack(npc, target)
            } else {
                    fire_attack(npc, target)
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
        npc.animate(91)
    } else {
        // Claw attack
        npc.prepareAttack(CombatClass.MELEE, CombatStyle.SLASH, AttackStyle.AGGRESSIVE)
        npc.animate(80)
    }
    if (MeleeCombatFormula.getAccuracy(npc, target) >= world.randomDouble()) {
        target.hit(world.random(26), type = HitType.HIT, delay = 1)
    } else {
        target.hit(damage = 0, type = HitType.BLOCK, delay = 1)
    }
}

fun fire_attack(npc: Npc, target: Pawn) {
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(81)
    npc.graphic(1, 62, 0)
    npc.dealHit(target = target, formula = DragonfireFormula(maxHit = 50), delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1)
}