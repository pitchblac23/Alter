package gg.rsmod.plugins.content.npcs.npcInfo.yak

arrayOf(Npcs.YAK).forEach { yak ->
    set_combat_def(yak) {

        configs {
            attackSpeed = 4
            respawnDelay = 50
            poisonChance = 0.0
            venomChance = 0.0
        }

        aggro {
            radius = 0
            searchDelay = 0
            aggroTimer = 0
            aggroMinutes = 0
            neverAggro()
        }

        stats {
            hitpoints = 50
            attack = 20
            strength = 10
            defence = 1
            magic = 0
            ranged = 0
        }

        bonuses {
            attackStab = 0
            attackSlash = 0
            attackCrush = 0
            attackMagic = 0
            attackRanged = 0

            defenceStab = 0
            defenceSlash = 0
            defenceCrush = 0
            defenceMagic = 0
            defenceRanged = 0

            attackBonus = 0
            strengthBonus = 0
            rangedStrengthBonus = 0
            magicDamageBonus = 0
        }

        anims {
            attack = 5782
            block = 5783
            death = 5784
        }

        slayerData {
            levelRequirement = 1
            xp = 10.0
        }
    }
}