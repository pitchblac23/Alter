package gg.rsmod.plugins.content.npcs.npcInfo.man

val civilian = arrayOf(Npcs.MAN_3108, Npcs.MAN_3107, Npcs.MAN_3106)

civilian.forEach { civilian ->
    set_combat_def(civilian) {
        configs {
            attackSpeed = 4
            respawnDelay = 70
        }

        stats {
            hitpoints = 7
            attack = 1
            defence = 1
            strength = 1
            magic = 1
            ranged = 1
        }

        bonuses {
            attackStab = 0
            attackSlash = 0
            attackCrush = 0
            attackMagic = 0
            attackRanged = 0

            defenceStab = -21
            defenceSlash = -21
            defenceCrush = -21
            defenceMagic = -21
            defenceRanged = -21

            attackBonus = 0
            strengthBonus = 0
            rangedStrengthBonus = 0
            magicDamageBonus = 0
        }

        anims {
            death = 836
            block = 425
            attack = 422
        }
    }

    set_drop_table(civilian) {
        droptable {
            dropTableJSON = "man/man.drops.json"
        }
    }
}