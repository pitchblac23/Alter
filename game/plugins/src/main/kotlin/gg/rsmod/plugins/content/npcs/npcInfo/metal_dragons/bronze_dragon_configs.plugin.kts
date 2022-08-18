package gg.rsmod.plugins.content.npcs.npcInfo.other

arrayOf(Npcs.BRONZE_DRAGON, Npcs.BRONZE_DRAGON_271, Npcs.BRONZE_DRAGON_7253).forEach { bronzedragon -> 
	set_combat_def(bronzedragon) {

		species {
			+ NpcSpecies.DRAGON
			+ NpcSpecies.BASIC_DRAGON
		}

		configs {
			attackSpeed = 4
			respawnDelay = 30
			poisonChance = 0.0
			venomChance = 0.0
		 }

		aggro {
			radius = 2
			searchDelay = 1
		 }

		stats {
			hitpoints = 122
			attack = 112
			strength = 112
			defence = 112
			magic = 100
			ranged = 1
		 }

		bonuses {
			attackBonus = 0
			strengthBonus = 0
			attackMagic = 0
			magicDamageBonus = 0
			attackRanged = 0
			rangedStrengthBonus = 0
			defenceStab = 50
			defenceSlash = 70
			defenceCrush = 70
			defenceMagic = 30
			defenceRanged = 90
		 }

		anims {
			attack = 80
			block = 89
			death = 92
		 }

		slayerData {
			levelRequirement = 0
			xp = 125.00
		 }
	 }
}
