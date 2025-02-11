package gg.rsmod.plugins.content.items.food

import gg.rsmod.plugins.content.items.consumables.food.Foods

Food.values.forEach { food ->
    on_item_option(item = food.item, option = "eat") {
        if (!Foods.canEat(player, food)) {
            return@on_item_option
        }

        val inventorySlot = player.getInteractingItemId()
        if (player.inventory.remove(item = food.item, beginSlot = inventorySlot).hasSucceeded()) {
            Foods.eat(player, food)
            if (food.replacement != -1) {
                player.inventory.add(item = food.replacement, beginSlot = inventorySlot)
            }
        }
    }
}