package gg.rsmod.plugins.content.mechanics.npcs.npcspawns

data class NpcSpawn(
    val id: Int = -1,
    val name: String = "",
    val x: Int = -1,
    val z: Int = -1,
    val height: Int = -1,
    val wander: Int = 5,
    val facing: Int = 3
)
