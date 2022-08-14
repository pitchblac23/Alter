package gg.rsmod.plugins.content.npcs.npcInfo.lesser_demons


val LESSERDEMONS = arrayOf(
    Npcs.LESSER_DEMON,
    Npcs.LESSER_DEMON_2006,
    Npcs.LESSER_DEMON_2007,
    Npcs.LESSER_DEMON_2008,
    Npcs.LESSER_DEMON_2018,
    Npcs.LESSER_DEMON_3982,
    Npcs.LESSER_DEMON_7247,
    Npcs.LESSER_DEMON_7248,
    Npcs.LESSER_DEMON_7656
)

set_multi_combat_region(region = 12344)

// will probably remove these for better spawn locations
spawn_npc(Npcs.LESSER_DEMON, x = 3093, z = 3618, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2006, x = 3094, z = 3611, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2007, x = 3095, z = 3617, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2018, x = 3092, z = 3616, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2007, x = 3049, z = 3575, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2018, x = 3055, z = 3600, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2018, x = 3060, z = 3605, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2018, x = 3100, z = 3650, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_7656, x = 3050, z = 3660, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_7247, x = 3105, z = 3550, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_2007, x = 3050, z = 3490, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_7248, x = 3215, z = 3675, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON_7247, x = 3115, z = 3560, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON, x = 3110, z = 3610, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON, x = 3055, z = 3625, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON, x = 3092, z = 3615, walkRadius = 15)
spawn_npc(Npcs.LESSER_DEMON, x = 3227, z = 3666, walkRadius = 15)

LESSERDEMONS.forEach { lesserdemon ->
    set_combat_def(lesserdemon) {
        species { +NpcSpecies.DEMON }


        configs {
            attackSpeed = 2
            respawnDelay = 10
        }

        aggro {
            radius = 2
            searchDelay = 1
        }

        stats {
            hitpoints = 60
            attack = 100
            strength = 100
            defence = 100
        }

        bonuses {
            defenceStab = 40
            defenceSlash = 40
            defenceCrush = 40
            defenceMagic = 40
            defenceRanged = 40
        }

        anims {
            block = 4676
            death = 67
        }

        slayerData {
            xp = 50.0
        }
    }
}