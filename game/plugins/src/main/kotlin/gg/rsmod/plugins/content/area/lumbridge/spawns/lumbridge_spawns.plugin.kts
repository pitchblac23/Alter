package gg.rsmod.plugins.content.area.lumbridge.spawns

/**Example
*spawn_npc(npc = Npcs.ID, x = xxxx, z = zzzz, height = 0, walkRadius = 0, direction = Direction.NORTH)
*/

/**Citizens*/
spawn_npc(Npcs.MAN_3108, 3236,3201, walkRadius = 5)
spawn_npc(Npcs.MAN_3107, 3235,3219, walkRadius = 5)
spawn_npc(Npcs.MAN_3106, 3231, 3207, walkRadius = 5)
spawn_npc(Npcs.WOMAN_3112, 3236,3203, walkRadius = 5)
spawn_npc(Npcs.WOMAN_3111, 3235,3206, walkRadius = 5)
spawn_npc(Npcs.WOMAN_3113, 3244, 3211, walkRadius = 5)

//will add to chats later
spawn_npc(Npcs.ACCOUNT_SECURITY_TUTOR, 3238, 3200, direction = Direction.EAST)
spawn_npc(Npcs.COUNT_CHECK, 3238, 3199, direction = Direction.EAST)
spawn_npc(Npcs.NIGEL_8391, 3243, 3201, walkRadius = 1)
spawn_npc(Npcs.LUMBRIDGE_GUIDE_306, x = 3238, z = 3220, direction = Direction.WEST)
spawn_npc(Npcs.FATHER_AERECK, 3243,3206, walkRadius = 3)
spawn_npc(Npcs.HATIUS_COSAINTUS, 3233,3215, walkRadius = 1)
spawn_npc(Npcs.IRON_MAN_TUTOR, 3229,3228, walkRadius = 1)
spawn_npc(Npcs.MELEE_COMBAT_TUTOR, 3220, 3238, walkRadius = 1)
spawn_npc(Npcs.RANGED_COMBAT_TUTOR, 3218, 3238,  walkRadius = 1)
spawn_npc(Npcs.MAGIC_COMBAT_TUTOR, 3216, 3238, walkRadius = 1)
spawn_npc(Npcs.WOODSMAN_TUTOR, 3228,3246, walkRadius = 1)
spawn_npc(Npcs.SMITHING_APPRENTICE, 3228,3254, walkRadius = 1)

/**Farmers*/
spawn_npc(Npcs.FARMER_3244, 3262, 3325, walkRadius = 20)
spawn_npc(Npcs.FARMER_3243, 3233, 3308, walkRadius = 20)
spawn_npc(Npcs.FARMER_3114, 3227, 3290, walkRadius = 10)
spawn_npc(Npcs.FARMER_3243, 3199, 3289, walkRadius = 10)

/**Other*/
spawn_npc(npc = Npcs.RAT_2854, x = 3236, z = 3222, walkRadius = 15)
spawn_npc(npc = Npcs.RAT_2854, x = 3232, z = 3229, walkRadius = 8)

/**item spawns*/
spawn_item(item = Items.KNIFE, amount = 1, x = 3224, z = 3202)
spawn_item(item = Items.EGG, amount = 1, x = 3185, z = 3278)
spawn_item(item = Items.SHEARS, amount = 1, x = 3192, z = 3272)