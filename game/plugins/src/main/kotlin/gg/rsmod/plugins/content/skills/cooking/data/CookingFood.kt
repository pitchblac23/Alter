package gg.rsmod.plugins.content.skills.cooking.data

import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Kyle Escobar
 *
 * Represents the foods that can be cooked.
 *
 * @param raw_item          The [Item.id] of the raw food
 * @param cooked_item       The [Item.id] of the cooked food
 * @param burnt_item        The [Item.id] of the burnt food
 * @param minLevel          The minimum level to cook the food.
 * @param maxLevel          The level which food no longer will burn.
 * @param xp                The amount of xp gained when successfully cooking the food.
 * @param requireRange      Boolean whether or not this food can be cooked on fires.
 */

/**TODO:
 * add in gnome cooking & raids fish, bats
 * need to add cooking cape to burn rates
 */

enum class CookingFood(val raw_item: Int, val cooked_item: Int, val burnt_item: Int, val xp: Double, val minLevel: Int, val maxLevel: Int, val requireRange: Boolean = true) {

    /**MEATS*/
    BEEF(Items.RAW_BEEF, Items.COOKED_MEAT, Items.BURNT_MEAT, 30.0, 1, 34, false),
    RAT_MEAT(Items.RAW_RAT_MEAT, Items.COOKED_MEAT, Items.BURNT_MEAT, 30.0, 1, 34, false),
    BEAR_MEAT(Items.RAW_BEAR_MEAT, Items.COOKED_MEAT, Items.BURNT_MEAT, 30.0, 1, 34, false),
    BOAR_MEAT(Items.RAW_BOAR_MEAT, Items.COOKED_MEAT, Items.BURNT_MEAT, 30.0, 1, 34, false),
    YAK_MEAT(Items.RAW_YAK_MEAT, Items.COOKED_MEAT, Items.BURNT_MEAT, 40.0, 1, 34, false),
    CHICKEN(Items.RAW_CHICKEN, Items.COOKED_CHICKEN, Items.BURNT_CHICKEN, 30.0, 1, 34, false),
    RABBIT(Items.RAW_RABBIT, Items.COOKED_RABBIT, Items.BURNT_RABBIT, 30.0, 1, 34, false),
    SHRIMP(Items.RAW_SHRIMPS, Items.SHRIMPS, Items.BURNT_SHRIMP, 30.0, 1, 34, false),
    ANCHOVIES(Items.RAW_ANCHOVIES, Items.ANCHOVIES, Items.BURNT_FISH, 30.0, 15, 34, false),
    SARDINE(Items.RAW_SARDINE, Items.SARDINE, Items.BURNT_FISH_369, 40.0, 1, 38, false),
    HERRING(Items.RAW_HERRING, Items.HERRING, Items.BURNT_FISH_357, 50.0, 5, 41, false),
    MACKEREL(Items.RAW_MACKEREL, Items.MACKEREL, Items.BURNT_FISH_357, 60.0, 10, 45, false),
    THIN_SNAIL(Items.THIN_SNAIL, Items.THIN_SNAIL_MEAT, Items.BURNT_SNAIL, 70.0, 12, 47, false),
    LEAN_SNAIL(Items.LEAN_SNAIL, Items.LEAN_SNAIL_MEAT, Items.BURNT_SNAIL, 95.0, 17, 47, false),//range cooking stop burn at 50
    SPIDER_SHAFT(Items.SPIDER_ON_SHAFT, Items.SPIDER_ON_SHAFT_6299, Items.BURNT_SPIDER, 80.0, 16, 48, false),
    SPIDER_STICK(Items.SPIDER_ON_STICK, Items.SPIDER_ON_STICK_6297, Items.BURNT_SPIDER, 80.0, 16, 48, false),
    PADDLE_FISH(Items.RAW_PADDLEFISH, Items.PADDLEFISH, Items.BURNT_FISH_23873, 15.0, 1, 48, true),
    TROUT(Items.RAW_TROUT, Items.TROUT, Items.BURNT_FISH_343, 70.0, 15, 49,false),
    COD(Items.RAW_COD, Items.COD, Items.BURNT_FISH_343, 75.0, 18, 51, false),//range cooking stop burn at 49
    PIKE(Items.RAW_PIKE, Items.PIKE, Items.BURNT_FISH_343, 80.0, 20, 54, false),
    FAT_SNAIL(Items.FAT_SNAIL, Items.FAT_SNAIL_MEAT, Items.BURNT_SNAIL, 95.0, 22, 56, false),
    SALMON(Items.RAW_SALMON, Items.SALMON, Items.BURNT_FISH_343, 90.0, 25, 58,false),
    SLIMY_EEL(Items.RAW_SLIMY_EEL, Items.COOKED_SLIMY_EEL, Items.BURNT_EEL, 95.0, 28, 61, false),
    CRAB(Items.CRAB_MEAT, Items.COOKED_CRAB_MEAT, Items.BURNT_CRAB_MEAT, 100.0, 21, 62, false),
    FISHCAKE(Items.RAW_FISHCAKE, Items.COOKED_FISHCAKE, Items.BURNT_FISHCAKE, 100.0, 31, 62, false),
    TUNA(Items.RAW_TUNA, Items.TUNA, Items.BURNT_FISH_367, 100.0, 30, 63, false),
    RAINBOW_FISH(Items.RAW_RAINBOW_FISH, Items.RAINBOW_FISH, Items.BURNT_RAINBOW_FISH, 110.0, 35, 63, false),
    CAVE_EEL(Items.RAW_CAVE_EEL, Items.CAVE_EEL, Items.BURNT_CAVE_EEL, 115.0, 38, 74, false),
    BASS(Items.RAW_BASS, Items.BASS, Items.BURNT_FISH_367, 130.0, 43, 80, false),
    JUBBLY(Items.RAW_JUBBLY, Items.COOKED_JUBBLY, Items.BURNT_JUBBLY, 160.0, 41, 99, true),// burn rate unknown also need splitroast
    CHOMPY(Items.RAW_CHOMPY, Items.COOKED_CHOMPY, Items.BURNT_CHOMPY, 100.0, 30, 99, true),// needs splitroast
    KARAMBWAN(Items.RAW_KARAMBWAN, Items.COOKED_KARAMBWAN, Items.BURNT_KARAMBWAN, 190.0, 30, 99, false),
    //POISON_KARAMBAWN(Items.RAW_KARAMBWAN, Items.POISON_KARAMBWAN, Items.BURNT_KARAMBWAN, 90.0, 1, 99, false), // fix for making posion vs cooked
    ROAST_BEAST(Items.SKEWERED_BEAST, Items.ROAST_BEAST_MEAT, Items.BURNT_BEAST_MEAT, 82.5, 21, 99, false),
    ROAST_BIRD(Items.SKEWERED_BIRD_MEAT, Items.ROAST_BEAST_MEAT, Items.BURNT_BIRD_MEAT, 60.0, 11, 99, false),
    ROAST_RABBIT(Items.SKEWERED_RABBIT, Items.ROAST_RABBIT, Items.BURNT_RABBIT, 70.0, 16, 99, false),
    UGTHANKI_MEAT(Items.RAW_UGTHANKI_MEAT, Items.UGTHANKI_MEAT, Items.BURNT_MEAT, 40.0, 1, 99, false), // no stop burning
    SEA_TURTLE(Items.RAW_SEA_TURTLE, Items.SEA_TURTLE, Items.BURNT_SEA_TURTLE, 211.3, 82, 99, false), // needs cooking cape
    DARK_CRAB(Items.RAW_DARK_CRAB, Items.DARK_CRAB, Items.BURNT_DARK_CRAB, 215.0, 90, 99, false), // needs cooking cape
    MANTA_RAY(Items.RAW_MANTA_RAY, Items.MANTA_RAY, Items.BURNT_MANTA_RAY, 216.3, 91, 99, false), // needs cooking cape
    ANGLERFISH(Items.RAW_ANGLERFISH, Items.ANGLERFISH, Items.BURNT_ANGLERFISH, 230.0, 84, 99, false),
    SHARK(Items.RAW_SHARK, Items.SHARK, Items.BURNT_SHARK, 230.0, 80, 99, false), // needs cooking cape
    MONKFISH(Items.RAW_MONKFISH, Items.MONKFISH, Items.BURNT_MONKFISH, 150.0, 62, 92, false),
    SWORDFISH(Items.RAW_SWORDFISH, Items.SWORDFISH, Items.BURNT_SWORDFISH, 140.0, 45, 86, false),
    LOBSTER(Items.RAW_LOBSTER, Items.LOBSTER, Items.BURNT_LOBSTER, 120.0, 40, 74, false),


    /**BAKED GOODS*/
    BREAD(Items.BREAD_DOUGH, Items.BREAD, Items.BURNT_BREAD, 40.0, 1, 38, true),
    PITTA(Items.PITTA_DOUGH, Items.PITTA_BREAD, Items.BURNT_PITTA_BREAD, 1.0, 58, 58, true),
    REDBERRY_PIE(Items.UNCOOKED_BERRY_PIE, Items.REDBERRY_PIE, Items.BURNT_PIE, 78.0, 10, 45, true),
    MEAT_PIE(Items.UNCOOKED_MEAT_PIE, Items.MEAT_PIE, Items.BURNT_PIE, 110.0, 20, 54, true),
    APPLE_PIE(Items.UNCOOKED_APPLE_PIE, Items.APPLE_PIE, Items.BURNT_PIE, 130.0, 30, 63, true),
    MUD_PIE(Items.RAW_MUD_PIE, Items.MUD_PIE, Items.BURNT_PIE, 128.0, 29, 63, true),
    PLAIN_PIZZA(Items.UNCOOKED_PIZZA, Items.PLAIN_PIZZA, Items.BURNT_PIZZA, 143.0, 35, 68, true),
    GARDEN_PIE(Items.RAW_GARDEN_PIE, Items.GARDEN_PIE, Items.BURNT_PIE, 138.0, 34, 68, true),
    FISH_PIE(Items.RAW_FISH_PIE, Items.FISH_PIE, Items.BURNT_PIE, 164.0, 47, 74, true),
    CAKE(Items.UNCOOKED_CAKE, Items.CAKE, Items.BURNT_CAKE, 180.0, 40, 74, true),
    BONTANICAL_PIE(Items.UNCOOKED_BOTANICAL_PIE, Items.BOTANICAL_PIE, Items.BURNT_PIE, 180.0, 52, 84, true),
    MUSHROOM_PIE(Items.UNCOOKED_MUSHROOM_PIE, Items.MUSHROOM_PIE, Items.BURNT_PIE, 200.0, 60, 89, true),
    ADMIRAL_PIE(Items.RAW_ADMIRAL_PIE, Items.ADMIRAL_PIE, Items.BURNT_PIE, 210.0, 70, 94, true),
    DRAGONFRUIT_PIE(Items.UNCOOKED_DRAGONFRUIT_PIE, Items.DRAGONFRUIT_PIE, Items.BURNT_PIE, 220.0, 73, 99, true), // needs cooking cape
    WILD_PIE(Items.RAW_WILD_PIE, Items.WILD_PIE, Items.BURNT_PIE, 240.0, 85, 99, true), // needs cooking cape
    SUMMER_PIE(Items.RAW_SUMMER_PIE, Items.SUMMER_PIE, Items.BURNT_PIE, 260.0, 95, 99, true), // needs cooking cape

    /**OTHER*/
    BAKED_POTATO(Items.POTATO, Items.BAKED_POTATO, Items.BURNT_POTATO, 15.0, 7, 41, false),
    SCRAMBLED_EGG(Items.UNCOOKED_EGG, Items.SCRAMBLED_EGG, Items.BURNT_EGG, 50.0, 13, 48, false),
    SWEETCORN(Items.SWEETCORN, Items.COOKED_SWEETCORN, Items.BURNT_SWEETCORN, 104.0, 28, 54, false),
    NETTLE_TEA(Items.NETTLEWATER, Items.NETTLE_TEA, Items.BOWL, 52.0, 20, 54, false),
    STEW(Items.UNCOOKED_STEW, Items.STEW, Items.BURNT_STEW, 117.0, 25, 58, false),
    CURRY(Items.UNCOOKED_CURRY, Items.CURRY, Items.BURNT_CURRY, 280.0, 60, 74, false),
    FRIED_ONIONS(Items.CHOPPED_ONION, Items.FRIED_ONIONS, Items.BURNT_ONION, 60.0, 42, 77, false),
    FIRED_MUSHROOMS(Items.SLICED_MUSHROOMS, Items.FRIED_MUSHROOMS, Items.BURNT_MUSHROOM, 60.0, 46, 90, false);


    companion object {
        val values = enumValues<CookingFood>()

        val definitions = values.associate { it.raw_item to it }
    }
}