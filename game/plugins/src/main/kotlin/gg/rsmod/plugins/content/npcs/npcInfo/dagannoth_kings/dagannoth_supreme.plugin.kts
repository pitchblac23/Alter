package gg.rsmod.plugins.content.npcs.npcInfo.dagannoth_kings

import gg.rsmod.game.model.combat.AttackStyle
import gg.rsmod.game.model.combat.CombatClass
import gg.rsmod.game.model.combat.CombatStyle
import gg.rsmod.plugins.content.combat.*
import gg.rsmod.plugins.content.combat.formula.RangedCombatFormula
import gg.rsmod.plugins.content.combat.strategy.RangedCombatStrategy

/**TODO:
 * Might make better spawns later
 */

spawn_npc(npc = Npcs.DAGANNOTH_SUPREME, x = 2906, z = 4389, direction = Direction.EAST, walkRadius = 3)

spawn_npc( npc = Npcs.DAGANNOTH_PRIME, x = 2919, z = 4389, direction = Direction.EAST, walkRadius = 3)

spawn_npc( npc = Npcs.DAGANNOTH_REX, x = 2915, z = 4387, direction = Direction.EAST, walkRadius = 3)

set_combat_def(npc = Npcs.DAGANNOTH_SUPREME) {
    configs {
        attackSpeed = 6
        respawnDelay = 90
    }

    aggro {
        radius = 10
        searchDelay = 1
        aggroMinutes = 10
    }

    bonuses {
        defenceStab = 10
        defenceCrush = 10
        defenceSlash = 10
        defenceMagic = 255
        defenceRanged = 550
    }

    stats {
        hitpoints = 255
        attack = 255
        strength = 255
        defence = 128
        magic = 255
        ranged = 255
    }

    anims {
        block = 2852
        death = 2856
    }

    slayerData {
        levelRequirement = 1
        xp = 255.0
    }
}

set_combat_def(npc = Npcs.DAGANNOTH_PRIME) {
    configs {
        attackSpeed = 10
        respawnDelay = 50
    }

    aggro {
        radius = 3
        searchDelay = 1
        aggroMinutes = 10
    }

    bonuses {
        defenceStab = 255
        defenceCrush = 255
        defenceSlash = 255
        defenceMagic = 255
        defenceRanged = 10
    }

    stats {
        hitpoints = 255
        attack = 255
        strength = 255
        defence = 255
        magic = 255
        ranged = 0
    }

    anims {
        attack = 2854
        block = 2852
        death = 2856
    }

    slayerData {
        levelRequirement = 1
        xp = 331.5
    }
}

set_combat_def(npc = Npcs.DAGANNOTH_REX) {
    configs {
        attackSpeed = 4
        respawnDelay = 50
    }

    aggro {
        radius = 10
        searchDelay = 1
        aggroMinutes = 10
    }

    bonuses {
        defenceStab = 255
        defenceCrush = 255
        defenceSlash = 255
        defenceMagic = 10
        defenceRanged = 255
    }

    stats {
        hitpoints = 255
        attack = 255
        strength = 255
        defence = 255
        magic = 0
        ranged = 255
    }

    anims {
        attack = 2851
        block = 2852
        death = 2856
    }

    slayerData {
        levelRequirement = 1
        xp = 255.0
    }
}

on_npc_combat(npc = Npcs.DAGANNOTH_SUPREME) {
    npc.queue {
        combat(this)
    }
}

suspend fun combat(it: QueueTask) {
    // 2855
    val npc = it.npc
    var target = npc.getCombatTarget() ?: return

    while(npc.canEngageCombat(target)) {
        npc.facePawn(target)
        if(npc.moveToAttackRange(it = it, target = target, distance = 6, projectile = true) && npc.isAttackDelayReady()) {
            fire_attack(npc, target)
            npc.postAttackLogic(target)
        }
        it.wait(1)
        target = npc.getCombatTarget() ?: break
    }

    npc.resetFacePawn()
    npc.removeCombatTarget()
}

fun fire_attack(npc: Npc, target: Pawn) {
    val projectile = npc.createProjectile(
            target = target,
            gfx = 393,
            startHeight = 43,
            endHeight = 31,
            delay = 51,
            angle = 15,
            steepness = 127
    )
    npc.prepareAttack(CombatClass.RANGED, CombatStyle.RANGED, AttackStyle.ACCURATE)
    npc.animate(id = 2855)
    world.spawn(projectile)
    npc.dealHit(
            target = target,
            formula = RangedCombatFormula,
            delay = RangedCombatStrategy.getHitDelay(
                    start = npc.getFrontFacingTile(target),
                    target = target.getCentreTile()
            ) - 1
    )
}

/*fun melee_attack(npc: Npc, target: Pawn) {
    if(world.chance(1, 2)) {

    }
/*}