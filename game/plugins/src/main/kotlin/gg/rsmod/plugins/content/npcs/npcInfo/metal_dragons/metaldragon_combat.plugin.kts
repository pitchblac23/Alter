package gg.rsmod.plugins.content.npcs.dragons

import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.DragonfireFormula
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy

on_npc_combat(Npcs.BRONZE_DRAGON, Npcs.BRONZE_DRAGON_271, Npcs.BRONZE_DRAGON_7253,
    Npcs.IRON_DRAGON, Npcs.IRON_DRAGON_273, Npcs.IRON_DRAGON_7254, Npcs.IRON_DRAGON_8080,
    Npcs.STEEL_DRAGON_139, Npcs.STEEL_DRAGON_274, Npcs.STEEL_DRAGON_275, Npcs.STEEL_DRAGON_7255, Npcs.STEEL_DRAGON_8086) {
    npc.queue {
        combat(this)
    }
}

suspend fun combat(it: QueueTask) {
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return

    while (npc.canEngageCombat(target)) {
        npc.facePawn(target)
        if (npc.moveToAttackRange(it, target, distance = 6, projectile = true) && npc.isAttackDelayReady()) {
            if (world.chance(1, 2) && npc.canAttackMelee(it, target, moveIfNeeded = false)) {
                when (world.random(2)) {
                    0 -> melee_attack(npc, target)
                    1 -> fire_attack(npc, target)
                }
            } else if (!npc.canAttackMelee(it, target, moveIfNeeded = false)) {
                    fire_ball(npc, target)
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

fun fire_ball(npc: Npc, target: Pawn) {
    val projectile = npc.createProjectile(target, gfx = 393, startHeight = 43, endHeight = 31, delay = 51, angle = 15, steepness = 127)
    npc.prepareAttack(CombatClass.MAGIC, CombatStyle.MAGIC, AttackStyle.ACCURATE)
    npc.animate(81)
    world.spawn(projectile)
    npc.dealHit(target = target, formula = DragonfireFormula(maxHit = 65), delay = RangedCombatStrategy.getHitDelay(npc.getFrontFacingTile(target), target.getCentreTile()) - 1)
}