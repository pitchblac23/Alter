package gg.rsmod.plugins.content.magic

/**
 * @author DaGreenRs <dagreenrs@gmail.com>
 */

/**
 * The attribute key for spellbook swap.
 */
val HAS_SPELLBOOK_SWAP = AttributeKey<Boolean>()

/**
 * The required runes to cast spellbook swap.
 */
val requiredRunes = arrayOf(Item(9075, 3), Item(563, 1), Item(564, 2))

on_login {
    player.attr[HAS_SPELLBOOK_SWAP] = false
}

on_button(interfaceId = 218, component = 139) {
    player.queue {
        requiredRunes.forEach { runes ->
            if (player.getSkills().getBaseLevel(Skills.MAGIC) < 96) {
                player.message("Your Magic level is not high enough for this spell.")
                return@queue
            }
            if (player.getVarbit(MagicSpells.INF_RUNES_VARBIT) == 0) {
                if (player.inventory.getItemCount(runes.id) < runes.amount && player.equipment.getItemCount(runes.id) < runes.amount) {
                    player.message("You do not have enough ${runes.getDef(player.world.definitions).name}s to cast this spell.")
                    return@queue
                }
            }
            when (options("Standart", "Ancient", "Arceuus", "Cancel", title = "Choose spellbook:")) {
                1 -> player.spellbookSwap(this, Spellbook.NORMAL)
                2 -> player.spellbookSwap(this, Spellbook.ANCIENTS)
                3 -> player.spellbookSwap(this, Spellbook.ARCEUUS)
                4 -> return@queue
            }
        }
    }
}

suspend fun Player.spellbookSwap(it: QueueTask, spellbook: Spellbook) {
    animate(id = 6299)
    graphic(id = 1062)
    it.wait(5)
    it.player.addXp(Skills.MAGIC, 130.0)
    repeat(7) {
        world.spawn(AreaSound(tile, id = 3613, radius = 1, volume = 1))
    }
    attr[HAS_SPELLBOOK_SWAP] = true
    setSpellbook(spellbook)
    message("You have 2 minutes before your spellbook changes back!")
    it.wait(60)
    message("You have 1 minute before your spellbook changes back!")
    message("If you want to use a spell from the current spellbook, do so before then.")
    it.wait(60)
    setSpellbook(Spellbook.LUNAR)
    attr[HAS_SPELLBOOK_SWAP] = false
    playSound(id = 3282)
    message("You ran out of time and your spellbook has changed back.")
}
