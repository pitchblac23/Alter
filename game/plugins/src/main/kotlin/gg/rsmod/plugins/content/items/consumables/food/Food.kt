package gg.rsmod.plugins.content.items.food

import gg.rsmod.plugins.api.cfg.Items


enum class Food(val item: Int, val heal: Int = 0, val overheal: Boolean = false,
                val replacement: Int = -1, val tickDelay: Int = 3,
                val comboFood: Boolean = false) {

    /**
     * Sea food.
     */
    SHRIMP(item = Items.SHRIMPS, heal = 3),
    SARDINE(item = Items.SARDINE, heal = 4),
    HERRING(item = Items.HERRING, heal = 5),
    MACKEREL(item = Items.MACKEREL, heal = 6),
    TROUT(item = Items.TROUT, heal = 7),
    COD(item = Items.COD, heal = 7),
    PIKE(item = Items.PIKE, heal = 8),
    SALMON(item = Items.SALMON, heal = 9),
    TUNA(item = Items.TUNA, heal = 10),
    RAINBOW(item = Items.RAINBOW_FISH, heal = 11),
    CAVEEEL(item = Items.CAVE_EEL, heal = 9),
    LOBSTER(item = Items.LOBSTER, heal = 12),
    BASS(item = Items.BASS, heal = 13),
    SWORDFISH(item = Items.SWORDFISH, heal = 14),
    MONKFISH(item = Items.MONKFISH, heal = 16),
    KARAMBWAN(item = Items.COOKED_KARAMBWAN, heal = 18, comboFood = true),
    SHARK(item = Items.SHARK, heal = 20),
    SEATURTLE(item = Items.SEA_TURTLE, heal = 21),
    MANTA_RAY(item = Items.MANTA_RAY, heal = 22),
    DARK_CRAB(item = Items.DARK_CRAB, heal = 22),
    ANGLERFISH(item = Items.ANGLERFISH, overheal = true),

    /**
     * Meat.
     */
    CHICKEN(item = Items.COOKED_CHICKEN, heal = 3),
    MEAT(item = Items.COOKED_MEAT, heal = 3),
    ROASTBEASTMEAT(item = Items.ROAST_BEAST_MEAT, heal = 8),
    KEBAB(item = Items.UGTHANKI_KEBAB, heal = 19),

    /**
     * Pastries.
     */
    BREAD(item = Items.BREAD, heal = 5),
    REDBERRY_PIE(item = Items.REDBERRY_PIE, heal = 5),
    REDBERRY_PIE_HALF(item = Items.HALF_A_REDBERRY_PIE, heal = 5),
    CAKE(item = Items.CAKE, heal = 4),
    _23_CAKE(item = Items._23_CAKE, heal = 4),
    CAKE_SLICE(item = Items.SLICE_OF_CAKE, heal = 4),
    MEAT_PIE(item = Items.MEAT_PIE, heal = 6),
    MEAT_PIE_HALF(item = Items.HALF_A_MEAT_PIE, heal = 6),
    APPLE_PIE(item = Items.APPLE_PIE, heal = 7),
    APPLE_PIE_HALF(item = Items.HALF_AN_APPLE_PIE, heal = 7),
    CHOCOLATE_CAKE(item = Items.CHOCOLATE_CAKE, heal = 5),
    _23_CHOC_CAKE(item = Items._23_CHOCOLATE_CAKE, heal = 5),
    CHOC_CAKE_SLICE(item = Items.CHOCOLATE_SLICE, heal = 5),
    ADMIRAL_PIE(item = Items.ADMIRAL_PIE, heal = 8),
    ADMIRAL_PIE_HALF(item = Items.HALF_AN_ADMIRAL_PIE, heal = 8),
    DRAGONFRUIT_PIE(item = Items.DRAGONFRUIT_PIE, heal = 10),
    DRAGONFRUIT_PIE_HALF(item = Items.HALF_A_DRAGONFRUIT_PIE, heal = 10),
    SUMMER_PIE(item = Items.SUMMER_PIE, heal = 11),
    SUMMER_PIE_HALF(item = Items.HALF_A_SUMMER_PIE, heal = 11),
    WILD_PIE(item = Items.WILD_PIE, heal = 11),
    WILD_PIE_HALF(item = Items.HALF_A_WILD_PIE, heal = 11),

    /**
     * Stews
     */
    STEW(item = Items.STEW, heal = 11),
    BANANA_STEW(item = Items.BANANA_STEW, heal = 11),
    TANGLED_TOAD(item = Items.TANGLED_TOADS_LEGS, heal = 15),
    CHOCOLATE_BOMB(item = Items.CHOCOLATE_BOMB, heal = 15),
    CURRY(item = Items.CURRY, heal = 19),

    /**
     * Pizza
     */
    PLAIN_PIZZA(item = Items.PLAIN_PIZZA, heal = 7),
    PLAIN_PIZZA_HALF(item = Items._12_PLAIN_PIZZA, heal = 7),
    MEAT_PIZZA(item = Items.MEAT_PIZZA, heal = 8),
    MEAT_PIZZA_HALF(item = Items._12_MEAT_PIZZA, heal = 8),
    ANCHOVY_PIZZA(item = Items.ANCHOVY_PIZZA, heal = 9),
    ANCHOVY_PIZZA_HALF(item = Items._12_ANCHOVY_PIZZA, heal = 9),
    PINEAPPLE_PIZZA(item = Items.PINEAPPLE_PIZZA, heal = 11),
    PINEAPPLE_PIZZA_HALF(item = Items._12_PINEAPPLE_PIZZA, heal = 11),

    /**
     * Other.
     */
    ONION(item = Items.ONION, heal = 1),
    CHOC_ICE(item = Items.CHOCICE, heal = 7),
    POTATO_BUTTER(item = Items.POTATO_WITH_BUTTER, heal = 14),
    POTATO_CHEESE(item = Items.POTATO_WITH_CHEESE, heal = 16),
    POTATO_MUSHROOM(item = Items.MUSHROOM_POTATO, heal = 20),
    POTATO_TUNA(item = Items.TUNA_POTATO, heal = 22);
    companion object {
        val values = enumValues<Food>()
    }
}